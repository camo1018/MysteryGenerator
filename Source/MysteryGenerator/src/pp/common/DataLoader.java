package pp.common;

import java.util.ArrayList;

import pp.generatordatacreator.DataCreator;
import pp.generatordatacreator.StoryItem;

public class DataLoader {

	public static ArrayList<StoryItem> murderWeaponsList;
	public static ArrayList<StoryItem> victimStatesList;
	public static ArrayList<StoryItem> locationsList;
	public static ArrayList<StoryItem> murdererStatesList;
	public static ArrayList<StoryItem> namesList;
	public static ArrayList<StoryItem> motivesList;

	public static void loadAllFiles() {
		// Get murder weapon list
		murderWeaponsList = DataCreator.readFromFile("murderWeapons.str");
		// Get victim state list
		victimStatesList = DataCreator.readFromFile("victimStates.str");
		// Get murder locations list
		locationsList = DataCreator.readFromFile("locations.str");
		// Get murderer states list
		murdererStatesList = DataCreator.readFromFile("murdererStates.str");
		// Get names list
		namesList = DataCreator.readFromFile("names.str");
		// Get motives list
		motivesList = DataCreator.readFromFile("motives.str");
	}



}
