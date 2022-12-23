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
	
	public void playCard(Card thisCard);
	
	public void showKeepers(Table thisTable);
	
	public void showRules(Table thisTable);
	
	public void showGoals(Table thisTable);
	
	public Table updateRules(Rule newRule, Table thisTable);
	
	public Table updateGoals(Goal newGoal, Table thisTable);
	
	public void nextTurn(Game thisGame);
	
	public Player checkWinner(Table thisTable);

}
