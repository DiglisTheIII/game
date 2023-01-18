package Main.MainMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import Main.MainMenu.MainMenu;
import Main.MainMenu.SubMenus.MainPanel;
import Main.MainMenu.SubMenus.SettingsMenus.Settings;
import Main.MainMenu.SubMenus.SettingsMenus.SettingsSub.Display;
import Script.Game.Intro.CharChr;


public class MainMenu extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static File res = new File("./src/Game/settings.txt");

    public static ArrayList<String> getResolution(File f) {
        f = MainMenu.res;
        ArrayList<String> dims = new ArrayList<String>();

        //Reads setting.txt and adds each line (only 2 always) to the ArrayList
        try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
            try (Scanner scan = new Scanner(f)) {
				while(scan.hasNextLine()) {
				    dims.add(scan.nextLine());
				}
			}    
            reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

        //TODO Delete when finished
        for(String s : dims) {
            System.out.println(s);
        }
        return dims;
    }

    int height = 800, width = 680;

    public MainMenu(int height, int width) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int scrWidth = (int) screenSize.getWidth();
        int scrHeight = (int) screenSize.getHeight();
        JFrame frame = new JFrame("Jaathran");
        MainPanel main = new MainPanel(frame);
        Settings settings = new Settings(frame);
        Display display = new Display(frame);
        CharChr chr = new CharChr();
        chr.next.setEnabled(false);
        frame.add(main);
        //Corrects if chosen resolution is larger than actual screen
        if(height > scrHeight || width > scrWidth) {
            System.out.println("Screen is too small");
            frame.setSize(240, 320);
        } else if(height < scrHeight && width < scrWidth) {
            System.out.println("Screen resized properly");
            frame.setSize(width, height);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setActionListener(main.play, (JPanel) main, (JPanel) chr, frame);
        
        setActionListener(main.settings, (JPanel) main, (JPanel) settings, frame);
       
        setActionListener(settings.display, (JPanel) settings, (JPanel) display, frame);
        
        setActionListener(settings.back, (JPanel) settings, (JPanel) main, frame);
        
        setActionListener(display.exit, (JPanel) display, (JPanel) settings, frame);
        
        setActionListener(chr.back, (JPanel) chr, (JPanel) main, frame);
        
        main.exit.addActionListener(e -> {
            System.exit(1);
        });
        
        chr.next.addActionListener(e -> {
        	if(chr.nameField.getText().length() > 0) {
        		try {
    				chr.printSkillsToFile(chr.nameField.getText());
    				chr.reroll.setEnabled(false);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	} else {
        		chr.nameField.setText("Invalid Length");
        	}
        });
   
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    /*
     * Presets buttons to switch between pages. Upcasting is 
     * required by JPanel child classes
     */
    public void setActionListener(JButton button, JPanel disable, JPanel enable, JFrame frame) {
    	button.addActionListener(e -> {
    		disable.setVisible(false);
    		enable.setVisible(true);
    		frame.add(enable);
    	});
    }
}
