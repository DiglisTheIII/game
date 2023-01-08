package Game.GameFunctions.Rolls;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerRolls {
    
    public static String error;
    
    public static int calcD4() {
        try {
            return ThreadLocalRandom.current().nextInt(1 , 5);
        }catch(Exception e) {
            EnemyRolls.setErr(e.getStackTrace().toString());
        }
        return -1;
    }

    public static int calcD6() {
        try {
            return ThreadLocalRandom.current().nextInt(1 , 7);
        }catch(Exception e) {
            EnemyRolls.setErr(e.getStackTrace().toString());
        }
        return -1;
    }

    public static int calcD8() {
        try {
            return ThreadLocalRandom.current().nextInt(1 , 9);
        }catch(Exception e) {
            EnemyRolls.setErr(e.getStackTrace().toString());
        }
        return -1;
    }

    public static int calcD10() {
        try {
            return ThreadLocalRandom.current().nextInt(1 , 11);
        }catch(Exception e) {
            EnemyRolls.setErr(e.getStackTrace().toString());
        }
        return -1;
    }

    public static int calcD20() {
        try {
            return ThreadLocalRandom.current().nextInt(1 , 21);
        }catch(Exception e) {
            EnemyRolls.setErr(e.getStackTrace().toString());
        }
        return -1;
    }

    public static String getErr() {
        return EnemyRolls.error;
    }

    public static void setErr(String x) {
        EnemyRolls.error = x;
    }
}