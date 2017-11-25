package model;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DataStorage {

	/**
	 * We declare all the variables that will be used in the different classes All
	 * the fonts used The inside and outside temperature, the humidity, and the order
	 * The variable used to stock the text entered by the user
	 */

	private Font classicFont = new Font("Calibri", Font.PLAIN, 40); // Police du texte basique
	private Font titleFont = new Font("Calibri", Font.PLAIN, 60);
	private Font tempFont = new Font("Calibri", Font.PLAIN, 80);
	private Font minFont = new Font("Calibri", Font.PLAIN, 24);
	
	private float outsideTemperature;
	private float humidity;
	private float order = 10.00f;
	private float insideTemperature;
	
	private JTextField textField;
	
	private JLabel orderLabel;	
	private JLabel inTempLabel;
	private JLabel outTempLabel;
	private JLabel humidityLabel;
	
	private String[] array = new String[4];

	/**
	 * Constructor of the class DataStorage.
	 */
	public DataStorage() {
		this.array[0] = "0";
		this.array[1] = "1";
		this.array[2] = "2";
		this.array[3] = "10";
	}
	
	/**
	 * Put the collected data in these variables.
	 */
	public void updateData() {
		this.outsideTemperature = Float.parseFloat(this.array[0]);
		this.insideTemperature = Float.parseFloat(this.array[1]);
		this.humidity = Float.parseFloat(this.array[2]);
	}

	/**
	 * Getter of the textField.
	 * 
	 * @return textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Getter of the classicFont.
	 * 
	 * @return classicFont
	 */
	public Font getClassicFont() {
		return classicFont;
	}

	/**
	 * Getter of the minFont.
	 * 
	 * @return minFont
	 */
	public Font getMinFont() {
		return minFont;
	}

	/**
	 * Getter of the titleFont.
	 * 
	 * @return titleFont
	 */
	public Font getTitleFont() {
		return titleFont;
	}

	/**
	 * Getter of the tempFont.
	 * 
	 * @return tempFont
	 */
	public Font getTempFont() {
		return tempFont;
	}

	/**
	 * Getter of the outsideTemperature.
	 * 
	 * @return outsideTemperature
	 */
	public float getOutsideTemperature() {
		return outsideTemperature;
	}

	/**
	 * Getter of the humidity.
	 * 
	 * @return humidity
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * Getter of the order.
	 * 
	 * @return order
	 */
	public float getOrder() {
		return order;
	}

	/**
	 * Getter of the insideTemperature.
	 * 
	 * @return insideTemperature
	 */
	public float getInsideTemperature() {
		return insideTemperature;
	}

	/**
	 * Getter of the orderLabel.
	 * 
	 * @return orderLabel
	 */
	public JLabel getOrderLabel() {
		return orderLabel;
	}
	
	/**
	 * Getter of inTempLabel.
	 * 
	 * @return inTempLabel
	 */
	public JLabel getInTempLabel() {
		return inTempLabel;
	}

	/**
	 * Getter of outTempLabel.
	 * 
	 * @return outTempLabel
	 */
	public JLabel getOutTempLabel() {
		return outTempLabel;
	}

	/**
	 * Getter of humidityLabel.
	 * 
	 * @return humidityLabel
	 */
	public JLabel getHumidityLabel() {
		return humidityLabel;
	}

	/**
	 * Getter of array.
	 * 
	 * @return array
	 */
	public String[] getArray() {
		return array;
	}

	/**
	 * Setter of orderLabel.
	 * 
	 * @param orderLabel
	 */
	public void setOrderLabel(JLabel orderLabel) {
		this.orderLabel = orderLabel;
	}

	/**
	 * Setter of outsideTemperature.
	 * 
	 * @param outsideTemperature
	 */
	public void setOutsideTemperature(float outsideTemperature) {
		this.outsideTemperature = outsideTemperature;
	}

	/**
	 * Setter of humidity.
	 * 
	 * @param humidity
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	/**
	 * Setter of insideTemperature.
	 * 
	 * @param insideTemperature
	 */
	public void setInsideTemperature(float insideTemperature) {
		this.insideTemperature = insideTemperature;
	}



	/**
	 * Setter of inTempLabel.
	 * 
	 * @param inTempLabel
	 */
	public void setInTempLabel(JLabel inTempLabel) {
		this.inTempLabel = inTempLabel;
	}

	/**
	 * Setter of outTempLabel.
	 * 
	 * @param outTempLabel
	 */
	public void setOutTempLabel(JLabel outTempLabel) {
		this.outTempLabel = outTempLabel;
	}

	/**
	 * Setter of humidityLabel.
	 * 
	 * @param humidityLabel
	 */
	public void setHumidityLabel(JLabel humidityLabel) {
		this.humidityLabel = humidityLabel;
	}
	
	/**
	 * Setter for the textField.
	 * 
	 * @param textField
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	/**
	 * Setter for the textField.
	 * 
	 * @param order
	 */
	public void setOrder(float order) {
		this.order = order;
	}


	/**
	 * Setter for the array.
	 * 
	 * @param array
	 */
	public void setArray(String[] array) {
		this.array = array;
	}
}
