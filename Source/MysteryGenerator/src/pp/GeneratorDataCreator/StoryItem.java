package pp.generatordatacreator;

import java.util.HashMap;
import java.util.Set;

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
	
	/**
	 * Set the attribute of the Story Item using one value.
	 * @param type
	 * @param value
	 */
	public void setItem(String type, String value) {
		dataMap.put(type, value);
	}
	
	/**
	 * Removes an attribute with the specified type.
	 * @param type
	 */
	public void removeItem(String type) {
		dataMap.remove(type);
	}
	
	/**
	 * Returns the data map.
	 * @return
	 */
	public HashMap<String, String> getMap() {
		return dataMap;
	}
	
	public String toString() {
		Set<String> set = dataMap.keySet();
		String result = "";
		for (String str : set) {
			result+= str + " - " + dataMap.get(str) + ", ";
		}
		return result;
	}
	
}
