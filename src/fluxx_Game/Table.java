/**
 * 
 */
package fluxx_Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	/*
	 * **************** GENERIC ATTRIBUTES OF TABLE ************************
	 */
	private int deckSize;
	private Stack<Card> Deck;
	
	public int playsLeft;
	public int drawsLeft;
	
	private Rule currentRule;
	private Goal currentGoal;
	private ArrayList<Keeper> allKeepers;
	private Stack<Card> discardedCards;
	
	public Table() {
		this.setDeck(new Stack<Card>());
		this.setDiscardedCards(new Stack<Card>());
	}
	
	

	/*
	 * **************** Getters & Setters ************************
	 */
	
	
	/**
	 * @return the deckSize
	 */
	public int getDeckSize() {
		return deckSize;
	}


	/**
	 * @param deckSize the deckSize to set
	 */
	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
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
	 * @return the drawsLeft
	 */
	public int getDrawsLeft() {
		return drawsLeft;
	}


	/**
	 * @param drawsLeft the drawsLeft to set
	 */
	public void setDrawsLeft(int drawsLeft) {
		this.drawsLeft = drawsLeft;
	}


	/**
	 * @return the currentRule
	 */
	public Rule getCurrentRule() {
		return currentRule;
	}


	/**
	 * @param currentRule the currentRule to set
	 */
	public void setCurrentRule(Rule currentRule) {
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


	/*
	 * **************** UTILITY FUNCTIONS ************************
	 */
	
	public int getRandomPosition(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
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
	
	
	public Stack<Card> resetDeck(Stack<Card> discarded, Stack<Card> current) {
		return current=shuffleDeck(discarded);
	}
	
	
	public void discard(Card thisCard){
		this.getDiscardedCards().push(thisCard);
	}
	
	public void dealCards(Stack<Card> currentDeck, int num_cards, Player thisPlayer) {
		for(int i=0;i<num_cards;i++) {thisPlayer.getMyHand().add(currentDeck.pop());}
	}
	
	public void dealCards(int index, ArrayList<Card> currentDeck, Player thisPlayer) {
		thisPlayer.getMyHand().add(currentDeck.get(index));
	}
	
	
	/*
	 * **************** INIT FUNCTIONS ************************
	 */
	
	public Table initTable(Game thisGame, String filename) throws IOException {
		
		/*
		 * **************** Fetching All keeper Cards ************************
		 */
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			   String keeperName;
			   while ((keeperName = br.readLine()) != null) {
				   Keeper newKeeper = new Keeper();
				   newKeeper.setItem(keeperName);
				   this.getDeck().push(newKeeper);
			   }
			}
		
		/*
		 * **************** Generating  Rule Cards ************************
		 */
		
		/*
		 * **************** Generating  Goals Cards ************************
		 */
		
		
		
		/*
		 * **************** Shuffling Deck x 5 times ************************
		 */
		
		
		
		/*
		 * **************** Basic Rule Card ************************
		 */
		
		
		

		return null;
	}
	
}
