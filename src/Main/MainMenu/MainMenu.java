package Main.MainMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
import Main.MainMenu.SubMenus.SettingsMenus.SettingsSub.Gameplay.Gameplay;
import Script.Game.Intro.CharChr;
import Script.Game.Intro.CharClassSetup;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static File res = new File("./src/Game/settings.txt");

	public static ArrayList<String> getResolution(File f) {
		f = MainMenu.res;
		ArrayList<String> dims = new ArrayList<String>();

		// Reads setting.txt and adds each line (only 2 always) to the ArrayList
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			try (Scanner scan = new Scanner(f)) {
				while (scan.hasNextLine()) {
					dims.add(scan.nextLine());
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// TODO Delete when finished
		for (String s : dims) {
			System.out.println(s);
		}
		return dims;
	}

	int height = 800, width = 680;

	public MainMenu(int height, int width) throws IOException {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int scrWidth = (int) screenSize.getWidth();
			int scrHeight = (int) screenSize.getHeight();
			JFrame frame = new JFrame("Jaathran");
			MainPanel main = new MainPanel(frame);
			Settings settings = new Settings(frame);
			Display display = new Display(frame);
			Gameplay gpl = new Gameplay();
			File temp = new File("ImageData/");
			File[] list = temp.listFiles();

			CharChr chr = new CharChr(list[0]);
			chr.next.setEnabled(false);

			System.out.println("Insert image into /ImageData/, must be 128x128");

			frame.add(main);
			// Corrects if chosen resolution is larger than actual screen
			if (height > scrHeight || width > scrWidth) {
				System.out.println("Screen is too small");
				frame.setSize(240, 320);
			} else if (height < scrHeight && width < scrWidth) {
				System.out.println("Screen resized properly");
				frame.setSize(width, height);
			}

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			main.play.addActionListener(e -> {
				File f = new File("./src/Game/Data/Character/char_data_skills.txt");
				if(f.length() == 0) {
					main.setVisible(false);
					chr.setVisible(true);
					frame.add(chr);
				} else if(f.length() != 0) {
					main.setVisible(false);
					gpl.setVisible(true);
					frame.add(gpl);
				}
			});

			setActionListener(main.settings, (JPanel) main, (JPanel) settings, frame);

			setActionListener(settings.display, (JPanel) settings, (JPanel) display, frame);

			setActionListener(settings.back, (JPanel) settings, (JPanel) main, frame);

			setActionListener(display.exit, (JPanel) display, (JPanel) settings, frame);

			setActionListener(chr.back, (JPanel) chr, (JPanel) main, frame);

			main.exit.addActionListener(e -> {
				System.exit(1);
			});

			chr.next.addActionListener(e -> {
					
				if (chr.nameField.getText().length() > 0) {
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
				try {
					List<String> char_name = Files
							.readAllLines(Paths.get("./src/Game/Data/Character/char_data_skills.txt"));
					String str = char_name.get(0).substring(0, 2).replaceAll(" ", "");
					String dex = char_name.get(1).substring(0, 2).replaceAll(" ", "");
					String con = char_name.get(2).substring(0, 2).replaceAll(" ", "");
					String intl = char_name.get(3).substring(0, 2).replaceAll(" ", "");
					String wis = char_name.get(4).substring(0, 2).replaceAll(" ", "");
					String chars = char_name.get(5).substring(0, 2).replaceAll(" ", "");
					CharClassSetup chrStp = new CharClassSetup(char_name.get(6), Integer.parseInt(str),
							Integer.parseInt(dex), Integer.parseInt(con), Integer.parseInt(intl), Integer.parseInt(wis),
							Integer.parseInt(chars));
					chr.setVisible(false);
					chrStp.setVisible(true);
					frame.add(chrStp);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Insert image into " + System.getProperty("user.dir") + "\\Jaathran\\ImageData\\, must be 128x128");
		}
	}

	/*
	 * Presets buttons to switch between pages. Upcasting is required by JPanel
	 * child classes
	 */
	public void setActionListener(JButton button, JPanel disable, JPanel enable, JFrame frame) {
		button.addActionListener(e -> {
			disable.setVisible(false);
			enable.setVisible(true);
			frame.add(enable);
		});
	}
}
