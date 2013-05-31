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
		murderWeaponsList = DataCreator.readFromFile("str/murderWeapons.str");
		// Get victim state list
		victimStatesList = DataCreator.readFromFile("str/victimStates.str");
		// Get murder locations list
		locationsList = DataCreator.readFromFile("str/locations.str");
		// Get murderer states list
		murdererStatesList = DataCreator.readFromFile("str/murdererStates.str");
		// Get names list
		namesList = DataCreator.readFromFile("str/names.str");
		// Get motives list
		motivesList = DataCreator.readFromFile("str/motives.str");
	}



}
