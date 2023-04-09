<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<SCRIPT language=javascript>

function txInput(Obj,String)
{
  document.getElementById(Obj).value = String;
}
</SCRIPT>
<body>


<form name="writeForm" method="post" action="inserttodolist" onSubmit='checkValid()'>


<table align="center" cellpadding="5" cellspacing="2" width="600" border="1">

    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#336699">
            <p align="center"><font color="white" size="3"><b>일정 작성</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="title" size="30"></span></b></td>
    </tr>
   
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">중요도</span></b></p>
        </td>
        <td width="450" height="20" ><b>
        <input type="radio" id="3" name="imp" value= "3" onclick="txInput('textinput',this.value)">3<br>
  		<input type="radio" id="2" name="imp" value="2" onclick="txInput('textinput',this.value)">2<br>
  		<input type="radio" id="1" name="imp" value="1" onclick="txInput('textinput',this.value)">1<br>        
        <span style="font-size:9pt;">
		<input type=text id="textinput"name="importance" size="50" readonly></span></b></td>
    </tr>
   
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">일정 시간</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		<input type="number" name="h" size="12" min='0' max='23'>
        	</span></b>
        	시
        	<b><span style="font-size:9pt;">
        		<input type="number" name="min" size="12" min='0' max='59' >
        	</span></b>
        	분
        </td>
    </tr>
           <input type="hidden" name="empNo", value="${sessionScope.emp.empNo}"/>

    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=일정추가> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="../todolist/viewtodolist/${sessionScope.emp.empNo}">리스트로 돌아가기</a>&gt;</span></div>

</BODY>
</HTML>