package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		DataStorage dataStorage = new DataStorage();
		CommPortFinder commPort = new CommPortFinder();
				
		ArduinoCommunictation serial = new ArduinoCommunictation(commPort.getCommPort(), dataStorage);
		serial.readIntput();
		
		DewPoint dewPoint = new DewPoint();
		
		Frame fenetre = new Frame(serial, dataStorage);
		serial.writeOutput(String.valueOf(dataStorage.getOrder()));
		
		PopUp popUp = new PopUp();
		
		DisplayLoop loop = new DisplayLoop(dewPoint, fenetre.getPanel().getProprieteBouton().getGraphique(), popUp, dataStorage, fenetre);
		loop.Loop();		
	}
}