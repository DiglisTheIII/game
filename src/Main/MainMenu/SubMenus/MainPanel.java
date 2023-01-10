package Main.MainMenu.SubMenus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Almost all panels in this menu work almost the exact same, but
 * once I can figure out layouts I will update this.
 */

public class MainPanel extends JPanel {
    
    public JButton play, settings, exit;

    public MainPanel(JFrame frame) {
        setLayout(new GridBagLayout());

        play = new JButton("Play");
        settings = new JButton("Settings");
        exit = new JButton("Exit");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(play, gbc);

        gbc.gridy = 1;
        add(settings, gbc);

        gbc.gridy = 2;
        add(exit, gbc);
    }

}
