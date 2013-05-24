package pp.generatorcore;

import java.util.ArrayList;

import pp.generatordatacreator.StoryItem;

public class LogicHandler {

	public static ArrayList<StoryItem> getStoryItemsWithFollowingAttributeFromList(String type, String value, ArrayList<StoryItem> list) {
		ArrayList<StoryItem> filteredList = new ArrayList<StoryItem>();
		for (StoryItem item : list) {
			if (item.getMap().get(type).equals(value)) {
				filteredList.add(item);
			}
		}
		return filteredList;
	}
	
	// Check if the given list contains a story item whose value of a given type equals to a given story item.
	public static boolean doesStoryItemWithSameValueOfSpecifiedTypeExistInList(StoryItem item, String type, ArrayList<StoryItem> list) {
		for (StoryItem itemInList : list) {
			if (itemInList.getMap().get(type).equals(item.getMap().get(type))) {
				return true;
			}
		}
		return false;
	}
	
}
