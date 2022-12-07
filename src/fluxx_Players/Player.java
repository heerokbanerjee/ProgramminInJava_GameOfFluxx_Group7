/**
 * 
 */
package fluxx_Players;

import fluxx_Cards.Card;
import fluxx_Cards.Keeper;

import java.util.ArrayList;

/**
 * @author hermes
 *
 */
public class Player implements inputHandler {
	
/*
 * **************** GENERIC ATTRIBUTES OF A PLAYER *********************	
 */

int playerID;
String playerName;
ArrayList<Card> myHand;
ArrayList<Keeper> myKeepers; // keepers placed in table

/*
 * **************** GETTERS & SETTERS *********************	
 */

/**
 * @return the playerID
 */
public int getPlayerID() {
	return playerID;
}
/**
 * @param playerID the playerID to set
 */
public void setPlayerID(int playerID) {
	this.playerID = playerID;
}
/**
 * @return the playerName
 */
public String getPlayerName() {
	return playerName;
}
/**
 * @param playerName the playerName to set
 */
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}

/**
 * @return the myHand
 */
public ArrayList<Card> getMyHand() {
	return myHand;
}
/**
 * @param myHand the myHand to set
 */
public void setMyHand(ArrayList<Card> myHand) {
	this.myHand = myHand;
}
/**
 * @return the myKeepers
 */
public ArrayList<Keeper> getMyKeepers() {
	return myKeepers;
}
/**
 * @param myKeepers the myKeepers to set
 */
public void setMyKeepers(ArrayList<Keeper> myKeepers) {
	this.myKeepers = myKeepers;
}

/*
 * **************** MORE UTILITY FUNCTIONS *********************
 * 
 */

public void getPlayerDetails() {
	//To implement	
}

private ArrayList<Card> showHand(){
	//To implement
	return null;
}

public ArrayList<Keeper> showKeepers(){
	//To implement
	return null;
}

public void playCard(Card c) {
	//To implement
}

/*
 * **************** To Handle User Input *********************	
 */

public void handleInput(String input){
	
	String[] commands = input.split(" ");
	
	//Show help
	if(input.matches("[H|h]elp.*")) {
	}
	
	//Show Hand
	if(input.matches("[S|s]how.*[H|h]and.*")) {
	}
	
	//Show Keepers
	if(input.matches("[S|s]how.*[K|k]eeper.*")) {
	}
	
	//Play Card
	if(input.matches("[P|p]lay.*[C|c]ard.*")) {
	}
		
}

	
}
