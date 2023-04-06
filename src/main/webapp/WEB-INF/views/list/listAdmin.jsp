<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	</head>
	
	<body>
	<section class="ftco-section">
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
					        <input type="text" class="form-control" name="search" placeholder="찾는 이름을 입력하세요" style="width: 200px;">
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
						         <th>UPDATE</th>
						      </tr>
						   </thead>
						   <tbody>
						      <c:forEach var="employee" items="${employees}">
						         <tr>
						            <th scope="row" class="scope">${employee.empNo}</th>
						            <td><a href="#" class="btn btn-link" onclick="deleteEmployee(${employee.empNo})">${employee.name}</a></td>
						            <td>${employee.email}</td>
						            <td>${employee.team}</td>
						            <td>${employee.position}</td>
						            <td>${employee.gender}</td>
						            <td><a href="${pageContext.request.contextPath}/company/update?empNo=${employee.empNo}" class="btn btn-primary">UPDATE</a></td>
						         </tr>
						      </c:forEach>
						      <c:if test="${empty employees}">
						         <tr>
						            <td colspan="7" class="text-center">검색 결과가 없습니다.</td>
						         </tr>
						      </c:if>
						   </tbody>
						</table>
		                 <script>
						  function deleteEmployee(empNo) {
						    if (confirm("정말로 삭제하시겠습니까?")) {
						      location.href = "${pageContext.request.contextPath}/company/delete?empNo=" + empNo;
						    }
						  }
						</script>
					</div>
				</div>
			</div>
		</div> <br>
			<div class="w-full text-center p-t-55">
			    <a href="/main" class="btn btn-primary mr-2">
			        Back to Main
			    </a>
			    <button onclick="history.back()" class="btn btn-secondary">Go Back</button>
			</div>
	</section>

	<script src="../resources/static/js/jquery.min.js"></script>
  <script src="../resources/static/js/popper.js"></script>
  <script src="../resources/static/js/bootstrap.min.js"></script>
  <script src="../resources/static/js/main.js"></script>

	</body>
</html>

