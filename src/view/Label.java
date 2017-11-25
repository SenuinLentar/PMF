package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DataStorage;

public class Label extends JPanel {

	/**
	 * Declaration of the variables used in order to create the labels
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titreLabel;
	private JLabel humiditeLabel;
	private JLabel consigneLabel;
	private JLabel temperatureInterieurLabel;
	private JLabel temperatureExterieurLabel;
	
	private DataStorage dataStorage;

	/**
	 * Properties of all the label used in the interface. It uses :
	 * 
	 * @param dataStorage
	 * @param conteneurFenetre
	 */
	public Label(DataStorage dataStorage, Panel conteneurFenetre) {

		this.dataStorage = dataStorage;
		
		/**
		 * The label for the title of the frame
		 */
		this.titreLabel = new JLabel();
		this.titreLabel.setBounds(270, 22, 400, 70);
		this.titreLabel.setText("Pimp my fridge");
		this.titreLabel.setForeground(Color.WHITE);
		this.titreLabel.setFont(dataStorage.getTitleFont());
		conteneurFenetre.add(titreLabel);

		/**
		 * the label that displays the inside temperature
		 */
		this.temperatureInterieurLabel = new JLabel();
		this.temperatureInterieurLabel.setBounds(20, 150, 400, 50);
		this.temperatureInterieurLabel.setText("Température intérieure");
		this.temperatureInterieurLabel.setForeground(Color.WHITE);
		this.temperatureInterieurLabel.setFont(dataStorage.getClassicFont());
		conteneurFenetre.add(temperatureInterieurLabel);

		/**
		 * the label that displays the outside temperature
		 */
		this.temperatureExterieurLabel = new JLabel();
		this.temperatureExterieurLabel.setBounds(20, 370, 400, 50);
		this.temperatureExterieurLabel.setText("Température extérieure");
		this.temperatureExterieurLabel.setForeground(Color.WHITE);
		this.temperatureExterieurLabel.setFont(dataStorage.getClassicFont());
		conteneurFenetre.add(temperatureExterieurLabel);

		/**
		 * the label that displays the order
		 */
		this.consigneLabel = new JLabel();
		this.consigneLabel.setBounds(500, 140, 300, 80); // CHANGER VALEUR
		this.consigneLabel.setText("Consigne");
		this.consigneLabel.setForeground(Color.WHITE);
		this.consigneLabel.setFont(dataStorage.getClassicFont());
		conteneurFenetre.add(consigneLabel);

		/**
		 * the label that displays the humidity
		 */
		this.humiditeLabel = new JLabel();
		this.humiditeLabel.setBounds(500, 355, 300, 80);
		this.humiditeLabel.setText("Humidité");
		this.humiditeLabel.setForeground(Color.WHITE);
		this.humiditeLabel.setFont(dataStorage.getClassicFont());
		conteneurFenetre.add(humiditeLabel);

		/**
		 * the label that displays the value of the inside temperature
		 */
		dataStorage.setInTempLabel(new JLabel());
		dataStorage.getValeurTemperatureInterieurLabel().setBounds(160, 250, 400, 70);
		dataStorage.getValeurTemperatureInterieurLabel()
				.setText(String.valueOf(dataStorage.getInsideTemperature()) + "°C");
		dataStorage.getValeurTemperatureInterieurLabel().setForeground(Color.WHITE);
		dataStorage.getValeurTemperatureInterieurLabel().setFont(dataStorage.getTempFont());
		conteneurFenetre.add(dataStorage.getValeurTemperatureInterieurLabel());
		/**
		 * the label that displays the value of the outside temperature
		 */
		dataStorage.setOutTempLabel(new JLabel());
		dataStorage.getOutTempLabel().setBounds(160, 400, 300, 200);
		dataStorage.getOutTempLabel()
				.setText(String.valueOf(dataStorage.getOutsideTemperature()) + "°C");
		dataStorage.getOutTempLabel().setForeground(Color.WHITE);
		dataStorage.getOutTempLabel().setFont(dataStorage.getTempFont());
		conteneurFenetre.add(dataStorage.getOutTempLabel());

		/**
		 * the label that displays the value of the order
		 */
		dataStorage.setOrderLabel(new JLabel());
		dataStorage.getOrderLabel().setBounds(500, 250, 400, 70);
		dataStorage.getOrderLabel().setText(String.valueOf(dataStorage.getOrder()) + "°C");
		dataStorage.getOrderLabel().setForeground(Color.WHITE);
		dataStorage.getOrderLabel().setFont(dataStorage.getTitleFont());
		conteneurFenetre.add(dataStorage.getOrderLabel());

		/**
		 * the label that displays the value of the humidity
		 */
		dataStorage.setHumidityLabel(new JLabel());
		dataStorage.getHumidityLabel().setBounds(600, 450, 300, 80);
		dataStorage.getHumidityLabel().setText(String.valueOf(dataStorage.getHumidity()) + "%");
		dataStorage.getHumidityLabel().setForeground(Color.WHITE);
		dataStorage.getHumidityLabel().setFont(dataStorage.getTempFont());
		conteneurFenetre.add(dataStorage.getHumidityLabel());
	}
	
	public void updateLabels() {
		this.dataStorage.getHumidityLabel().setText(String.valueOf(dataStorage.getHumidity()));
		this.dataStorage.getOutTempLabel()
				.setText(String.valueOf(dataStorage.getOutsideTemperature()));
		this.dataStorage.getValeurTemperatureInterieurLabel()
				.setText(String.valueOf(dataStorage.getInsideTemperature()));
	}
}
