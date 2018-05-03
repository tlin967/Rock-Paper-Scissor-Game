import java.util.Scanner;

// This is the non-GUI version of the application
public class RPSConsoleGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Rock, Paper, Scissors! ");
		
		RPSGame game = new RPSGame();
		
		String userMove = "r";
		while((userMove.equals("r") || userMove.equals("p") || userMove.equals("s"))) {
			System.out.println("To play, enter: ");
			System.out.println("	'r' to play ROCK ");
			System.out.println("	'p' to play PAPER ");
			System.out.println("	's' to play SCISSORS ");
			System.out.println("	or any other characters to quit.");
			
			userMove = scan.next();
			
			if(userMove.equals("r")){
				game.setMove("ROCK");
				game.generateComputerPlay();
				game.findWinner();
				System.out.println(game.toString());
				
			}
			else if(userMove.equals("p")) {
				game.setMove("PAPER");
				game.generateComputerPlay();
				game.findWinner();
				System.out.println(game.toString());
			}
			else if(userMove.equals("s")){
				game.setMove("SCISSORS");
				game.generateComputerPlay();
				game.findWinner();
				System.out.println(game.toString());
			}
		}
		
	
	}

}
