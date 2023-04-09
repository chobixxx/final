<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<style>
</style>
<title>freeboard update</title>
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
<img src="../images/logo.png" style="width:130px; height:130px;" align="center">
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
					<li><a href="../BoardServlet/boardallview"><span class="icon solid fa-home">자유 게시판</span></a></li>
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
	<br><br>
	<div id="main" align="center">


	<form action="../board/boardupdate" method="post">
	  <!-- update Form  -->	
	  <table border="1" cellspacing="1" width="60%">

		   <tr>
		
			<td width="30%">제목</td>
			<td width="70%">
				<input type="type" name="title" >
			</td>		  
		  <tr>	
		 <tr>
		
			<td width="30%">내용</td>
			<td width="70%">
				<input type="type" name="content" >
			</td>		  
		  <tr>	 
		 <tr>
			<td width="30%">게시글 비밀번호</td>
			<td width="70%">
				<input type="password" name="password" >
			</td>
			<input type="hidden" name="empNo", value="${sessionScope.emp.empNo}"/>
			
			
		  </tr>	 	  	
  
	</table>  
	<p/>
	<input type="submit" value="수정" > &nbsp;
	<input type="reset" value="취소">&nbsp;
	
	</form>
	</div>
	
			

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