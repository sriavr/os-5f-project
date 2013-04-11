<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row"></div>
<div class="row">
	<s:form method="get">
		<div class="columns large-4">
			<div class="row">
				<h4>Select folders</h4>
				<input type="checkbox" checked="checked" name="folder" value="inbox" />
				Inbox<br /> <input type="checkbox" name="folder" value="sentItems" />
				Sent Items<br /> <input type="checkbox" name="folder"
					value="delItems" /> Deleted Items <br /> <input type="checkbox"
					name="folder" value="allItems" /> All Documents<br />
			</div>
			<br>
			<div class="row">
				<h4>Select graph</h4>
				<select name="graph" tabindex="1" class="pretty dk">
					<option value="xychart">Scatter Plot - Email count per employee</option>
					<option value="piechart">Pie Chart - Email distribution in folders</option>
				</select>
			</div>
			<br>
			<div class="row">
				<h4>Select sample</h4>
				<input type="radio" checked="checked" name="sampleSize" value="5" /> Run on a sample of size 5
				<br>
				<input type="radio" name="sampleSize" value="20" /> Run on a sample of size 20
				<br>
				<input type="radio" name="sampleSize" value="all" /> Run on entire dataset
			</div>

			<div class="row">
				<input class="medium button btn-generate" type="submit"
					value="Generate Graph" />
			</div>
		</div>
		<div class="columns large-8">
			<s:if test="%{graphName != null}">
				<img src="graphs/<s:property value="graphName"/>" />
			</s:if>
		</div>
	</s:form>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				//alert('working');
				$('img').wrap('<span style="display:inline-block"></span>')
						.css('display', 'block').parent().zoom();

				$('.default').dropkick();
			});

	
</script>