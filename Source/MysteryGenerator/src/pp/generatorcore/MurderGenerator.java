package pp.generatorcore;

import java.util.ArrayList;
import java.util.Random;

import pp.generatordatacreator.DataCreator;
import pp.generatordatacreator.StoryItem;

/**
 * MurderGenerator generates all the components to the actual murder itself.
 * @author Paul
 *
 */
public class MurderGenerator {
	
	DataCreator dataHandler;
	
	ArrayList<StoryItem> murderWeaponsList;
	ArrayList<StoryItem> victimStatesList;
	
	StoryItem murderWeapon;
	StoryItem fatalWound;
	
	// Constants
	final int MIN_VICTIM_STATES_COUNT = 5; // Minimum number of states a victim could have
	final int ADD_VICTIM_STATES_COUNT = 3; // Maximum number of states a victim could have over the minimum count
	
	
	
	public MurderGenerator() {
		dataHandler = new DataCreator();
		
		// Get murder weapon list
		murderWeaponsList = dataHandler.readFromFile("murderWeapons.str");
		// Get victim state list
		victimStatesList = dataHandler.readFromFile("victimStates.str");
	}
	
	// It's probably good to start with a murder weapon.  It lets us then determine the wound type, and etc.
	public void chooseMurderWeapon() {
		Random rand = new Random();
		int randIndex = rand.nextInt(murderWeaponsList.size());
		murderWeapon = murderWeaponsList.get(randIndex);		
	}
	
	
	// What wound killed the victim?  It's important to distinguish the fatal wound from "distraction" wounds that will come up later.
	public void chooseFatalWound() {
		Random rand = new Random();
		
		ArrayList<StoryItem> filteredList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Type", "Wound", victimStatesList);
		filteredList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Cause", murderWeapon.getMap().get("Cause"), filteredList);
		
		// Choose a random wound from the filtered list
		fatalWound = filteredList.get(rand.nextInt(filteredList.size()));
	}
	
	
	
}
