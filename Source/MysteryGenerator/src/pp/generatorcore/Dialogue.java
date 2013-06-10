package pp.generatorcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import pp.common.DataLoader;
import pp.generatordatacreator.StoryItem;

public class Dialogue {

	private Event event;
	private HashMap<String, String> dialoguesMap;
	private ArrayList<StoryItem> dialoguesList;
	
	private Random rand;
	
	
	public Dialogue(Event referenceEvent) {
		event = referenceEvent;
		dialoguesList = DataLoader.dialoguesList;
		rand = new Random();
	}
	
	// Let's keep it simple for now.  Just get the dialogue for the gist of the murder event.
	
	// Talk about who was the murderer.
	private void getMurdererNameDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "MurdererName", dialoguesList);
		StoryItem item = itemsList.get(rand.nextInt(itemsList.size()));
		String text = item.getMap().get("Text");
		String formattedText = this.getFormattedString(text);
		dialoguesMap.put("MurdererName", formattedText);
	}
	
	// Talk about what the murder weapon was.
	private void getMurderWeaponDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "MurderWeapon", dialoguesList);
		StoryItem item = itemsList.get(rand.nextInt(itemsList.size()));
		String text = item.getMap().get("Text");
		String formattedText = this.getFormattedString(text);
		dialoguesMap.put("MurderWeapon", formattedText);
	}
	
	private void getFatalWoundDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "FatalWound", dialoguesList);
		StoryItem item = itemsList.get(rand.nextInt(itemsList.size()));
		String text = item.getMap().get("Text");
		String formattedText = this.getFormattedString(text);
		dialoguesMap.put("FatalWound", formattedText);
	}
	
	private void getMurderLocationDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "MurderLocation", dialoguesList);
		StoryItem item = itemsList.get(rand.nextInt(itemsList.size()));
		String text = item.getMap().get("Text");
		String formattedText = this.getFormattedString(text);
		dialoguesMap.put("MurderLocation",  formattedText);
	}
	
	private void getMurderTimeDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "MurderLocation", dialoguesList);
		StoryItem item = itemsList.get(rand.nextInt(itemsList.size()));
		String text = item.getMap().get("Text");
		String formattedText = this.getFormattedString(text);
		dialoguesMap.put("MurderTime",  formattedText);
	}
	
	private void getMurderMotiveDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "MurderMotive", dialoguesList);
		StoryItem item = itemsList.get(rand.nextInt(itemsList.size()));
		String text = item.getMap().get("Text");
		String formattedText = this.getFormattedString(text);
		dialoguesMap.put("MurderMotive", formattedText);
	}
	
	private void getMurdererStatesDialogue() {
		ArrayList<StoryItem> itemsList = LogicHandler.getStoryItemsWithFollowingAttributeFromList("ConvType", "MurdererState", dialoguesList);
		String combinedText = "";
		for (StoryItem murdererState : MurderGenerator.murdererStates) {
			String text = murdererState.getMap().get("Text");
			text = this.getFormattedString(text, murdererState);
			text += " ";
			combinedText += text;
		}
		combinedText = combinedText.trim();
		dialoguesMap.put("MurdererStates", combinedText);
	}
	
	// Take in a string and replace the context tags with relevant text.
	private String getFormattedString(String string) {
		String editStr = string;
		editStr = editStr.replaceAll("{@MURDERERNAME}", event.murdererName.getFirstName() + " " + event.murdererName.getLastName());
		editStr = editStr.replaceAll("{@VICTIMNAME}", event.victimName.getFirstName() + " " + event.victimName.getLastName());
		editStr = editStr.replaceAll("{@MURDERWEAPON}", event.murderWeapon.getMap().get("Name"));
		editStr = editStr.replaceAll("{@FATALWOUND}", event.fatalWound.getMap().get("Name"));
		editStr = editStr.replaceAll("{@MURDERLOCATION}", event.murderLocation.getMap().get("Name"));
		editStr = editStr.replaceAll("{@MURDERMOTIVE}", event.murderMotive.getMap().get("Name"));
		
		return editStr;
	}
	
	private String getFormattedString(String string, StoryItem murdererState) {
		String editStr = string;
		editStr = this.getFormattedString(editStr);
		editStr = editStr.replaceAll("{@MURDERERSTATE}", murdererState.getMap().get("Name"));
		
		return editStr;
	}
	
	
}
