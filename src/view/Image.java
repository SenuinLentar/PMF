package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DataStorage;

public class Image extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel backgroundLabel;
	private JLabel dropLabel;
	private JLabel lineLabel;
	private JLabel outThermLabel;
	private JLabel inThermLabel;

	private ImageIcon outThermIcon = new ImageIcon("image/exterieur.png");
	private ImageIcon inThermIcon = new ImageIcon("image/low.png");
	private ImageIcon dropIcon = new ImageIcon("image/goutte.png");
	private ImageIcon lineIcon = new ImageIcon("image/barre.png");
	private ImageIcon backgroundIcon = new ImageIcon("image/wetAsphalte.png");

	private DataStorage dataStorage;

	/**
	 * The constructor of the class Image.
	 * 
	 * @param dataStorage
	 * @param panel
	 */
	public Image(DataStorage dataStorage, Panel panel) {

		this.dataStorage = dataStorage;

		/**
		 * The image used for the humidity.
		 */
		dropLabel = new JLabel(dropIcon);
		this.dropLabel.setBounds(490, 450, 50, 100);
		panel.add(dropLabel);

		/**
		 * The image used for the separation in the middle.
		 */
		lineLabel = new JLabel(lineIcon);
		this.lineLabel.setBounds(450, 170, 10, 390);
		panel.add(lineLabel);

		/**
		 * The image used for the outside temperature.
		 */
		outThermLabel = new JLabel(outThermIcon);
		this.outThermLabel.setBounds(20, 450, 100, 100);
		panel.add(outThermLabel);

		/**
		 * The image used for the inside temperature.
		 */
		inThermLabel = new JLabel();
		this.inThermLabel.setBounds(30, 220, 120, 100);
		panel.add(inThermLabel);

		updateImage();

		/**
		 * The image used for the background.
		 */
		backgroundLabel = new JLabel(backgroundIcon);
		this.backgroundLabel.setSize(900, 700);
		panel.add(backgroundLabel);
	}

	/**
	 * Method used to update the image of the inside thermometer.
	 */
	public void updateImage() {
		if (this.dataStorage.getInsideTemperature() <= 13.0) {
			inThermIcon = new ImageIcon("image/low.png");
			this.inThermLabel.setIcon(inThermIcon);
		}

		else if ((this.dataStorage.getInsideTemperature() > 13.0) && (dataStorage.getInsideTemperature() <= 17.0)) {
			inThermIcon = new ImageIcon("image/great.png");
			this.inThermLabel.setIcon(inThermIcon);
		}

		else if (this.dataStorage.getInsideTemperature() > 17.0) {
			inThermIcon = new ImageIcon("image/hight.png");
			this.inThermLabel.setIcon(inThermIcon);
		}

		else {
			System.out.println("Error in updateImage");
		}
	}
}