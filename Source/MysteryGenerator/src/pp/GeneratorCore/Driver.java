package pp.generatorcore;

import pp.common.DataLoader;


public class Driver {
	
	/**
	 * Instantiate a Story Generator Driver for starting the story generation. 
	 */
	public Driver() {
		
		// Load all the data files
		DataLoader.loadAllFiles();
		
		MurderGenerator.generateMurder();
		
		System.out.println("Murder Weapon: " + MurderGenerator.murderWeapon);
		System.out.println("Victim Wound: " + MurderGenerator.fatalWound);
		System.out.println("Murder Location: " + MurderGenerator.murderLocation);
		System.out.println("Murderer States: " + MurderGenerator.murdererStates);
		System.out.println("Victim Name: " + MurderGenerator.victimName);
		System.out.println("Murderer Name: " + MurderGenerator.murdererName);
		System.out.println("Murder Motives: " + MurderGenerator.murderMotive);
		System.out.println("Murder Time: " + MurderGenerator.murderTime);
		
	}
	
	// TEST DRIVER
	public static void main(String[] args) {
		// Load all the data files
				DataLoader.loadAllFiles();
				
				MurderGenerator.generateMurder();
				
				System.out.println("Murder Weapon: " + MurderGenerator.murderWeapon);
				System.out.println("Victim Wound: " + MurderGenerator.fatalWound);
				System.out.println("Murder Location: " + MurderGenerator.murderLocation);
				System.out.println("Murderer States: " + MurderGenerator.murdererStates);
				System.out.println("Victim Name: " + MurderGenerator.victimName);
				System.out.println("Murderer Name: " + MurderGenerator.murdererName);
				System.out.println("Murder Motives: " + MurderGenerator.murderMotive);
				System.out.println("Murder Time: " + MurderGenerator.murderTime);
	}
	
	
	
	
	

}
