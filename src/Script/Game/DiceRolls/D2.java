package Script.Game.DiceRolls;

import java.util.concurrent.ThreadLocalRandom;

public class D2 {
	
	
	public static int _1d2() {
		return ThreadLocalRandom.current().nextInt(1, 3);
	}
	
	public static int _2d2() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 3);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 3);
		return roll1 + roll2;
	}
	
	public static int _3d2() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 3);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 3);
		int roll3 = ThreadLocalRandom.current().nextInt(1, 3);
		return roll1 + roll2 + roll3;
	}
	
	public static int _4d2() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 3);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 3);
		int roll3 = ThreadLocalRandom.current().nextInt(1, 3);
		int roll4 = ThreadLocalRandom.current().nextInt(1, 3);
		return roll1 + roll2 + roll3 + roll4;
	}

}
