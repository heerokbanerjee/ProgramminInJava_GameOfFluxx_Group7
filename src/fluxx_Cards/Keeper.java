package fluxx_Cards;

import java.util.StringJoiner;

public class Keeper extends Card {
	
	public String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
	    StringJoiner keeperCard = new StringJoiner("\n");
	    keeperCard.add("****** Keeper Card ******");
	    keeperCard.add(this.getItem().toString());
		return keeperCard.toString();
	}
	
}
