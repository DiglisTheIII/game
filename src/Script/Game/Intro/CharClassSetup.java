package Script.Game.Intro;

import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JButton;
=======
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee

public class CharClassSetup extends JPanel {

	/**
<<<<<<< HEAD
	 * 
	 */

	/**
	 * Create the panel.
	 */
	public CharClassSetup(String name, int str, int dex, int con, int intl, int wis, int chars) {
		setLayout(null);
		
		final JLabel lineChange_label = new JLabel("Name:");
		lineChange_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lineChange_label.setBounds(10, 11, 55, 22);
		add(lineChange_label);
		
		JLabel lineChange = new JLabel(name);
		lineChange.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lineChange.setBounds(64, 15, 263, 14);
		add(lineChange);
		
		JLabel str_label = new JLabel("Strength:");
		str_label.setBounds(10, 44, 55, 14);
		add(str_label);
		
		JLabel dex_label = new JLabel("Dexterity:");
		dex_label.setBounds(10, 69, 61, 14);
		add(dex_label);
		
		JLabel con_label = new JLabel("Constitution:");
		con_label.setBounds(10, 94, 93, 14);
		add(con_label);
		
		JLabel intl_label = new JLabel("Intelligence:");
		intl_label.setBounds(10, 119, 70, 14);
		add(intl_label);
		
		JLabel wis_label = new JLabel("Wisdom:");
		wis_label.setBounds(10, 144, 55, 14);
		add(wis_label);
		
		JLabel char_label = new JLabel("Charisma:");
		char_label.setBounds(10, 169, 70, 14);
		add(char_label);
		
		JLabel str1 = new JLabel(String.valueOf(str));
		str1.setBounds(116, 44, 46, 14);
		add(str1);
		
		JLabel dex1 = new JLabel(String.valueOf(dex));
		dex1.setBounds(116, 69, 46, 14);
		add(dex1);
		
		JLabel con1 = new JLabel(String.valueOf(con));
		con1.setBounds(116, 94, 46, 14);
		add(con1);
		
		JLabel intl1 = new JLabel(String.valueOf(intl));
		intl1.setBounds(116, 119, 46, 14);
		add(intl1);
		
		JLabel wis1 = new JLabel(String.valueOf(wis));
		wis1.setBounds(116, 144, 46, 14);
		add(wis1);
		
		JLabel chars1 = new JLabel(String.valueOf(chars));
		chars1.setBounds(116, 169, 46, 14);
		add(chars1);
		
		File folder = new File("ImageData/");
		File[] file = folder.listFiles();
		
		ImageIcon imgIco = new ImageIcon(file[0].getAbsolutePath());
		JLabel img = new JLabel("");
		img.setBounds(157, 11, 152, 272);
		img.setIcon(imgIco);
		add(img);
		
		JButton atronach_btn = new JButton("Atronach");
		atronach_btn.setBounds(319, 13, 121, 23);
		add(atronach_btn);
		
		JButton necromancer_btn = new JButton("Necromancer");
		necromancer_btn.setBounds(319, 65, 121, 23);
		add(necromancer_btn);
		
		JButton barbarian_btn = new JButton("Barbarian");
		barbarian_btn.setBounds(319, 115, 121, 23);
		add(barbarian_btn);
		
		JButton[] btns = {atronach_btn, necromancer_btn, barbarian_btn};
		
		atronach_btn.addActionListener(e -> {
			for(int i = 0; i < btns.length; i++) {
				btns[i].setEnabled(false);
			}
			
			int tempIntl = Integer.parseInt(intl1.getText());
			int atronachIntl = tempIntl + 5;
			int tempWis = Integer.parseInt(wis1.getText());
			int atronachWis = tempWis + 3;
			
			String update1 = String.valueOf(atronachIntl);
			String update2 = String.valueOf(atronachWis);
			
			intl1.setText(update1);
			wis1.setText(update2);
			
			try {
				updateFile(update1, update2, 3, 4, "int", "wis");
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		});
		
		
		necromancer_btn.addActionListener(e -> {
			for(int i = 0; i < btns.length; i++) {
				btns[i].setEnabled(false);
			}
			
			int tempIntl = Integer.parseInt(intl1.getText());
			int necroIntl = tempIntl + 4;
			int tempChar = Integer.parseInt(chars1.getText());
			int necroChar = tempChar + 3;
			
			String update1 = String.valueOf(necroIntl);
			String update2 = String.valueOf(necroChar);
			
			intl1.setText(update1);
			chars1.setText(update2);
			
			try {
				updateFile(update1, update2, 3, 5, "int", "char");
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});
		
		barbarian_btn.addActionListener(e -> {
			for(int i = 0; i < btns.length; i++) {
				btns[i].setEnabled(false);
			}
			
			int tempStr = Integer.parseInt(str1.getText());
			int barbStr = tempStr + 5;
			int tempCon = Integer.parseInt(con1.getText());
			int barbCon = tempCon + 4;
			
			String update1 = String.valueOf(barbStr);
			String update2 = String.valueOf(barbCon);
			
			str1.setText(update1);
			con1.setText(update2);
			
			try {
				updateFile(update1, update2, 0, 2, "str", "con");
			}catch(IOException e3) {
				
			}
		});
	}
	
	
	/* 
	 * up1ind and up2ind are the indices to update when the buttons are pressed. 
	 * 
	 * All this does is pick a line in a file, and replace it with the updated stats.
	 */
	public void updateFile(String update1, String update2, int up1ind, int up2ind, String stat1, String stat2) throws IOException {
		File f = new File("./src/Game/Data/Character/char_data_skills.txt");
		List<String> lineChange = Files
				.readAllLines(Paths.get(f.getAbsolutePath()));
		
		lineChange.set(up1ind, update1 + "		  :" + stat1);
		lineChange.set(up2ind, update2 + "		  :" + stat2);
		Files.write(f.toPath(), lineChange);
	}
	
	public String getCharName() throws IOException {
		return Files.readAllLines(Paths.get("./src/Game/Data/Character/char_data_skills.txt")).get(6);
	}
=======
	 * Create the panel.
	 */
	public CharClassSetup() {

	}

>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
}
