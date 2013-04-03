<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Intelligence and Analytics</title>
<link rel="stylesheet" href="styles/reset.css" />
<link rel="stylesheet" href="styles/foundation/normalize.css" />
<link rel="stylesheet" href="styles/foundation/foundation.css" />
<link rel="stylesheet" href="styles/style.css" />
<link rel="stylesheet" href="styles/avgrund.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>

<body>
	<div>
		<div class="row header-box">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="row body-box">
			<tiles:insertAttribute name="body" />
		</div>

		<div class="row footer-box">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>