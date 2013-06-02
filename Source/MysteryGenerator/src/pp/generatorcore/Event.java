package pp.generatorcore;

import java.util.ArrayList;
import java.util.Random;

import pp.common.DataLoader;
import pp.common.Name;
import pp.common.Time;
import pp.generatordatacreator.StoryItem;

/**
 * Event class stores the collection of events, generated based on what really happened.
 * This can be used to generate a list of things that happened according to a witness.
 * 
 * @author PaulPa
 *
 */

public class Event {

	public StoryItem murderWeapon;
	public StoryItem fatalWound;
	public StoryItem murderLocation;
	public ArrayList<StoryItem> murdererStates;
	public Name victimName;
	public Name murdererName;
	public StoryItem murderMotive;
	public Time murderTime;

	// How 'ridiculous' is the event compared to the evidence and the real murder?
	public int accuracy;
	// Arbitrarily determined
	// 0 - almost as close to the actual murder
	// 1 - close
	// 2 - somewhat close
	// 3 - not so close.
	// 4 - ridiculous

	public Event() {
		accuracy = 0;
	}

	public Event(int accuracy) {
		this.accuracy = accuracy;
	}

	public void generateMurderWeapon() {
		ArrayList<StoryItem> itemsList;
		switch (accuracy) {
		case 0:
		case 1:
		case 2:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("type", MurderGenerator.murderWeapon.getMap().get("type"), DataLoader.murderWeaponsList);
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("woundType", MurderGenerator.murderWeapon.getMap().get("woundType"), itemsList);
			break;
		case 3:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("type", MurderGenerator.murderWeapon.getMap().get("type"), DataLoader.murderWeaponsList);
			break;
		default:
			itemsList = DataLoader.murderWeaponsList;
			break;
		}

		Random rand = new Random();

		murderWeapon = itemsList.get(rand.nextInt(itemsList.size()));			
	}
}
