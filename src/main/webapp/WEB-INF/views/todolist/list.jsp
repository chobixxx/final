<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todolist</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="preconnect1" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/assets/css/yy.css" />



</head>
<body class="is-preload">
<div class="header1"  style="box-sizing: border-box;" >
<div align="center">
<a href="${pageContext.request.contextPath}/NoticeServlet/noticeallview">
<img src="${pageContext.request.contextPath}/resources/static/images/logo.png" style="width:130px; height:130px;" align="center">
</a>
<div style="float: right;" >
  <a href="${pageContext.request.contextPath}/company/logout">Logout</a>
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
					<li><a href="${pageContext.request.contextPath}/BoardServlet/boardallview"><span class="icon solid fa-home">자유 게시판</span></a></li>
					<li><a href="${pageContext.request.contextPath}/search/SearchServlet/allView" id="portfolio-link"><span class="icon solid fa-th">사원조회</span></a></li>
					<li><a href="${pageContext.request.contextPath}/message/viewmessage/${sessionScope.employeeNo}" id="portfolio-link"><span class="icon solid fa-envelope">메시지</span></a></li>
					<li><a href="${pageContext.request.contextPath}/todolist/viewtodolist/${sessionScope.employeeNo}" id="portfolio-link"><span class="icon solid fa-envelope">Todolist</span></a></li>
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
				<li><a href="https://github.com/ChoiJongKwan/GroupWare5" class="icon brands fa-github"><span
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
	<div class="page-title" align="center" style="font-size: 50px"  >
				<strong> Todolist</strong>	
		</div>
	<div id="main">


		
<table align="center" border="1" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<colgroup>
		<col width="60%"/>

		<col width="10%"/>
		<col width="6%"/>
		<col width="14%"/>

	</colgroup>
	<tr>
        <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">제목</span></b></font></p>
        </td>
       
        <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">중요도</span></b></font></p>
        </td>
         <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">시간</span></b></font></p>
        </td>
         <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">삭제</span></b></font></p>
        </td>

    </tr>
    <c:choose>
    <c:when test="${empty requestScope.list}">
	<tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 할일이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="e">
		    <tr>
		        <td bgcolor="">
					<p align="center"><span style="font-size:15pt;">
					${e.title}</span></p>
					
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">		
						${e.importance}
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">		
						${e.h} : ${e.min}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:15pt;">		
						<input type="hidden" name="num" value="${e.num}">
						<button onclick="location.href='${pageContext.request.contextPath}/todolist/delete?num=${e.num}&amp;empNo=${sessionScope.emp.empNo}'">삭제 </button>
				</span></p>
		        </td>
		    </tr>
		 
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<input type="hidden" name="empNo" value="${sessionScope.emp.empNo}" />
					
	
</div>
<hr>
<div align=right>
<button type="button" onclick="location.href = '/todolist/inserttodolist'" style="background-color:#555">
  <i class='far fa-file-alt' style='font-size:18px;color:white'>&nbsp;일정추가</i>
</button>

<span style="font-size:9pt;">&lt;<a href="../insert">일정추가 </a>&gt;</span></div>
</body>