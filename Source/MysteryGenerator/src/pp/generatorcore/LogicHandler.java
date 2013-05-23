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
	
}
