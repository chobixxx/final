<%@page import="com.groupware.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
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
  #joinForm{
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
  .btn_join{
    width: 130px; 
    height:45px;
    background-color:black;
    color:white;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_cancel{
    width: 130px; 
    height:45px;
    background-color:black;
    color:white;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_join:hover{
    width: 130px; 
    height:45px;
    background-color:white;
    border: 1px solid black;
    color:black;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_cancel:hover{
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
  .btn_span1 {
    margin-right: 10px;
  }  

</style>
</head>
<body>
   <div class="entire-wrap">
    <main>
      
        <div class="form-wrapper">
          
          <form method="post" action="${pageContext.request.contextPath}/company/join">
            <table width="100%">   
              <tr>
                <th colspan='2'>Registration</th>
              <tr>
              <td width=30% class="title">Email</td>
              <td width=70%>
                  <input type="text" id="email" name="email" required>
                  <button type="button" onclick="checkDuplicateEmail()">중복 확인</button>
                  <div id="email-check-message"></div>
              </td>
              </tr>
              <tr>
              <td width=30% class="title">Password</td>
              <td width=70%>
                  <input type="password" id="pw" name="password" placeholder="영문, 숫자 포함 8~16자이내 ">
              </td>
              </tr>  
<!--               <tr>
              <td width=30% class="title">Password Check</td>
              <td width=70%>
                <input type="password" id="pw_chk" name="password" placeholder="영문, 숫자 포함 8~16자이내">
              </td>
              </tr> -->
              <tr>
              <td width=30% class="title">Name</td>
              <td width=70% >
                  <input type="text" id="name" name="name" required>
              </td>
              </tr>        
              <tr>
				<td width=30% class="title">Team</td>
                <td>            
				<input type="radio" name="team" value="경영팀" checked>경영팀
				<input type="radio" name="team" value="기획팀">기획팀
				<input type="radio" name="team" value="인사팀">인사팀
				<input type="radio" name="team" value="영업팀">영업팀
				<input type="radio" name="team" value="관리팀">관리팀<br>	
                </td>
              </tr> 
              <tr>
              <td width=30% class="title">Position</td>
                <td>
				<input type="radio" name="position" value="사원" checked>사원
				<input type="radio" name="position" value="대리">대리
				<input type="radio" name="position" value="과장">과장
				<input type="radio" name="position" value="차장">차장
				<input type="radio" name="position" value="부장">부장
				<input type="radio" name="position" value="관리자">관리자<br>	
                  </td>
              </tr>    
               <tr>
              <td width=30% class="title">gender</td>
                <td>
			    <input type="radio" name="gender" value="Male" checked>남성
			    <input type="radio" name="gender" value="Female">여성
                  </td>
              </tr>
            </table>
            <div class="btn_div">
              <span class="btn_span1">
                <button class="btn_join" type="submit" value="회원가입">Sign Up</button>
              </span>
              <span class="btn_span2">
                <button class="btn_cancel" type="reset" value="취소">Cancel</button>
              </span>
            </div>
          </form>   
          
			<script>
			function checkDuplicateEmail() {
			  var email = document.getElementById("email").value;
			  if (email == "") {
			    alert("이메일을 입력해주세요.");
			    return;
			  }
			  var xhr = new XMLHttpRequest();
			  xhr.onreadystatechange = function() {
			    if (xhr.readyState == XMLHttpRequest.DONE) {
			      var messageElem = document.getElementById("email-check-message");
			      if (xhr.status == 200) {
			    	  // 중복되지 않은 경우
		                 if (xhr.responseText == "200") {
		                   messageElem.style.color = "green";
		                   messageElem.innerHTML = "사용 가능한 이메일입니다.";
		                 }
		                 // 중복된 경우
		                 else if (xhr.responseText == "100") {
		                   messageElem.style.color = "red";
		                   messageElem.innerHTML = "이미 등록된 이메일입니다.";
		                 }
			      } else {
			        messageElem.style.color = "red";
			        messageElem.innerHTML = "서버 에러가 발생했습니다.";
			      }
			    }
			  };
			  xhr.open("POST", "/company/checkEmail?email=" + email);
			  xhr.send();
			}
			</script>
           
      </div>
      </main>
   </div>
</body>
</html>