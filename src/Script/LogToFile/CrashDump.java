package Script.LogToFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Game.GameFunctions.Rolls.EnemyRolls;

public class CrashDump {
    
    public String error = EnemyRolls.getErr();

    public void writeToCrashDump() {
        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./Logs/crash_dump.txt")));
            writer.write(error);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
