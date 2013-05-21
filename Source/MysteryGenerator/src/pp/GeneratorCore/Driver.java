package pp.generatorcore;

import java.util.ArrayList;

import pp.generatordatacreator.DataCreator;
import pp.generatordatacreator.StoryItem;

public class Driver {
	
	/**
	 * Instantiate a Story Generator Driver for starting the story generation. 
	 */
	public Driver() {
	
		DataCreator dataHandler = new DataCreator();
		ArrayList<StoryItem> itemsList = dataHandler.getItemArray();
		
	}
	
	
	
	
	

}
