/**
 * 
 */
package fluxx_Cards;

/**
 * @author hermes
 *
 */
public abstract class Card {

	int cardID;

	/**
	 * @return the cardID
	 */
	public int getCardID() {
		return cardID;
	}

	/**
	 * @param cardID the cardID to set
	 */
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	@Override
	public String toString() {
		
		// Implement code to return specific string based on sub-class
		return "Card [cardID=" + cardID + "]";
	}
	
	
	
	
}
