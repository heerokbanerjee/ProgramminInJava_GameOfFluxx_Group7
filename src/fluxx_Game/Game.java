/**
 * 
 */
package fluxx_Game;

import java.util.ArrayList;
import fluxx_Cards.Keeper;
import fluxx_Players.Player;

/**
 * @author hermes
 *
 */
public class Game {
	
	
	ArrayList<Player> allPlayers;
	ArrayList<Keeper> allKeepers;
	Table table;
	Player currentPlayer;
	
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
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
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
	
	/*
	 * **************** START OF GAME ************************
	 */
	
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
