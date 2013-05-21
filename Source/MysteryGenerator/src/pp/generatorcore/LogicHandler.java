package pp.generatorcore;

import java.util.ArrayList;
import java.util.Random;

import pp.generatordatacreator.StoryItem;

/**
 * LogicHandler is responsible for picking certain story elements that are critical in a mystery plot, such as the murder weapon, murder location, victim type, murder type, and etc.
 * @author PaulPa
 *
 */
public class LogicHandler {

	ArrayList<StoryItem> storyList;
	
	public LogicHandler(ArrayList<StoryItem> storyList) {
		this.storyList = storyList;
	}
	
	// It's probably good to start with a murder weapon.  It lets us then determine the wound type, and etc.
	public StoryItem chooseMurderWeapon() {
		Random rand = new Random();
		
	}
	
	
	
}
