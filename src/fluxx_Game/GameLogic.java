/**
 * 
 */
package fluxx_Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
public class GameLogic implements gameInterface, inputHandler {
	
	public static final int MAX_ALLOWED_PLAYERS=6;
	public static final int DEFAULT_TABLE_ID = 0;
	public int playsLeft;
	public int cardsDrawn;
	
	private ArrayList<Player> allPlayers;
	private ArrayList<Table> allTables;
	private Player currentPlayer;

	
	/*
	 * **************** Constructor ************************
	 */
	public GameLogic() {
		this.setAllPlayers(new ArrayList<Player>());
		this.setAllTables(new ArrayList<Table>());
		this.setCurrentPlayer(null);
		this.setCardsDrawn(0);
		this.setPlaysLeft(0);
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
	
	/**
	 * @return the playsLeft
	 */
	public int getPlaysLeft() {
		return playsLeft;
	}


	/**
	 * @param playsLeft the playsLeft to set
	 */
	public void setPlaysLeft(int playsLeft) {
		this.playsLeft = playsLeft;
	}

	
	/**
	 * @return the cardsDrawn
	 */
	public int getCardsDrawn() {
		return cardsDrawn;
	}

	/**
	 * @param cardsDrawn the cardsDrawn to set
	 */
	public void setCardsDrawn(int cardsDrawn) {
		this.cardsDrawn = cardsDrawn;
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
			
			// set play_limit as per newly added rule
			Rule currentRule = this.showRules(tableID);
			this.setPlaysLeft(currentRule.getPlayLimit());
			
			//update cards drawn if thisCard is a DrawLimit card
			if((currentRule.getDrawLimit() - this.getCardsDrawn())==0)
				this.setCardsDrawn(this.getCardsDrawn());
			else
				this.setCardsDrawn((currentRule.getDrawLimit() - this.getCardsDrawn()));
		}
		
		else if (thisCard instanceof Keeper) {
			//To implement
			this.getCurrentPlayer().getMyKeepers().add((Keeper) thisCard);
		}
		
		else if (thisCard instanceof Goal) {
			//To implement
			this.updateGoals(tableID, (Goal) thisCard);
		}
		
	}

	@Override
	public void showKeepers(int tableID) {
		
		System.out.println("------ All Keeper Cards on the Table -------");
		
		for(Player thisPlayer: this.getAllPlayers()) {
			System.out.print(thisPlayer.getPlayerName()+":: ");
			System.out.println(thisPlayer.getMyKeepers());
		}
		
	}

	@Override
	public Rule showRules(int tableID) {
		//Finding the max of each limit for all rule cards in stack
		Stack<Rule> rules = this.getAllTables().get(tableID).getCurrentRule();
		int play=0,draw=0,hand=0,keep=0;
		
		for(Rule thisRule: rules) {
						
			if(thisRule.getPlayLimit()>play) play=thisRule.getPlayLimit();
			if(thisRule.getDrawLimit()>draw) draw=thisRule.getDrawLimit();
			if(thisRule.getHandLimit()>hand) hand=thisRule.getHandLimit();
			if(thisRule.getKeeperLimit()>keep) keep=thisRule.getKeeperLimit();
		}
		
		Rule currentRule = new Rule(draw,play,keep,hand);		
		return currentRule;
	}

	@Override
	public void showGoals(int tableID) {
		// TODO Auto-generated method stub
		if(this.getAllTables().get(tableID).getCurrentGoal()==null)
			System.out.println("\n>> There are no current goals to win the game!");
		else {
			System.out.println("\n>> The current goal to win the game is :");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(this.getAllTables().get(tableID).getCurrentGoal());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
	}
	

	@Override
	public Table updateRules(int tableID, Rule newRule) {
		// TODO Auto-generated method stub
		Stack<Rule> clone = this.getAllTables().get(tableID).getCurrentRule();
		Stack<Rule> popped= new Stack<Rule>();
		boolean toSwap = false;
		Rule tos;
		
		for(; !clone.isEmpty();popped.push(tos)) {
			tos = clone.pop();
			/*
			 *  ALGORITHM FOR SINGLE RULES IN A 'RULE' CARD
			 * 
			 */ 
			
			//if TOS is Basic Rule Card
			if((tos.getDrawLimit()==1 && tos.getPlayLimit()==1) ) {
				//if(newRule.getDrawLimit()!=0 || newRule.getPlayLimit()!=0)
				clone.push(tos);
				clone.push(newRule);
				break;
			}
			
			else if(tos.getHandLimit()!=0 && newRule.getHandLimit()!=0) {
				toSwap=true;}
			else if(tos.getKeeperLimit()!=0 && newRule.getKeeperLimit()!=0) {
				toSwap=true;}
			else if(tos.getPlayLimit()!=0 && newRule.getPlayLimit()!=0) {
				toSwap=true;}
			else if(tos.getDrawLimit()!=0 && newRule.getDrawLimit()!=0) {
				toSwap=true;}
			else {
				continue;
			}
			
			/*  ************** NOT TESTED *******************
			 *  ALGORITHM FOR TWO PAIRS OF RULES IN A 'RULE' CARD (UNTESTED)
			 * 	
			 *  TO ADD LOGIC FOR OTHER COMBINATIONS OF FIELDS (HANDLIMIT + PLAYLIMIT, etc.)
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
	
			// check for swap
			if(toSwap==true) {
				this.getAllTables().get(tableID).discard(tos);
				clone.push(newRule);
				break;
			}			
		}
		
		//push back all traversed cards in Stack
		for(Rule poppy: popped)
			clone.push(poppy);
		
		
		this.getAllTables().get(tableID).setCurrentRule(clone);
		
		return this.getAllTables().get(tableID);
	}

	@Override
	public Table updateGoals(int tableID, Goal newGoal) {
		this.getAllTables().get(tableID).setCurrentGoal((Goal) newGoal);
		return this.getAllTables().get(tableID);
	}

	/*
	 * Method a player draws cards from the draw pile. Those cards are removed from the draw pile
	 * and added to the player's list of cards.
	 * 
	 *	@param	currentDeck	 draw pile
	 *	@param	num_cards	 number of cards to be drawn from draw pile
	 *	@param	thisPlayer	 an individual player
	 */
	public void drawCards(Stack<Card> currentDeck, int num_cards, Player thisPlayer) {
				
		for(int i=0;i<num_cards;i++) {
			this.drawCards(0,currentDeck,thisPlayer);
			}
	}
	
	/*
	 * Method a player draws a particular card from the draw pile
	 * 
	 *	@param	index	 sequence number of a card in a deck of cards
	 *	@param	currentDeck	 draw pile
	 *	@param	thisPlayer	 an individual player
	 */
	public void drawCards(int index, Stack<Card> currentDeck, Player thisPlayer) {
		
			thisPlayer.getMyHand().add(currentDeck.remove(index));
	}
	
	
	/*
	 * Method Changes the current player of the game to the next player
	 * 
	 */
	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub
		try{this.setCurrentPlayer(this.getAllPlayers().get(this.getAllPlayers().indexOf(currentPlayer)+1));}
		catch(IndexOutOfBoundsException e) {this.setCurrentPlayer(this.getAllPlayers().get(0));}
		
		//re-initialize play_left && cards_drawn
		Rule currentRule = this.showRules(DEFAULT_TABLE_ID);
		this.setCardsDrawn(0);
		this.setPlaysLeft(currentRule.getPlayLimit());
	}

	@Override
	public Player checkWinner(int tableID) {
		
		Goal currentGoal = this.getAllTables().get(tableID).getCurrentGoal();
		if(currentGoal == null) return null;
		
		boolean is_winner =true;
		for(Player thisPlayer: this.getAllPlayers()) {
			for(Keeper thisOne: currentGoal.getKeepers()) {
				if(!thisPlayer.getMyKeepers().contains(thisOne))
					is_winner=false;
			}
			
			if(is_winner==true)
				return thisPlayer;
		}
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
			else if(input.matches("[S|s]how.*[H|h]and.*")) {
				
				this.getCurrentPlayer().showHand();
			}
			
		//Show All keepers
		else if(input.matches("[S|s]how.*[A|a]ll.*[K|k]eeper.*")) {
			
			this.showKeepers(DEFAULT_TABLE_ID);
		}
		
		//Show Keepers
			else if(input.matches("[S|s]how.*[K|k]eeper.*")) {
				
				this.getCurrentPlayer().showKeepers();
			}
		
		//Show Rules
			else if(input.matches("[S|s]how.*[R|r]ule.*")) {
				
				Rule currentRule=this.showRules(DEFAULT_TABLE_ID);
				System.out.println(">> The current rules of the game are: ");
				System.out.println(currentRule);
			}
				
		//Show Goals
			else if(input.matches("[S|s]how.*[G|g]oal.*")) {
				
				this.showGoals(DEFAULT_TABLE_ID);
			}
		
		//Play Card
			else if(input.matches("[P|p]lay.*[C|c]ard.*")) {
				//System.out.print("play");
				int pos;
				try{pos=Integer.valueOf(commands[2])-1;}catch(Exception e) {pos=0;}
				this.playCard(DEFAULT_TABLE_ID,this.getCurrentPlayer().getMyHand().get(pos));
				this.getCurrentPlayer().playCard(pos);
				
				if(this.getPlaysLeft()!=0)
					this.setPlaysLeft(this.getPlaysLeft()-1);
			}
		
		//Discard Card
			else if(input.matches("[D|d]iscard.*[C|c]ard.*")) {
				
				int pos;
				try{pos=Integer.valueOf(commands[2])-1;}catch(Exception e) {pos=0;}
				Card discarded = this.getCurrentPlayer().getMyHand().remove(pos-1);
				this.getAllTables().get(DEFAULT_TABLE_ID).discard(discarded);
			}
		
		//Draw Cards
			else if(input.matches("[D|d]raw.*[C|c]ard.*")) {
				
				int num;
				try{num=Integer.valueOf(commands[2]);}catch(Exception e) {num=1;}
				
				if(this.getCardsDrawn()- this.showRules(DEFAULT_TABLE_ID).getDrawLimit()!=0) {
					this.drawCards(this.getAllTables().get(DEFAULT_TABLE_ID).getDeck(), num, currentPlayer);
					this.setCardsDrawn(this.getCardsDrawn()+1);
					System.out.println("Cards Drawn >>"+ this.getCardsDrawn());
				}
				else
					System.out.println(">> You cannot draw any more cards!");
			}
			else {
				System.out.println(">> \""+input+"\" is not a valid command. Please Type \"help me\" to review the list of recognized commands.");
			}
	}	

}
