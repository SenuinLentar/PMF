package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		DataStorage dataStorage = new DataStorage();
		CommPort commPort = new CommPort();
				
		Serial serial = new Serial(commPort.getCommPort(), chunksCreator);
		serial.readIntput();
		
		DewPoint dewPoint = new DewPoint();
		
		Graphique graphique = new Graphique(chunksCreator);
		new Fenetre(graphique, chunksCreator, serial, dataStorage);
		serial.writeOutput(String.valueOf(dataStorage.getConsigne()));
		
		PopUp popUp = new PopUp();
		
		DisplayLoop loop = new DisplayLoop(chunksCreator, dewPoint, graphique, popUp, dataStorage);
		loop.Loop();		
	}
}
