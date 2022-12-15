package fluxx_Cards;

public class Rule extends Card {
	
	public int drawLimit;
	public int handLimit;
	public int keeperLimit;
	public int playLimit;
	
	public int getDrawLimit() {
		return drawLimit;
	}
	public void setDrawLimit(int drawLimit) {
		this.drawLimit = drawLimit;
	}
	public int getHandLimit() {
		return handLimit;
	}
	public void setHandLimit(int handLimit) {
		this.handLimit = handLimit;
	}
	public int getKeeperLimit() {
		return keeperLimit;
	}
	public void setKeeperLimit(int keeperLimit) {
		this.keeperLimit = keeperLimit;
	}
	public int getPlayLimit() {
		return playLimit;
	}
	public void setPlayLimit(int playLimit) {
		this.playLimit = playLimit;
	}
	
	
}

