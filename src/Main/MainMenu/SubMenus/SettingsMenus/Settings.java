package Main.MainMenu.SubMenus.SettingsMenus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Settings extends JPanel {

    public JButton display, gameplay, back;

    public Settings(JFrame frame) {
        setLayout(new GridBagLayout());

        display = new JButton("Display");
        gameplay = new JButton("Gameplay");
        back = new JButton("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(display, gbc);

        gbc.gridy = 1;
        add(gameplay, gbc);

        gbc.gridy = 2;
        add(back, gbc);

    }

}
