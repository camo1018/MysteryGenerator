package pp.generatorcore;

public class Witness {

	Event perceivedEvent; // What happened according to this witness
	Dialogue dialogue;
	
	public Witness() {		
		generateEvent();
		generateDialogue();
	}
	
	private void generateEvent() {
		perceivedEvent = new Event(MurderGenerator.murdererName);
	}
	
	private void generateDialogue() {
		dialogue = new Dialogue(perceivedEvent);
	}
	
	
	
}
