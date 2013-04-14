package app;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.XMLInputSource;

import annotation.DateTimeAnnotation;

import util.PrintAnnotations;

/**
 * An example application that reads documents from files, sends them though an
 * Analysis Engine, and prints all discovered annotations to System.out.
 * <p>
 * The application takes two arguments:
 * <ol type="1">
 * <li>The path to an XML descriptor for the Analysis Engine to be executed</li>
 * <li>An input directory containing files to be processed</li>
 * </ol>
 */
public class MainApp1 {
	/**
	 * Main program.
	 * 
	 * @param args
	 *            Command-line arguments - see class description
	 */
	private static ArrayList<File> mFiles = new ArrayList<File>();

	private static void addFilesFromDir(File dir) {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				mFiles.add(files[i]);
			} else {
				addFilesFromDir(files[i]);
			}
		}
	}

	public static void main(String[] args) {
		try {
			File taeDescriptor = null;
			File inputDir = null;

			// Read and validate command line arguments
			boolean validArgs = false;
			if (args.length != 2) {
				Properties properties = new Properties();
				try {
					properties.load(Thread.currentThread()
							.getContextClassLoader()
							.getResourceAsStream("myapp.properties"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String modelDir = properties.getProperty("modelDir");
				System.out.println("modelDir:" + modelDir);
				String enronRoot = properties.getProperty("enronRoot");
				System.out.println("enronRoot:" + enronRoot);
				String descRoot = properties.getProperty("descRoot");
				System.out.println("descRoot:" + descRoot);
				inputDir = new File(enronRoot);

				taeDescriptor = new File(descRoot + File.separator
						+ "EmailAnnotator.xml");
				validArgs = taeDescriptor.exists()
						&& !taeDescriptor.isDirectory()
						&& inputDir.isDirectory();
				System.out.println(" taeDescriptor.exists():"
						+ taeDescriptor.exists()
						+ " !taeDescriptor.isDirectory()"
						+ !taeDescriptor.isDirectory()
						+ " inputDir.isDirectory():" + inputDir.isDirectory());
			}
			if (!validArgs) {
				printUsageMessage();
			} else {
				// get Resource Specifier from XML file
				XMLInputSource in = new XMLInputSource(taeDescriptor);
				ResourceSpecifier specifier = UIMAFramework.getXMLParser()
						.parseResourceSpecifier(in);

				// for debugging, output the Resource Specifier
				// System.out.println(specifier);

				// create Analysis Engine
				AnalysisEngine ae = UIMAFramework
						.produceAnalysisEngine(specifier);
				// create a CAS
				CAS cas = ae.newCAS();

				// get all files in the input directory
				// File[] files = inputDir.listFiles();
				addFilesFromDir(inputDir);
				if (mFiles == null || mFiles.size() == 0) {
					System.out.println("No files to process");
				} else {
					// process documents
					for (int i = 0; i < mFiles.size(); i++) {
						if (!mFiles.get(i).isDirectory()) {
							processFile(mFiles.get(i), ae, cas);
						}
					}
				}
				ae.destroy();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints usage message.
	 */
	private static void printUsageMessage() {
		System.err
				.println("Usage: java org.apache.uima.example.ExampleApplication "
						+ "<Analysis Engine descriptor or PEAR file name> <input dir>");
	}

	/**
	 * Processes a single XML file and prints annotations to System.out
	 * 
	 * @param aFile
	 *            file to process
	 * @param aAE
	 *            Analysis Engine that will process the file
	 * @param aCAS
	 *            CAS that will be used to hold analysis results
	 */
	private static void processFile(File aFile, AnalysisEngine aAE, CAS aCAS)
			throws IOException, AnalysisEngineProcessException {
		// System.out.println("Processing file " + aFile.getName());

		String document = FileUtils.file2String(aFile);
		document = document.trim();

		// put document text in CAS
		aCAS.setDocumentText(document);

		// process
		aAE.process(aCAS);

		// print annotations to System.out
		Type dateTimeAnnotation = aCAS.getTypeSystem().getType(
				"annotation.DateTimeAnnotation");
		printDateTimeAnnotations(aCAS, dateTimeAnnotation, System.out);

		// reset the CAS to prepare it for processing the next document
		aCAS.reset();
	}

	public static void printDateTimeAnnotations(CAS aCAS,
			Type dateTimeAnnotation, PrintStream out) {
		FSIterator iter = aCAS.getAnnotationIndex(dateTimeAnnotation)
				.iterator();

		// iterate
		while (iter.isValid()) {
			FeatureStructure fs = iter.get();
			DateTimeAnnotation annotation = (DateTimeAnnotation) fs;
			System.out.println("Email received time:"
					+ annotation.getEmailReceivedDateTime());
			iter.moveToNext();
		}
	}

}
