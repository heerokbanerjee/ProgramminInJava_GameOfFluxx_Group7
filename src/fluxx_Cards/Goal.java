package fluxx_Cards;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Goal extends Card {

	public ArrayList<Keeper> keepers;
	
	
	public Goal() {
		this.setKeepers(new ArrayList<Keeper>());
	}

	public ArrayList<Keeper> getKeepers() {
		return keepers;
	}

	public void setKeepers(ArrayList<Keeper> keepers) {
		this.keepers = keepers;
	}
	
	@Override
	public String toString() {
	    StringJoiner newGoal = new StringJoiner("\n");
	    newGoal.add("[Goal Card]");
	    for(int i = 0; i < this.getKeepers().size(); i++) {
	    	newGoal.add((i+1)+" >> "+this.getKeepers().get(i).getItem().toString());
	    	
		}
		return newGoal.toString();
	}
}
