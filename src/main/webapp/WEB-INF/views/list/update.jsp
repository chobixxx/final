<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.groupware.entity.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>회원 정보 수정</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
		}
		
		.container {
			max-width: 800px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
			border-radius: 5px;
			box-sizing: border-box;
			text-align: center;
		}
		
		h1 {
			margin: 10;
			font-size: 32px;
			font-weight: bold;
			color: #333;
			margin-bottom: 20px;
		}
		
		form {
			margin: 0 auto;
			max-width: 500px;
			display: flex;
			flex-direction: column;
			align-items: center;
		}
		
		form label {
			display: block;
			margin-bottom: 5px;
			font-weight: bold;
			color: #666;
			text-align: left;
			margin-top: 15px;
			width: 100%;
			box-sizing: border-box;
		}
		
		form input {
			display: block;
			padding: 10px;
			border: none;
			background-color: #f2f2f2;
			margin-bottom: 20px;
			border-radius: 5px;
			width: 100%;
			box-sizing: border-box;
			font-size: 16px;
			color: #333;
		}
		
		form input[type="submit"] {
			background-color: #333;
			color: #fff;
			cursor: pointer;
		}
		
		form input[readonly] {
			background-color: #ddd;
			color: #666;
			cursor: not-allowed;
		}
		
		form input[type="submit"]:hover {
			background-color: #555;
		}
		
		form select {
			display: block;
			padding: 10px;
			border: none;
			background-color: #f2f2f2;
			margin-bottom: 20px;
			border-radius: 5px;
			width: 100%;
			box-sizing: border-box;
			font-size: 16px;
			color: #333;
		}
		
		form label[for="team"], form label[for="position"] {
			text-align: left;
		}
		
		form label[for="team"]::after, form label[for="position"]::after {
			content: "*";
			color: red;
		}
		
	</style>
</head>
<body>
	<div class="container">
		<h1>직원 정보 수정</h1>
		<form action="/company/update" method="post">
			<label for="empNo">사번</label>
			<input type="empNo" name="empNo" id="empNo" value="${employee.empNo}" readonly/>
			<input type="hidden" name="empNoHidden" value="${employee.empNo}">
			
			<label for="name">이름</label>
			<input type="name" name="name" id="name" value="${employee.name}" readonly/>
			<input type="hidden" name="nameHidden" value="${employee.name}">
			
			<label for="email">이메일</label>
			<input type="email" name="email" id="email" value="${employee.email}" readonly/>
			<input type="hidden" name="emailHidden" value="${employee.email}">
			
			<label for="gender">성별</label>
			<input type="gender" name="gender" id="gender" value="${employee.gender}" readonly/>
			<input type="hidden" name="genderHidden" value="${employee.gender}">
			
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" value="${employee.password}" required/>
			
			<label for="team">부서</label>
			<select name="team" id="team">
			  <option value="경영팀" selected>경영팀</option>
			  <option value="기획팀">기획팀</option>
			  <option value="인사팀">인사팀</option>
			  <option value="영업팀">영업팀</option>
			</select>
			
			<label for="position">직급</label>
			<select name="position" id="position">
			  <option value="사원" selected>사원</option>
			  <option value="대리">대리</option>
			  <option value="과장">과장</option>
			  <option value="차장">차장</option>
			  <option value="부장">부장</option>
			</select>
			
			<input type="submit" value="수정하기" onclick="showPopup()">
		</form>
	</div>
		
			<script>
			function showPopup() {
			  alert("회원 정보 수정이 완료되었습니다.");
			  closePopup();
			}
			
			function closePopup() {
			  window.opener.location.href = "${pageContext.request.contextPath}/company/allEmp";
			  window.close();
			}
			</script>
</body>
</html>

<!-- </body>
</html> -->
