/**
 * 
 */
package fluxx_Players;

import fluxx_Cards.Card;
import fluxx_Cards.Keeper;
import fluxx_Game.Game;
import fluxx_Game.inputHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author hermes
 *
 */
public class Player{
		
	static int num_ID=0;	
	/*
	 * **************** GENERIC ATTRIBUTES OF A PLAYER *********************	
	 */
	
	private int playerID;
	private String playerName;
	private Game myGame;
	private ArrayList<Card> myHand;
	private ArrayList<Keeper> myKeepers; // keepers placed in table
	
	/*
	 * **************** CONSTRUCTOR *********************	
	 */
	public Player(String Name, Game thisGame) {
		this.setPlayerID(Player.num_ID++);
		this.setPlayerName(Name);
		this.setMyGame(thisGame);
		this.setMyHand(new ArrayList<Card>());
		this.setMyKeepers(new ArrayList<Keeper>());
	}
	
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
	 * @return the myGame
	 */
	public Game getMyGame() {
		return myGame;
	}
	
	/**
	 * @param myGame the myGame to set
	 */
	public void setMyGame(Game myGame) {
		this.myGame = myGame;
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
	 * **************** MORE UTILITY FUNCTIONS (OUTPUT)*********************
	 * 
	 */
	
	public void getPlayerDetails() {
		//To implement	
	}
	
	public ArrayList<Card> showHand(){
		
		//   [1] : Keeper Card -- > Ghoda
		//   [2] : Rule Card --> keeper limit 2
		//To implement
		return null;
	}
	
	public ArrayList<Keeper> showKeepers(){
		//To implement
		return null;
	}
	
	public void playCard(int position) {
		//To implement
		Card selectedCard = this.getMyHand().remove(position);
		this.getMyGame().playCard(selectedCard);
	}
		
}
