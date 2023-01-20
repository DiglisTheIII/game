package Main;

import java.io.File;
import java.io.IOException;

import Main.MainMenu.MainMenu;
import Script.Game.Intro.CharChr;
<<<<<<< HEAD
import Script.Game.Intro.CharClassSetup;
=======
>>>>>>> 62c60336af148deae6e369c9167c3133432808ee

public class Runnable {
    
    public int height;
    public int width;

    public Runnable(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public static void main(String[] args) {   
        
        try {
			new MainMenu(Integer.valueOf(MainMenu.getResolution(new File("./src/Game/settings.txt")).get(1)), 
			    Integer.valueOf(MainMenu.getResolution(new File("./src/Game/settings.txt")).get(0)));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	
    }
}
