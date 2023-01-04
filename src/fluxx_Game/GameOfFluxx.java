package fluxx_Game;

import java.io.IOException;
import java.util.Scanner;

import fluxx_Players.Player;

public class GameOfFluxx extends GameLogic implements inputHandler {

	public GameOfFluxx() {
		super();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner ns = new Scanner(System.in);
		
		
		//******************** Introduction *************************
		
		GameLogic thisGame = new GameLogic();
		thisGame.printFile("res/intro.txt");
		thisGame.printFile("res/help.txt");
		
		//******************** Adding Players *************************
		
		int num_players=0;
		System.out.println("\n>> Please enter the number of players in the game:");
		for(num_players=ns.nextInt();(num_players>GameLogic.MAX_ALLOWED_PLAYERS || num_players==0);num_players=ns.nextInt()) {	
			System.out.println("\n>> Maximum number of allowed players are upto : "+ GameLogic.MAX_ALLOWED_PLAYERS);
			System.out.println(">> Please enter a valid number of players in the game:");
		}
		for(int i=0;i<num_players;i++) {
			String name;
			Player newPlayer = new Player();
			System.out.println(">> Enter name of Player#"+(i+1)+">> ");
			name = ns.next();
			newPlayer.setPlayerName(name);
			thisGame.addPlayer(newPlayer);
		}
		
		//******************** Initialize Tables - By Default 1 Table *************************
		
		thisGame.getAllTables().add(new Table());
		thisGame.getAllTables().get(DEFAULT_TABLE_ID).initTable("res/animals.txt",10);
		thisGame.setCurrentPlayer(thisGame.getAllPlayers().get(0));
		
		// Deal 3 cards to each player
		for(Player thisplayer: thisGame.getAllPlayers())
		thisGame.drawCards(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getDeck(), 3,thisplayer);
		
		// Set plays left to current Rule --> Basic Rule --> Play 1
		thisGame.setPlaysLeft(thisGame.showRules(DEFAULT_TABLE_ID).getPlayLimit());
		
		// Just to help with nextLine() inconsistency in IDE console
		System.out.println(">> Type 'help me' to review how to play the game! Press any key to continue ....");
		ns.nextLine();
		
		// Gameplay
		while(thisGame.checkWinner(DEFAULT_TABLE_ID)==null){
			//clear console with escape character
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			System.out.println("\n"+thisGame.getCurrentPlayer().getPlayerName()+" >> You have "+ (thisGame.showRules(DEFAULT_TABLE_ID).getDrawLimit()- thisGame.getCardsDrawn())+ " draws and "+thisGame.getPlaysLeft()+ " plays left!");
			System.out.println("["+thisGame.getCurrentPlayer().getPlayerName()+"]>> ");
			
			String input = ns.nextLine();
			thisGame.handleInput(input);
	
			if(thisGame.getPlaysLeft()==0) {
				System.out.println(">> ********* NEXT TURN *********");
				thisGame.nextTurn();
				System.out.println(">> ********* PLEASE PASS THE DEVICE TO THE NEXT PLAYER >> " + thisGame.getCurrentPlayer().getPlayerName());
			}
		}
		
		//Winner of Game
		System.out.println("\n>>********************* CONGRATULATIONS ***************************");
		System.out.println(">> "+thisGame.checkWinner(DEFAULT_TABLE_ID).getPlayerName()+" has won the game!!!");
		
	}

}
