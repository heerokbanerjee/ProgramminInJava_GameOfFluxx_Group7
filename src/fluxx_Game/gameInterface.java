/**
 * 
 */
package fluxx_Game;

import fluxx_Cards.Card;

/**
 * @author hermes
 *
 */
public interface gameInterface {
	
	public void playCard(Card thisCard);
	
	public void showKeepers(Table thisTable);
	
	public void showRules(Table thisTable);
	
	public void showGoals(Table thisTable);
	
	public boolean updateRules(Table thisTable);
	
	public void nextTurn(Game thisGame);
	
	public void checkWinner(Game thisGame);

}
