import java.util.Scanner;

import fluxx_Game.Game;

/**
 * 
 */

/**
 * @author hermes
 *
 */
public class GameOfFluxx extends Game {
	
	
	public GameOfFluxx() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		GameOfFluxx thisGame = new GameOfFluxx();
		Scanner ns = new Scanner(System.in);
		
		
		thisGame.printFile("res/intro.txt");
		

	}

}
