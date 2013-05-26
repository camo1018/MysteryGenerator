package pp.generatordatacreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Loads the data content for story generation for editing.
 * @author Paul Park
 *
 */

public class DataCreator {

	// This field to access the last loaded array of StoryItems for use by the data creator tool.
	public static ArrayList<StoryItem> itemArray;

	/**
	 * Read from str file with specified file path.
	 * 
	 * @param filePath
	 */
	public static ArrayList<StoryItem> readFromFile(String filePath) {

		// Load the data from resources.
		itemArray = new ArrayList<StoryItem>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			StoryItem currStoryItem = null;

			while  ((line = reader.readLine()) != null) {

				// Read a line.  We want to look for an ID tag, which signals that an item is going to be listed.

				// Add support for commenting using //
				if (line.substring(0, 2).equals("//")) {
					break;
				}

				if (line.equalsIgnoreCase("newitem")) {
					currStoryItem = new StoryItem();
				}
				else if (line.equalsIgnoreCase("enditem")) {
					itemArray.add(currStoryItem);
					currStoryItem = null;
				}
				else {
					// Break the line into pieces.  Separation between type and value will be done with \t.  The first tab will be the type.  All the indices that follow are values.
					String[] splitLine = line.split("\t");
					String type = splitLine[0];
					String value = splitLine[1];
					currStoryItem.setItem(type, value);
				}	

			}
			reader.close();
		}

		catch (IOException e) {
			// File is not found.  Create one.
			System.out.println("File not found at the specified path.  Creating a new one...");
			File file = new File(filePath);
			try {
				file.createNewFile();
			}
			catch (IOException ee) {
				ee.printStackTrace();
			}
		}
		
		return itemArray;
	}

	/**
	 * Writes the story data to file.
	 */
	public void writeToFile(String filePath) {

		// Get what to write.
		String content = "";
		for (int i = 0; i < itemArray.size(); i++) {
			content+="newitem\r\n";
			StoryItem item = itemArray.get(i);
			HashMap<String, String> map = item.getMap();
			Set<String> keySet = map.keySet();
			Iterator<String> iter = keySet.iterator();
			// Write the attributes of an item.
			String currItem = null;
			while (iter.hasNext()) {
				currItem = iter.next();
				// Write the type field.
				content+= currItem + "\t";
				// Get the value
				content+= item.getMap().get(currItem);
				// Once we are done with the attribute, add a new line.
				content+= "\r\n";
			}

			// We are done with the item.
			content+= "enditem\r\n";

		}

		try {
			File file = new File(filePath);

			// Check if the file exists.  Shouldn't need this but just in case.
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(content);
			writer.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Returns itemArray.
	 * @return Array of StoryItem
	 */
	public ArrayList<StoryItem> getItemArray() {
		return itemArray;
	}

	/**
	 * Add a story item to itemArray.
	 */
	public void addStoryItem(StoryItem strItem) {
		itemArray.add(strItem);
	}

	/**
	 * Remove a story item with the specified index from itemArray.
	 */
	public void removeStoryItem(int index) {
		itemArray.remove(index);
	}

}