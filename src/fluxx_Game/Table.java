/**
 * 
 */
package fluxx_Game;

import java.io.BufferedReader;
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
public class Table {
	
	static int num_ID=1;
	
	/*
	 * **************** GENERIC ATTRIBUTES OF TABLE ************************
	 */
	
	private int tableID;
	private Stack<Card> Deck;
		
	private Stack<Rule> currentRule;
	private Goal currentGoal;
	private ArrayList<Keeper> allKeepers;
	private Stack<Card> discardedCards;
	
	public Table() {
		this.setTableID(Table.num_ID++);
		this.setDeck(new Stack<Card>());
		this.setAllKeepers(new ArrayList<Keeper>());
		this.setCurrentRule(new Stack<Rule>());
		this.setDiscardedCards(new Stack<Card>());
	}	
	

	/*
	 * **************** Getters & Setters ************************
	 */
	
	
	/**
	 * @return the tableID
	 */
	public int getTableID() {
		return tableID;
	}



	/**
	 * @param tableID the tableID to set
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	

	/**
	 * @return the deck
	 */
	public Stack<Card> getDeck() {
		return Deck;
	}


	/**
	 * @param deck the deck to set
	 */
	public void setDeck(Stack<Card> deck) {
		Deck = deck;
	}



	/**
	 * @return the currentRule
	 */
	public Stack<Rule> getCurrentRule() {
		return currentRule;
	}

	

	/**
	 * @param currentRule the currentRule to set
	 */
	public void setCurrentRule(Stack<Rule> currentRule) {
		this.currentRule = currentRule;
	}


	/**
	 * @return the currentGoal
	 */
	public Goal getCurrentGoal() {
		return currentGoal;
	}


	/**
	 * @param currentGoal the currentGoal to set
	 */
	public void setCurrentGoal(Goal currentGoal) {
		this.currentGoal = currentGoal;
	}

	/**
	 * @return the allKeepers
	 */
	public ArrayList<Keeper> getAllKeepers() {
		return allKeepers;
	}



	/**
	 * @param allKeepers the allKeepers to set
	 */
	public void setAllKeepers(ArrayList<Keeper> allKeepers) {
		this.allKeepers = allKeepers;
	}



	/**
	 * @return the discardedCards
	 */
	public Stack<Card> getDiscardedCards() {
		return discardedCards;
	}


	/**
	 * @param discardedCards the discardedCards to set
	 */
	public void setDiscardedCards(Stack<Card> discardedCards) {
		this.discardedCards = discardedCards;
	}

	public int getRandomPosition(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	/*
	 * Method shuffles the deck of cards
	 * 
	 *	@param	thisDeck	deck of cards
	 * 	@return	same deck of cards after shuffling it
	 */
	public Stack<Card> shuffleDeck(Stack<Card> thisDeck){
		
		//To implement algorithm to randomly shuffle a given deck
		int deckSize=thisDeck.size();
		for(int i=0;i< deckSize/2;i++) {
			
			int pos1=getRandomPosition(0,deckSize-1);		int pos2=getRandomPosition(0,deckSize-1);
			
			Card card1=thisDeck.remove(pos1);				Card card2=thisDeck.remove(pos2);
			
			thisDeck.add(pos1, card2);						thisDeck.add(pos2,card1);
			
		}
		return thisDeck;
	}
	
	/*
	 * Method put the discarded cards back into the draw pile when the draw pile becomes empty
	 * 
	 *	@param	discarded	deck of discarded cards
	 *	@param	current		deck of cards 
	 * 	@return	current deck of cards after adding discarded cards into it
	 */
	public Stack<Card> resetDeck(Stack<Card> discarded, Stack<Card> current) {
		return current=shuffleDeck(discarded);
	}
	
	/*
	 * Method put a card into the discarded cards pile
	 * 
	 *	@param	thisCard	a card
	 */
	public void discard(Card thisCard){
		this.getDiscardedCards().push(thisCard);
	}
	
	
	/*
	 * **************** INIT FUNCTIONS ************************
	 */
	
	public Table initTable(String filename, int n) throws IOException {
		
		/*
		 * **************** Fetching All keeper Cards ************************
		 */
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			   String keeperName;
			   while ((keeperName = br.readLine()) != null) {
				   Keeper newKeeper = new Keeper();
				   newKeeper.setItem(keeperName);
				   this.getAllKeepers().add(newKeeper);
				   this.getDeck().push(newKeeper);
			   }
			}
		
		
		/*
		 * **************** Generating  Goals Cards ************************
		 */
		ArrayList<Keeper> tempKeepersList = this.getAllKeepers();
	
		for (int i = 0; i < tempKeepersList.size(); i++) {
			
			Goal thisGoal = new Goal();
			int pos1=getRandomPosition(0,tempKeepersList.size()-1);
			Keeper thisKeeper1 = tempKeepersList.get(pos1);
			tempKeepersList.remove(pos1);
			
			int pos2=getRandomPosition(0,tempKeepersList.size()-1);
			Keeper thisKeeper2 = tempKeepersList.get(pos2);
			tempKeepersList.remove(pos2);
			
			thisGoal.getKeepers().add(thisKeeper1);
			thisGoal.getKeepers().add(thisKeeper2);
			this.getDeck().push(thisGoal);
		}
		
				
		/*
		 * **************** Generating  Rule Cards ************************
		 */
		
		// Single Draw Limit Rule Cards - 'n' times
			for(int i =0; i< n;i++) {
				
			Rule newRule = new Rule(getRandomPosition(2,5),0,0,0);
			this.getDeck().push(newRule);
			
			}
		
		// Single Play Limit Rule Cards - 'n' times
				for(int i =0; i< n;i++) {
					
				Rule newRule = new Rule(0,getRandomPosition(2,5),0,0);
				this.getDeck().push(newRule);
				
			}
		
		// Single Play Limit Rule Cards - 'n' times
				for(int i =0; i< n;i++) {
					
				Rule newRule = new Rule(0,0,getRandomPosition(2,5),0);
				this.getDeck().push(newRule);
				
			}
				
		// Single Play Limit Rule Cards - 'n' times
				for(int i =0; i< n;i++) {
					
				Rule newRule = new Rule(0,0,0,getRandomPosition(2,5));
				this.getDeck().push(newRule);
				
			}		
		
		// Pairs of Rule cards (DrawLimit + KeeperLimit, etc.) are not implemented
		
		/*
		 * **************** Shuffling Deck x 1500*n times ************************
		 */
		int count = 1500*n;
		while (count != 0) {
			Deck = shuffleDeck(Deck);
			count--;
		}
		
		/*
		 * **************** Add Basic Rule Card ************************
		 */
		Rule basicRule = new Rule(1,1,0,0);
		this.getCurrentRule().push(basicRule);
		
		return this;
	}
	
}
