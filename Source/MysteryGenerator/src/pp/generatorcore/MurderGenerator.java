package pp.generatorcore;

import java.util.ArrayList;
import java.util.Random;

import pp.common.DataLoader;
import pp.common.Name;
import pp.common.Time;
import pp.generatordatacreator.StoryItem;

/**
 * MurderGenerator generates all the components to the actual murder itself.
 * @author Paul
 *
 */
public class MurderGenerator {
	
	public static StoryItem murderWeapon;
	public static StoryItem fatalWound;
	public static StoryItem murderLocation;
	public static ArrayList<StoryItem> murdererStates;
	public static Name victimName;
	public static Name murdererName;
	public static StoryItem murderMotive;
	public static Time murderTime;
	
	// Constants
	final private static int MIN_MURDERER_STATES_COUNT = 1; // Minimum number of states a victim could have.  If the number is too big, then it won't get there most likely.
	final private static int MAX_MURDERER_STATES_COUNT = 3;
	//final private static int MIN_VICTIM_STATES_COUNT = 5; // Minimum number of states a victim could have
	//final private static int ADD_VICTIM_STATES_COUNT = 3; // Maximum number of states a victim could have over the minimum count
	
	
	
	public MurderGenerator() {
	}
	
	// It's probably good to start with a murder weapon.  It lets us then determine the wound type, and etc.
	private static void chooseMurderWeapon() {
		Random rand = new Random();
		int randIndex = rand.nextInt(DataLoader.murderWeaponsList.size());
		murderWeapon = DataLoader.murderWeaponsList.get(randIndex);		
	}
	
	
	// What wound killed the victim?  It's important to distinguish the fatal wound from "distraction" wounds that will come up later.
	private static void chooseFatalWound() {
		Random rand = new Random();
		
		ArrayList<StoryItem> filteredList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Type", "Wound", DataLoader.victimStatesList);
		filteredList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Cause", murderWeapon.getMap().get("Cause"), filteredList);
		
		// Choose a random wound from the filtered list
		fatalWound = filteredList.get(rand.nextInt(filteredList.size()));
	}
	
	// Where was the victim killed?  This usually has nothing to do with the previous two items, but keep in mind this is going to affect other locations
	// that will be determined later.
	private static void chooseMurderLocation() {
		Random rand = new Random();
		
		murderLocation = DataLoader.locationsList.get(rand.nextInt(DataLoader.locationsList.size()));
	}
	
	// What was the murderer wearing?  This will affect whether his face was seen or whether fingerprints can be found on the murder weapon.
	private static void chooseMurdererStates() {
		murdererStates = new ArrayList<StoryItem>();
		Random rand = new Random();
		int diffRand = MAX_MURDERER_STATES_COUNT - MIN_MURDERER_STATES_COUNT;
		
		for (int i = 0; i < MIN_MURDERER_STATES_COUNT + rand.nextInt(diffRand); i++) {
			StoryItem item = DataLoader.murdererStatesList.get(rand.nextInt(DataLoader.murdererStatesList.size()));
			if (!LogicHandler.doesStoryItemWithSameValueOfSpecifiedTypeExistInList(item, "type", murdererStates)) {
				murdererStates.add(item);
			}
		}
	}
	
	// Randomly generate the victim's name.
	private static void chooseVictimName() {
		Random rand = new Random();
		
		StoryItem nameStoryItem = DataLoader.namesList.get(rand.nextInt(DataLoader.namesList.size()));
		victimName = new Name(nameStoryItem.getMap().get("FirstName"), nameStoryItem.getMap().get("LastName"));
	}
	
	// Randomly generate the murderer's name.
	private static void chooseMurdererName() {
		Random rand = new Random();
		
		StoryItem nameStoryItem = DataLoader.namesList.get(rand.nextInt(DataLoader.namesList.size()));
		murdererName = new Name(nameStoryItem.getMap().get("FirstName"), nameStoryItem.getMap().get("LastName"));
	}
	
	// What is the murderer's motive.  This is a complex decision for the generator to make.
	private static void chooseMotives() {
		Random rand = new Random();
		
		murderMotive = DataLoader.motivesList.get(rand.nextInt(DataLoader.motivesList.size()));
	}
	
	// When was the victim killed?  This will set the stage for rest of the time-based settings.
	private static void chooseMurderTime() {
		Random rand = new Random();
		
		// Month
		int month = rand.nextInt(12) + 1;
		// Day
		int day = rand.nextInt(Time.getDaysForMonth(month)) + 1;
		// Hour
		int hour = rand.nextInt(24) + 1;
		// Minute
		int minute = rand.nextInt(60);
		
		murderTime = new Time(month, day, hour, minute);		
	}
	
	/**
	 * Macro to generate all the circumstances of the murder.
	 */
	public static void generateMurder() {
		chooseMurderWeapon();
		chooseFatalWound();
		chooseMurderLocation();
		chooseMurdererStates();
		chooseVictimName();
		chooseMurdererName();
		chooseMotives();
		chooseMurderTime();
	}
	
	
	
	
	
}
