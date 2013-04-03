package action;

import java.io.File;

import model.POScount;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.tokenize.TokenizerME;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import org.apache.commons.io.IOUtils;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import com.mycompany.tgni.utils.UimaUtils;

import org.jfree.chart.JFreeChart;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
//import java.util.Random;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public class Graph2Action extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private String sentItemsPath;
	private String folderName = "ybarbo-p";
	private String graphName;
	private String graphPath;
	private int numEmails;
	private static String modelPath = "";
	private String enronRoot = "";

	public String getGraphPath() {
		return graphPath;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public int getNumEmails() {
		return numEmails;
	}

	public void setNumEmails(int numEmails) {
		this.numEmails = numEmails;
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
		modelPath = properties.getProperty("modelDir");
		System.out.println("modelDir:" + modelPath);
		enronRoot = properties.getProperty("enronRoot");
		System.out.println("enronRoot:" + enronRoot);
		int value = 15, min = 1, max = 50;
		ArrayList<POScount> list = new ArrayList<POScount>();
		sentItemsPath = enronRoot + File.separator + folderName
				+ File.separator + "sent_items";
		System.out.println("sentItemsPath: " + sentItemsPath);
		list = getPOSList(new File(sentItemsPath));
		double[] adjArr = new double[list.size()];
		double[] advArr = new double[list.size()];
		double[] verArr = new double[list.size()];
		double[] nounArr = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			adjArr[i] = list.get(i).adjectives;
			advArr[i] = list.get(i).adverbs;
			verArr[i] = list.get(i).verbs;
			nounArr[i] = list.get(i).nouns;
		}

		HistogramDataset dataset = new HistogramDataset();
		dataset.setType(HistogramType.FREQUENCY);
		dataset.addSeries("Adjectives", adjArr, value, min, max);
		dataset.addSeries("Adverbs", advArr, 10, min, 20);
		dataset.addSeries("Verbs", verArr, value, min, max);
		// dataset.addSeries("Nouns", verArr, 80, min, 300);
		String plotTitle = "Parts of speech in emails histogram";
		String xaxis = "Number of parts of speech";
		String yaxis = "Number of emails";
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean show = true;
		boolean toolTips = true;
		boolean urls = true;
		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, dataset, orientation, show, toolTips, urls);
		int width = 1000;
		int height = 1000;

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
			ChartUtilities.saveChartAsPNG(new File(graphPath), chart, width,
					height);
			System.out.println("Chart generated.");
		} catch (Exception e) {
			System.out.println("Problem occurred creating chart.");
		}

		return SUCCESS;
	}

	private ArrayList<POScount> getPOSList(File Dir) {
		ArrayList<POScount> posList = new ArrayList<POScount>();
		POScount posCount = new POScount();
		System.out.println(Dir.getName());
		if (Dir.getName().equalsIgnoreCase("sent_items")) {

			File[] list = Dir.listFiles();
			try {
				System.out.println("numEmails:" + numEmails);
				if (numEmails == 0)
					numEmails = list.length;
				for (int k = 0; k < list.length && k < numEmails; k++) {
					if (list[k].isDirectory())
						continue;
					String temp = readFile(list[k]);
					// System.out.println(temp + "\n\n\n");
					posCount = countPOS(temp);
					if (posCount != null) {
						posList.add(posCount);
						System.out
								.println("Adjectives:" + posCount.adjectives
										+ " Verbs:" + posCount.verbs
										+ " Adverbs:" + posCount.adverbs
										+ " Nouns:" + posCount.nouns);
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return posList;
	}

	private String readFile(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

	public POScount countPOS(String text) throws Exception {
		POScount posCount = new POScount();
		SentenceDetectorME sentenceDetector;
		TokenizerME tokenizer;
		POSTaggerME posTagger;
		ChunkerME chunker;
		int count = 0;
		InputStream smis = null;
		InputStream tmis = null;
		InputStream pmis = null;
		InputStream cmis = null;
		try {
			smis = new FileInputStream(new File(modelPath + File.separator
					+ "en-sent.bin"));
			tmis = new FileInputStream(new File(modelPath + File.separator
					+ "en-token.bin"));
			pmis = new FileInputStream(new File(modelPath + File.separator
					+ "en-pos-maxent.bin"));
			// cmis = new FileInputStream(new File(modelPath + File.separator
			// + "en-chunker.bin"));
			SentenceModel smodel = new SentenceModel(smis);
			sentenceDetector = new SentenceDetectorME(smodel);
			TokenizerModel tmodel = new TokenizerModel(tmis);
			tokenizer = new TokenizerME(tmodel);
			POSModel pmodel = new POSModel(pmis);
			posTagger = new POSTaggerME(pmodel);
			// ChunkerModel cmodel = new ChunkerModel(cmis);
			// chunker = new ChunkerME(cmodel);
		} finally {
			IOUtils.closeQuietly(cmis);
			IOUtils.closeQuietly(pmis);
			IOUtils.closeQuietly(tmis);
			IOUtils.closeQuietly(smis);
		}

		Span[] sentSpans = sentenceDetector.sentPosDetect(text);
		for (Span sentSpan : sentSpans) {
			String sentence = sentSpan.getCoveredText(text).toString();
			int start = sentSpan.getStart();
			Span[] tokSpans = tokenizer.tokenizePos(sentence);
			String[] tokens = new String[tokSpans.length];
			for (int i = 0; i < tokens.length; i++) {
				tokens[i] = tokSpans[i].getCoveredText(sentence).toString();
			}
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
		return posCount;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
