package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DataStorage {

	/**
	 * We declare all the variables that will be used in the different classes All
	 * the fonts used The inside and outside temperature, the humidity, and the order
	 * The variable used to stock the text entered by the user
	 */

	private Font f = new Font("Calibri", Font.PLAIN, 40); // Police du texte basique
	private Font titre = new Font("Calibri", Font.PLAIN, 60);
	private Font temperature = new Font("Calibri", Font.PLAIN, 80);
	private Font fmin = new Font("Calibri", Font.PLAIN, 24);
	private float temperatureExterieure;
	private float humiditeActuelle;
	private float consigne = 10.00f;
	private float temperatureInterieure;
	private String writeConsigne;
	private JLabel valeurConsigneLabel;
	private JTextField texte;
	private JLabel valeurTemperatureInterieurLabel;
	private JLabel valeurTemperatureExterieurLabel;
	private JLabel valeurHumiditeLabel;
	
	private String[] array = new String[4];

	public DataStorage() {
		
		this.array[0] = "0";
		this.array[1] = "1";
		this.array[2] = "2";
		this.array[3] = "10";
		
	}
	
	public void updateDatas() {
		this.temperatureExterieure = Float.parseFloat(this.array[0]);
		this.temperatureInterieure = Float.parseFloat(this.array[1]);
		this.humiditeActuelle = Float.parseFloat(this.array[2]);
	}

	/**
	 * getter of the text
	 * 
	 * @return texte
	 */
	public JTextField getTexte() {
		return texte;
	}

	/**
	 * setter for the text
	 * 
	 * @param texte
	 */
	public void setTexte(JTextField texte) {
		this.texte = texte;
	}

	/**
	 * @return f
	 */
	public Font getF() {
		return f;
	}

	/**
	 * @return fmin
	 */
	public Font getFmin() {
		return fmin;
	}

	/**
	 * @return titre
	 */
	public Font getTitre() {
		return titre;
	}

	/**
	 * @return temperature
	 */
	public Font getTemperature() {
		return temperature;
	}

	/**
	 * get the temperature outside
	 * 
	 * @return temperatureExterieure
	 */
	public float getTemperatureExterieure() {
		return temperatureExterieure;
	}

	/**
	 * get the humidity
	 * 
	 * @return humiditeActuelle
	 */
	public float getHumiditeActuelle() {
		return humiditeActuelle;
	}

	/**
	 * get the order for the inside temperature
	 * 
	 * @return consigne
	 */
	public float getConsigne() {
		return consigne;
	}

	/**
	 * set the order for the inside temperature
	 * 
	 * @param consigne
	 */
	public void setConsigne(float consigne) {
		this.consigne = consigne;
	}

	/**
	 * get the inside temperature
	 * 
	 * @returntemperatureInterieure
	 */
	public float getTemperatureInterieure() {
		return temperatureInterieure;
	}

	/**
	 * MAxime
	 * 
	 * @return writeConsigne
	 */
	public String getWriteConsigne() {
		return writeConsigne;
	}

	/**
	 * MAxime
	 * 
	 * @param writeConsigne
	 */
	public void setWriteConsigne(String writeConsigne) {
		this.writeConsigne = writeConsigne;
	}

	/**
	 * get the value of the order
	 * 
	 * @return valeurConsigneLabel
	 */
	public JLabel getValeurConsigneLabel() {
		return valeurConsigneLabel;
	}

	/**
	 * set the value of the order
	 * 
	 * @param valeurConsigneLabel
	 */
	public void setValeurConsigneLabel(JLabel valeurConsigneLabel) {
		this.valeurConsigneLabel = valeurConsigneLabel;
	}

	/**
	 * set the value of the outside temperature
	 * 
	 * @param temperatureExterieure
	 */
	public void setTemperatureExterieure(float temperatureExterieure) {
		this.temperatureExterieure = temperatureExterieure;
	}

	/**
	 * set the value of the humidity
	 * 
	 * @param humiditeActuelle
	 */
	public void setHumiditeActuelle(float humiditeActuelle) {
		this.humiditeActuelle = humiditeActuelle;
	}

	/**
	 * set the value of the inside temperature
	 * 
	 * @param temperatureInterieure
	 */
	public void setTemperatureInterieure(float temperatureInterieure) {
		this.temperatureInterieure = temperatureInterieure;
	}

	/**
	 * Getter of temperatureInterieurLabel.
	 * 
	 * @return temperatureInterieurLabel
	 */
	public JLabel getValeurTemperatureInterieurLabel() {
		return valeurTemperatureInterieurLabel;
	}

	/**
	 * Getter of temperatureExterieurLabel.
	 * 
	 * @return temperatureExterieurLabel
	 */
	public JLabel getValeurTemperatureExterieurLabel() {
		return valeurTemperatureExterieurLabel;
	}

	/**
	 * Getter of valeurHumiditeLabel.
	 * 
	 * @return valeurHumiditeLabel
	 */
	public JLabel getValeurHumiditeLabel() {
		return valeurHumiditeLabel;
	}

	/**
	 * Setter of valeurTemperatureInterieurLabel.
	 * 
	 * @param valeurTemperatureInterieurLabel
	 */
	public void setValeurTemperatureInterieurLabel(JLabel valeurTemperatureInterieurLabel) {
		this.valeurTemperatureInterieurLabel = valeurTemperatureInterieurLabel;
	}

	/**
	 * Setter of valeurTemperatureExterieurLabel.
	 * 
	 * @param valeurTemperatureExterieurLabel
	 */
	public void setValeurTemperatureExterieurLabel(JLabel valeurTemperatureExterieurLabel) {
		this.valeurTemperatureExterieurLabel = valeurTemperatureExterieurLabel;
	}

	/**
	 * Setter of valeurHumiditeLabel.
	 * 
	 * @param valeurHumiditeLabel
	 */
	public void setValeurHumiditeLabel(JLabel valeurHumiditeLabel) {
		this.valeurHumiditeLabel = valeurHumiditeLabel;
	}

	/**
	 * The getter of chunks.
	 * 
	 * @return chunks
	 */
	public String[] getArray() {
		return array;
	}

	/**
	 * The setter of chunks.
	 * 
	 * @param string
	 */
	public void setArray(String[] string) {
		this.array = string;
	}
}
