<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>notice list read</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="preconnect1" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../resources/static/assets/css/yy.css" />


</head>	
<body class="is-preload">
<div class="header1"  style="box-sizing: border-box;" >
<div align="center">
<span>
<img src="../resources/static/images/logo.png" style="width:130px; height:130px;" align="center">
</span>
<div align="right">
  <a href="${pageContext.request.contextPath}/company/logout">Logout</a>
</div>
</div>

 </div>>
	<!-- Header -->
	<div id="header2">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class="image avatar48"><img src="../resources/static/images/avatar.jpg"
					alt="" /></span>
				<h1 id="title">${sessionScope.emp.empNo}｜${sessionScope.emp.name}</h1>
				<p>${sessionScope.emp.email}</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="../Board/boardallview"><span class="icon solid fa-home">자유 게시판</span></a></li>
					<li><a href="../search/SearchServlet/allView" id="portfolio-link"><span class="icon solid fa-th">사원조회</span></a></li>
					<li><a href="../message/list" id="portfolio-link"><span class="icon solid fa-envelope">메시지</span></a></li>
					<li><a href="../todolist/allview" id="portfolio-link"><span class="icon solid fa-envelope">Todolist</span></a></li>
				</ul>
			</nav>

		</div>

		<div class="bottom">

			<!-- Social Icons -->
			<ul class="icons">
				<li><a href="#" class="icon brands fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon brands fa-facebook-f"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon brands fa-github"><span
						class="label">Github</span></a></li>
				<li><a href="#" class="icon brands fa-dribbble"><span
						class="label">Dribbble</span></a></li>
				<li><a href="#" class="icon solid fa-envelope"><span
						class="label">Email</span></a></li>
			</ul>

		</div>

	</div>
	<!-- Main -->
	<br>
	<br>
	<div id="main" align="center">
		<table align="center" cellpadding="5" cellspacing="2" width="60%"
			border='1'>
			<tr>
				<td width="1220" height="20" colspan="4" bgcolor="black">
					<p align="center">
						<font color="white" size="3"> <b>${data.no}번 게시물 자세히보기</b>
						</font>
					</p>
				</td>
			</tr>

			<tr>
				<td width="100" height="20">
					<p align="right">
						<b><span style="font-size: 12pt;">작성자</span></b>
					</p>
				</td>
				<td width="450" height="20" colspan="3"><span
					style="font-size: 12pt;"><b>${data.empNo.name}</b></span>
				</td>
			</tr>


			<tr>
				<td width="100" height="20">
					<p align="right">
						<b><span style="font-size: 12pt;">작성일</span></b>
					</p>
				</td>
				<td width="450" height="20" colspan="3"><span
					style="font-size: 12pt;"><b>${data.writedate}</b></span></td>
			</tr>
			<tr>
			<tr>
				<td width="100" height="20">
					<p align="right">
						<b><span style="font-size: 12pt;">제 목</span></b>
					</p>
				</td>
				<td width="450" height="20" colspan="3"><span
					style="font-size: 12pt;"><b>${data.title}</b></span></td>
			</tr>


			<tr>
				<td width="100" height="200" valign="top">
					<p align="right">
						<b><span style="font-size: 12pt;">내 용</span></b>
					</p>
				</td>

				<td width="450" height="200" valign="top" colspan="3"><span
					style="font-size: 12pt;"><b>${data.content}</b></span></td>
			</tr>

			<tr>
				<td height="20" colspan="4" align="center" valign="middle"></td>
			</tr>
		</table>


		<hr>


		<br>
		<br>


		<!-- Scripts -->
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/jquery.scrolly.min.js"></script>
		<script src="../assets/js/jquery.scrollex.min.js"></script>
		<script src="../assets/js/browser.min.js"></script>
		<script src="../assets/js/breakpoints.min.js"></script>
		<script src="../assets/js/util.js"></script>
		<script src="../assets/js/main.js"></script>
</body>
</html>
