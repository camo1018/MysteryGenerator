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
	
	public Event(Name murdererName) {
		accuracy = 0;
		this.murdererName = murdererName;
		victimName = MurderGenerator.victimName;
	}
	
	public Event(Name murdererName, Name victimName) {
		accuracy = 0;
		this.murdererName = murdererName;
		this.victimName = victimName;
	}

	public Event(int accuracy, Name murdererName) {
		this.accuracy = accuracy;
		this.murdererName = murdererName;
		victimName = MurderGenerator.victimName;
	}
	
	public Event(int accuracy, Name murdererName, Name victimName) {
		this.accuracy = accuracy;
		this.murdererName = murdererName;
		this.victimName = victimName;
	}
	
	public void generateMurderWeapon() {
		ArrayList<StoryItem> itemsList;
		switch (accuracy) {
		case 0:
		case 1:
		case 2:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Type", MurderGenerator.murderWeapon.getMap().get("Type"), DataLoader.murderWeaponsList);
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("WoundType", MurderGenerator.murderWeapon.getMap().get("WoundType"), itemsList);
			break;
		case 3:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Type", MurderGenerator.murderWeapon.getMap().get("Type"), DataLoader.murderWeaponsList);
			break;
		default:
			itemsList = DataLoader.murderWeaponsList;
			break;
		}

		Random rand = new Random();

		murderWeapon = itemsList.get(rand.nextInt(itemsList.size()));			
	}

	public void generateFatalWound() {
		ArrayList<StoryItem> itemsList;
		switch(accuracy) {
		case 0:
		case 1:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Type", "Wound", DataLoader.victimStatesList);
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("WoundType", MurderGenerator.fatalWound.getMap().get("WoundType"), itemsList);
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Location", MurderGenerator.fatalWound.getMap().get("Location"), itemsList);
			break;
		case 2:
		case 3:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Type",  "Wound",  DataLoader.victimStatesList);
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("WoundType", MurderGenerator.fatalWound.getMap().get("WoundType"), itemsList);
			break;
		default:
			itemsList = DataLoader.victimStatesList;
			break;
		}

		Random rand = new Random();

		fatalWound = itemsList.get(rand.nextInt(itemsList.size()));
	}

	public void generateMurderLocation() {
		ArrayList<StoryItem> itemsList;
		switch(accuracy) {
		case 0:
		case 1:
		case 2:
			murderLocation = MurderGenerator.murderLocation;
			return;
		case 3:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("District", MurderGenerator.murderLocation.getMap().get("District"), DataLoader.locationsList);
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("Block", MurderGenerator.murderLocation.getMap().get("Block"), itemsList);
			break;
		default:
			itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("District",  MurderGenerator.murderLocation.getMap().get("District"), DataLoader.locationsList);
			break;
		}

		Random rand = new Random();

		murderLocation = itemsList.get(rand.nextInt(itemsList.size()));
	}

	public void generateMurdererStates() {
		Random rand = new Random();
		ArrayList <StoryItem> itemsList;
		switch(accuracy) {
		case 0:
			itemsList = MurderGenerator.murdererStates;
			break;
		case 1:
			itemsList = MurderGenerator.murdererStates;
			break;
		case 2:
			itemsList = MurderGenerator.murdererStates;
			itemsList.remove(rand.nextInt(itemsList.size()));
			break;
		case 3:
			// + 1 to account for not having any state.
			int statesCount = MurderGenerator.murdererStates.size() + 1;
			int index = rand.nextInt(statesCount);
			if (index == 0) {
				murdererStates = new ArrayList<StoryItem>();
			}
			else {
				murdererStates = new ArrayList<StoryItem>();
				murdererStates.add(MurderGenerator.murdererStates.get(index - 1));
			}
			return;
		default:
			murdererStates = new ArrayList<StoryItem>();
			int diffRand = MurderGenerator.MAX_MURDERER_STATES_COUNT - MurderGenerator.MIN_MURDERER_STATES_COUNT;

			for (int i = 0; i < MurderGenerator.MIN_MURDERER_STATES_COUNT + rand.nextInt(diffRand); i++) {
				StoryItem item = DataLoader.murdererStatesList.get(rand.nextInt(DataLoader.murdererStatesList.size()));
				if (!LogicHandler.doesStoryItemWithSameValueOfSpecifiedTypeExistInList(item, "type", murdererStates)) {
					murdererStates.add(item);
				}
			}
			return;
		}
		
		murdererStates = itemsList;
	}
	
	public void generateMurderMotive() {
		// TODO: More context-specific motive selection
		Random rand = new Random();
		murderMotive = DataLoader.motivesList.get(rand.nextInt(DataLoader.motivesList.size()));		
	}
	
	public void generateMurderTime() {
		switch(accuracy) {
		case 0:
			
		}
	}
	
	

}
