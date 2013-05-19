package pp.GeneratorDataCreator;

import java.util.HashMap;

/**
 * StoryItem object represents a single story item that the creator loads in from the database.
 * 
 * @author Paul
 *
 */

public class StoryItem {
	
	private HashMap<String, String> dataMap;
	
	public StoryItem() {
		dataMap = new HashMap<String, String>();
	}
	
	public void SetItem(String type, String value) {
		dataMap.put(type, value);
	}
	
	public void RemoveItem(String type) {
		dataMap.remove(type);
	}
	
	public HashMap<String, String> getMap() {
		return dataMap;
	}
	
}
