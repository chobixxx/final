<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록 정보</title>
<style>
	body {
	  background-color: #f2f2f2;
	  font-family: Arial, sans-serif;
	}
	
	.entire-wrap {
	  max-width: 800px;
	  margin: 0 auto;
	  padding: 20px;
	  background-color: #fff;
	  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	  border-radius: 5px;
	  box-sizing: border-box;
	  text-align: center;
	}
	
	table {
	  border-collapse: collapse;
	  width: 100%;
	  margin-top: 20px;
	  margin-bottom: 20px;
	}
	
	th {
	  font-size: 16px;
	  font-weight: bold;
	  text-align: center;
	  padding: 10px;
	  background-color: #333;
	  color: #fff;
	}
	
	td {
	  font-size: 14px;
	  text-align: center;
	  padding: 10px;
	  border: 1px solid #ddd;
	}
	
	a {
	  color: #333;
	  text-decoration: none;
	  font-weight: bold;
	  margin-top: 20px;
	  display: inline-block;
	  border-radius: 5px;
	  padding: 10px;
	  background-color: #f2f2f2;
	  box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
	}
	
	a:hover {
	  background-color: #333;
	  color: #fff;
	}
</style>
</head>
<body>  
	<div class="entire-wrap">
	    <main>
			<div class="form-wrapper">
			<table border="1">
				<tr>
					<th>이름</th>
					<th>이메일</th>
					<th>부서</th>
					<th>직급</th>
					<th>성별</th>
				</tr>
			 	<tr>
					<td>${EmployeeDTO.name}</td>
					<td>${EmployeeDTO.email}</td>
					<td>${EmployeeDTO.team}</td>
					<td>${EmployeeDTO.position}</td>
					<td>${EmployeeDTO.gender}</td>
			 	</tr>
			</table>
			</div>
		</main>
   </div>
   <center><a href="${pageContext.request.contextPath}/">Login</a></center>
</body>
</html>
