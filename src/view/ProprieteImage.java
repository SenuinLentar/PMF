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

	/**
	 * The contructor ProprieteImage needs
	 * 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public ProprieteImage(DataStorage dataStorage, ConteneurFenetre conteneurFenetre) {

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

		/**
		 * the image used for the inside temperature 3 images for the 3 different cases
		 * 
		 */
		if (dataStorage.getTemperatureInterieure() <= 10.0) {
			thermometreInterieurImage = new JLabel(new ImageIcon("image/low.png"));
			this.thermometreInterieurImage.setBounds(30, 220, 60, 100);
			conteneurFenetre.add(thermometreInterieurImage);
		} else if ((dataStorage.getTemperatureInterieure() > 10.0)
				&& (dataStorage.getTemperatureInterieure() <= 13.0)) {
			thermometreInterieurImage = new JLabel(new ImageIcon("image/great.png"));
			this.thermometreInterieurImage.setBounds(30, 220, 60, 150);
			conteneurFenetre.add(thermometreInterieurImage);
		} else if (dataStorage.getTemperatureInterieure() > 13.0) {
			thermometreInterieurImage = new JLabel(new ImageIcon("image/hight.png"));
			this.thermometreInterieurImage.setBounds(30, 220, 60, 150);
			conteneurFenetre.add(thermometreInterieurImage);
		} else {
			System.out.println("nop"); // FAIRE RESTE 10-13 14-17 18-20
		}

		/**
		 * the image used for the background
		 */
		fondImage = new JLabel(new ImageIcon("image/wetAsphalte.png"));
		this.fondImage.setSize(900, 700);
		conteneurFenetre.add(fondImage);

	}

}
