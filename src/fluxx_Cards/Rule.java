package fluxx_Cards;

import java.util.StringJoiner;

public class Rule extends Card {
	
	public int drawLimit;
	public int playLimit;
	public int handLimit;
	public int keeperLimit;
	
	public Rule() {
		
		this.drawLimit = 0;
		this.playLimit = 0;
		this.handLimit = 0;
		this.keeperLimit = 0;
	}
	
	public Rule(int drawLimit, int playLimit , int keeperLimit, int handLimit) {
		this.drawLimit = drawLimit;
		this.playLimit = playLimit;
		this.handLimit = handLimit;
		this.keeperLimit = keeperLimit;
	}
	
	
	public int getDrawLimit() {
		return drawLimit;
	}
	public void setDrawLimit(int drawLimit) {
		this.drawLimit = drawLimit;
	}
	public int getPlayLimit() {
		return playLimit;
	}
	public void setPlayLimit(int playLimit) {
		this.playLimit = playLimit;
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
	
	@Override
	public String toString() {
	    StringJoiner newRule = new StringJoiner("\n");
	    if(this.getDrawLimit()==1 && this.getPlayLimit()==1)
	    {
	    	newRule.add("[Basic Rule Card]");
	    	newRule.add("Draw Limit : 1");
	    	newRule.add("Play Limit : 1");
	    	return newRule.toString();
	    }
	    else {
	    	newRule.add("[Rule Card]");
		    if(this.getDrawLimit()!=0) {newRule.add("Draw Limit : "+this.getDrawLimit());}
		    if(this.getPlayLimit()!=0) {newRule.add("Play Limit : "+this.getPlayLimit());}
		    if(this.getHandLimit()!=0) {newRule.add("Hand Limit : "+this.getHandLimit());}
		    if(this.getKeeperLimit()!=0) {newRule.add("Keeper Limit : "+this.getKeeperLimit());}
			return newRule.toString();
	    	
	    } 
	}
	
}

