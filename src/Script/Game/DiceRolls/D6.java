package Script.Game.DiceRolls;

import java.util.concurrent.ThreadLocalRandom;

public class D6 {
	
	public static int _1d6() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}
	
	public static int _2d6() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 7);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 7);
		return roll1 + roll2;
	}
	
	public static int _3d6() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 7);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 7);
		int roll3 = ThreadLocalRandom.current().nextInt(1, 7);
		return roll1 + roll2 + roll3;
	}
	
	public static int _4d6() {
		int roll1 = ThreadLocalRandom.current().nextInt(1, 7);
		int roll2 = ThreadLocalRandom.current().nextInt(1, 7);
		int roll3 = ThreadLocalRandom.current().nextInt(1, 7);
		int roll4 = ThreadLocalRandom.current().nextInt(1, 7);
		return roll1 + roll2 + roll3 + roll4;
	}
	
}
