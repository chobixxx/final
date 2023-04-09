<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>All Documents</title>
<link rel="stylesheet"
	href="/resources/static/https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<form method="GET" action="/document/search">
		<label for="keyword">제목 검색:</label> <input type="text" id="keyword"
			name="keyword">
		<button type="submit">검색</button>
		</form>
		
		<form method="POST" action="/document/delete">
		<table>
			<thead>
				<tr>
					<th>선택</th>
					<th>사번(수정해야함)</th>
					<th>제목</th>
					<th>상태</th>
					<th>작성 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="document" items="${documents}">
					<tr>
					<td><input type="checkbox" name="checked" value="${document.empNo}"></td>
						<td>${document.empNo}</td>
						<td>${document.title}</td>
						<td>${document.status}</td>
						<td>${document.created_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<button type="submit">삭제</button>
		</form>
		<a href="/document/new">새 글 작성</a>
</body>
</html>