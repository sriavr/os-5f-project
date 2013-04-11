<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<hr />
<div class="row">
	<div class="columns large-4">
		<h3>Full Name</h3>
	</div>

	<div class="columns large-6">
		<h3>Details</h3>
	</div>
</div>
<hr />
<s:iterator value="employees">
	<div class="row">
		<div class="columns large-4">
			<h4>
				<s:property value="firstName" />
				<s:property value="lastName" />
			</h4>
		</div>

		<div class="columns large-6">
			<div class="row">
				<s:property value="emailId" />
			</div>
			<div class="row">
				<div class="columns large-6">
					Sent Mails(
					<s:property value="numSentEmails" />
					)
				</div>
				<div class="columns large-6">
					Received Mails(
					<s:property value="numRecEmails" />
					)
				</div>
			</div>
			<div class="row">
				<s:url action="getEmpStats" var="url1">
					<s:param name="folderName" value="folderName" />
				</s:url>
				<s:url action="graph2" var="url2">
					<s:param name="folderName" value="folderName" />
				</s:url>				
				<a href="<s:property value="#url1"/>">Email Stats</a> | 
				<a href="<s:property value="#url2"/>">Parts of Speech Analysis</a>
			</div>
		</div>
		<hr />
	</div>

</s:iterator>




