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
	max-width: 100%;
}

#button {
	text-align: center;
}
</style>
</head>
<body>

	<div id="main">
		<div id="frm">

			<h3 id="date" style="margin: 30px 0px; color: red;"> </h3>
			<p style="text-align:left;"> 가장 많이 나온곳 : ${cityInfo[1].cityName}</p>

			<table class=table style="text-align: center;">
				<thead class=thead-dark>
					<tr>
						<th>도시 명</th>
						<th>합계</th>
						<th>국내 발생</th>
						<th>해외유입</th>
						<th>격리중</th>
						<th>격리해제</th>
						<th>총 확진자</th>
						<th>완치율</th>
				</thead>
				<tbody>
					<c:forEach items="${cityInfo}" var="city">
						<tr>
							<td>${city.cityName}</td>
							<td style="font-weight: bold;">${city.todayTotal}</td>
							<td>${city.domestic}</td>
							<td>${city.foreign}</td>
							<td>${city.confirmedPatient}</td>
							<td>${city.recoveredPatient}</td>
							<td>${city.totalPatient}</td>
							<td>${city.recoveredRate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="<c:url value="/" />" class="btn btn-secondary button"> 돌아가기 </a>
			<a class="btn btn-secondary" onclick="downloadExcel();"> 엑셀에 저장 </a>
			
			<form action="downloadExcel" method="post" name="f1">
			</form>
		</div>
	</div>

	<script>
		let today = new Date();
		let nowDate = today.toLocaleDateString();

		document.getElementById('date').innerHTML = nowDate+" 코로나 상황!!!";

		function downloadExcel(){

			var f = document.f1;
			f.submit();
		}
	</script>
</body>
</html>
