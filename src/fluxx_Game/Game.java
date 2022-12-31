/**
 * 
 */
package fluxx_Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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
	
	public static final int MAX_ALLOWED_PLAYERS=6;
	public static final int DEFAULT_TABLE_ID = 0;
	private ArrayList<Player> allPlayers;
	private ArrayList<Table> allTables;
	private Player currentPlayer;
	
	/*
	 * **************** Constructor ************************
	 */
	public Game() {
		this.setAllPlayers(new ArrayList<Player>());
		this.setAllTables(new ArrayList<Table>());
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
	public ArrayList<Table> getAllTables() {
		return allTables;
	}

	/**
	 * @param table the table to set
	 */
	public void setAllTables(ArrayList<Table> table) {
		this.allTables = table;
	}
	
	/**
	 * @param thisPlayer
	 */
	public void addTable(Table thisTable) {
		this.getAllTables().add(thisTable);
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
	 * **************** Game Interface Implementation ************************
	 */
	@Override
	public void playCard(int tableID, Card thisCard) {
		// TODO Auto-generated method stub
		
		if (thisCard instanceof Rule) {
			//To implement
			this.updateRules(tableID, (Rule) thisCard);
		}
		
		else if (thisCard instanceof Keeper) {
			//To implement
			this.getCurrentPlayer().getMyKeepers().add((Keeper) thisCard);
		}
		
		else if (thisCard instanceof Goal) {
			//To implement
			this.updateGoals(tableID, (Goal) thisCard);
		}
		
		// check if plays left
		
		
	}

	@Override
	public void showKeepers(int tableID) {
		// TODO Auto-generated method stub
		System.out.println("------ All Keeper Cards on the Table -------");
		
		for(Player thisPlayer: this.getAllPlayers()) {
			System.out.print(thisPlayer.getPlayerName()+":: ");
			System.out.print(thisPlayer.getMyKeepers());
		}
		
	}

	@Override
	public void showRules(int tableID) {
		// TODO Auto-generated method stub
		System.out.print(this.getAllTables().get(tableID).getCurrentRule());
	}

	@Override
	public void showGoals(int tableID) {
		// TODO Auto-generated method stub
		System.out.print(this.getAllTables().get(tableID).getCurrentGoal());
		
	}
	

	@Override
	public Table updateRules(int tableID, Rule newRule) {
		// TODO Auto-generated method stub
		Stack<Rule> clone = this.getAllTables().get(tableID).getCurrentRule();
		Stack<Rule> popped= new Stack<Rule>();
		
		for(Rule tos = clone.pop(); clone.isEmpty();popped.push(tos)) {
			
			/*
			 *  ALGORITHM FOR SINGLE RULES IN A 'RULE' CARD
			 * 
			 */ 
			
			boolean toSwap = false;
			
			//if TOS is Basic Rule Card
			if((tos.getDrawLimit()==1 && tos.getPlayLimit()==1) ) {
				//if(newRule.getDrawLimit()!=0 || newRule.getPlayLimit()!=0)
				clone.push(newRule);
			}
			
			if(tos.getHandLimit()!=0 && newRule.getHandLimit()!=0) {toSwap=true;}
			if(tos.getKeeperLimit()!=0 && newRule.getKeeperLimit()!=0) {toSwap=true;}
			
			
			/*
			 *  ALGORITHM FOR TWO PAIRS OF RULES IN A 'RULE' CARD (UNTESTED)
			 * 	
			 *  NOT TESTED >> TO ADD LOGIC FOR OTHER COMBINATIONS OF FIELDS (HANDLIMIT + PLAYLIMIT, etc.)
			 *  
			 	if(tos.getDrawLimit() != 0 && newRule.getDrawLimit()!=0) {
				
					if(tos.getHandLimit()!=0 && newRule.getHandLimit()!=0 && (tos.getKeeperLimit()==0 && tos.getPlayLimit()==0)) {
						toSwap=true;
					}
					
					if(tos.getKeeperLimit()!=0 && newRule.getKeeperLimit()!=0 && (tos.getHandLimit()==0 && tos.getPlayLimit()==0)) {
						toSwap=true;
					}
					
					if(tos.getPlayLimit()!=0 && newRule.getPlayLimit()!=0 && (tos.getKeeperLimit()==0 && tos.getHandLimit()==0)) {
						toSwap=true;
					}	
				
				}
			 */
			
			// check for swap or to push
			if(toSwap==true) {
				
				Rule toDiscard= this.getAllTables().get(tableID).getCurrentRule().pop();
				this.getAllTables().get(tableID).discard(toDiscard);
				clone.push(newRule);
				break;
			}
				
			
		}
		
		for(Rule poppy: popped)
			clone.push(poppy);
		
		
		this.getAllTables().get(tableID).setCurrentRule(clone);
		
		
		return null;
	}

	@Override
	public Table updateGoals(int tableID, Goal newGoal) {
		// TODO Auto-generated method stub
		this.getAllTables().get(tableID).setCurrentGoal((Goal) newGoal);
		return null;
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
	public Player checkWinner(int tableID) {
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
	 * **************** INIT FUNCTIONS ************************
	 */
	
	public Game initGame(int num_tables, int num_players, int num_dealCards){
				
		/*
		 * **************** Add Players to Game ************************
		 */
		
		for(int i =0; i<num_players;i++) {
			Player newPlayer = new Player();
			
			this.addPlayer(newPlayer);
		}
		

		/*
		 * **************** Add Tables to Game ************************
		 */
		
		for(Table thisTable: allTables) {
			this.addTable(thisTable);
		}
		
		/*
		 * **************** Deal 'num_dealCards' Cards to each Player ************************
		 */
		
		for(Table thisTable: this.getAllTables()) {
			
			for(Player thisPlayer: this.getAllPlayers()) 
				thisTable.drawCards(thisTable.getDeck(), num_dealCards, thisPlayer);				
		}
		
		return this;
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
			
		//Show All keepers
		
		//Show Rules
			if(input.matches("[S|s]how.*[R|r]ule.*")) {
				this.showRules(DEFAULT_TABLE_ID);
			}
				
		//Show Goals
			if(input.matches("[S|s]how.*[G|g]oal.*")) {
				this.getAllTables().get(DEFAULT_TABLE_ID).getCurrentGoal();
			}
		
		//Play Card
			if(input.matches("[P|p]lay.*[C|c]ard.*")) {
				int pos=Integer.valueOf(commands[2])-1;
				this.playCard(DEFAULT_TABLE_ID,this.getCurrentPlayer().getMyHand().get(pos));
				this.getCurrentPlayer().playCard(pos);
				
			}
		
		//Discard Card
			if(input.matches("[D|d]iscard.*[C|c]ard.*")) {
				int pos=Integer.valueOf(commands[2]);
				Card discarded = this.getCurrentPlayer().getMyHand().remove(pos-1);
				this.getAllTables().get(DEFAULT_TABLE_ID).discard(discarded);
			}
		
		//Draw Cards
			if(input.matches("[D|d]raw.*[C|c]ard.*")) {
				int num;
				try{num=Integer.valueOf(commands[2]);}catch(Exception e) {num=1;}
				this.getAllTables().get(DEFAULT_TABLE_ID).drawCards(this.getAllTables().get(DEFAULT_TABLE_ID).getDeck(), num, currentPlayer);
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
		
		thisGame.addPlayer(new Player("Heerok"));
		thisGame.addPlayer(new Player("Madhurima"));
		thisGame.addPlayer(new Player("Lesley"));
		thisGame.addPlayer(new Player("Simon"));
		thisGame.setCurrentPlayer(thisGame.getAllPlayers().get(0));
		
		thisGame.getAllTables().add(new Table());
		thisGame.getAllTables().get(DEFAULT_TABLE_ID).initTable("res/allKeepers.txt",10);
		//System.out.print(thisGame.getTable().getDeck());
		
		// player 1 draws 3 cards
		thisGame.getAllTables().get(DEFAULT_TABLE_ID).drawCards(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getDeck(), 3, thisGame.getCurrentPlayer());
		
		//System.out.print(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getCurrentRule());
		//System.out.println(thisGame.getAllTables().get(DEFAULT_TABLE_ID).getDeck());
		
		
		// player 1 discards card number 2
		//Card abc= thisGame.getCurrentPlayer().getMyHand().remove(2);
		//thisGame.getAllTables().get(DEFAULT_TABLE_ID).discard(abc);
		
		
		//System.out.print(thisGame.getTable().get(0).getDiscardedCards());
		
		
		//******************** Gameplay *****************************
		//System.out.println("Enter the number of players: ");
		//int num_players = ns.nextInt();

		
		while(thisGame.checkWinner(DEFAULT_TABLE_ID)==null){
			String input = ns.nextLine();
			thisGame.handleInput(input);
			
		}
		
	}

}
