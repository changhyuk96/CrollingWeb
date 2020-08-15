<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
<head>
<title>Home</title>

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<style>
html, body {
	height: 100%;
	width: 100%;
	margin: 0;
}

#main {
	height: 100%;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
}

#frm {
	margin: auto;
	max-width: 50%;
}

#button {
	text-align: center;
}
</style>
</head>

<body>

	<!-- 			
	 -->

	<div id="main">
		<div id="frm">
			<h4>${info.nowTemperature} </h4>
			<h4>${info.nowWeather} </h4><br/>
			<a href="<c:url value="/" />" class="btn btn-secondary button">
				돌아가기 </a>
		</div>
	</div>

</body>
</html>
