<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>비밀번호 찾기</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../resources/static/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/vendor/pw/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/vendor/pw/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../resources/static/vendor/pw/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/vendor/pw/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/vendor/pw/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../resources/static/vendor/pw/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/static/css/pw/util.css">
	<link rel="stylesheet" type="text/css" href="../resources/static/css/pw/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
				<form action="${pageContext.request.contextPath}/company/findPw" method="post" class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-53">
						FIND PASSWORD
					</span>
					
					<div class="p-t-31 p-b-9">
						<span class="txt1">
							EMAIL
						</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Username is required">
						<input class="input100" type="text" id="email" name="email" required >
						<span class="focus-input100"></span>
					</div>
					
					<div class="p-t-13 p-b-9">
						<span class="txt1">
							NAME
						</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="text" id="name" name="name" required >
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button type="submit" class="login100-form-btn">
							FIND
						</button>
					</div>
				</form>
				<div class="w-full text-center p-t-55">
						<span class="txt2">
							Forget Email?
						</span>
						<a href="findEmail" class="txt2 bo1">
							Find Email
						</a>
					</div>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="../resources/static/vendor/pw/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/static/vendor/pw/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/static/vendor/pw/bootstrap/js/popper.js"></script>
	<script src="../resources/static/vendor/pw/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/static/vendor/pw/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/static/vendor/pw/daterangepicker/moment.min.js"></script>
	<script src="../resources/static/vendor/pw/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../resources/static/vendor/pw/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="../resources/static/pw/js/main.js"></script>

</body>
</html>