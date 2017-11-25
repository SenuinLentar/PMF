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
	private JLabel titleLabel;
	private JLabel humidityLabel;
	private JLabel orderLabel;
	private JLabel inTempLabel;
	private JLabel outTempLabel;

	private DataStorage dataStorage;

	/**
	 * Properties of all the label used in the interface. It uses :
	 * 
	 * @param dataStorage
	 * @param panel
	 */
	public Label(DataStorage dataStorage, Panel panel) {

		this.dataStorage = dataStorage;

		/**
		 * The label for the title of the frame
		 */
		this.titleLabel = new JLabel();
		this.titleLabel.setBounds(270, 22, 400, 70);
		this.titleLabel.setText("Pimp my fridge");
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(dataStorage.getTitleFont());
		panel.add(titleLabel);

		/**
		 * The label that displays the inside temperature.
		 */
		this.inTempLabel = new JLabel();
		this.inTempLabel.setBounds(20, 150, 400, 50);
		this.inTempLabel.setText("Température intérieure");
		this.inTempLabel.setForeground(Color.WHITE);
		this.inTempLabel.setFont(dataStorage.getClassicFont());
		panel.add(inTempLabel);

		/**
		 * The label that displays the outside temperature.
		 */
		this.outTempLabel = new JLabel();
		this.outTempLabel.setBounds(20, 370, 400, 50);
		this.outTempLabel.setText("Température extérieure");
		this.outTempLabel.setForeground(Color.WHITE);
		this.outTempLabel.setFont(dataStorage.getClassicFont());
		panel.add(outTempLabel);

		/**
		 * The label that displays the order.
		 */
		this.orderLabel = new JLabel();
		this.orderLabel.setBounds(500, 140, 300, 80); // CHANGER VALEUR
		this.orderLabel.setText("Consigne");
		this.orderLabel.setForeground(Color.WHITE);
		this.orderLabel.setFont(dataStorage.getClassicFont());
		panel.add(orderLabel);

		/**
		 * The label that displays the humidity.
		 */
		this.humidityLabel = new JLabel();
		this.humidityLabel.setBounds(500, 355, 300, 80);
		this.humidityLabel.setText("Humidité");
		this.humidityLabel.setForeground(Color.WHITE);
		this.humidityLabel.setFont(dataStorage.getClassicFont());
		panel.add(humidityLabel);

		/**
		 * The label that displays the value of the inside temperature.
		 */
		dataStorage.setInTempValueLabel(new JLabel());
		dataStorage.getInTempValueLabel().setBounds(160, 250, 400, 70);
		dataStorage.getInTempValueLabel().setText(String.valueOf(dataStorage.getInsideTemperature()) + "°C");
		dataStorage.getInTempValueLabel().setForeground(Color.WHITE);
		dataStorage.getInTempValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getInTempValueLabel());

		/**
		 * The label that displays the value of the outside temperature.
		 */
		dataStorage.setOutTempValueLabel(new JLabel());
		dataStorage.getOutTempValueLabel().setBounds(160, 400, 300, 200);
		dataStorage.getOutTempValueLabel().setText(String.valueOf(dataStorage.getOutsideTemperature()) + "°C");
		dataStorage.getOutTempValueLabel().setForeground(Color.WHITE);
		dataStorage.getOutTempValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getOutTempValueLabel());

		/**
		 * The label that displays the value of the order.
		 */
		dataStorage.setOrderValueLabel(new JLabel());
		dataStorage.getOrderValueLabel().setBounds(500, 250, 400, 70);
		dataStorage.getOrderValueLabel().setText(String.valueOf(dataStorage.getOrder()) + "°C");
		dataStorage.getOrderValueLabel().setForeground(Color.WHITE);
		dataStorage.getOrderValueLabel().setFont(dataStorage.getTitleFont());
		panel.add(dataStorage.getOrderValueLabel());

		/**
		 * The label that displays the value of the humidity.
		 */
		dataStorage.setHumidityValueLabel(new JLabel());
		dataStorage.getHumidityValueLabel().setBounds(600, 450, 300, 80);
		dataStorage.getHumidityValueLabel().setText(String.valueOf(dataStorage.getHumidity()) + "%");
		dataStorage.getHumidityValueLabel().setForeground(Color.WHITE);
		dataStorage.getHumidityValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getHumidityValueLabel());
	}

	/**
	 * Update the display of the labels.
	 */
	public void updateLabels() {
		this.dataStorage.getHumidityValueLabel().setText(String.valueOf(dataStorage.getHumidity()));
		this.dataStorage.getOutTempValueLabel().setText(String.valueOf(dataStorage.getOutsideTemperature()));
		this.dataStorage.getInTempValueLabel().setText(String.valueOf(dataStorage.getInsideTemperature()));
	}
}
