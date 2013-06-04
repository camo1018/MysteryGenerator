package pp.generatorcore;

public class Witness {

	Event perceivedEvent; // What happened according to this witness
	
	public Witness() {		
		
	}
	
	private void generateEvent() {
		perceivedEvent = new Event(MurderGenerator.murdererName);
	}
	
	private void generateDialogue() {
		
	}
	
	
	
}
