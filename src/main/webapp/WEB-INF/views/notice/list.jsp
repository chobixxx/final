<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<style>
</style>
<title>notice list</title>
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
<a href="${pageContext.request.contextPath}/NoticeServlet/noticeallview">
<img src="../resources/static/images/logo.png" style="width:130px; height:130px;" align="center">
</a>
</span>
<div align="right">
  <a href="${pageContext.request.contextPath}/company/logout">Logout</a>
</div>
</div>

 </div>
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
					<li><a href="../board/boardallview"><span class="icon solid fa-home">자유 게시판</span></a></li>
					<li><a href="../company/allEmp" id="portfolio-link"><span class="icon solid fa-th">사원조회</span></a></li>
					<li><a href="../message/received/${sessionScope.emp.empNo}" id="portfolio-link"><span class="icon solid fa-envelope">메시지</span></a></li>
					<li><a href="${pageContext.request.contextPath}/todolist/viewtodolist/${sessionScope.emp.empNo}" id="portfolio-link"><span class="icon solid fa-envelope">Todolist</span></a></li>
					<li><a href="../document/listDoc" id="portfolio-link"><span class="icon solid fa-envelope">결재</span></a></li>
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
	<br><br>
	<div id="main">

		<div class="page-title">
			<div class="container1">
				<h3>공지사항</h3>
			</div>
		</div>


		<!-- board list area -->
		<div id="board-list">
			<div class="container1">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">이름</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>

						<c:choose>
							<c:when test="${empty requestScope.allData}">
								<tr>
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 12pt;">등록된 방명록이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>

								<c:forEach items="${requestScope.allData}" var="e">

									<tr>
										<td>${e.no}</td>
										<th><a href="../NoticeServlet/noticeread?no=${e.no}">${e.title}</a></th>
										<td>${e.empNo.name}</td>
										<td>${e.writedate}</td>
									</tr>

								</c:forEach>
							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
			</div>
		</div>
	<br>
	<div align="right">

	</div>
	<br><br>

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