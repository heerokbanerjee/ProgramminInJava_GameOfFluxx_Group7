/**
 * 
 */
package fluxx_Game;

import java.util.ArrayList;

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
	ArrayList<Card> Deck;
	
	int playsLeft;
	int drawsLeft;
	
	Rule currentRule;
	Goal currentGoal;
	ArrayList<Keeper> currentKeepers;
	ArrayList<Card> discardedCards;
	
	

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
	public ArrayList<Card> getDeck() {
		return Deck;
	}


	/**
	 * @param deck the deck to set
	 */
	public void setDeck(ArrayList<Card> deck) {
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
	public ArrayList<Card> getDiscardedCards() {
		return discardedCards;
	}


	/**
	 * @param discardedCards the discardedCards to set
	 */
	public void setDiscardedCards(ArrayList<Card> discardedCards) {
		this.discardedCards = discardedCards;
	}


	/*
	 * **************** UTILITY FUNCTIONS ************************
	 */

	public ArrayList<Card> shuffleDeck(ArrayList<Card> thisDeck){
		//To implement algorithm to shuffle a given deck
		return null;
	}
	
	
	public void resetDeck(ArrayList<Card> discarded, ArrayList<Card> current) {
		//To implement
	}
	
	
	public void discard(Card thisCard){
		//To implement
	}
	
	public void dealCards(ArrayList<Card> currentDeck, int num_cards, Player thisPlayer) {
		//To implement
	}
	
}
