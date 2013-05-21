package pp.generatordatacreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
	
	/**
	 * Set the attribute of the Story Item using one value.
	 * @param type
	 * @param value
	 */
	public void setItem(String type, String value) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(value);
		dataMap.put(type, list);
	}
	
	/**
	 * Set the attribute of the Story Item using multiple values.
	 * @param type
	 * @param values
	 */
	public void setItem(String type, ArrayList<String> values) {
		dataMap.put(type, values);
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
	public HashMap<String, ArrayList<String>> getMap() {
		return dataMap;
	}
	
	public String toString() {
		Set<String> keySet = dataMap.keySet();
		String toRet = "";
		for (String str : keySet) {
			toRet += str + "\t";
			for (String value : dataMap.get(str)) {
				toRet += value + "\t";
			}
			toRet += "\n";
		}
		return toRet;
	}
	
}
