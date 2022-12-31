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
		
	static int num_ID=1;	
	/*
	 * **************** GENERIC ATTRIBUTES OF A PLAYER *********************	
	 */
	
	private int playerID;
	private String playerName;
	private ArrayList<Card> myHand;
	private ArrayList<Keeper> myKeepers; // keepers placed in table
	
	/*
	 * **************** CONSTRUCTOR *********************	
	 */
	public Player() {
		this.setPlayerID(Player.num_ID++);
		this.setPlayerName("");
		this.setMyHand(new ArrayList<Card>());
		this.setMyKeepers(new ArrayList<Keeper>());
	}
	
	//Parameterized Constructor
	public Player(String name) {
		this.setPlayerID(Player.num_ID++);
		this.setPlayerName(name);
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
	
	
	public ArrayList<Card> showHand(){
		
		System.out.println(" >> You have the following cards in your hand:");
		System.out.println("-----------------------------");
		for(int i =0; i< this.getMyHand().size();i++) {
			System.out.println("(Card#"+(i+1)+") --> "+this.getMyHand().get(i));
			System.out.println("-----------------------------");
		}
		return this.getMyHand();
	}
	
	public ArrayList<Keeper> showKeepers(){
		
		if(this.getMyKeepers().size()==0) {System.out.println(" >> You have no Keeper cards in the table!");}
		else {
			System.out.println(" >> You have the following Keeper cards in table:");
			System.out.println("-----------------------------");
			for(int i =0; i< this.getMyKeepers().size();i++) {
				System.out.println((i+1)+" --> "+this.getMyKeepers().get(i));
				System.out.println("-----------------------------");
			}
		}
		return this.getMyKeepers();
	}
	
	public void playCard(int position) {
		//To implement
		Card selectedCard = this.getMyHand().remove(position);
	}
		
}
