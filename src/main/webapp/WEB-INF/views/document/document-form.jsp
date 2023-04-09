<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>새 글 작성</title>
</head>
<body>
    <h1>새 글</h1>

    <form:form method="POST" modelAttribute="document">
        <label>제목:</label>
        <form:input path="title"/>

        <label>내용:</label>
        <form:textarea path="content"/>

        <button type="submit">제출</button>
    </form:form>
</body>
</html>