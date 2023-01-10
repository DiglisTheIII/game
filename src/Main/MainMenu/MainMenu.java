package Main.MainMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import Main.MainMenu.MainMenu;
import Main.MainMenu.SubMenus.MainPanel;
import Main.MainMenu.SubMenus.SettingsMenus.Settings;
import Main.MainMenu.SubMenus.SettingsMenus.SettingsSub.Display;


public class MainMenu extends JFrame {
    
    static File res = new File("./src/Game/settings.txt");

    public static ArrayList<String> getResolution(File f) {
        f = MainMenu.res;
        ArrayList<String> dims = new ArrayList<String>();
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

        for(String s : dims) {
            System.out.println(s);
        }
        return dims;
    }

    int height = 800, width = 680;

    public MainMenu(int height, int width) {
        JFrame frame = new JFrame("Jaathran");
        MainPanel main = new MainPanel(frame);
        Settings settings = new Settings(frame);
        Display display = new Display(frame);
        frame.add(main);
        frame.setSize(width, height);
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
