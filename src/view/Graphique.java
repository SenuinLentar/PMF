package view;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import model.ChunksCreator;

/**
 * Class Graphique in which we fill and display the graphique
 */
public class Graphique extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * the variable used for the graphique Two variables for two "lines" One
	 * variable for the chart One array (two dimension) to stock the values of the
	 * temperature inside and the humidity Create the array to stok the values
	 * 
	 */
	private XYSeries temperature, humidite;
	private XYSeriesCollection graphique;
	private JFreeChart chart;
	private XYDataset dataset;
	private ChartPanel chartPanel;
	private float[][] data = new float[3][10];
	private ChunksCreator chunksCreator;
	private int x = 0, time = 0;

	/**
	 * Contructor Graphique which uses
	 * 
	 * @param chunksCreator
	 */
	public Graphique(ChunksCreator chunksCreator) {
		this.chunksCreator = chunksCreator;
		this.graphique = new XYSeriesCollection();
	}

	/**
	 * Methode to instantiate the JFrame of the graph
	 * 
	 */
	public void initUI() {
		this.dataset = createDataset();
		this.chart = createChart(dataset);
		this.chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		add(chartPanel);
		pack();
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Graphique.HIDE_ON_CLOSE);
	}

	public void updateGraphic() {
		this.dataset = createDataset();
		this.chart = createChart(dataset);
		//this.chartPanel = new ChartPanel(chart);
	}

	/**
	 * Method that create the Dataset and
	 * 
	 * @return graphique It fills the 2 variables (temperature and humidity) with
	 *         the data stored in the array (Chunck) Then the 2 variables are added
	 *         to the XYSeriesCollection
	 */
	public XYDataset createDataset() {

		temperature = new XYSeries("température (°C)");
		humidite = new XYSeries("humidité");

		this.temperature.clear();
		this.humidite.clear();
		this.graphique.removeAllSeries();
		
		for (int i = 0; i < 9; i++) {
			this.temperature.add(data[2][i], data[0][i]);
			this.humidite.add(data[2][i], data[1][i]);
		}

		this.graphique.addSeries(temperature);
		this.graphique.addSeries(humidite);

		time++;

		return graphique;
	}

	/**
	 * Methode that update the array using
	 * 
	 * @param chunks
	 *            It allows the graph to refresh by removing the first value of the
	 *            array and by shifting all the values in the case-1
	 */
	public void updateTable(String[] chunks) {
		if (x < 10) {
			data[0][x] = Float.parseFloat(this.chunksCreator.getChunks()[1]);
			data[1][x] = Float.parseFloat(this.chunksCreator.getChunks()[2]);
			data[2][x] = time;
			x++;
		} else {
			for (int i = 0; i < 9; i++) {
				data[0][i] = data[0][i + 1];
				data[1][i] = data[1][i + 1];
				data[2][i] = data[2][i + 1];
			}
			data[0][9] = Float.parseFloat(this.chunksCreator.getChunks()[1]);
			data[1][9] = Float.parseFloat(this.chunksCreator.getChunks()[2]);
			data[2][9] = time;
			time++;
		}
	}

	/**
	 * Methode that create the chart using
	 * 
	 * @param dataset
	 * @return chart
	 */
	private JFreeChart createChart(final XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart("Courbe température et humidité", "temps (en seconde)", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);

		// Grille fond du graphique.
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		chart.getLegend().setFrame(BlockBorder.NONE);
		return chart;
	}

	/**
	 * getter for the data
	 * 
	 * @return data
	 */
	public float[][] getData() {
		return data;
	}

}
