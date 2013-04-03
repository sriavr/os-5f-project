package action;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.JFreeChart;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
//import java.util.Random;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
import java.util.Properties;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public class Graph1Action extends ActionSupport implements ServletRequestAware {

	public HttpServletRequest request;
	public String graphName;
	public String graphPath;

	public String getGraphPath() {
		return graphPath;
	}

	public void setGraphPath(String graphPath) {
		this.graphPath = graphPath;
	}

	public String getGraphName() {
		return graphName;
	}

	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}

	@Override
	public String execute() throws Exception {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("myapp.properties"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String modelDir = properties.getProperty("modelDir");
		System.out.println("modelDir:" + modelDir);
		String enronRoot = properties.getProperty("enronRoot");
		System.out.println("enronRoot:" + enronRoot);
		// /UIMAwebapp2/WebContent/graphs
		int stats[] = new int[1000];
		int count = 0;

		// function to get the name of employee
		File folder = new File(enronRoot);

		File[] listOfFiles1 = folder.listFiles();
		System.out.println(listOfFiles1.length);

		for (int i = 0; i < listOfFiles1.length; i++) {

			if (listOfFiles1[i].isDirectory()) {

				File[] list = listOfFiles1[i].listFiles();
				for (int j = 0; j < list.length; j++) {
					System.out.println("path:" + list[j].getAbsolutePath());
					count = addFilesFromDir(list[j]);
					System.out.println(count);
					if (count != -1) {
						stats[i] = count;
						break;
					}
				}
			}
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("Sent emails");
		for (int i = 0; i <= listOfFiles1.length; i++) {

			data.add(i, stats[i]);

		}
		dataset.addSeries(data);
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Number of emails sent vs Employees", // chart title
				"Enron Employees ", // x axis label
				"Number of emails", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false);
		try {

			String filepath = request.getRealPath("/graphs");
			String ext = "jpeg";
			// File dir = new File("D:\\");
			graphName = "graph1"
					+ String.format("%s.%s",
							RandomStringUtils.randomAlphanumeric(8), ext);
			graphPath = filepath + File.separator + graphName;
			// String name="graph1.jpeg";
			System.out.println(graphPath);
			ChartUtilities
					.saveChartAsJPEG(new File(graphPath), chart, 500, 500);
			System.out.println("Chart generated.");
		} catch (Exception e) {
			System.out.println("Problem occurred creating chart.");
		}

		return SUCCESS;
	}

	private static int addFilesFromDir(File Dir) { // function that would read
													// all folders inside a
													// particular employee we
													// received from string s

		int count = -1;
		System.out.println("dirname: " + Dir.getName());
		if (Dir.getName().trim().equalsIgnoreCase("sent_items")) {
			File[] list = Dir.listFiles();
			count = list.length;
			System.out.println("count=" + count);

		}

		return count;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
