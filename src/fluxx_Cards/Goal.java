package fluxx_Cards;
import java.util.List;

public class Goal extends Card {

	public List<Keeper> keepers;

	public List<Keeper> getKeepers() {
		return keepers;
	}

	public void setKeepers(List<Keeper> keepers) {
		this.keepers = keepers;
	}
}
