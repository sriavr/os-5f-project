package action;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import model.POScount;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import org.jfree.chart.JFreeChart;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.XMLInputSource;
//import java.util.Random;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import util.DateUtil;

import javax.servlet.http.HttpServletRequest;

import annotation.DateTimeAnnotation;

import com.opensymphony.xwork2.ActionSupport;

public class Graph1Action extends ActionSupport implements ServletRequestAware {
	Logger logger = Logger.getLogger(this.getClass().getName());
	public HttpServletRequest request;
	private String graphName;
	private String sampleSize = "";
	private String graphPath;
	private String folder;
	private int width = 800;
	private int height = 800;
	private String graph = "xychart";
	private ArrayList<Calendar> emailDatesList = new ArrayList<Calendar>();
	private int[] months = new int[12];
	private InputStream smis = null;
	private InputStream tmis = null;
	private InputStream pmis = null;
	private InputStream cmis = null;
	private static SentenceDetectorME sentenceDetector;
	private static TokenizerME tokenizer;
	private static POSTaggerME posTagger;
	private static ChunkerME chunker;

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

	private Properties properties;
	private TimeSeries timegraphYearly;
	private TimeSeries timegraphMonthly;
	private TimeSeries timegraphDaily;
	private TimeSeries timegraphDailyTrend;
	private TimeSeries timegraphHourly;
	private TimeSeries timegraphEmotivenessDaily;
	private TimeSeries timegraphEmotivenessWeekly;
	private String modelDir = "";
	private SentenceModel smodel;
	private TokenizerModel tmodel;

	@Override
	public String execute() throws Exception {
		logger.info("Inside execute method");
		properties = new Properties();
		try {
			logger.info("Loading properties");
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("myapp.properties"));

		} catch (IOException e) {
			logger.error("Error loading properties file.", e);
			e.printStackTrace();
		}

		modelDir = properties.getProperty("modelDir");
		logger.debug("modelDir:" + modelDir);
		String enronRoot = properties.getProperty("enronRoot");
		logger.debug("enronRoot:" + enronRoot);
		String descRoot = properties.getProperty("descRoot");
		logger.debug("descRoot:" + descRoot);

		smis = new FileInputStream(new File(modelDir + File.separator
				+ "en-sent.bin"));
		tmis = new FileInputStream(new File(modelDir + File.separator
				+ "en-token.bin"));
		pmis = new FileInputStream(new File(modelDir + File.separator
				+ "en-pos-maxent.bin"));
		// cmis = new FileInputStream(new File(modelPath + File.separator
		// + "en-chunker.bin"));
		smodel = new SentenceModel(smis);
		sentenceDetector = new SentenceDetectorME(smodel);
		tmodel = new TokenizerModel(tmis);
		tokenizer = new TokenizerME(tmodel);
		POSModel pmodel = new POSModel(pmis);
		posTagger = new POSTaggerME(pmodel);

		timegraphYearly = new TimeSeries("Yearly emails sent");
		timegraphMonthly = new TimeSeries("Monthly emails sent");
		timegraphDaily = new TimeSeries("Daily emails sent");
		timegraphDailyTrend = new TimeSeries(
				"Trend of emails sent by day of month");
		timegraphHourly = new TimeSeries("Hourly emails sent");
		timegraphEmotivenessDaily = new TimeSeries("Emotiveness (daily)");
		timegraphEmotivenessWeekly = new TimeSeries("Emotiveness (Weekly)");
		File inputDir = new File(enronRoot);
		File taeDescriptor = null;

		taeDescriptor = new File(descRoot + File.separator
				+ "EmailAnnotator.xml");
		boolean validArgs = false;
		validArgs = taeDescriptor.exists() && !taeDescriptor.isDirectory()
				&& inputDir.isDirectory();

		// logger.debug(" taeDescriptor.exists():" + taeDescriptor.exists()
		// + " !taeDescriptor.isDirectory()"
		// + !taeDescriptor.isDirectory() + " inputDir.isDirectory():"
		// + inputDir.isDirectory());\
		logger.debug("validArgs:" + validArgs);

		logger.info("Getting Resource Specifier from XML file");
		XMLInputSource in = new XMLInputSource(taeDescriptor);
		ResourceSpecifier specifier = UIMAFramework.getXMLParser()
				.parseResourceSpecifier(in);

		logger.info("create Analysis Engine");
		AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);
		// create a CAS
		CAS cas = ae.newCAS();

		URL dirURL = this.getClass().getClassLoader()
				.getResource("TimeDetectionAnnotator.xml");
		logger.debug("dirURL:" + dirURL);

		int sSize = 5;
		if (sampleSize.trim().equals("5"))
			sSize = 5;
		else if (sampleSize.trim().equals("20"))
			sSize = 20;
		else if (sampleSize.trim().equals("all"))
			sSize = 10000;
		else if (!sampleSize.isEmpty())
			sSize = Integer.parseInt(sampleSize.trim());
		logger.debug("sSize:" + sSize);

		logger.info("adding files from enron directory");
		addFilesFromDir(inputDir, sSize);
		logger.debug("added " + mFiles.size() + " files");
		if (mFiles == null || mFiles.size() == 0) {
			logger.debug("No files to process");
		} else {
			logger.info("processing documents");
			for (int i = 0; i < mFiles.size() && i < sSize; i++) {
				if (!mFiles.get(i).isDirectory()) {
					processFile(mFiles.get(i), ae, cas);
				}
			}
		}

		logger.info("Destroying the analysis engine");
		ae.destroy();

		logger.debug("graph:" + graph);
		boolean inbox = false, sentItems = false, delItems = false, allItems = false;
		logger.debug("folder:" + folder);
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
		}

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

		for (int i = 0; i < listOfFiles1.length && i < sSize; i++) {

			if (listOfFiles1[i].isDirectory()) {

				File[] list = listOfFiles1[i].listFiles();
				for (int j = 0; j < list.length; j++) {
					// logger.info("path:" + list[j].getAbsolutePath());
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
				logger.debug("graphPath:" + graphPath);
				ChartUtilities.saveChartAsJPEG(new File(graphPath), chart,
						width, height);
				logger.debug("Chart generated.");
			} catch (Exception e) {
				logger.error("Problem occurred creating chart.", e);
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
				logger.debug("graphPath:" + graphPath);
				ChartUtilities.saveChartAsJPEG(new File(graphPath), chart2,
						width, height);
				logger.debug("Chart generated.");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Problem occurred creating chart.", e);
			}
		} else if (graph.trim().startsWith("timegraph")) {
			logger.info("Inside block for running " + graph
					+ " of execute method");
			drawTimeGraph(sSize, graph.trim());
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

	/*
	 * 
	 * function that would read all folders inside a particular employee we
	 * received from string s
	 */
	private int addFilesFromDir(File Dir, String fName) {

		int count = -1;
		// logger.debug("dirname: " + Dir.getName());
		if (Dir.getName().trim().equalsIgnoreCase(fName)) {
			File[] list = Dir.listFiles();
			count = list.length;
			logger.debug("count=" + count);

		}

		return count;
	}

	public void drawTimeGraph(int sSize, String graph) {
		logger.info("Inside drawTimeGraph()");
		try {
			File taeDescriptor = null;
			File inputDir = null;

			// Read and validate command line arguments
			boolean validArgs = false;

			Properties properties = new Properties();
			try {
				properties.load(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("myapp.properties"));
			} catch (IOException e) {
				logger.error("Error occurred while loading properties file.", e);
				e.printStackTrace();
			}
			String modelDir = properties.getProperty("modelDir");
			logger.debug("modelDir:" + modelDir);
			String enronRoot = properties.getProperty("enronRoot");
			logger.debug("enronRoot:" + enronRoot);
			String descRoot = properties.getProperty("descRoot");
			logger.debug("descRoot:" + descRoot);
			inputDir = new File(enronRoot);

			taeDescriptor = new File(descRoot + File.separator
					+ "EmailAnnotator.xml");
			validArgs = taeDescriptor.exists() && !taeDescriptor.isDirectory()
					&& inputDir.isDirectory();
			logger.debug(" taeDescriptor.exists():" + taeDescriptor.exists()
					+ " !taeDescriptor.isDirectory()"
					+ !taeDescriptor.isDirectory() + " inputDir.isDirectory():"
					+ inputDir.isDirectory());

			// get Resource Specifier from XML file
			XMLInputSource in = new XMLInputSource(taeDescriptor);
			ResourceSpecifier specifier = UIMAFramework.getXMLParser()
					.parseResourceSpecifier(in);

			// create Analysis Engine
			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);
			// create a CAS
			CAS cas = ae.newCAS();

			TimeSeriesCollection tsc = new TimeSeriesCollection();
			String title = "";
			String xAxisLabel = "";
			String yAxisLabel = "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			boolean isHistogram = false;
			JFreeChart chart = null;
			if (graph.equals("timegraph1")) {
				tsc.addSeries(timegraphDaily);
				title = "Daily graph of historic email data";
				xAxisLabel = "Day";
				dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				isHistogram = true;
			} else if (graph.equals("timegraph2")) {
				tsc.addSeries(timegraphMonthly);
				title = "Monthly graph of historic email data";
				xAxisLabel = "Month";
				dateFormat = new SimpleDateFormat("MMM-yyyy");
				isHistogram = true;
			} else if (graph.equals("timegraph3")) {
				tsc.addSeries(timegraphYearly);
				title = "Yearly graph of historic email data";
				xAxisLabel = "Year";
				dateFormat = new SimpleDateFormat("yyyy");
				isHistogram = true;
			} else if (graph.equals("timegraph4")) {
				tsc.addSeries(timegraphDaily);
				title = "Daily graph of historic email data";
				xAxisLabel = "Day";
				dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				isHistogram = false;
			} else if (graph.equals("timegraph5")) {
				tsc.addSeries(timegraphMonthly);
				title = "Monthly graph of historic email data";
				xAxisLabel = "Month";
				dateFormat = new SimpleDateFormat("MMM-yyyy");
				isHistogram = false;
			} else if (graph.equals("timegraph6")) {
				tsc.addSeries(timegraphYearly);
				title = "Yearly graph of historic email data";
				xAxisLabel = "Year";
				dateFormat = new SimpleDateFormat("yyyy");
				isHistogram = false;
			} else if (graph.equals("timegraph7")) {
				tsc.addSeries(timegraphDailyTrend);
				title = "Daily graph of trend of emails";
				xAxisLabel = "Day";
				dateFormat = new SimpleDateFormat("dd");
				isHistogram = false;
			} else if (graph.equals("timegraph8")) {
				tsc.addSeries(timegraphHourly);
				title = "Hourly graph of trend of emails";
				xAxisLabel = "Hour";
				dateFormat = new SimpleDateFormat("hh");
				isHistogram = false;
			} else if (graph.equals("timegraph9")) {
				tsc.addSeries(timegraphEmotivenessDaily);
				title = "Average emotiveness of Enron Employees";
				xAxisLabel = "Day";
				dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				isHistogram = false;
			} else if (graph.equals("timegraph10")) {
				tsc.addSeries(timegraphEmotivenessWeekly);
				title = "Average emotiveness of Enron Employees";
				xAxisLabel = "Week";
				dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				isHistogram = false;
			}

			if (isHistogram) {
				chart = ChartFactory.createHistogram(title, xAxisLabel,
						yAxisLabel, tsc, PlotOrientation.VERTICAL, true, true,
						true);
			} else {
				chart = ChartFactory.createTimeSeriesChart(title, xAxisLabel,
						yAxisLabel, tsc, true, true, true);
			}

			final XYPlot plot = chart.getXYPlot();
			final XYItemRenderer renderer = plot.getRenderer();

			final StandardXYToolTipGenerator g = new StandardXYToolTipGenerator(
					StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
					dateFormat, new DecimalFormat("0"));

			renderer.setToolTipGenerator(g);
			// chart.getXYPlot().setDomainAxis(new DateAxis());
			plot.setDomainAxis(new DateAxis());

			try {
				String filepath = request.getRealPath("/graphs");
				String ext = "jpeg";
				graphName = "graph1"
						+ String.format("%s.%s",
								RandomStringUtils.randomAlphanumeric(8), ext);
				graphPath = filepath + File.separator + graphName;
				// String name="graph1.jpeg";
				logger.debug(graphPath);
				ChartUtilities.saveChartAsJPEG(new File(graphPath), chart,
						width, height);
				logger.debug("Chart generated.");
			} catch (Exception e) {
				logger.error("Problem occurred creating chart.", e);
			}

			ae.destroy();

		} catch (Exception e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
	}

	private static ArrayList<File> mFiles = new ArrayList<File>();

	private static void addFilesFromDir(File dir, int size) {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				if (mFiles.size() > size)
					return;
				else
					mFiles.add(files[i]);
			} else {
				addFilesFromDir(files[i], size);
			}
		}
	}

	private void processFile(File aFile, AnalysisEngine aAE, CAS aCAS)
			throws IOException, AnalysisEngineProcessException {
		logger.debug("Processing file " + aFile.getName());
		String document = FileUtils.file2String(aFile);
		document = document.trim();

		// put document text in CAS
		aCAS.setDocumentText(document);

		// process
		aAE.process(aCAS);

		logger.info("print annotations to System.out");

		processAnnotations(aCAS);

		// reset the CAS to prepare it for processing the next document
		aCAS.reset();
	}

	public void processAnnotations(CAS aCAS) {
		logger.debug("Inside printDateTimeAnnotations method");
		Type dateTimeAnnotation = aCAS.getTypeSystem().getType(
				"annotation.DateTimeAnnotation");
		FSIterator<AnnotationFS> iter = aCAS.getAnnotationIndex(
				dateTimeAnnotation).iterator();

		logger.info("Iterating CAS to look for Feature Structures");
		while (iter.isValid()) {
			FeatureStructure fs = iter.get();
			logger.info(" fs.getType().getName():" + fs.getType().getName());
			logger.info("fs.getType().getShortName():"
					+ fs.getType().getShortName());
			DateTimeAnnotation annotation = (DateTimeAnnotation) fs;
			logger.debug("Email received time:"
					+ annotation.getEmailReceivedDateTime());
			Calendar calendar = DateUtil.date_parse(annotation
					.getEmailReceivedDateTime());
			// calendar.get(Calendar.MONTH);
			// emailDatesList.add(calendar);
			RegularTimePeriod monthTimePeriod = new Month(calendar.getTime());
			RegularTimePeriod dayTimePeriod = new Day(calendar.getTime());
			RegularTimePeriod yearTimePeriod = new Year(calendar.getTime());
			RegularTimePeriod weekTimePeriod = new Week(calendar.getTime());
			RegularTimePeriod dayTimePeriodTrend = new Day(
					calendar.get(Calendar.DAY_OF_MONTH), 1, 2001);
			RegularTimePeriod hourTimePeriod = new Hour(
					calendar.get(Calendar.HOUR_OF_DAY), 1, 1, 2001);
			
			logger.debug("Month:" + monthTimePeriod + " Day:" + dayTimePeriod
					+ " Year:" + yearTimePeriod + " Hour:" + hourTimePeriod);

			TimeSeriesDataItem tdiYearly = timegraphYearly
					.getDataItem(yearTimePeriod);
			TimeSeriesDataItem tdiMonthly = timegraphMonthly
					.getDataItem(monthTimePeriod);
			TimeSeriesDataItem tdiDaily = timegraphDaily
					.getDataItem(dayTimePeriod);
			TimeSeriesDataItem tdiDailyTrend = timegraphDailyTrend
					.getDataItem(dayTimePeriodTrend);
			TimeSeriesDataItem tdiHourly = timegraphHourly
					.getDataItem(hourTimePeriod);
			TimeSeriesDataItem tdiDailyEmotiveness = timegraphEmotivenessDaily
					.getDataItem(dayTimePeriod);
			TimeSeriesDataItem tdiWeeklyEmotiveness = timegraphEmotivenessWeekly
					.getDataItem(weekTimePeriod);

			Number monthlyValue = 0, dailyValue = 0, yearlyValue = 0, dailyValueTrend = 0, hourlyValue = 0, weeklyValue = 0;
			double emotivenessValue = 0, temp = 0, emotiveValueWeekly = 0;

			if ((annotation.getNouns() + annotation.getVerbs()) != 0)
				emotivenessValue = ((double) annotation.getAdjectives() + annotation
						.getAdverbs())
						/ (annotation.getNouns() + annotation.getVerbs());

			emotiveValueWeekly = emotivenessValue;
			
			if (tdiYearly != null)
				yearlyValue = tdiYearly.getValue();
			else
				yearlyValue = 0;

			if (tdiMonthly != null)
				monthlyValue = tdiMonthly.getValue();
			else
				monthlyValue = 0;

			if (tdiDaily != null)
				dailyValue = tdiDaily.getValue();
			else
				dailyValue = 0;

			if (tdiDailyTrend != null)
				dailyValueTrend = tdiDailyTrend.getValue();
			else
				dailyValueTrend = 0;

			if (tdiHourly != null)
				hourlyValue = tdiHourly.getValue();
			else
				hourlyValue = 0;
			
			if (tdiWeeklyEmotiveness != null)
				weeklyValue = tdiWeeklyEmotiveness.getValue();
			else
				weeklyValue = 0;
			
			if (tdiWeeklyEmotiveness != null)
			weeklyValue = ((tdiWeeklyEmotiveness.getValue()
					.doubleValue() * weeklyValue.intValue()) + emotiveValueWeekly)
					/ (weeklyValue.intValue() + 1);
			
			
			if (tdiDailyEmotiveness != null)
				emotivenessValue = ((tdiDailyEmotiveness.getValue()
						.doubleValue() * dailyValue.intValue()) + emotivenessValue)
						/ (dailyValue.intValue() + 1);

			logger.debug("emotivenessValue:" + emotivenessValue);

			timegraphYearly.addOrUpdate(yearTimePeriod,
					yearlyValue.intValue() + 1);
			timegraphMonthly.addOrUpdate(monthTimePeriod,
					monthlyValue.intValue() + 1);
			timegraphDaily
					.addOrUpdate(dayTimePeriod, dailyValue.intValue() + 1);
			timegraphDailyTrend.addOrUpdate(dayTimePeriodTrend,
					dailyValueTrend.intValue() + 1);
			timegraphHourly.addOrUpdate(hourTimePeriod,
					hourlyValue.intValue() + 1);
			timegraphEmotivenessDaily.addOrUpdate(dayTimePeriod,
					emotivenessValue);
			timegraphEmotivenessWeekly.addOrUpdate(weekTimePeriod,
					weeklyValue);
			
			iter.moveToNext();
		}

		/*
		 * FSIndex<Annotation> index = aCAS.getAnnotationIndex(); for
		 * (Iterator<Annotation> it = index.iterator(); it.hasNext(); ) {
		 * Annotation annotation = it.next(); List<Feature> features = new
		 * ArrayList<Feature>(); if
		 * (annotation.getType().getName().contains("com.mycompany")) { features
		 * = annotation.getType().getFeatures(); } List<String> fasl = new
		 * ArrayList<String>(); for (Feature feature : features) { if
		 * (feature.getName().contains("com.mycompany")) { String name =
		 * feature.getShortName(); String value =
		 * annotation.getStringValue(feature); fasl.add(name + "=\"" + value +
		 * "\""); } }
		 */
	}

	public static POScount countPOS(String text) throws Exception {
		POScount posCount = new POScount();
		int count = 0;

		Span[] sentSpans = sentenceDetector.sentPosDetect(text);
		for (Span sentSpan : sentSpans) {
			String sentence = sentSpan.getCoveredText(text).toString();
			int start = sentSpan.getStart();
			Span[] tokSpans = tokenizer.tokenizePos(sentence);
			String[] tokens = new String[tokSpans.length];
			for (int i = 0; i < tokens.length; i++) {
				tokens[i] = tokSpans[i].getCoveredText(sentence).toString();
			}

			if (tokens != null) {
				String[] tags = posTagger.tag(tokens);

				for (int i = 0; i < tags.length; i++) {
					if (tags[i].trim().startsWith("JJ"))
						posCount.adjectives++;
					else if (tags[i].trim().startsWith("RB"))
						posCount.adverbs++;
					else if (tags[i].trim().startsWith("NN"))
						posCount.nouns++;
					else if (tags[i].trim().startsWith("VB"))
						posCount.verbs++;
					// System.out.println("tags" + tags[i] + "\t");
				}
			}
		}
		return posCount;
	}

	// public static void printDateTimeAnnotations(CAS aCAS, Type
	// dateTimeAnnotation, PrintStream out) {
	//
	// DateTimeAnnotation annotation = (DateTimeAnnotation) fs;
	// System.out.println("Email received time:" +
	// annotation.getEmailReceivedDateTime()); iter.moveToNext(); }
	//
	// HistogramDataset dataset = new HistogramDataset();
	// dataset.setType(HistogramType.FREQUENCY); // TimeSeriesCollection ts =
	// new TimeSeriesCollection(); // ts.addSeries("L&G European Index Trust")
	//
	//
	//
	//
	// String plotTitle = "Parts of speech in emails histogram"; String xaxis =
	// "Number of parts of speech"; String yaxis = "Number of emails";
	// PlotOrientation orientation = PlotOrientation.VERTICAL; boolean show =
	// true; boolean toolTips = true; boolean urls = true; JFreeChart chart =
	// ChartFactory.createHistogram(plotTitle, xaxis, yaxis, dataset,
	// orientation, show, toolTips, urls); int width = 1000; int height = 1000;
	//
	// try { String filepath = request.getRealPath("/graphs"); String ext =
	// "jpeg"; // File dir = new File("D:\\"); graphName = "graph1" +
	// String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
	// graphPath = filepath + File.separator + graphName; // String
	// name="graph1.jpeg"; System.out.println(graphPath);
	// ChartUtilities.saveChartAsPNG(new File(graphPath), chart, width, height);
	// System.out.println("Chart generated.");
	//
	//
	// }

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
