package Main;

import java.io.File;

import Main.MainMenu.MainMenu;

public class Runnable {
    
    public int height;
    public int width;

    public Runnable(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public static void main(String[] args) {   
        
        new MainMenu(Integer.valueOf(MainMenu.getResolution(new File("./src/Game/settings.txt")).get(1)), 
            Integer.valueOf(MainMenu.getResolution(new File("./src/Game/settings.txt")).get(0)));     
    }
}
