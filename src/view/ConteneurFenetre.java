package view;

import javax.swing.JPanel;

import model.Serial;

public class ConteneurFenetre extends JPanel{


	
	private ProprieteImage proprieteImage;
	private ProprieteLabel proprieteLabel;
	private ProprieteBouton proprieteBouton;
	
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the panel uses
	 *
	 * @param graphique
	 * @param chunkCreator
	 * @param serial
	 * @param dataStorage
	 */
	public ConteneurFenetre(Serial serial, DataStorage dataStorage) {
		
		this.setLayout(null);
		proprieteLabel = new ProprieteLabel(dataStorage, this);
		proprieteBouton = new ProprieteBouton(dataStorage, serial, this);
		proprieteImage = new ProprieteImage(dataStorage, this);
	
	
		/**
		 * the values for the inside and outside temperature are filled with the values collected with arduino (thermistance+DHT)
		 */
//		dataStorage.setTemperatureExterieure(Float.parseFloat(chunkCreator.getChunks()[0]));
//		dataStorage.setTemperatureInterieure(Float.parseFloat(chunkCreator.getChunks()[1]));
//		dataStorage.setHumiditeActuelle(Float.parseFloat(chunkCreator.getChunks()[2]));
	}

	public ProprieteBouton getProprieteBouton() {
		return proprieteBouton;
	}

	public ProprieteImage getProprieteImage() {
		return proprieteImage;
	}
	
	public ProprieteLabel getProprieteLabel() {
		return proprieteLabel;
	}

}