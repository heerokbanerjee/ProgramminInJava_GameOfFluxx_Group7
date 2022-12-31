/**
 * 
 */
package fluxx_Game;

import fluxx_Cards.Card;
import fluxx_Cards.Goal;
import fluxx_Cards.Rule;
import fluxx_Players.Player;

/**
 * @author hermes
 *
 */
public interface gameInterface {
	
	public void playCard(int tableID, Card thisCard);
	
	public void showKeepers(int tableID);
	
	public void showRules(int tableID);
	
	public void showGoals(int tableID);
	
	public Table updateRules(int tableID, Rule newRule);
	
	public Table updateGoals(int tableID, Goal newGoal);
	
	public void nextTurn(Game thisGame);
	
	public Player checkWinner(int tableID);

}
