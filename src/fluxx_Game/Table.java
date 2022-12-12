/**
 * 
 */
package fluxx_Game;

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
	
	/*
	 * **************** GENERIC ATTRIBUTES OF TABLE ************************
	 */
	int deckSize;
	Stack<Card> Deck;
	
	int playsLeft;
	int drawsLeft;
	
	Rule currentRule;
	Goal currentGoal;
	ArrayList<Keeper> currentKeepers;
	Stack<Card> discardedCards;
	
	

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
	 * @return the currentKeepers
	 */
	public ArrayList<Keeper> getCurrentKeepers() {
		return currentKeepers;
	}


	/**
	 * @param currentKeepers the currentKeepers to set
	 */
	public void setCurrentKeepers(ArrayList<Keeper> currentKeepers) {
		this.currentKeepers = currentKeepers;
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
	
	public Stack<Card> shuffleDeck(Stack<Card> discarded){
		
		//To implement algorithm to randomly shuffle a given deck
		int deckSize=discarded.size();
		for(int i=0;i< deckSize/2;i++) {
			
			int pos1=getRandomPosition(0,deckSize-1);		int pos2=getRandomPosition(0,deckSize-1);
			
			Card card1=this.getDeck().remove(pos1);			Card card2=this.getDeck().remove(pos2);
			
			this.getDeck().add(pos1, card2);				this.getDeck().add(pos2,card1);
			
		}
		return this.getDeck();
	}
	
	
	public Stack<Card> resetDeck(Stack<Card> discarded, Stack<Card> current) {
		return current=shuffleDeck(discarded);
	}
	
	
	public void discard(Card thisCard){
		this.getDiscardedCards().add(thisCard);
	}
	
	public void dealCards(Stack<Card> currentDeck, int num_cards, Player thisPlayer) {
		for(int i=0;i<num_cards;i++) {thisPlayer.getMyHand().add(currentDeck.pop());}
	}
	
	public void dealCards(int index, ArrayList<Card> currentDeck, Player thisPlayer) {
		thisPlayer.getMyHand().add(currentDeck.get(index));
	}
	
}
