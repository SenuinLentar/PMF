package view;

import controller.DewPoint;

import model.ChunksCreator;

public class DisplayLoop {

	private ChunksCreator chunksCreator;
	private DewPoint dewPoint;
	private Graphique graphique;
	private PopUp popUp;
	private DataStorage dataStorage;
	private Fenetre fenetre;
	
	//private ProprieteImage proprieteImage;

	/**
	 * Constructor of the DisplayLoop class.
	 *
	 * @param chunksCreator
	 * @param dewPoint
	 * @param graphique
	 * @param fenetre
	 * @param popUp
	 * @param dataStorage
	 */
	public DisplayLoop(ChunksCreator chunksCreator, DewPoint dewPoint, Graphique graphique,
			PopUp popUp, DataStorage dataStorage, Fenetre fenetre) {
		
		this.fenetre = fenetre;
		this.chunksCreator = chunksCreator;
		this.dewPoint = dewPoint;
		this.graphique = graphique;
		this.popUp = popUp;
		this.dataStorage = dataStorage;
		System.out.println("Température extérieure : \t Température intérieure : \t Humidité : \t Consigne :");
	}

	/**
	 * A loop that refresh all we need.
	 * 
	 * @throws InterruptedException
	 */
	public void Loop() throws InterruptedException {
		while (true) {
			
			this.refreshData();
			this.dewPointCalculation();
			this.updateGraphicData();
//			this.printData();
			this.dewPointTest();
			this.doorOpenTest();
			this.updateThermometerImage();
			Thread.sleep(1000);
		}
	}
	
	/**
	 * Refresh the display of the data on the window.
	 */
	public void refreshData() {
		this.dataStorage.updateDatas();
		this.fenetre.getConteneurFenetre().getProprieteLabel().updateLabels();
	}
	
	/**
	 * Calculate the dew point.
	 */
	public void dewPointCalculation () {
		this.dewPoint.dewPointTemp(this.chunksCreator.getChunks()[1], this.chunksCreator.getChunks()[2]);
	}
	
	/**
	 * Update the graphic.
	 */
	public void updateGraphicData() {
		this.graphique.updateTable(this.chunksCreator.getChunks());
//		this.graphique.initUI();
		this.graphique.updateGraphic();
	}
	
	/**
	 * Print the output of the Arduino card.
	 */
	public void printData() {
		for(int i = 0; i<4; i++) {
			System.out.println(this.chunksCreator.getChunks()[i] + "\t\t\t");
		}
//		
//		System.out.println("\t" + this.chunksCreator.getChunks()[0] + "\t\t\t\t" + this.chunksCreator.getChunks()[1]
//				+ "\t\t\t " + this.chunksCreator.getChunks()[2] + "\t\t" + this.chunksCreator.getChunks()[3]);
		System.out.println(dewPoint.getDewPointTemp());
	}
	
	/**
	 * Check if there is condensation formation, if yes, it display a new windows with a message.
	 */
	public void dewPointTest() {
		if (this.dewPoint.getDewPointTemp() > Double.parseDouble(this.chunksCreator.getChunks()[1])) {
			// Double.parseDouble(this.chunksCreator.getChunks()[0]) >
			// Double.parseDouble(this.chunksCreator.getChunks()[1])
			// this.dewPoint.getDewPointTemp() >
			// Double.parseDouble(this.chunksCreator.getChunks()[1])
			this.popUp.condensation();
		}
	}
	
	/**
	 * Check if the fridge's door is open, if yes, it display a new windows with a message.
	 */
	public void doorOpenTest() {
		if (this.graphique.getData()[0][9] - this.graphique.getData()[0][0] > 0.5) {
			// this.graphique.getData()[0][9] - this.graphique.getData()[0][8] > 5
			this.popUp.porte();
		}
	}
	
	public void updateThermometerImage () {
		this.fenetre.getConteneurFenetre().getProprieteImage().updateImage();
	}
}