package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		DataStorage dataStorage = new DataStorage();
		CommPort commPort = new CommPort();
				
		Serial serial = new Serial(commPort.getCommPort(), dataStorage);
		serial.readIntput();
		
		DewPoint dewPoint = new DewPoint();
		
		Fenetre fenetre = new Fenetre(serial, dataStorage);
		serial.writeOutput(String.valueOf(dataStorage.getConsigne()));
		
		PopUp popUp = new PopUp();
		
		DisplayLoop loop = new DisplayLoop(dewPoint, fenetre.getConteneurFenetre().getProprieteBouton().getGraphique(), popUp, dataStorage, fenetre);
		loop.Loop();		
	}
}