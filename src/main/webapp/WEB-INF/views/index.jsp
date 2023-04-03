<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>내일 여행</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url("../resources/static/images/beach.png");
  min-height: 100%;
  background-position: center;
  background-size: cover;
}
</style>
</head>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
<div class="w3-display-topleft w3-padding-large w3-xlarge">
   <a href="../">Tomorrow Tour</a>
  </div>
  <div class="w3-display-middle">
    <h1 class="w3-jumbo w3-animate-top" > </h1>
    <hr class="w3-border-grey" style="margin:auto;width:40%">
    </div>
   <div style="display:block; margin:20px auto;">
         
        </div>
       <br> <br><br><br><br><br>
        <main>        
<div class="form-wrapper" align="center">
	<img src="../resources/static/images/logo.png" style="width:150px; height:150px;"> <br>
    <form id="loginForm" action="company/login" method="post" >
        <h3><p style="color:#046582;">Welcome !</p></h3>
        <div class="input-wrapper" style="display:block; margin:20px auto;">
        
            <input type="text" id="email" name="email" placeholder=" ID" required>
        </div>
        <div class="input-wrapper" style="display:block; margin:20px auto;">
        
            <input type="password" id="password" name="password" placeholder=" Password" required>
        </div>
        <div style="display:block; margin:20px auto;">
            <button type="submit" id="btnLogin" style="background-color:#aad5e5; color:#FFFFFF; border:0px;">LOGIN</button>
        </div>

        <div class="login_append">
        <span class="txt_find">
           <a href="../company/findEmail" class="link_find"><p style="color:#000000;">이메일 찾기</a>
            |
           <a href="../company/findPw" class="link_find">비밀번호 찾기</a>
            |
           <a href="../company/join" class="link_find">회원가입</p></a>
         </span>
       </div>

    </form>
</div>
</main>
  
  <div class="w3-display-bottomleft w3-padding-large">
    by GroupWare5
  </div>
</div>

</body>


</html>