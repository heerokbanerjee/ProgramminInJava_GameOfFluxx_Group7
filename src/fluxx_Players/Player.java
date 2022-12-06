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
public class Player {
	
/*
 * **************** GENERIC ATTRIBUTES OF A PLAYER *********************	
 */

private int playerID;
public String playerName;
private ArrayList<Card> myHand;
public ArrayList<Keeper> myKeepers;

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

	
}
