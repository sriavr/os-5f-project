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
		String temp = "";
		BufferedReader br = new BufferedReader(new StringReader(docText));
		try {

			while ((temp = br.readLine()) != null) {
				if (temp.contains("Date:")) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String str;
		// str = "Date: Wed, 6 Feb 2002 13:10:43 -0800 (PST)";
		Calendar cal = null;
		cal = DateUtil.date_parse(temp);

//		System.out.println("temp: " + temp);
//		System.out.println("cal: " + cal);
		TimeDetectionAnnotation annotation = new TimeDetectionAnnotation(aJCas);
		annotation.setBegin(1);
		annotation.setEnd(1);
		/*** HARDCODING ***/
		annotation.setTimeSlot(cal.get(Calendar.HOUR));
		annotation.setSelected(true);
		annotation.addToIndexes();
	
	}
}