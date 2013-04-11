package action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import model.EmployeeModel;

import com.opensymphony.xwork2.ActionSupport;

public class ViewEmployeeAction extends ActionSupport {
	private ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();
	public static String path;

	public ArrayList<EmployeeModel> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<EmployeeModel> employees) {
		this.employees = employees;
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
		path = enronRoot;
		File folder = new File(path);
		File[] listOfFiles1 = folder.listFiles();
		employees = new ArrayList<EmployeeModel>();

		for (int i = 0; i < listOfFiles1.length; i++) {

			if (listOfFiles1[i].isDirectory()) {

				EmployeeModel employee = new EmployeeModel();
				// System.out.println("Name of employee:/t " +
				// listOfFiles1[i].getName());

				employee.setEmpId(i);

				employee = getStats(employee, listOfFiles1[i]);

				String email_id = email_parse(listOfFiles1[i].getName());
				System.out.println(email_id + "\n");
				employee.setEmailId(email_id);

				String FirstName = getFirstName(listOfFiles1[i].getName());
				String LastName = getLastName(listOfFiles1[i].getName());
				employee.setFolderName(listOfFiles1[i].getName());
				employee.setFirstName(FirstName);
				employee.setLastName(LastName);
				System.out.println("add  employee");
				employees.add(employee);
				System.out.println("added one employee");
			}
		}

		return SUCCESS;
	}

	private String getLastName(String name) {

		Scanner in;

		int i = 1;
		String from = null;
		String str1, str2 = null, str3 = null, str4 = null;

		try {
			in = new Scanner(new File(path + File.separator + name
					+ File.separator + "sent_items" + File.separator + "2."));
			while (in.hasNextLine()) {
				String filesURL = in.nextLine();

				if (i++ == 9) {
					// System.out.println(filesURL);
					from = filesURL;
					// System.out.println(from);
					from = from + " ";
					str1 = str_piece(from, ':', 1);
					str2 = str_piece(from, ' ', 2);
					str3 = str_piece(from, ' ', 3);
					str4 = str_piece(from, ' ', 4);
					str3.trim();
					if (str2.charAt(str2.length() - 1) == ',') {
						str2 = str2.replace(str2.substring(str2.length() - 1),
								"");

					}
					str2.trim();
					// System.out.println("1:\n"+str1);
					System.out.println("2:\n" + str2);
					// System.out.println("3:\n"+str3);
					// System.out.println("4:\n"+str4);

				}
			}

		} catch (FileNotFoundException e) {
			str2 = "<last name not found>";
			e.printStackTrace();
		}

		return str2;

	}

	private String getFirstName(String name) {

		Scanner in;

		int i = 1;
		String from = null;
		String str1, str2 = null, str3 = null, str4 = null;

		try {
			in = new Scanner(new File(path + File.separator + name
					+ File.separator + "sent_items" + File.separator + "2."));
			while (in.hasNextLine()) {
				String filesURL = in.nextLine();

				if (i++ == 9) {

					// System.out.println(filesURL);
					from = filesURL;
					// System.out.println(from);
					from = from + " ";
					str1 = str_piece(from, ':', 1);
					str2 = str_piece(from, ' ', 2);
					str3 = str_piece(from, ' ', 3);
					str4 = str_piece(from, ' ', 4);
					str3.trim();
					if (str2.charAt(str2.length() - 1) == ',') {
						str2 = str2.replace(str2.substring(str2.length() - 1),
								"");

					}
					str2.trim();
					// System.out.println("1:\n"+str1);
					// System.out.println("2:\n"+str2);
					System.out.println("3:\n" + str3);
					// System.out.println("4:\n"+str4);

				}
			}

		} catch (FileNotFoundException e) {
			str3 = "<first name not found>";
			e.printStackTrace();
		}

		return str3;

	}

	private EmployeeModel getStats(EmployeeModel employees2, File dir) {

		File folder = new File(path + File.separator + dir.getName()
				+ File.separator + "sent_items");
		File folder1 = new File(path + File.separator + dir.getName()
				+ File.separator + "inbox");
		System.out.println("folder:" + folder + " folder1:" + folder1);
		File[] sentlist = folder.listFiles();
		File[] reclist = folder1.listFiles();
		System.out.println("sentNo:" + sentlist.length);
		System.out.println("recNo:" + reclist.length);

		employees2.setNumRecEmails(sentlist.length);
		employees2.setNumSentEmails(reclist.length);

		return employees2;
	}

	public static String email_parse(String name) {

		Scanner in;

		int i = 1;
		String from = null;
		String str1, str2 = null;

		try {
			in = new Scanner(new File(path + File.separator + name
					+ File.separator + "sent_items" + File.separator + "2."));
			while (in.hasNextLine()) {
				String filesURL = in.nextLine();

				if (i++ == 3) {

					// System.out.println(filesURL);
					from = filesURL;
					// System.out.println(from);
					from = from + " ";
					str1 = str_piece(from, ':', 1);
					str2 = str_piece(from, ' ', 2);
					str2.trim();
					System.out.println("email id is:\n" + str2);

				}
			}

		} catch (FileNotFoundException e) {
			str2 ="<unable to determine emailid>";
			e.printStackTrace();
		}

		return str2;

	}

	public static String str_piece(String str, char separator, int index) {
		String str_result = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == separator) {
				count++;
				if (count == index) {
					break;
				}
			} else {
				if (count == index - 1) {
					str_result += str.charAt(i);
				}
			}
		}
		return str_result;

	}

}
