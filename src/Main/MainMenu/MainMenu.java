package Main.MainMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import Main.MainMenu.MainMenu;
import Main.MainMenu.SubMenus.MainPanel;
import Main.MainMenu.SubMenus.SettingsMenus.Settings;
import Main.MainMenu.SubMenus.SettingsMenus.SettingsSub.Display;


public class MainMenu extends JFrame {
    
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
        double scrWidth = screenSize.getWidth();
        double scrHeight = screenSize.getHeight();
        JFrame frame = new JFrame("Jaathran");
        MainPanel main = new MainPanel(frame);
        Settings settings = new Settings(frame);
        Display display = new Display(frame);
        frame.add(main);
        //Corrects if chosen resolution is larger than actual screen
        if(height > (int) scrHeight || width > (int) scrWidth) {
            System.out.println("Screen is too small");
            frame.setSize((int) (scrWidth / 2), (int) (scrHeight / 2));
        } else if(height < (int) scrHeight && width < (int) scrWidth) {
            System.out.println("Screen resized properly");
            frame.setSize(width, height);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main.play.addActionListener(e -> {

        });
        

        /*
         * A little workaround I wrote to get around using CardLayout.
         * While I know CardLayout is likely 100x more efficient, 
         * it felt like such a hassle to get it to work, and I will use it for the 
         * actual in-game scene transitions. Main menu shouldn't matter.
         */
        main.settings.addActionListener(ActionEvent -> {
            main.setVisible(false);
            settings.setVisible(true);
            frame.add(settings);
        });

        main.exit.addActionListener(e -> {
            System.exit(1);
        });

        settings.display.addActionListener(e -> {
            settings.setVisible(false);
            frame.add(display);
        });

        settings.gameplay.addActionListener(e -> {

        });

        settings.back.addActionListener(e -> {
            settings.setVisible(false);
            main.setVisible(true);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JFrame mainMenu(int height, int width) {      
        JFrame frame = new JFrame("Jaathran");
        MainPanel main = new MainPanel(frame);
        Settings settings = new Settings(frame);
        Display display = new Display(frame);
        frame.add(main);
        frame.setSize(800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main.play.addActionListener(e -> {

        });

        main.settings.addActionListener(ActionEvent -> {
            main.setVisible(false);
            settings.setVisible(true);
            frame.add(settings);
        });

        main.exit.addActionListener(e -> {
            System.exit(1);
        });

        settings.display.addActionListener(e -> {
            settings.setVisible(false);
            frame.add(display);
        });

        settings.gameplay.addActionListener(e -> {

        });

        settings.back.addActionListener(e -> {
            settings.setVisible(false);
            main.setVisible(true);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }

}
