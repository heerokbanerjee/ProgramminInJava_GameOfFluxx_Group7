/**
 * 
 */
package fluxx_Players;

/**
 * @author hermes
 *
 */
public interface inputHandler {
	
public static void handleInput(String input) {
	
	String[] commands = input.split(" ");
	
	//Show help
	if(input.matches("[H|h]elp.*")) {
	}
	
	//Show Hand
	if(input.matches("[S|s]how.*[H|h]and.*")) {
	}
	
	//Show Keepers
	if(input.matches("[S|s]how.*[K|k]eeper.*")) {
	}
	
	//Play Card
	if(input.matches("[P|p]lay.*[C|c]ard.*")) {
	}
		
}

}
