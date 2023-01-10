package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Runnable {
    
    JFrame frame;
    JPanel panel;
    int width, height;

    public Runnable() {
        mainMenu(frame);
    }
    
    public static void main(String[] args) {
        new Runnable();
    }

    public JFrame mainMenu(JFrame frame) {
        this.frame = frame;    
        JPanel panel = mainPanel(new JPanel());  
        frame = new JFrame("Jaathran");
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(800, 640);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final int getWidth = frame.getWidth();
        final int getHeight = frame.getHeight();

        JButton START = new JButton("Start");
        START.setSize(10, 10);

        START.addActionListener(ActionEvent -> {
            System.out.println(getWidth + " " + getHeight);
        });

        START.setBounds(frame.getHeight() / 2, frame.getWidth() / 2, 10, 10);

        return this.frame;
    }

    public JPanel mainPanel(JPanel panel) {
        this.panel = panel;
        final JButton START = new JButton("Start");
        final JButton SETTINGS = new JButton("Settings");
        final JButton EXIT = new JButton("Exit");
        GridBagConstraints constr = new GridBagConstraints();

        panel.setLayout(new GridBagLayout());

        constr.insets = new Insets(5, 5, 5, 5);
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridx = 0;
        constr.gridy = 0;
        constr.gridwidth = 1;

        panel.add(START, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        panel.add(SETTINGS, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        panel.add(EXIT, constr);

        START.addActionListener(ActionEvent -> {
            
        });

        SETTINGS.addActionListener(ActionEvent -> {

        });

        EXIT.addActionListener(ActionEvent -> {
            System.exit(1);
        });

        return panel;
    }
}
