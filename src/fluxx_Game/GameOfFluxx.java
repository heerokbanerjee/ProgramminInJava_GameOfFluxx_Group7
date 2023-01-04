package fluxx_Game;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import fluxx_Cards.Goal;
import fluxx_Cards.Rule;
import fluxx_Players.Player;

public class GameOfFluxx extends GameLogic {

	public GameOfFluxx() {
		super();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner ns = new Scanner(System.in);
		
		
		//******************** Intro *************************
		
		GameLogic thisGame = new GameLogic();
		thisGame.printFile("res/intro.txt");
		thisGame.printFile("res/help.txt");
		
		thisGame.addPlayer(new Player("Heerok"));
		thisGame.addPlayer(new Player("Madhurima"));
		thisGame.addPlayer(new Player("Lesley"));
		thisGame.addPlayer(new Player("Simon"));
		thisGame.setCurrentPlayer(thisGame.getAllPlayers().get(0));
		
		thisGame.getAllTables().add(new Table());
		thisGame.getAllTables().get(DEFAULT_TABLE_ID).initTable("res/animals.txt",10);
		//System.out.print(thisGame.getTable().getDeck());
		
		// All players draws 3 cards
		for(Player thisplayer: thisGame.getAllPlayers())
		thisGame.drawCards(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getDeck(), 3,thisplayer);
		
		Rule currentRule = thisGame.showRules(DEFAULT_TABLE_ID);
		thisGame.setPlaysLeft(currentRule.getPlayLimit());
		thisGame.setDrawsLeft(currentRule.getDrawLimit());
		
		//**************** TEST FOR UPDATE RULES ****************
		
				Stack<Rule> rules = thisGame.getAllTables().get(DEFAULT_TABLE_ID).getCurrentRule();
				// add new rule cards
				//thisGame.updateRules(DEFAULT_TABLE_ID, new Rule(0,0,4,0));
				//System.out.print("Discarded >>"+thisGame.getAllTables().get(DEFAULT_TABLE_ID).getDiscardedCards());
				//System.out.println("Stack:"+rules);
				
				
		
		//******************** Gameplay *****************************
		//System.out.println("Enter the number of players: ");
		//int num_players = ns.nextInt();

				
		//**************** TEST FOR UPDATE GOALS >> check for WINNER ****************
		Goal goal = new Goal();
		goal.getKeepers().add(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getAllKeepers().get(1));
		goal.getKeepers().add(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getAllKeepers().get(2));
		thisGame.updateGoals(DEFAULT_TABLE_ID, goal);
		
		//thisGame.getCurrentPlayer().getMyKeepers().add(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getAllKeepers().get(1));
		//thisGame.getCurrentPlayer().getMyKeepers().add(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getAllKeepers().get(2));
		Player p1=thisGame.checkWinner(DEFAULT_TABLE_ID);
		//System.out.println(p1);
		
		while(thisGame.checkWinner(DEFAULT_TABLE_ID)==null){
			System.out.println("\n"+thisGame.getCurrentPlayer().getPlayerName()+" >> You have "+ thisGame.getDrawsLeft()+ " draws and "+thisGame.getPlaysLeft()+ " plays left!");
			System.out.println("["+thisGame.getCurrentPlayer().getPlayerName()+"]>> ");
			String input = ns.nextLine();
			thisGame.handleInput(input);
			
			if(thisGame.getPlaysLeft()==0) {
				System.out.println("********* NEXT TURN *********");
				thisGame.nextTurn();
				System.out.println("********* PLEASE PASS THE DEVICE TO THE NEXT PLAYER >> " + thisGame.getCurrentPlayer().getPlayerName());
			}
		}
		
		System.out.println("********************* CONGRATULATIONS ***************************");
		System.out.println(">> "+thisGame.checkWinner(DEFAULT_TABLE_ID).getPlayerName()+" has won the game!!!");
		
	}

}
