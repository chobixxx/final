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

<!-- 
	http://localhost/step05_customer/update.jsp
	http://localhost/step05_customer/CustomerServlet/update
	http://localhost/step05_customer/CustomerServlet/allView
 -->
<form action="../SearchServlet/update?employeeNo=${requestScope.evo.employeeNo}" method="post">

	<table class="tg">
	<thead>
	  <tr>
	    <th class="tg-calz" width=30%>사번</th>
	    <th class="tg-baqh" width=50%>-${requestScope.evo.employeeNo}-</th>
	  </tr>
	</thead>
	<tbody>
	  <tr>
	    <td class="tg-calz" width=30%>메일</td>
	    <td class="tg-baqh" width=50%>${requestScope.evo.email}</td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>이름</td>
	    <td class="tg-baqh" width=50%>${requestScope.evo.employeeName}</td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>부서</td>
	    <td class="tg-baqh" width=50%>
	    	<input type="type" name="teamName" value="${requestScope.evo.teamName}">
	    </td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>비번</td>
	    <td class="tg-baqh" width=50%>
	    	<input type="password" name="password" value="${requestScope.evo.password}">
	    </td>
	  </tr>
	  <tr>
	    <td class="tg-calz" width=30%>직급</td>
	    <td class="tg-baqh" width=50%>
	    	<input type="type" name="positionName" value="${requestScope.evo.positionName}">
	    </td>
	  </tr>
	</tbody>
	</table>
	<p/>

	<input type="submit" value="수정" > &nbsp;
	<input type="reset" value="취소">&nbsp;
	<input type="button" value="모두보기" Onclick="location.href='${pageContext.request.contextPath}/search/SearchServlet/allView'">
</form>

</body>
</html>
