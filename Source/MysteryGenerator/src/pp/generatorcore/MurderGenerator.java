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
	
	ArrayList<StoryItem> murderWeaponList;
	
	StoryItem murderWeapon;
	
	
	
	public MurderGenerator() {
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
