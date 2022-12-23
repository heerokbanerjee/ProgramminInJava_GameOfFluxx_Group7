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
public class Game implements gameInterface {
	
	
	private ArrayList<Player> allPlayers;
	private HashMap<Integer,Keeper> allKeepers;
	private Table table;
	private Player currentPlayer;
	
	/*
	 * **************** Constructor ************************
	 */
	public Game() {
		this.setAllPlayers(new ArrayList<Player>());
		this.setAllKeepers(new HashMap<Integer,Keeper>());
		this.setTable(new Table());
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
	 * @return the allKeepers
	 */
	public HashMap<Integer,Keeper> getAllKeepers() {
		return allKeepers;
	}

	/**
	 * @param allKeepers the allKeepers to set
	 */
	public void setAllKeepers(HashMap<Integer, Keeper> allKeepers) {
		this.allKeepers = allKeepers;
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
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
		
	}

	@Override
	public void showKeepers(Table thisTable) {
		// TODO Auto-generated method stub
		System.out.println("------ All Keeper Cards on the Table -------");
		
		for(Player thisPlayer: thisTable.getCurrentKeepers().keySet()) {
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
	 * **************** START OF GAME ************************
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
		
		
		//******************** Gameplay *****************************
		//System.out.println("Enter the number of players: ");
		//int num_players = ns.nextInt();
	
		//thisGame.getTable().initTable(thisGame);
		
		while(thisGame.checkWinner(thisGame.getTable())==null){
			String input = ns.next();
			thisGame.getCurrentPlayer().handleInput(input);
			
		}
		

	}

}
