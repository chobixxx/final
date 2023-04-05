<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.groupware.entity.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 
	//view.jsp에서 세션에 저장된  객체 획득해서 update를 위한 화면에 데이타 출력

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>직원 정보 수정</title>

<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-baqh{text-align:center;vertical-align:top}
.tg .tg-calz{background-color:#000000;border-color:inherit;color:#ffffff;font-weight:bold;text-align:center;vertical-align:top}
</style>

</head>
<body>

<br>
<center>
<h3>직원 정보 수정</h3>
<br>
	<form action="/company/update" method="post">
 	 <input type="hidden" name="empNo" value="${employee.empNo}" />

	<table class="tg">
	<thead>
	  <tr>
	    <th class="tg-calz" width=30%>사번</th>
	    <th class="tg-baqh" width=50%>-${employee.empNo}-</th>
	    <input type="hidden" name="empNo" value="${employee.empNo}" />
	  </tr>
	</thead>
	<tbody>
		<tr>
		  <td class="tg-calz" width=30%>메일</td>
		  <td class="tg-baqh" width=50%>${employee.email}</td>
		  <input type="hidden" name="email" value="${employee.email}" />
		</tr>
	  <tr>
	    <td class="tg-calz" width=30%>이름</td>
	    <td class="tg-baqh" width=50%>${employee.name}</td>
	    <input type="hidden" name="name" value="${employee.name}" />
	  </tr>
	  <tr>
	  <td class="tg-calz" width=30%>성별</td>
	  <td class="tg-baqh" width=50%>${employee.gender}</td>
	  <input type="hidden" name="gender" value="${employee.gender}" />
		</tr>
	  <tr>
	    <td class="tg-calz" width=30%>부서</td>
	    <td class="tg-baqh" width=50%>
	    		<input type="radio" name="team" value="경영팀" checked>경영팀
				<input type="radio" name="team" value="기획팀">기획팀
				<input type="radio" name="team" value="인사팀">인사팀
				<input type="radio" name="team" value="영업팀">영업팀<br>	
	    </td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>비번</td>
	    <td class="tg-baqh" width=50%>
	    	<input type="password" name="password" value="${employee.password}">
	    </td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>직급</td>
	    <td class="tg-baqh" width=50%>
	    		<input type="radio" name="position" value="사원" checked>사원
				<input type="radio" name="position" value="대리">대리
				<input type="radio" name="position" value="과장">과장
				<input type="radio" name="position" value="차장">차장
				<input type="radio" name="position" value="부장">부장<br>
	    </td>
	  </tr>
	</tbody>
	</table>
	<p/>

	<input type="submit" value="수정" > &nbsp;
	<input type="reset" value="취소">&nbsp;
	<input type="button" value="모두보기" Onclick="location.href='${pageContext.request.contextPath}/company/allEmp'">
</form>

</body>
</html>
