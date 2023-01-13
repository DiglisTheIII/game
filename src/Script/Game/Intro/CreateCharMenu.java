package Script.Game.Intro;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class CreateCharMenu extends JPanel {
    
    JTextField str, dex, con, intl, wis, chrs;

    public CreateCharMenu() {
        setMenu();
    }

    public void setMenu() {

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;

        for(int i = 0; i < 6; i++) {
            c.gridy = i;
            JTextField txt = new JTextField(10);
            add(txt, c);
        }
    }

}
