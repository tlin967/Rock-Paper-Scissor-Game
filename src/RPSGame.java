import java.util.Random;

public class RPSGame {
	
	private int cWins;
	private int uWins;
	private int ties;
	private static final String ROCK = "ROCK";
	private static final String PAPER = "PAPER";
	private static final String SCISSORS= "SCISSORS";
	private static final String USER_WINS = "You win. ";
	private static final String COMPUTER_WINS = "You lose. ";
	private static final String TIE = "It's a tie. ";
	private int computerPlay;
	private String computerPlayed;
	private String userPlay;
	private String winner;
	
	public RPSGame() {
		cWins = 0;
		uWins = 0;
		ties = 0;
	}

	public int getCWins() {
		return cWins;
	}

	public int getUWins() {
		return uWins;
	}

	public int getTies() {
		return ties;
	}

	public String getWinner() {
		return winner;
	}

	public String getUserPlay(){
		return userPlay;
	}
	
	public String getComputerPlay(){
		return computerPlayed;
	}
	public void setCWins(int theNewCWins) {
		if (theNewCWins >= 0) {
			cWins = theNewCWins;
		}
	}
	public void setUWins(int theNewUWins) {
		if (theNewUWins >= 0) {
			uWins = theNewUWins;
		}
	}
	public void setTies(int theNewTies) {
		if (theNewTies >= 0) {
			ties = theNewTies;
		}
	}
	public void setMove(String move){
		userPlay = move;
	}
	public String toString(){
		String t = "\nYou chose: " + userPlay ;
		t += "\nComputer chose: " + computerPlayed;
		t += "\n" + winner;
		t += "\n\nTies: " + ties + " Wins: " + uWins + " Losses: " + cWins;
		return t;
	}
	
	// Generates random computer plays 
	public String generateComputerPlay() {
		Random generator = new Random();
		computerPlay = generator.nextInt(3)+1;
		if(computerPlay == 1){
			computerPlayed = ROCK;
			return ROCK;
		}
		else if(computerPlay == 2) {
			computerPlayed = PAPER;
			return PAPER;
		}
		else{
			computerPlayed = SCISSORS;
			return SCISSORS;
		}
	}

	// This method determines how a winner is chosen
	public String findWinner() { 
		if ((userPlay == ROCK && computerPlayed == PAPER) || (userPlay == PAPER && computerPlayed == SCISSORS)
				|| (userPlay == SCISSORS && computerPlayed == ROCK)) {
			cWins++;
			winner = COMPUTER_WINS;
			return COMPUTER_WINS;
		} else if ((userPlay == ROCK && computerPlayed == SCISSORS) || (userPlay == SCISSORS && computerPlayed == PAPER)
				|| (userPlay == PAPER && computerPlayed == ROCK)) {
			uWins++;
			winner = USER_WINS;
			return USER_WINS;
		} else {
			ties++;
			winner = TIE;
			return TIE;
		}
	}
	
}
