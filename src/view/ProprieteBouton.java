package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Serial;

public class ProprieteBouton extends JPanel implements ActionListener {

	/**
	 * Declaration of the variables used in order to create the buttons
	 */
	private static final long serialVersionUID = 1L;
	private JButton boutonPlus;
	private JButton boutonMoins;
	private JButton boutonGraphique;

	private DataStorage dataStorage;
	private Graphique graphique;

	private Serial serial;

	/**
	 * the constructor needs
	 * 
	 * @param dataStorage
	 * @param graphique
	 * @param serial
	 * @param conteneurFenetre
	 *            in order to create the buttons
	 */
	public ProprieteBouton(DataStorage dataStorage, Serial serial, ConteneurFenetre conteneurFenetre) {

		graphique = new Graphique(dataStorage);

		/**
		 * WE call the consttructor of dataStorage, graphique & serial
		 */
		this.dataStorage = dataStorage;
		this.serial = serial;

		/**
		 * The button with the image +
		 */
		boutonPlus = new JButton();
		this.boutonPlus.setIcon(new ImageIcon("image/plus.png"));
		this.boutonPlus.setBounds(680, 160, 80, 80);
		this.boutonPlus.setBorderPainted(true);
		this.boutonPlus.addActionListener(this);
		conteneurFenetre.add(boutonPlus);

		/**
		 * The button with the image -
		 */
		boutonMoins = new JButton();
		this.boutonMoins.setIcon(new ImageIcon("image/moins.png"));
		this.boutonMoins.setBounds(780, 160, 80, 80);
		this.boutonMoins.setBorderPainted(false);
		 this.boutonMoins.setBackground(null);
		this.boutonMoins.addActionListener(this);
		conteneurFenetre.add(boutonMoins);

		/**
		 * The button with that allows us to display the graph
		 */
		boutonGraphique = new JButton();
		this.boutonGraphique.setText("Afficher le graphique");
		this.boutonGraphique.setForeground(Color.darkGray);
		this.boutonGraphique.setFont(this.dataStorage.getFmin());
		this.boutonGraphique.setBounds(350, 600, 250, 50);
		this.boutonGraphique.addActionListener(this);
		conteneurFenetre.add(boutonGraphique);

		/**
		 * this is the field in which the user can put the order
		 */
		dataStorage.setTexte(new JTextField());
		dataStorage.getTexte().setBounds(710, 260, 130, 60);
		dataStorage.getTexte().setFont(dataStorage.getF());
		dataStorage.getTexte().addActionListener(this);
		conteneurFenetre.add(dataStorage.getTexte());

	}

	/**
	 * Method actionPerformed that detect when a button is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == boutonPlus) {

			if (this.dataStorage.getConsigne() <= 19f) {
				this.dataStorage.setConsigne(this.dataStorage.getConsigne() + 1f);
				this.dataStorage.getValeurConsigneLabel()
						.setText(String.valueOf(this.dataStorage.getConsigne()) + "°C");
			} else {
				this.dataStorage.getValeurConsigneLabel().setText("20.0°C");
				this.dataStorage.setConsigne(20.00f);
			}
		}

		else if (source == boutonMoins) {

			if (this.dataStorage.getConsigne() >= 11f) {
				this.dataStorage.setConsigne(this.dataStorage.getConsigne() - 1f);
				this.dataStorage.getValeurConsigneLabel()
						.setText(String.valueOf(this.dataStorage.getConsigne()) + "°C");
			} else {
				this.dataStorage.getValeurConsigneLabel().setText("10.0°C");
				this.dataStorage.setConsigne(10.00f);
			}
		}

		else if (source == this.dataStorage.getTexte()) {

			float a = Float.parseFloat(this.dataStorage.getTexte().getText());

			if (a > 20f) {
				this.dataStorage.setConsigne(20.00f);
			} else if (a < 10f) {
				this.dataStorage.setConsigne(10.00f);
			} else if ((a >= 10f) && (a <= 20f)) {
				this.dataStorage.setConsigne(a);
			} else {
				System.out.println("nope");
			}
			this.dataStorage.getValeurConsigneLabel().setText(this.dataStorage.getConsigne() + "°C");
		}

		else if (source == boutonGraphique) {
			SwingUtilities.invokeLater(() -> {
				this.graphique.initUI();
				graphique.setVisible(true);
			});
		}

		this.dataStorage.setWriteConsigne(Float.toString(this.dataStorage.getConsigne()));
		try {
			this.serial.writeOutput(this.dataStorage.getWriteConsigne());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Graphique getGraphique() {
		return graphique;
	}
}
