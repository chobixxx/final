<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.groupware.entity.*, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
  <head>
  	<title>Table 03</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href='../resources/static/https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="../resources/static/https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../resources/static/css/style.css">
	<link rel="stylesheet" href="../resources/static/assets/css/yy.css" />
</head>
	
<body class="is-preload">

<div class="header1"  style="box-sizing: border-box;" >
	<div align="center">
		<span>
			<img src="../resources/static/images/logo.png" style="width:130px; height:130px;" align="center">
		</span>
		<div align="right" style="font-size:18px;">
		  <a href="${pageContext.request.contextPath}/company/logout">Logout</a>
		</div>
	</div>
</div>
<!-- Header -->
<div id="header2">
	<div class="top">
		<!-- Logo -->
		<div id="logo">
			<span class="image avatar48"><img src="../resources/static/images/avatar.jpg" alt="" /></span>
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
			<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
			<li><a href="#" class="icon brands fa-facebook-f"><span	class="label">Facebook</span></a></li>
			<li><a href="#" class="icon brands fa-github"><span	class="label">Github</span></a></li>
			<li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
			<li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
		</ul>
	</div>
</div>
<!-- Main -->
<br><br>
<div id="main" class="listEmp">
	<div class="page-title">
		<div class="container1">
			<h3>직원 목록</h3>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form action="searchEmp" method="post" class="form-inline">
				    <div class="form-group mr-2">
				        <input type="text" class="form-control" name="search" placeholder="찾는 이름을 입력하세요." style="width: 200px;">
				    </div>
				    <button type="submit" class="btn btn-primary">검색</button>
				</form>
				<br>
				<div class="table-wrap">
					<table class="table table-striped">
						<thead class="thead-primary">
							<tr>
								<th>NO</th>
								<th>NAME</th>
								<th>EMAIL</th>
								<th>TEAM</th>
								<th>POSITION</th>
								<th>GENDER</th>
							</tr>
						</thead>
						<tbody>
						    <c:forEach var="employee" items="${employees}">
						        <tr>
						            <th scope="row" class="scope">${employee.empNo}</th>
						            <td>${employee.name}</td>
						            <td>${employee.email}</td>
						            <td>${employee.team}</td>
						            <td>${employee.position}</td>
						            <td>${employee.gender}</td>
						        </tr>
						    </c:forEach>
					        <c:if test="${empty employees}">
					            <tr>
					                <td colspan="6" class="text-center">검색 결과가 없습니다.</td>
					            </tr>
					        </c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="w-full text-center p-t-55">
	    <a href="/main" class="btn btn-primary mr-2">
	        Main
	    </a>
	    <button onclick="history.back()" class="btn btn-primary">Back</button>
	</div>
	<br>
	<br>
	<!-- <section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">NAEIL TOUR</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h4 class="text-center mb-4">직원 목록</h4>
						<form action="searchEmp" method="post" class="form-inline">
						    <div class="form-group mr-2">
						        <input type="text" class="form-control" name="search" placeholder="찾는 이름을 입력하세요." style="width: 200px;">
						    </div>
						    <button type="submit" class="btn btn-primary">검색</button>
						</form>	<br>
					<div class="table-wrap">
						<table class="table table-striped">
							<thead class="thead-primary">
								<tr>
									<th>NO</th>
									<th>NAME</th>
									<th>EMAIL</th>
									<th>TEAM</th>
									<th>POSITION</th>
									<th>GENDER</th>
								</tr>
							</thead>
							<tbody>
							    <c:forEach var="employee" items="${employees}">
							        <tr>
							            <th scope="row" class="scope">${employee.empNo}</th>
							            <td>${employee.name}</td>
							            <td>${employee.email}</td>
							            <td>${employee.team}</td>
							            <td>${employee.position}</td>
							            <td>${employee.gender}</td>
							        </tr>
							    </c:forEach>
							    <c:if test="${empty employees}">
							        <tr>
							            <td colspan="6" class="text-center">검색 결과가 없습니다.</td>
							        </tr>
							    </c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<br>
			<div class="w-full text-center p-t-55">
			    <a href="/main" class="btn btn-primary mr-2">
			        Back to Main
			    </a>
			    <button onclick="history.back()" class="btn btn-secondary">Go Back</button>
			</div>
	</section> -->
</div>

<script src="../resources/static/js/jquery.min.js"></script>
<script src="../resources/static/js/popper.js"></script>
<script src="../resources/static/js/bootstrap.min.js"></script>
<script src="../resources/static/js/main.js"></script>

	</body>
</html>

