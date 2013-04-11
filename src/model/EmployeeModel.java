package model;

public class EmployeeModel {
	private int empId;
	private String firstName;
	private String lastName;
	private int numSentEmails;
	private int numRecEmails;
	private String emailId;
	private String folderName;
	
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumSentEmails() {
		return numSentEmails;
	}

	public void setNumSentEmails(int numSentEmails) {
		this.numSentEmails = numSentEmails;
	}

	public int getNumRecEmails() {
		return numRecEmails;
	}

	public void setNumRecEmails(int numRecEmails) {
		this.numRecEmails = numRecEmails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
