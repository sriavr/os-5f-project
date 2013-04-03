package util;

import java.io.File;
import java.util.ArrayList;

public class EmailUtil {
	static ArrayList<File> inbox = new ArrayList<File>();
	static ArrayList<File> sent_items = new ArrayList<File>();
	static ArrayList<File> deleted_items = new ArrayList<File>();
	static ArrayList<File> all_documents = new ArrayList<File>();

	public static void main(String args[]) {
		File folder = new File("/media/F038C72B38C6EFA0/IIITB/Semester 2/Operating Systems");
		readFilename(folder);
	}

	private static int readFilename(File Dir1) { // function to get the name of
													// employee
		File[] listOfFiles1 = Dir1.listFiles();
		for (int i = 0; i < listOfFiles1.length; i++) {
			if (listOfFiles1[i].isDirectory()) {
				System.out.println("\nDirectory: " + listOfFiles1[i].getName());
				String s = listOfFiles1[i].getName();
				addFilesFromDir(listOfFiles1[i], s);
			}
		}
		return 1;
	}

	/*
	 * function that would read all folders inside a particular employee we
	 * received from string s
	 */
	private static int addFilesFromDir(File Dir, String s) {

		File[] listOfFiles = Dir.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
				String s1 = listOfFiles[i].getName();
				if (s1.equalsIgnoreCase("sent_items")) {
					System.out.println("Files in Sent Items folder of \t " + s);
					readFiles(listOfFiles[i], s1);

				}
				if (s1.equalsIgnoreCase("inbox")) {
					System.out.println("Files in Inbox folder of \t " + s);
					readFiles(listOfFiles[i], s1);
				}

				if (s1.equalsIgnoreCase("all_documents")) {
					System.out.println("Files in all_documents folder of \t "
							+ s);
					readFiles(listOfFiles[i], s1);

				}

				if (s1.equalsIgnoreCase("deleted_items")) {
					System.out.println("Files in deleted_items folder of \t "
							+ s);
					readFiles(listOfFiles[i], s1);

				}
			} else

				addFilesFromDir(listOfFiles[i], s);

		}

		return 0;
	}

	private static void readFiles(File Dir, String s1) {// function to read the
														// files of the
														// particular folder of
														// an employee.
		File[] list = Dir.listFiles();
		for (int i = 0; i < list.length; i++) {

			if (list[i].isFile()) {

				if (s1.equalsIgnoreCase("inbox")) {
					inbox.add(list[i]);
				}

				if (s1.equalsIgnoreCase("sent_items")) {
					sent_items.add(list[i]);
				}

				if (s1.equalsIgnoreCase("deleted_items")) {
					deleted_items.add(list[i]);
				}

				if (s1.equalsIgnoreCase("all_documents")) {
					all_documents.add(list[i]);
				}

			}

		}
	}
}