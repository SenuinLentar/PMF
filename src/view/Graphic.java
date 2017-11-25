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

import model.DataStorage;

/**
 * Class Graphique in which we fill and display the graphique
 */
public class Graphic extends JFrame {

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
	private XYSeries temperatureInside, temperatureOutside, humidite;
	private XYSeriesCollection graphique;
	private JFreeChart chart;
	private XYDataset dataset;
	private ChartPanel chartPanel;
	private float[][] data = new float[4][10];
	private DataStorage dataStorage;
	private int x = 0, time = 0;

	/**
	 * Contructor Graphique which uses
	 * 
	 * @param chunksCreator
	 */
	public Graphic(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
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
		this.setDefaultCloseOperation(Graphic.HIDE_ON_CLOSE);
	}

	public void updateGraphic() {
		this.dataset = createDataset();
		this.chart = createChart(dataset);
		// this.chartPanel = new ChartPanel(chart);
	}

	/**
	 * Method that create the Dataset and
	 * 
	 * @return graphique It fills the 2 variables (temperature and humidity) with
	 *         the data stored in the array (Chunck) Then the 2 variables are added
	 *         to the XYSeriesCollection
	 */
	public XYDataset createDataset() {

		temperatureInside = new XYSeries("température intérieure(°C)");
		humidite = new XYSeries("humidité");
		temperatureOutside = new XYSeries("empérature extérieure(°C)");

		this.temperatureInside.clear();
		this.temperatureOutside.clear();
		this.humidite.clear();
		this.graphique.removeAllSeries();

		for (int i = 0; i < 9; i++) {
			this.temperatureInside.add(data[3][i], data[0][i]);
			this.humidite.add(data[3][i], data[1][i]);
			this.temperatureOutside.add(data[3][i], data[2][i]);
		}

		this.graphique.addSeries(temperatureInside);
		this.graphique.addSeries(humidite);
		this.graphique.addSeries(temperatureOutside);

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
			data[0][x] = Float.parseFloat(this.dataStorage.getArray()[1]);
			data[1][x] = Float.parseFloat(this.dataStorage.getArray()[2]);
			data[2][x] = Float.parseFloat(this.dataStorage.getArray()[0]);
			data[3][x] = time;
			x++;
		} else {
			for (int i = 0; i < 9; i++) {
				data[0][i] = data[0][i + 1];
				data[1][i] = data[1][i + 1];
				data[2][i] = data[2][i + 1];
				data[3][i] = data[3][i + 1];
			}
			data[0][9] = Float.parseFloat(this.dataStorage.getArray()[1]);
			data[1][9] = Float.parseFloat(this.dataStorage.getArray()[2]);
			data[2][9] = Float.parseFloat(this.dataStorage.getArray()[0]);
			data[3][9] = time;
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

		JFreeChart chart = ChartFactory.createXYLineChart("Courbe températures et humidité", "temps (en seconde)", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));

		renderer.setSeriesPaint(2, Color.GREEN);
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));

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
