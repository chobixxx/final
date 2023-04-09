<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="imgbg">
<head>
	<title>비밀번호 찾기</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap" rel="stylesheet">
<style>
main * { font-family: 'Noto Sans KR', sans-serif; }

html.imgbg { background-image: url(../resources/static/images/in5.jpg); background-size: cover;background-position: center; height: 100%; overflow:hidden; }
html.imgbg article { background-color: rgb(255 255 255 / 80%); }
html.imgbg body { overflow-y: scroll; height: 100%; }
</style>
</head>
<body>
	<main class="container">
		<article class="" style="text-align:center; max-width:500px;margin:auto; margin-top:80px;">
			<h3>비밀번호 찾기 검색결과</h3>
			<div style="margin-bottom:50px;">
				<h5 style="font-weight:500;">비밀번호는 ${password} 입니다.</h5>
			</div>
			<div>
				<button type="button" id="loginBtn" class="" Onclick="location.href='/'">Login</button>
				<button type="reset" onclick="history.go(-1);" class="contrast" style="margin:0px;">Cancel</button>
			</div>
		</article>
	</main>
</body>
</html>