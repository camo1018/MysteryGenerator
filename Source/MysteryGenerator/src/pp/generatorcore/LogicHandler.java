package pp.generatorcore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import pp.generatordatacreator.DataCreator;
import pp.generatordatacreator.StoryItem;

/**
 * LogicHandler is responsible for picking certain story elements that are critical in a mystery plot, such as the murder weapon, murder location, victim type, murder type, and etc.
 * @author PaulPa
 *
 */
public class LogicHandler {
	
	DataCreator dataHandler;
	
	ArrayList<StoryItem> murderWeaponList;
	
	StoryItem murderWeapon;
	
	
	
	public LogicHandler() {
		dataHandler = new DataCreator();
		
		// Get murder weapon list
		murderWeaponList = dataHandler.readFromFile("murderWeapons.str");
	}
	
	// It's probably good to start with a murder weapon.  It lets us then determine the wound type, and etc.
	public void chooseMurderWeapon() {
		Random rand = new Random();
		int randIndex = rand.nextInt(murderWeaponList.size());
		murderWeapon = murderWeaponList.get(randIndex);		
	}
	
	
	
}
