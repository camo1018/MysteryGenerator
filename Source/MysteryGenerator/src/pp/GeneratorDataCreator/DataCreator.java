package pp.generatordatacreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Loads the data content for story generation for editing.
 * @author Paul Park
 *
 */

public class DataCreator {

	private BufferedReader reader;
	private ArrayList<StoryItem> itemArray;

	public DataCreator() {

		// Load the data from resources.
		itemArray = new ArrayList<StoryItem>();

		try {
			reader = new BufferedReader(new FileReader("data.str"));
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
					ArrayList<String> values = new ArrayList<String>();
					// Load up all the values
					for (int i = 1; i < splitLine.length; i++) {
						values.add(splitLine[i]);
					}
					currStoryItem.SetItem(type, values);
				}	

			}

		}

		catch (IOException e) {
			// File is not found.  Create one.
			File file = new File("data.str");
			try {
				file.createNewFile();
			}
			catch (IOException ee) {
				ee.printStackTrace();
			}
		}
	}

	/**
	 * Writes the story data to file.
	 */
	public void WriteToFile() {

		// Get what to write.
		String content = "";
		for (int i = 0; i < itemArray.size(); i++) {
			// TODO Implement
		}
		
		try {
			File file = new File("data.str");

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



}