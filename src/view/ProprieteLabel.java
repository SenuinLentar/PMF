package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProprieteLabel extends JPanel {

	/**
	 * Declaration of the variables used in order to create the labels
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titreLabel;
	private JLabel humiditeLabel;
	private JLabel consigneLabel;
	private JLabel temperatureInterieurLabel;
	private JLabel temperatureExterieurLabel;

	/**
	 * Properties of all the label used in the interface. It uses :
	 * 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public ProprieteLabel(DataStorage dataStorage, ConteneurFenetre conteneurFenetre) {

		/**
		 * The label for the title of the frame
		 */
		this.titreLabel = new JLabel();
		this.titreLabel.setBounds(270, 22, 400, 70);
		this.titreLabel.setText("Pimp my fridge");
		this.titreLabel.setForeground(Color.WHITE);
		this.titreLabel.setFont(dataStorage.getTitre());
		conteneurFenetre.add(titreLabel);

		/**
		 * the label that displays the inside temperature
		 */
		this.temperatureInterieurLabel = new JLabel();
		this.temperatureInterieurLabel.setBounds(20, 150, 400, 50);
		this.temperatureInterieurLabel.setText("Température intérieure");
		this.temperatureInterieurLabel.setForeground(Color.WHITE);
		this.temperatureInterieurLabel.setFont(dataStorage.getF());
		conteneurFenetre.add(temperatureInterieurLabel);

		/**
		 * the label that displays the outside temperature
		 */
		this.temperatureExterieurLabel = new JLabel();
		this.temperatureExterieurLabel.setBounds(20, 370, 400, 50);
		this.temperatureExterieurLabel.setText("Température extérieure");
		this.temperatureExterieurLabel.setForeground(Color.WHITE);
		this.temperatureExterieurLabel.setFont(dataStorage.getF());
		conteneurFenetre.add(temperatureExterieurLabel);

		/**
		 * the label that displays the order
		 */
		this.consigneLabel = new JLabel();
		this.consigneLabel.setBounds(500, 140, 300, 80); // CHANGER VALEUR
		this.consigneLabel.setText("Consigne");
		this.consigneLabel.setForeground(Color.WHITE);
		this.consigneLabel.setFont(dataStorage.getF());
		conteneurFenetre.add(consigneLabel);

		/**
		 * the label that displays the humidity
		 */
		this.humiditeLabel = new JLabel();
		this.humiditeLabel.setBounds(500, 355, 300, 80);
		this.humiditeLabel.setText("Humidité");
		this.humiditeLabel.setForeground(Color.WHITE);
		this.humiditeLabel.setFont(dataStorage.getF());
		conteneurFenetre.add(humiditeLabel);

		/**
		 * the label that displays the value of the inside temperature
		 */
		dataStorage.setValeurTemperatureInterieurLabel(new JLabel());
		dataStorage.getValeurTemperatureInterieurLabel().setBounds(160, 250, 400, 70);
		dataStorage.getValeurTemperatureInterieurLabel()
				.setText(String.valueOf(dataStorage.getTemperatureInterieure()) + "°C");
		dataStorage.getValeurTemperatureInterieurLabel().setForeground(Color.WHITE);
		dataStorage.getValeurTemperatureInterieurLabel().setFont(dataStorage.getTemperature());
		conteneurFenetre.add(dataStorage.getValeurTemperatureInterieurLabel());

		/**
		 * the label that displays the value of the outside temperature
		 */
		dataStorage.setValeurTemperatureExterieurLabel(new JLabel());
		dataStorage.getValeurTemperatureExterieurLabel().setBounds(160, 400, 300, 200);
		dataStorage.getValeurTemperatureExterieurLabel()
				.setText(String.valueOf(dataStorage.getTemperatureExterieure()) + "°C");
		dataStorage.getValeurTemperatureExterieurLabel().setForeground(Color.WHITE);
		dataStorage.getValeurTemperatureExterieurLabel().setFont(dataStorage.getTemperature());
		conteneurFenetre.add(dataStorage.getValeurTemperatureExterieurLabel());

		/**
		 * the label that displays the value of the order
		 */
		dataStorage.setValeurConsigneLabel(new JLabel());
		dataStorage.getValeurConsigneLabel().setBounds(500, 250, 400, 70);
		dataStorage.getValeurConsigneLabel().setText(String.valueOf(dataStorage.getConsigne()) + "°C");
		dataStorage.getValeurConsigneLabel().setForeground(Color.WHITE);
		dataStorage.getValeurConsigneLabel().setFont(dataStorage.getTitre());
		conteneurFenetre.add(dataStorage.getValeurConsigneLabel());

		/**
		 * the label that displays the value of the humidity
		 */
		dataStorage.setValeurHumiditeLabel(new JLabel());
		dataStorage.getValeurHumiditeLabel().setBounds(600, 450, 300, 80);
		dataStorage.getValeurHumiditeLabel().setText(String.valueOf(dataStorage.getHumiditeActuelle()) + "%");
		dataStorage.getValeurHumiditeLabel().setForeground(Color.WHITE);
		dataStorage.getValeurHumiditeLabel().setFont(dataStorage.getTemperature());
		conteneurFenetre.add(dataStorage.getValeurHumiditeLabel());
	}
}
