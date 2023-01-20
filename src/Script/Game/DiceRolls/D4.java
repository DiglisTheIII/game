package Script.Game.DiceRolls;

import java.util.concurrent.ThreadLocalRandom;

public class D4 {
	
	public static int _1d4() {
		return ThreadLocalRandom.current().nextInt(1, 5);
	}
	
	public static int _2d4() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 5);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 5);
		return roll1 + roll2;
	}
	
	public static int _3d4() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 5);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 5);
		int roll3 = ThreadLocalRandom.current().nextInt(1, 5);
		return roll1 + roll2 + roll3;
	}
	
	public static int _4d4() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 5);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 5);
		int roll3 = ThreadLocalRandom.current().nextInt(1, 5);
		int roll4 = ThreadLocalRandom.current().nextInt(1, 5);
		return roll1 + roll2 + roll3 + roll4;
	}
	
}
