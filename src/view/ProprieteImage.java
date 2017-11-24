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
	
	private ImageIcon thermometreExterieurIcon = new ImageIcon("image/exterieur.png");
	private ImageIcon thermometreInterieurIcon = new ImageIcon("image/low.png");;
	private ImageIcon goutteIcon = new ImageIcon("image/goutte.png");
	private ImageIcon barreIcon = new ImageIcon("image/barre.png");
	private ImageIcon fondIcon = new ImageIcon("image/wetAsphalte.png");

	private DataStorage dataStorage;
	
	/**
	 * The constructor ProprieteImage needs
	 * 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public ProprieteImage(DataStorage dataStorage, ConteneurFenetre conteneurFenetre) {

		this.dataStorage = dataStorage;
		
		/**
		 * the image used for the humidity
		 */
		goutteImage = new JLabel(goutteIcon);
		this.goutteImage.setBounds(490, 450, 50, 100);
		conteneurFenetre.add(goutteImage);

		/**
		 * the image used for the separation in the middle
		 */
		barreImage = new JLabel(barreIcon);
		this.barreImage.setBounds(450, 170, 10, 390);
		conteneurFenetre.add(barreImage);

		/**
		 * the image used for the outside temperature
		 */
		thermometreExterieurImage = new JLabel(thermometreExterieurIcon);
		this.thermometreExterieurImage.setBounds(20, 450, 100, 100);
		conteneurFenetre.add(thermometreExterieurImage);
		
		/**
		 * the image used for the inside temperature
		 */
		thermometreInterieurImage = new JLabel();
		this.thermometreInterieurImage.setBounds(30, 220, 120, 100);
		conteneurFenetre.add(thermometreInterieurImage);
		
		updateImage();
		
		/**
		 * the image used for the background
		 */
		fondImage = new JLabel(fondIcon);
		this.fondImage.setSize(900, 700);
		conteneurFenetre.add(fondImage);
	}
	
	/**
	 * Method used to update the image for the outside  temperature 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public void updateImage () {
//		thermometreInterieurIcon.getImage().flush();
		
		/**
		 * the image used for the inside temperature 3 images for the 3 different cases
		 * 
		 */
		if (this.dataStorage.getTemperatureInterieure() <= 13.0) {
			thermometreInterieurIcon = new ImageIcon("image/low.png");
			this.thermometreInterieurImage.setIcon(thermometreInterieurIcon);
			
		} 
		
		else if ((this.dataStorage.getTemperatureInterieure() > 13.0) && (dataStorage.getTemperatureInterieure() <= 20.0)) {
			thermometreInterieurIcon = new ImageIcon("image/great.png");
			this.thermometreInterieurImage.setIcon(thermometreInterieurIcon);
		} 
		
		else if (this.dataStorage.getTemperatureInterieure() > 20.0) {
			thermometreInterieurIcon = new ImageIcon("image/hight.png");
			this.thermometreInterieurImage.setIcon(thermometreInterieurIcon);

		} 
		
		else {
			System.out.println("nop");
		}
	}
}
