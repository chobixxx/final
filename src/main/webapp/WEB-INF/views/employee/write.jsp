<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" class="imgbg">

<head>
    <title>내일여행 직원 등록</title>
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
article div > form div { padding:0; margin-bottom:20px; }
article div > form div input:not([type=radio]),
article div > form div button { margin:0 !important; }

html.imgbg { background-image: url(../resources/static/images/in5.jpg); background-size: cover;background-position: center; height: 100%; overflow:hidden; }
html.imgbg article.grid { background-color: rgb(255 255 255 / 80%); }
html.imgbg body { overflow-y: scroll; height: 100%; }
</style>
</head>

<body>
	<main class="container">
		<article class="grid" style="">
	        <div>
	          <hgroup style="margin-bottom: 50px;">
	            <h2>내일여행 직원 등록</h2>
	            <h3>Registration Form</h3>
	          </hgroup>
	          <form method="POST" action="${pageContext.request.contextPath}/company/join">
	            <div>
		            <label for="email">이메일</label>
		            <div class="grid">
		            	<input type="text" id="email" name="email" placeholder="Email" aria-label="Email" required>
		            	<button type="submit" class="" onclick="checkDuplicateEmail()">확인</button>
	            	</div>
	            </div>
	            <div>
		            <label for="password">비밀번호</label>
		            <input type="password" id="password" name="password" placeholder="영문, 숫자 포함 8~16자이내" aria-label="Password" required>
	            </div>
	            <div>
		            <label for="name">이름</label>
	            	<input type="text" id="name" name="name" placeholder="Name" aria-label="name" required>
	            </div>
	            <div>
		            <label for="gender">성별</label>
		            <div class="grid">
						<label for="Male"><input type="radio" id="gender1" name="gender" value="Male" checked="checked" >Male</label>
						<label for="Female"><input type="radio" id="gender2" name="gender" value="Female" checked="checked" >Female</label>
		            </div>
	            </div>
	            <div>
		            <label for="team">부서</label>
					<select id="team" required name="team">
						<option disabled="disabled" selected="selected">부서 선택</option>
						<option value="경영팀">경영팀</option>
						<option value="기획팀">기획팀</option>
						<option value="인사팀">인사팀</option>
						<option value="영업팀">영업팀</option>
					</select>
	            </div>
	            <div>
		            <label for="position">직급</label>
					<select id="position" name="position" required>
						<option disabled="disabled" selected="selected">직급 선택</option>
						<option value="사원">사원</option>
						<option value="대리">대리</option>
						<option value="과장">과장</option>
						<option value="차장">차장</option>
						<option value="부장">부장</option>
					</select>
	            </div>
	            <button type="submit" class="contrast">Submit</button>
	          </form>
	        </div>
	        <div style="background-image: url('../resources/static/images/in1.jpg');background-size: cover;background-position: center;"></div>
	    </article>
	</main>

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
                   //messageElem.style.color = "green";
                   //messageElem.innerHTML = "사용 가능한 이메일입니다.";
                   alert("사용 가능한 이메일입니다.");
                   return false;
                 }
                 // 중복된 경우
                 else if (xhr.responseText == "100") {
                   //messageElem.style.color = "red";
                   //messageElem.innerHTML = "이미 등록된 이메일입니다.";
                   alert("이미 등록된 이메일입니다.");
                   return false;
                 }
	      } else {
	        //messageElem.style.color = "red";
	        //messageElem.innerHTML = "서버 에러가 발생했습니다.";
               alert("서버 에러가 발생했습니다.");
               return false;
	      }
	    }
	  };
	  xhr.open("POST", "/company/checkEmail?email=" + email);
	  xhr.send();
	}
	</script>

</body>
</html>