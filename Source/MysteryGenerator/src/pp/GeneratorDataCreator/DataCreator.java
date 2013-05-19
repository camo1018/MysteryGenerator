package pp.GeneratorDataCreator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Loads the data content for story generation for editting.
 * @author Paul
 *
 */

public class DataCreator {

	BufferedReader reader;
	ArrayList<StoryItem> itemArray;

	public DataCreator() {

		// Load the data from resources.

		try {
			reader = new BufferedReader(new FileReader("data.str"));
			itemArray = new ArrayList<StoryItem>();
			String line = null;

			while  ((line = reader.readLine()) != null) {

				// Read a line.  We want to look for an ID tag, which signals that an item is going to be listed.
				
				// Add support for commenting using //
				if (line.substring(0, 2).equals("//")) {
					break;
				}
				
				// Break the line into pieces.  Separation between type and value will be done with \t.  The first tab will be the type.  All the indices that follow are values.
				String[] splitLine = line.split("\t");
				
					

			}

		}

		catch (IOException e) {
			// File is not found.  Create one.

		}


	}

}



}
