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
	public int deckSize;
	public ArrayList<Card> Deck;
	
	public int playsLeft;
	public int drawsLeft;
	
	public Rule currentRule;
	public Goal currentGoal;
	public ArrayList<Keeper> currentKeepers;
	public ArrayList<Card> discardedCards;

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
	
	
	public void discard() {
		//To implement
	}
	
	public void dealCards(ArrayList<Card> currentDeck, int num_cards, Player thisPlayer) {
		//To implement
	}
	
}
