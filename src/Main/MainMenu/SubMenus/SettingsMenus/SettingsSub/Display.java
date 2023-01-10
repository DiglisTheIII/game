package Main.MainMenu.SubMenus.SettingsMenus.SettingsSub;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Display extends JPanel {
    String selection = "";
    public Display(JFrame frame) {
        //Array of all resolutions supported by Windows 10
        String[] resolutionList = { 
            "3840x2160",
            "2560x1080",
            "1920x1080",
            "1680x1050", 
            "1600x1024",
            "1600x900",
            "1366x768",
            "1360x768",
            "1280x1024",
            "1280x960",
            "1280x800",
            "1280x768",
            "1280x720",
            "1176x664",
            "1152x864",
            "1024x768",
            "800x600"
        };
        JComboBox<String> resolutions = new JComboBox<String>(resolutionList);
        final JButton btn = new JButton("Set resolution");
        this.add(resolutions);
        this.add(btn);
        resolutions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Stores selected item as string.
                selection = (String) resolutions.getSelectedItem();
                if(selection.length() >= 8) {
                    String temp = selection.replace("x", "");
                    int height, width;
                    //Gets rid of 'x' and turns selection into an integer.
                    height = Integer.valueOf(temp.substring(0, 4));
                    width = Integer.valueOf(temp.substring(4, temp.length()));
                    try { writeResolutionToSettings(height, width); } catch (IOException e1) { e1.printStackTrace(); }
                    System.out.println(height + "x" + width);
                } else if(selection.length() < 8) {
                    //Same as before, just with different indexing due to 800x600 having less digits
                    String temp = selection.replace("x", "");
                    int height, width;
                    height = Integer.valueOf(temp.substring(0, 3));
                    width = Integer.valueOf(temp.substring(3, temp.length()));
                    try { writeResolutionToSettings(height, width); } catch (IOException e1) { e1.printStackTrace(); }
                    System.out.println(height + "x" + width);
                }
            }
        });

        this.setVisible(true);
    }

    void writeResolutionToSettings(int height, int width) throws IOException {
        File f = new File("./src/Game/settings.txt");
        System.out.println(f.exists());
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        
        if(!f.exists()) {
            /*
             * Pretty straightfoward, if settings.txt doesn't exist,
             * it creates a new one and writes to it as normal.
             */
            f.createNewFile();
            writer.write(String.valueOf(height) + "\n");
            writer.write(String.valueOf(width));
            writer.close();
        } else if(f.exists() && f.length() == 0) {
            /*
            * Checks if file exists and is empty. If not both then it 
            * will check for existence, and if that fails it will 
            * generate a new file.
            */
            try {
                writer.write(String.valueOf(height) + "\n");
                writer.write(String.valueOf(width));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(f.exists() && f.length() > 0) {
            String line = null;
            try {
                /*
                 * This one is very important, as it erases
                 * the file containing the resolution selected by the player.
                 * This is important so there is no weird conflict, preventing
                 * either a weird ass resolution, or no change at all.
                 */
                BufferedReader reader = new BufferedReader(new FileReader(f));
                PrintWriter pw = new PrintWriter(new FileWriter(f));

                while((line = reader.readLine()) != null) {
                    pw.println(line);
                    pw.flush();
                }
                pw.close();
                reader.close();

                writer.write(String.valueOf(height) + "\n");
                writer.write(String.valueOf(width));
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
