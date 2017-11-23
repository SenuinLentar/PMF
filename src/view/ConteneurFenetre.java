package view;

import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ChunksCreator;
import model.Serial;

public class ConteneurFenetre extends JPanel{


	
	private ProprieteImage proprieteImage;
	private ProprieteLabel proprieteLabel;
	
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the panel uses
	 *
	 * @param graphique
	 * @param chunkCreator
	 * @param serial
	 * @param dataStorage
	 */
	public ConteneurFenetre(Graphique graphique, ChunksCreator chunkCreator, Serial serial, DataStorage dataStorage) {
		
		this.setLayout(null);
		proprieteLabel = new ProprieteLabel(dataStorage, this);
		new ProprieteBouton(dataStorage, graphique, serial, this);
		proprieteImage = new ProprieteImage(dataStorage, this);
	
	
		/**
		 * the values for the inside and outside temperature are filled with the values collected with arduino (thermistance+DHT)
		 */
//		dataStorage.setTemperatureExterieure(Float.parseFloat(chunkCreator.getChunks()[0]));
//		dataStorage.setTemperatureInterieure(Float.parseFloat(chunkCreator.getChunks()[1]));
//		dataStorage.setHumiditeActuelle(Float.parseFloat(chunkCreator.getChunks()[2]));
	}

	public ProprieteImage getProprieteImage() {
		return proprieteImage;
	}
	
	public ProprieteLabel getProprieteLabel() {
		return proprieteLabel;
	}

}