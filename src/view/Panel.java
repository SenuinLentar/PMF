package view;

import javax.swing.JPanel;

import model.DataStorage;
import model.ArduinoCommunictation;

public class Panel extends JPanel{


	
	private Image proprieteImage;
	private Label proprieteLabel;
	private Button proprieteBouton;
	
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the panel uses
	 *
	 * @param graphique
	 * @param chunkCreator
	 * @param serial
	 * @param dataStorage
	 */
	public Panel(ArduinoCommunictation serial, DataStorage dataStorage) {
		
		this.setLayout(null);
		
		proprieteBouton = new Button(dataStorage, serial, this);
		proprieteLabel = new Label(dataStorage, this);
		proprieteImage = new Image(dataStorage, this);
		
		
	
		/**
		 * the values for the inside and outside temperature are filled with the values collected with arduino (thermistance+DHT)
		 */
//		dataStorage.setTemperatureExterieure(Float.parseFloat(chunkCreator.getChunks()[0]));
//		dataStorage.setTemperatureInterieure(Float.parseFloat(chunkCreator.getChunks()[1]));
//		dataStorage.setHumiditeActuelle(Float.parseFloat(chunkCreator.getChunks()[2]));
	}

	public Button getProprieteBouton() {
		return proprieteBouton;
	}

	public Image getProprieteImage() {
		return proprieteImage;
	}
	
	public Label getProprieteLabel() {
		return proprieteLabel;
	}

}