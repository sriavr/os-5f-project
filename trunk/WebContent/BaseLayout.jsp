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
<script src='js/jquery.zoom.js'></script>
<script src='js/jquery.dropkick-1.0.0.js'></script>
<link rel="stylesheet" href="js/dropkick.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Carter+One&v1'
	rel='stylesheet' type='text/css'>
<style type="text/css">
.btn-generate {
	width: 250px;
}

.zoom {
	display: inline-block;
	position: relative;
}

/* magnifying glass icon */
.zoom:after {
	content: '';
	display: block;
	width: 33px;
	height: 33px;
	position: absolute;
	top: 0;
	right: 0;
	background: url(js/icon.png);
}

.zoom img {
	display: block;
}

.zoom img::selection {
	background-color: transparent;
}

img:hover {
	cursor: url(js/grab.cur), default;
}

img:active {
	cursor: url(js/grabbed.cur), default;
}

.dk_theme_black {
	background: #aebcbf;
	background: -moz-linear-gradient(top, #aebcbf 0%, #6e7774 50%, #0a0e0a 51%, #0a0809
		100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #aebcbf),
		color-stop(50%, #6e7774), color-stop(51%, #0a0e0a),
		color-stop(100%, #0a0809) );
	background: -webkit-linear-gradient(top, #aebcbf 0%, #6e7774 50%, #0a0e0a 51%,
		#0a0809 100%);
	background: -o-linear-gradient(top, #aebcbf 0%, #6e7774 50%, #0a0e0a 51%, #0a0809
		100%);
	background: -ms-linear-gradient(top, #aebcbf 0%, #6e7774 50%, #0a0e0a 51%, #0a0809
		100%);
	background: linear-gradient(top, #aebcbf 0%, #6e7774 50%, #0a0e0a 51%, #0a0809 100%);
}

.dk_theme_black .dk_toggle,.dk_theme_black.dk_open .dk_toggle {
	background-color: transparent;
	color: #fff;
	text-shadow: none;
}

.dk_theme_black .dk_options a {
	background-color: #333;
	color: #fff;
	text-shadow: none;
}

.dk_theme_black .dk_options a:hover,.dk_theme_black .dk_option_current a
	{
	background-color: #E15A01;
	color: #fff;
	text-shadow: #604A42 0 1px 0;
}
</style>
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