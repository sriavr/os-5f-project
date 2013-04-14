package annotator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.POScount;
import opennlp.tools.postag.POSContextGenerator;

import org.apache.log4j.Logger;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import action.Graph1Action;
import annotation.DateTimeAnnotation;
import annotation.POSAnnotation;

import com.mycompany.tgni.analysis.uima.annotators.keyword.KeywordAnnotation;

import type.*;
import util.DateUtil;

public class EmailAnnotator extends JCasAnnotator_ImplBase {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	public void process(JCas aJCas) {
		// get document text from JCas
		String docText = aJCas.getDocumentText();

		int pos = 0;

		// THIS IS EXAMPLE CODE FROM
		// https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=9&cad=rja&ved=0CHQQFjAI&url=http://www.fing.edu.uy/~gmonce/ws-uima-a4.pdf&ei=Qi5nUamwHsWPrgfnnIGABA&usg=AFQjCNFA3BHzvLy3eeSIqQl56-wgJgsyog&sig2=TThKEgc4QcoUpb8rzv4a8Q&bvm=bv.45107431,d.bmk

		DateUtil dateUtil = new DateUtil();
		Pattern datePattern = DateUtil.getDateTimePattern();

		Matcher matcher = datePattern.matcher(docText);
		if (matcher.find(pos)) {
			DateTimeAnnotation annotation = new DateTimeAnnotation(aJCas);
			// annotation.setEmailSentDateTime(v)
			annotation.setBegin(matcher.start());
			annotation.setEnd(matcher.end());
			// System.out.println("PRINTING STUFF::" + matcher.group() +
			// "\n\n\n");
			annotation.setEmailReceivedDateTime(matcher.group());
			try {
			logger.info("Running countPOS method");
			/*POScount p =  Graph1Action.countPOS(docText);
			annotation.setNouns(p.nouns);
			annotation.setAdjectives(p.adjectives);
			annotation.setAdverbs(p.adverbs);
			annotation.setVerbs(p.verbs);
			logger.info("adjectives:"+ p.adjectives + " adverbs:"+ p.adverbs + " nouns:"+ p.nouns + " verbs:"+ p.verbs);*/
			
			annotation.addToIndexes();
			pos = matcher.end();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//			logger.info("Running countPOS method");
//			POScount p =  Graph1Action.countPOS(docText);
//			POSAnnotation posAnnotation = new POSAnnotation(aJCas);
//			posAnnotation.setNouns(p.nouns);
//			posAnnotation.setAdjectives(p.adjectives);
//			posAnnotation.setAdverbs(p.adverbs);
//			posAnnotation.setVerbs(p.verbs);
//			logger.info("adjectives:"+ p.adjectives + " adverbs:"+ p.adverbs + " nouns:"+ p.nouns + " verbs:"+ p.verbs);
//			posAnnotation.addToIndexes();
		
	}
}