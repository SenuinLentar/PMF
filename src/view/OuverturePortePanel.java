package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class OuverturePortePanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel text;
	private Font test = new Font("Calibri", Font.BOLD, 40);

    /**
     * Constructor of the class OuverturePortePanel.
     */
    public OuverturePortePanel() {
        text = new JLabel ();
        this.text.setBounds(20, 150, 400, 50);
        this.text.setText("Porte ouverte!");
        this.text.setForeground(Color.BLACK);
        this.text.setFont(test);
        this.add(text);
    }
}