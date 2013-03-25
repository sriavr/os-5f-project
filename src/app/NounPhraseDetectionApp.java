package app;

import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.analysis_engine.AnalysisEngine;

import org.apache.uima.UIMAFramework;
import com.mycompany.tgni.uima.annotators.nlp.*;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

import com.mycompany.tgni.utils.UimaUtils;

import type.TimeDetectionAnnotation;

public class NounPhraseDetectionApp {
	private static final String[] INPUTS = new String[] {
			"Be that as it may, the show must go on",
			"As I was telling you, he will not attend the meeting.",
			"Lead is the lead cause of lead poisoning.",
			"What I am trying to say is that Jadeja is a joke"

	};

	public static void main(String[] args) {

		AnalysisEngine ae = null;
		try {
			ae = com.mycompany.tgni.utils.UimaUtils.getAE(
					"desc/NounPhraseAnnotator.xml", null);
		} catch (InvalidXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String input : INPUTS) {
			System.out.println("text: " + input);
			JCas jcas = null;
			try {
				jcas = UimaUtils
						.runAE(ae, input, UimaUtils.MIMETYPE_TEXT, jcas);
			} catch (AnalysisEngineProcessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ResourceInitializationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FSIndex<Annotation> index = jcas
					.getAnnotationIndex(NounPhraseAnnotation.type);
			for (Iterator<Annotation> it = index.iterator(); it.hasNext();) {
				NounPhraseAnnotation annotation = (NounPhraseAnnotation) it
						.next();
				System.out.println("...(" + annotation.getBegin() + ","
						+ annotation.getEnd() + "): "
						+ annotation.getCoveredText());
			}
		}
	}
}
