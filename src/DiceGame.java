
public class DiceGame {
	
	public static void playGame() {
		
		int rollTotal = rollDice();
		rollResults(rollTotal);
	}
	
	public static int rollDice() {
		
		int rollCount = 4;
		int sum = 0;
		
		for (int i = 1; i <= rollCount; i++) {
			int roll = (int)(Math.random() * 6) + 1;
		    System.out.println("Roll #" + i + " is: " + roll);
		    sum = sum + roll;
		}
		
		System.out.println("Sum of your dice rolls is: " + sum);	
		System.out.println("");	
		return sum;
	}
	
	public static void rollResults(int rollTotal) {
		
		int[] winNum = {7, 11, 15, 21};
		int[] loseNum = {13, 10, 12, 19, 20, 22, 23, 24};
		int rerollTotal;
		
		//check if player wins
		for (int num : winNum) {
			if (num == rollTotal) {
				System.out.println("You win!");
				return;
			}	
		}
		
		//check if player looses
		for (int num : loseNum) {
			if (num == rollTotal) {
				System.out.println("You lose!");
				return;
			}	
		}
		
		System.out.println("Sudden death! Reroll dice. Match your previous total in order to win!");
		System.out.println("Total to match: " + rollTotal);
		
		rerollTotal = rollDice();
		
		//check if old total with new total
		if (rollTotal == rerollTotal) {
			System.out.println("You win!");
			return;
		} else {
			System.out.println("You lose!");
			return;
		}	
	}
}	
	
