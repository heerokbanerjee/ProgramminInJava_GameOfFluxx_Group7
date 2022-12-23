package fluxx_Cards;
import java.util.List;
import java.util.StringJoiner;

public class Goal extends Card {

	public List<Keeper> keepers;

	public List<Keeper> getKeepers() {
		return keepers;
	}

	public void setKeepers(List<Keeper> keepers) {
		this.keepers = keepers;
	}
	
	@Override
	public String toString() {
	    StringJoiner newGoal = new StringJoiner("\n");
	    newGoal.add("****** Goal Card ******");
	    for(int i = 0; i < this.getKeepers().size(); i++) {
	    	newGoal.add((i+1)+" >> "+this.getKeepers().get(i).toString());
		}
		return newGoal.toString();
	}
}
