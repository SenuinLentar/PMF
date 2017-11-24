package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProprieteImage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondImage;
	private JLabel goutteImage;
	private JLabel barreImage;
	private JLabel thermometreExterieurImage;
	private JLabel thermometreInterieurImage;

	private DataStorage dataStorage;
	private ConteneurFenetre conteneurFenetre;
	
	/**
	 * The constructor ProprieteImage needs
	 * 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public ProprieteImage(DataStorage dataStorage, ConteneurFenetre conteneurFenetre) {

		this.dataStorage = dataStorage;
		this.conteneurFenetre = conteneurFenetre;
		
		/**
		 * the image used for the humidity
		 */
		goutteImage = new JLabel(new ImageIcon("image/goutte.png"));
		this.goutteImage.setBounds(490, 450, 50, 100);
		conteneurFenetre.add(goutteImage);

		/**
		 * the image used for the separation in the middle
		 */
		barreImage = new JLabel(new ImageIcon("image/barre.png"));
		this.barreImage.setBounds(450, 170, 10, 390);
		conteneurFenetre.add(barreImage);

		/**
		 * the image used for the outside temperature
		 */
		thermometreExterieurImage = new JLabel(new ImageIcon("image/exterieur.png"));
		this.thermometreExterieurImage.setBounds(20, 450, 100, 100);
		conteneurFenetre.add(thermometreExterieurImage);

		updateImage();
		
		/**
		 * the image used for the background
		 */
		fondImage = new JLabel(new ImageIcon("image/wetAsphalte.png"));
		this.fondImage.setSize(900, 700);
		conteneurFenetre.add(fondImage);

		
	}
	
	/**
	 * Method used to update the image for the outside  temperature 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public void updateImage () {
		
		thermometreInterieurImage = new JLabel();
		
		/**
		 * the image used for the inside temperature 3 images for the 3 different cases
		 * 
		 */
		if (this.dataStorage.getTemperatureInterieure() <= 13.0) {
			this.thermometreInterieurImage.setIcon(new ImageIcon("image/low.png"));
		} 
		
		else if ((this.dataStorage.getTemperatureInterieure() > 13.0) && (dataStorage.getTemperatureInterieure() <= 17.0)) {
			this.thermometreInterieurImage.setIcon(new ImageIcon("image/great.png"));
		} 
		
		else if (this.dataStorage.getTemperatureInterieure() > 17.0) {
			this.thermometreInterieurImage.setIcon(new ImageIcon("image/hight.png"));
		} 
		
		else {
			System.out.println("nop");
		}
		
		
		this.thermometreInterieurImage.setBounds(30, 220, 60, 100);
		conteneurFenetre.add(thermometreInterieurImage);
	}

}
