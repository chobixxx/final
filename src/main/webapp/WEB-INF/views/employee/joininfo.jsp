<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록 정보</title>
<style>
  table{
    text-align: center;
    border: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid gray;
    height: 75px;
  }
  th{   
    height:100px;
    background-color: black;
    color:white;
    font-size: 30px;
    font-weight: bold;
  }
  .title{
    font-weight: bold;
  }
  .form-wrapper {
    width:600px;
    text-align: center;
    margin: 200px auto;          
  }
  #JoinInfoForm{
    text-align: center;
  }
  input[type=text], input[type=password]  {
    border: 0 solid black;
    width: 200px;
    height:30px;
  }
  

  select {
    width: 200px;
    height:40px;
    font-size: 15px;  
  }
  option {
    padding-left: 40px;
  }
  #check {
    font-size: 10px; 
  }
  
  /* button */
  .btn_Login{
    width: 130px; 
    height:45px;
    background-color:black;
    color:white;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_Login:hover{
    width: 130px; 
    height:45px;
    background-color:white;
    border: 1px solid black;
    color:black;
    font-size: 16px;
    font-weight: bold;
  }
  
  .btn_div{
    margin-top: 50px;
    text-align: center;
  }
  .btn_span {
    margin-right: 10px;
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
   &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/">메인 화면 이동</a>
</body>
</html>
