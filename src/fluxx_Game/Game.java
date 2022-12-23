/**
 * 
 */
package fluxx_Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import fluxx_Cards.Card;
import fluxx_Cards.Goal;
import fluxx_Cards.Keeper;
import fluxx_Cards.Rule;
import fluxx_Players.Player;

/**
 * @author hermes
 *
 */
public class Game implements gameInterface, inputHandler {
	
	
	private ArrayList<Player> allPlayers;
	private ArrayList<Table> table;
	private Player currentPlayer;
	
	/*
	 * **************** Constructor ************************
	 */
	public Game() {
		this.setAllPlayers(new ArrayList<Player>());
		this.setTable(new ArrayList<Table>());
		this.setCurrentPlayer(null);
	}
	/*
	 * **************** Getters & Setters ************************
	 */
	
	
	/**
	 * @return the allPlayers
	 */
	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}
	

	/**
	 * @param allPlayers the allPlayers to set
	 */
	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
	/**
	 * @param thisPlayer
	 */
	public void addPlayer(Player thisPlayer) {
		this.getAllPlayers().add(thisPlayer);
	}

	/**
	 * @return the table
	 */
	public ArrayList<Table> getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(ArrayList<Table> table) {
		this.table = table;
	}

	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	
	/*
	 * **************** Interface Implementation ************************
	 */
	@Override
	public void playCard(Card thisCard) {
		// TODO Auto-generated method stub
		
		if (thisCard instanceof Rule) {
			//To implement
			
		}
		
		else if (thisCard instanceof Keeper) {
			//To implement
		}
		
		else if (thisCard instanceof Goal) {
			//To implement
		}
		
		// check if plays left
		
		
	}

	@Override
	public void showKeepers(Table thisTable) {
		// TODO Auto-generated method stub
		System.out.println("------ All Keeper Cards on the Table -------");
		
		for(Player thisPlayer: this.getAllPlayers()) {
			System.out.print(thisPlayer.getPlayerName()+":: ");
			System.out.print(thisPlayer.getMyKeepers());
		}
		
	}

	@Override
	public void showRules(Table thisTable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showGoals(Table thisTable) {
		// TODO Auto-generated method stub
		System.out.print(thisTable.getCurrentGoal());
		
	}

	@Override
	public Table updateRules(Rule newRule, Table thisTable) {
		// TODO Auto-generated method stub
		return thisTable;
	}
	
	@Override
	public Table updateGoals(Goal newGoal, Table thisTable) {
		// TODO Auto-generated method stub
		thisTable.setCurrentGoal(newGoal);
		return thisTable;
	}


	@Override
	public void nextTurn(Game thisGame) {
		// TODO Auto-generated method stub
		thisGame.setCurrentPlayer(thisGame.getAllPlayers().get(thisGame.getAllPlayers().indexOf(currentPlayer)+1));
		//TO:DO initialize play_left + draws_left
		
		// check for hand limit and check for keeper limit
		// ask current player to discard cards
		return;
	}

	@Override
	public Player checkWinner(Table thisTable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void printFile(String fileName) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			   String line;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			}
	}
	
	
	/*
	 * **************** Input Handler Implementation *********************	
	 */
	
	public void handleInput(String input) throws FileNotFoundException, IOException{
		
		String[] commands = input.split(" ");
		
		//Show help
		if(input.matches("[H|h]elp.*")) {
			this.printFile("res/help.txt");
		}
		
		//Show Hand
		if(input.matches("[S|s]how.*[H|h]and.*")) {
			this.getCurrentPlayer().showHand();
		}
		
		//Show Keepers
		if(input.matches("[S|s]how.*[K|k]eeper.*")) {
			this.getCurrentPlayer().showKeepers();
		}
		
		//Play Card
		if(input.matches("[P|p]lay.*[C|c]ard.*")) {
			
		}
			
	}
	
	
	/*
	 * **************** TEST GAME (To be removed) ************************
	 */
	
	/**
	 * @param args
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner ns = new Scanner(System.in);		
		
		//******************** Only For Testing *************************
		
		//******************** Introduction to Game *************************
		
		Game thisGame = new Game();
		thisGame.printFile("res/intro.txt");
		
		thisGame.addPlayer(new Player("Heerok",thisGame));
		thisGame.addPlayer(new Player("Madhurima",thisGame));
		thisGame.addPlayer(new Player("Lesley",thisGame));
		thisGame.addPlayer(new Player("Simon",thisGame));
		thisGame.setCurrentPlayer(thisGame.getAllPlayers().get(0));
		
		thisGame.getTable().get(0).initTable(thisGame,"res/allKeepers.txt");
		//System.out.print(thisGame.getTable().getDeck());
		
		// player 1 draws 3 cards
		thisGame.getTable().get(0).dealCards(thisGame.getTable().get(0).getDeck(), 3, thisGame.getCurrentPlayer());
		
		//System.out.print(thisGame.getCurrentPlayer().getMyHand());
		
		// player 1 discards card number 2
		Card abc= thisGame.getCurrentPlayer().getMyHand().remove(2);
		thisGame.getTable().get(0).discard(abc);
		
		
		System.out.print(thisGame.getTable().get(0).getDiscardedCards());
		
		
		//******************** Gameplay *****************************
		//System.out.println("Enter the number of players: ");
		//int num_players = ns.nextInt();

		//thisGame.getTable().initTable(thisGame);
		
		while(thisGame.checkWinner(thisGame.getTable().get(0))==null){
			String input = ns.next();
			thisGame.handleInput(input);
			
		}
		

	}

}
