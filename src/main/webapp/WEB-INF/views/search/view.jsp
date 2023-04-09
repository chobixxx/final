<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<% System.out.println("view.jsp실행 확인"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>직원정보 보기</title>

	<style type="text/css">
	.tg  {border-collapse:collapse;border-spacing:0; width: 60%;}
	.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
	  overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
	  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg .tg-baqh{text-align:center;vertical-align:top}
	.tg .tg-l4e4{background-color:#000000;border-color:inherit;color:#ffffff; font-weight:bold;text-align:center;vertical-align:top}
	</style>

</head>

<body>		
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

	<h3>직원 정보 보기</h3>
	<br>
	<form action="/allView">
	
		<table class="tg">
	<thead>
	  <tr>
	    <th class="tg-calz" width=30%>사번</th>
	    <th class="tg-baqh" width=50%>${evo.employeeNo}</th>
	  </tr>
	</thead>
	<tbody>
	  <tr>
	    <td class="tg-calz" width=30%>부서</td>
	    <td class="tg-baqh" width=50%>${evo.teamName}</td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>이름</td>
	    <td class="tg-baqh" width=50%>${evo.employeeName}</td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>메일</td>
	    <td class="tg-baqh" width=50%>${evo.email}</td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>직급</td>
	    <td class="tg-baqh" width=50%>${evo.positionName}</td>
	  </tr>
	</tbody>
	</table>
		<br>
		<br> 
		
		<!-- 
		http://ip:port/context명/update.jsp
		${pageContext.request.contextPath} : 코드 사용 권장
		즉 현 jsp의 실행 위치가 어디에 있든지 <http://ip:port/context명/> 을 의미하는 코드
		 -->
		
		<input type="button" value="update" Onclick="location.href='${pageContext.request.contextPath}/update.jsp'">&nbsp; 
		<input type="submit" value="allView"> 
	</form>


</body>
</html>
