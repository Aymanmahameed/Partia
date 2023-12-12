package boundary;

import java.time.LocalTime;

import control.ExportControl;
import control.ImportControl;

public class Main {

	public static void main(String[] args) {
		//new PartiesImport("json/Parties.json");
		new FRMLogin();
		LocalTime currentTime = LocalTime.now();
        ImportControl.getInstance().importCustomersFromXML("xml/Participant.xml");
        // Check if the hour is 10 o'clock
        if (currentTime.getHour() == 10) {
        	ExportControl.getInstance().exportParticipantToXML();
        } 
		
		
		


	}

}
