<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="imgbg">
<head>
<meta charset="UTF-8">
<title>사원등록 정보</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap" rel="stylesheet">
<style>
main * { font-family: 'Noto Sans KR', sans-serif; }
article { padding: 0; overflow: hidden; }
article.grid { margin-top:50px;margin-bottom:50px; }
article div { padding: 1rem; }
@media (min-width: 576px) {
	body > main { padding: 1.25rem 0; }
	article div { padding: 1.25rem; }
}
@media (min-width: 768px) {
	body > main { padding: 1.5rem 0; }
	article div { padding: 1.5rem; }
}
@media (min-width: 992px) {
	body > main { padding: 1.75rem 0; }
	article div { padding: 1.75rem; }
}
@media (min-width: 1200px) {
	body > main { padding: 2rem 0; }
	article div { padding: 2rem; }
}
article div > div.grid,
article div > div.grid div { padding:0; padding-bottom: 10px; margin-top: 10px; }
article div > div.grid { border-bottom: 1px solid #ccc; }
a.login { margin-top:50px;width:100%; }

html.imgbg { background-image: url(../resources/static/images/in5.jpg); background-size: cover;background-position: center; height: 100%; overflow:hidden; }
html.imgbg article.grid { background-color: rgb(255 255 255 / 80%); }
html.imgbg body { overflow-y: scroll; height: 100%; }
</style>

<body>
	<main class="container">
		<article class="grid">
	        <div>
	          <hgroup style="margin-bottom: 50px;">
	            <h2>환영합니다!</h2>
	            <h3>Welcome!</h3>
	          </hgroup>
	          <div class="grid">
	          	<div>이름</div>
	          	<div>${EmployeeDTO.name}</div>
	          </div>
	          <div class="grid">
	          	<div>이메일</div>
	          	<div>${EmployeeDTO.email}</div>
	          </div>
	          <div class="grid">
	          	<div>부서</div>
	          	<div>${EmployeeDTO.team}</div>
	          </div>
	          <div class="grid">
	          	<div>직급</div>
	          	<div>${EmployeeDTO.position}</div>
	          </div>
	          <div class="grid">
	          	<div>성별</div>
	          	<div>${EmployeeDTO.gender}</div>
	          </div>
	          <a href="${pageContext.request.contextPath}/" role="button" class="login">Login</a>
	        </div>
	        <div style="background-image: url('../resources/static/images/in2.jpg');background-size: cover;background-position: center;"></div>
	    </article>
	</main>
</body>
</html>
