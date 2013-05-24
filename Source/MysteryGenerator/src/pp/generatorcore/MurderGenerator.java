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
	
	private DataCreator dataHandler;
	
	private ArrayList<StoryItem> murderWeaponsList;
	private ArrayList<StoryItem> victimStatesList;
	private ArrayList<StoryItem> locationsList;
	private ArrayList<StoryItem> murdererStatesList;
	
	public StoryItem murderWeapon;
	public StoryItem fatalWound;
	public StoryItem murderLocation;
	public ArrayList<StoryItem> murdererStates;
	
	// Constants
	final private int MIN_MURDERER_STATES_COUNT = 1; // Minimum number of states a victim could have.  If the number is too big, then it won't get there most likely.
	final private int MAX_MURDERER_STATES_COUNT = 3;
	//final private int MIN_VICTIM_STATES_COUNT = 5; // Minimum number of states a victim could have
	//final private int ADD_VICTIM_STATES_COUNT = 3; // Maximum number of states a victim could have over the minimum count
	
	
	
	public MurderGenerator() {
		dataHandler = new DataCreator();
		
		// Get murder weapon list
		murderWeaponsList = dataHandler.readFromFile("murderWeapons.str");
		// Get victim state list
		victimStatesList = dataHandler.readFromFile("victimStates.str");
		// Get murder locations list
		locationsList = dataHandler.readFromFile("locations.str");
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
	
	// Where was the victim killed?  This usually has nothing to do with the previous two items, but keep in mind this is going to affect other locations
	// that will be determined later.
	public void chooseMurderLocation() {
		Random rand = new Random();
		
		murderLocation = locationsList.get(rand.nextInt(locationsList.size()));
	}
	
	// What was the murderer wearing?  This will affect whether his face was seen or whether fingerprints can be found on the murder weapon.
	public void chooseMurdererStates() {
		murdererStates = new ArrayList<StoryItem>();
		Random rand = new Random();
		int diffRand = MAX_MURDERER_STATES_COUNT - MIN_MURDERER_STATES_COUNT;
		
		for (int i = 0; i < MIN_MURDERER_STATES_COUNT + rand.nextInt(diffRand); i++) {
			StoryItem item = murdererStatesList.get(rand.nextInt(murdererStatesList.size()));
			if (!LogicHandler.doesStoryItemWithSameValueOfSpecifiedTypeExistInList(item, "type", murdererStates)) {
				murdererStates.add(item);
			}
		}
	}
	
	public void chooseVictimName() {
		
	}
	
	
	
	
	
}
