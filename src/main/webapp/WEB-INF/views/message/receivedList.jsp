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

	<link href='/resources/static/https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="/resources/static/https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="/resources/static/css/style.css">

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
					<h4 class="text-center mb-4">받은 메시지</h4>
					<div class="table-wrap">
						<table class="table table-striped">
							<thead class="thead-primary">
								<tr>
									<th>제목</th>
									<th>내용</th>
									<th>보낸 사람</th>
									<th>수신일</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
							    <c:forEach var="m" items="${requestScope.receivedList}">
							        <tr>
							            <th scope="row" class="scope">${m.title}</th>
							            <td>${m.content}</td>
							            <td>${m.sender}</td>
							            <td>${m.writeDate}</td>
							            <td>
							            	<input type="hidden" name="id" value="${m.id}">
											<button onclick="location.href='${pageContext.request.contextPath}/message/receivedDelete?id=${m.id}&empNo=${m.receiver}'"> 삭제 </button>
							        	</td>
							        </tr>
							    </c:forEach>
							    <c:if test="${empty requestScope.receivedList}">
							        <tr>
							            <td colspan="6" class="text-center">메시지가 없습니다.</td>
							        </tr>
							    </c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<br>
			<div align=right>
				<span style="font-size:9pt;">&lt;
					<a href="${pageContext.request.contextPath}/message/viewSendPage/${sessionScope.emp.empNo}" method="GET">메시지 발송</a>
				</span>
			</div>
			<div align=right>
				<span style="font-size:9pt;">&lt;
					<a href="${pageContext.request.contextPath}/message/sent/${sessionScope.emp.empNo}" id="portfolio-link">
					<span class="icon solid fa-envelope">보낸 메시지</span></a>
				</span>
			</div>
		</div>
		<br>
			<div class="w-full text-center p-t-55">
			    <a href="/main" class="btn btn-primary mr-2">
			        Back to Main
			    </a>
			    <button onclick="history.back()" class="btn btn-secondary">Go Back</button>
			</div>
	</section>

	<script src="/resources/static/js/jquery.min.js"></script>
  <script src="/resources/static/js/popper.js"></script>
  <script src="/resources/static/js/bootstrap.min.js"></script>
  <script src="/resources/static/js/main.js"></script>

	</body>
</html>

