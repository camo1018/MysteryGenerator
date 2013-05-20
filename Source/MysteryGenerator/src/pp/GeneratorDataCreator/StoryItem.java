package pp.generatordatacreator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * StoryItem object represents a single story item that the creator loads in from the database.
 * 
 * @author Paul
 *
 */

public class StoryItem {
	
	private HashMap<String, ArrayList<String>> dataMap;
	
	public StoryItem() {
		dataMap = new HashMap<String, ArrayList<String>>();
	}
	
	public void SetItem(String type, ArrayList<String> values) {
		dataMap.put(type, values);
	}
	
	public void RemoveItem(String type) {
		dataMap.remove(type);
	}
	
	public HashMap<String, ArrayList<String>> getMap() {
		return dataMap;
	}
	
}
