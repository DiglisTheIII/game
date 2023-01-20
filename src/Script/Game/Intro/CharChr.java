package Script.Game.Intro;

import javax.swing.JPanel;

import Script.Game.DiceRolls.D6;

import javax.swing.JLabel;
<<<<<<< HEAD
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

=======
import javax.swing.JButton;
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.awt.Image;
=======
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CharChr extends JPanel {
<<<<<<< HEAD

=======
	
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
	/**
	 * 
	 */
	private static final long serialVersionUID = 8598800371276377658L;
	public JButton next, back, reroll;
	public JTextField nameField;
	public int[] skills;

<<<<<<< HEAD
	public CharChr(File f) {
		/*
		 * Most of this is just boilerplate code, just settings up the user environment
		 * before any events are triggered.
		 */

		setLayout(null);

		next = new JButton("Next\r\n");
		next.setBounds(351, 266, 89, 23);
		// add(next);

		back = new JButton("Back");
		back.setBounds(10, 266, 89, 23);
		add(back);

		JLabel str = new JLabel("Strength:");
		str.setBounds(38, 21, 61, 14);
		add(str);

		JLabel num_stat_str = new JLabel("0");
		num_stat_str.setBounds(137, 21, 25, 14);
		add(num_stat_str);

		JLabel dex = new JLabel("Dexterity:");
		dex.setBounds(38, 44, 61, 14);
		add(dex);

		JLabel num_stat_dex = new JLabel("0");
		num_stat_dex.setBounds(137, 44, 33, 14);
		add(num_stat_dex);

		JLabel con = new JLabel("Constitution:");
		con.setBounds(38, 69, 73, 14);
		add(con);

		JLabel num_stat_con = new JLabel("0");
		num_stat_con.setBounds(137, 69, 46, 14);
		add(num_stat_con);

		JLabel intl = new JLabel("Intelligence:");
		intl.setBounds(38, 94, 73, 14);
		add(intl);

		JLabel num_stat_int = new JLabel("0");
		num_stat_int.setBounds(137, 94, 46, 14);
		add(num_stat_int);

		JLabel wis = new JLabel("Wisdom:");
		wis.setBounds(38, 119, 61, 14);
		add(wis);

		JLabel num_stat_wis = new JLabel("0");
		num_stat_wis.setBounds(137, 119, 46, 14);
		add(num_stat_wis);

		JLabel chr = new JLabel("Charisma:");
		chr.setBounds(38, 144, 61, 14);
		add(chr);

		JLabel num_stat_char = new JLabel("0");
		num_stat_char.setBounds(137, 144, 46, 14);
		add(num_stat_char);

		System.out.println("Insert image into " + System.getProperty("user.dir"));

		ImageIcon img = new ImageIcon(f.getAbsolutePath());
		JLabel img_icon = new JLabel();
		img_icon.setBounds(177, 21, 263, 234);
		img_icon.setIcon(img);
		add(img_icon);

=======
	public CharChr() {
		/*
		 * Most of this is just boilerplate code, 
		 * just sets up the user environment before
		 * any events are triggered.
		 */
		
		setLayout(null);
		
		next = new JButton("Next\r\n");
		next.setBounds(351, 266, 89, 23);
		//add(next);
		
		back = new JButton("Back");
		back.setBounds(10, 266, 89, 23);
		add(back);
		
		JLabel str = new JLabel("Strength:");
		str.setBounds(38, 21, 61, 14);
		add(str);
		
		JLabel num_stat_str = new JLabel("0");
		num_stat_str.setBounds(137, 21, 25, 14);
		add(num_stat_str);
		
		JLabel dex = new JLabel("Dexterity:");
		dex.setBounds(38, 44, 61, 14);
		add(dex);
		
		JLabel num_stat_dex = new JLabel("0");
		num_stat_dex.setBounds(137, 44, 33, 14);
		add(num_stat_dex);
		
		JLabel con = new JLabel("Constitution:");
		con.setBounds(38, 69, 73, 14);
		add(con);
		
		JLabel num_stat_con = new JLabel("0");
		num_stat_con.setBounds(137, 69, 46, 14);
		add(num_stat_con);
		
		JLabel intl = new JLabel("Intelligence:");
		intl.setBounds(38, 94, 73, 14);
		add(intl);
		
		JLabel num_stat_int = new JLabel("0");
		num_stat_int.setBounds(137, 94, 46, 14);
		add(num_stat_int);
		
		JLabel wis = new JLabel("Wisdom:");
		wis.setBounds(38, 119, 61, 14);
		add(wis);
		
		JLabel num_stat_wis = new JLabel("0");
		num_stat_wis.setBounds(137, 119, 46, 14);
		add(num_stat_wis);
		
		JLabel chr = new JLabel("Charisma:");
		chr.setBounds(38, 144, 61, 14);
		add(chr);
		
		JLabel num_stat_char = new JLabel("0");
		num_stat_char.setBounds(137, 144, 46, 14);
		add(num_stat_char);
		
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
		reroll = new JButton("Re-roll");
		reroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
<<<<<<< HEAD
				 * Using an array to set the values of the character stats, just made the code a
				 * lot faster to write, and is likely a lot more efficient.
				 */
				JLabel[] labels = { num_stat_str, num_stat_dex, num_stat_con, num_stat_int, num_stat_wis,
						num_stat_char };

				int[] rolls = { randomStr(), randomDex(), randomCon(), randomIntl(), randomWis(), randomChr() };

				for (int i = 0; i < labels.length; i++) {
					labels[i].setText(String.valueOf(rolls[i]));
				}

=======
				 * Using an array to set the values of the character stats, just
				 * made the code a lot faster to write, and is likely a lot more
				 * efficient.
				 */
				JLabel[] labels = { num_stat_str, num_stat_dex, num_stat_con, num_stat_int, num_stat_wis, num_stat_char };
				
				int[] rolls = { randomStr(), randomDex(), randomCon(), randomIntl(), randomWis(), randomChr() };
				
				for(int i = 0; i < labels.length; i++) {
					labels[i].setText(String.valueOf(rolls[i]));
				}
				
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
				setSkills(rolls);
				next.setEnabled(true);
			}
		});
		reroll.setBounds(177, 266, 89, 23);
		add(reroll);
<<<<<<< HEAD

=======
		
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
		nameField = new JTextField();
		nameField.setBounds(38, 169, 107, 20);
		add(nameField);
		nameField.setColumns(10);
<<<<<<< HEAD

		add(next);

		initialize();
	}

	public int getNameLen() {
		return nameField.getText().length();
	}

	private int randomStr() {
		return D6._2d6() * 3;
	}

	private int randomDex() {
		return D6._2d6() * 3;
	}

	private int randomCon() {
		return D6._2d6() * 3;
	}

	private int randomIntl() {
		return D6._2d6() * 3;
	}

	private int randomWis() {
		return D6._2d6() * 3;
	}

=======
		
		add(next);
		initialize();
	}
	
	public int getNameLen() {
		return nameField.getText().length();
	}
	
	private int randomStr() {
		return D6._2d6() * 3;
	}
	
	private int randomDex() {
		return D6._2d6() * 3;
	}
	
	private int randomCon() {
		return D6._2d6() * 3;
	}
	
	private int randomIntl() {
		return D6._2d6() * 3;
	}
	
	private int randomWis() {
		return D6._2d6() * 3;
	}
	
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
	private int randomChr() {
		return D6._2d6() * 3;
	}

	private void initialize() {
		this.setVisible(true);
	}
<<<<<<< HEAD

	private int[] setSkills(int[] skills) {
		return this.skills = skills;
	}

	public void printSkillsToFile(String name) throws IOException {
		/*
		 * Simple file writer, all it does is write the skills and name of the character
		 * to the file listed below.
=======
	
	private int[] setSkills(int[] skills) {
		return this.skills = skills;
	}
	
	public void printSkillsToFile(String name) throws IOException {
		/*
		 * Simple file writer, all it does is write the skills and name of
		 * the character to the file listed below.
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
		 */
		try {
			String[] skillNames = { "str", "dex", "con", "intl", "wisdom", "char" };
			File f = new File("./src/Game/Data/Character/char_data_skills.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
<<<<<<< HEAD
			for (int i = 0; i < this.skills.length; i++) {
				writer.write(this.skills[i] + "        :" + skillNames[i]);
=======
			for(int i = 0; i < this.skills.length; i++) {
				writer.write(this.skills[i] + "     :" + skillNames[i]);
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
				writer.newLine();
			}
			writer.write(name);
			writer.close();
<<<<<<< HEAD
		} catch (FileNotFoundException e) {
=======
		}catch(FileNotFoundException e) {
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee
			e.printStackTrace();
		}
	}
}
