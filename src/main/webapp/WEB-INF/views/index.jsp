<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" class="imgbg">
<head>
	<title>내일여행 로그인 페이지</title>
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
.login-btn-box { padding: 0;margin-top: 50px; }
.login-btn-box > div { padding:0; text-align:center; }
.login-btn-box > div a { font-size:14px; }

html.imgbg { background-image: url(../resources/static/images/in5.jpg); background-size: cover;background-position: center; height: 100%; overflow:hidden; }
html.imgbg article.grid { background-color: rgb(255 255 255 / 80%); }
html.imgbg body { overflow-y: scroll; height: 100%; }
</style>
</head>
<body>
	<main class="container">
		<article class="grid">
	        <div>
	          <hgroup style="margin-bottom: 50px;">
	            <h2>내일여행 직원 로그인</h2>
	            <h3>LOGIN</h3>
	          </hgroup>
	          <form class="login100-form validate-form" id="loginForm" action="company/login" method="post">
	            <input type="text" id="email" name="email" placeholder="Email" aria-label="Email" required>
	            <input type="password" id="password" name="password" placeholder="Password" aria-label="Password" required>
	            <fieldset>
	              <label for="remember">
	                <input type="checkbox" role="switch" id="remember" name="remember">
	                Remember me
	              </label>
	            </fieldset>
	            <button type="submit" class="contrast">Login</button>
	            <div class="grid login-btn-box" style="">
					<div><a class="txt2" href="company/findPw">Forget Password?</a></div>
					<div><a class="txt2" href="company/join">Create your Account</a></div>
				</div>
	          </form>
	        </div>
	        <div style="background-image: url('../resources/static/images/in2.jpg');background-size: cover;background-position: center;"></div>
	    </article>
	</main>

	<script src="../resources/static/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="../resources/static/vendor/bootstrap/js/popper.js"></script>
	<script src="../resources/static/vendor/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="../resources/static/js/main.js"></script>

</body>
</html>