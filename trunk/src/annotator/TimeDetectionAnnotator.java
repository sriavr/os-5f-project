package annotator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import type.*;
import util.DateUtil;

public class TimeDetectionAnnotator extends JCasAnnotator_ImplBase {
	// create regular expression pattern for Yorktown room number
	private Pattern emailPattern = Pattern
			.compile("[a-zA-Z]*[0-9]*@[a-zA-Z]*\\.[a-zA-Z]*");

	public void process(JCas aJCas) {
		
		// The JCas object is the data object inside UIMA where all the
		// information is stored. It contains all annotations created by
		// previous annotators, and the document text to be analyzed.

		// get document text from JCas
		String docText = aJCas.getDocumentText();

		int pos = 0;

		// match found - create the match as annotation in
		// the JCas with some additional meta information
		
		
		//THIS IS EXAMPLE CODE FROM https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=9&cad=rja&ved=0CHQQFjAI&url=http://www.fing.edu.uy/~gmonce/ws-uima-a4.pdf&ei=Qi5nUamwHsWPrgfnnIGABA&usg=AFQjCNFA3BHzvLy3eeSIqQl56-wgJgsyog&sig2=TThKEgc4QcoUpb8rzv4a8Q&bvm=bv.45107431,d.bmk
		Pattern UniverseProductNumbers = Pattern
				.compile("\\b[U][A-Z][A-Z]-\\d\\d\\d\\d\\d\\b");
		Matcher matcher = UniverseProductNumbers.matcher(docText);
		while (matcher.find(pos)) {
			pos = matcher.end();
		}
		
		
		String temp = "";
		BufferedReader br = new BufferedReader(new StringReader(docText));
		try {
			while ((temp = br.readLine()) != null) {
				if (temp.contains("Date:")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		Calendar cal = null;
		cal = DateUtil.date_parse(temp);

		TimeDetectionAnnotation annotation = new TimeDetectionAnnotation(aJCas);
		annotation.setBegin(1);
		annotation.setEnd(1);
		/*** HARDCODING ***/
		annotation.setTimeSlot(cal.get(Calendar.HOUR));
		annotation.setSelected(true);
		annotation.addToIndexes();

	}
}