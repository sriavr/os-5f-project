package action;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.JFreeChart;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
//import java.util.Random;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
import java.util.Properties;
import java.util.StringTokenizer;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public class Graph1Action extends ActionSupport implements ServletRequestAware {

	public HttpServletRequest request;
	private String graphName;
	private String sampleSize = "";
	private String graphPath;
	private String folder;
	private int width = 800;
	private int height = 800;
	private String graph = "xychart";

	public String getSampleSize() {
		return sampleSize;
	}

	public void setSampleSize(String sampleSize) {
		this.sampleSize = sampleSize;
	}

	public String getGraph() {
		return graph;
	}

	public void setGraph(String graph) {
		this.graph = graph;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

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
		int sSize = 5;
		if (sampleSize.trim().equals("5"))
			sSize = 5;
		else if (sampleSize.trim().equals("20"))
			sSize = 20;
		else if (sampleSize.trim().equals("all"))
			sSize = 10000;
		
		System.out.println("sSize:"+sSize);

		System.out.println("graph:" + graph);
		boolean inbox = false, sentItems = false, delItems = false, allItems = false;
		System.out.println("folder:" + folder);
		if (folder != null) {
			StringTokenizer st = new StringTokenizer(folder, ",");
			while (st.hasMoreTokens()) {
				String temp = st.nextToken().trim();
				if (temp.equals("inbox"))
					inbox = true;
				else if (temp.equals("sentItems"))
					sentItems = true;
				else if (temp.equals("delItems"))
					delItems = true;
				else if (temp.equals("allItems"))
					allItems = true;
			}
			// System.out.println("inbox:" + inbox + " sentItems:" + sentItems
			// + " delItems:" + delItems + " allItems:" + allItems);
		}

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
		int inboxArr[] = new int[1000];
		int sentItemsArr[] = new int[1000];
		int delItemsArr[] = new int[1000];
		int allItemsArr[] = new int[1000];
		int inboxCnt = 0, sentItemsCnt = 0, delItemsCnt = 0, allItemsCnt = 0;

		// function to get the name of employee
		File folder = new File(enronRoot);

		File[] listOfFiles1 = folder.listFiles();
		// System.out.println(listOfFiles1.length);

		for (int i = 0; i < listOfFiles1.length && i <sSize; i++) {

			if (listOfFiles1[i].isDirectory()) {

				File[] list = listOfFiles1[i].listFiles();
				for (int j = 0; j < list.length; j++) {
					System.out.println("path:" + list[j].getAbsolutePath());
					inboxCnt = addFilesFromDir(list[j], "inbox");
					sentItemsCnt = addFilesFromDir(list[j], "sent_items");
					delItemsCnt = addFilesFromDir(list[j], "deleted_items");
					allItemsCnt = addFilesFromDir(list[j], "all_documents");
					// System.out.println("Count inbox:" + inboxCnt
					// + " sentItems:" + sentItemsCnt + " delItems:"
					// + delItemsCnt + " allItems:" + allItemsCnt);
					if (inboxCnt != -1) {
						inboxArr[i] = inboxCnt;
					}
					if (sentItemsCnt != -1) {
						sentItemsArr[i] = sentItemsCnt;
					}
					if (delItemsCnt != -1) {
						delItemsArr[i] = delItemsCnt;
					}
					if (allItemsCnt != -1) {
						allItemsArr[i] = allItemsCnt;
					}
				}
			}
		}

		if (graph.trim().equals("piechart")) {
			DefaultPieDataset pieDataset = new DefaultPieDataset();
			if (inbox)
				pieDataset.setValue("Inbox", countArr(inboxArr));
			if (sentItems)
				pieDataset.setValue("Sent Items", countArr(sentItemsArr));
			if (delItems)
				pieDataset.setValue("Deleted Items", countArr(delItemsArr));
			if (allItems)
				pieDataset.setValue("All Documents", countArr(allItemsArr));
			JFreeChart chart = ChartFactory.createPieChart3D(
					"Email distribution", pieDataset, true, true, true);
			PiePlot3D p = (PiePlot3D) chart.getPlot();
			p.setForegroundAlpha(0.9f);
			p.setBackgroundPaint(Color.white);
			p.setOutlineVisible(false);
			try {
				String filepath = request.getRealPath("/graphs");
				String ext = "jpeg";
				// File dir = new File("D:\\");
				graphName = "graphPie"
						+ String.format("%s.%s",
								RandomStringUtils.randomAlphanumeric(8), ext);
				graphPath = filepath + File.separator + graphName;
				// String name="graph1.jpeg";
				System.out.println(graphPath);
				ChartUtilities.saveChartAsJPEG(new File(graphPath), chart,
						width, height);
				System.out.println("Chart generated.");
			} catch (Exception e) {
				System.out.println("Problem occurred creating chart.");
			}
		} else if (graph.trim().equals("xychart")) {
			XYSeriesCollection dataset = new XYSeriesCollection();

			XYSeries inboxData = new XYSeries("inbox");
			XYSeries sentItemsData = new XYSeries("sent items");
			XYSeries delItemsData = new XYSeries("deleted items");
			XYSeries allItemsData = new XYSeries("all documents");
			for (int i = 0; i <= listOfFiles1.length; i++) {
				inboxData.add(i, inboxArr[i]);
				sentItemsData.add(i, sentItemsArr[i]);
				delItemsData.add(i, delItemsArr[i]);
				allItemsData.add(i, allItemsArr[i]);
			}

			if (inbox)
				dataset.addSeries(inboxData);
			if (sentItems)
				dataset.addSeries(sentItemsData);
			if (delItems)
				dataset.addSeries(delItemsData);
			if (allItems)
				dataset.addSeries(allItemsData);

			JFreeChart chart2 = ChartFactory.createScatterPlot(
					"Number of emails vs Employees", // chart title
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
				ChartUtilities.saveChartAsJPEG(new File(graphPath), chart2,
						width, height);
				System.out.println("Chart generated.");
			} catch (Exception e) {
				System.out.println("Problem occurred creating chart.");
			}
		}
		return SUCCESS;
	}

	private int countArr(int[] inboxArr) {
		int temp = 0;
		for (int i = 0; i < inboxArr.length; i++) {
			temp = temp + inboxArr[i];
		}
		return temp;
	}

	private static int addFilesFromDir(File Dir, String fName) { // function
																	// that
																	// would
																	// read
		// all folders inside a
		// particular employee we
		// received from string s

		int count = -1;
		// System.out.println("dirname: " + Dir.getName());
		if (Dir.getName().trim().equalsIgnoreCase(fName)) {
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
