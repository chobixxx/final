<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>내일여행 직원 등록</title>

    <!-- Icons font CSS-->
    <link href="../resources/static/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="../resources/static/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="../resources/static/https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="../resources/static/vendor/select2/select2.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../resources/static/css/register_main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w960">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Registration Form</h2>
                    <form method="POST" action="${pageContext.request.contextPath}/company/join">
                        <div class="input-group">
                            <label class="label">Email</label>
                            <input class="input--style-4" type="text" id="email" name="email" required>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">이름</label>
                                    <input class="input--style-4" type="text" id="name" name="name" required>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
									<label class="label">성별</label>
									<div class="p-t-10">
										<label class="radio-container m-r-45">Male
											<input type="radio" checked="checked" name="gender" value="Male">
											<span class="checkmark"></span>
										</label>
										<label class="radio-container">Female
											<input type="radio" name="gender" value="Female">
											<span class="checkmark"></span>
										</label>
									</div>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-3">
                                <div class="input-group">
                                    <label class="label">password</label>
                                    <input class="input--style-4" type="password" id="pw" name="password" placeholder="영문, 숫자 포함 8~16자이내 ">
                                </div>
                            </div>
<!--                             <div class="col-3">
                                <div class="input-group">
                                    <label class="label">password confirm</label>
                                    <input class="input--style-4" type="password" name="passwordConfirm">
                                </div>
                            </div>
                            <div class="input-group" style="display:flex;align-items:flex-end;">
								<button class="btn btn--radius-2 btn--blue" type="submit" style="height:50px;">확인</button>
                            </div>
                        </div> -->
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
									<label class="label">부서</label>
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="team">
											<option disabled="disabled" selected="selected">부서 선택</option>
											<option value="경영팀">경영팀</option>
											<option value="기획팀">기획팀</option>
											<option value="인사팀">인사팀</option>
											<option value="영업팀">영업팀</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
									<label class="label">직급</label>
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="position">
											<option disabled="disabled" selected="selected">직급 선택</option>
											<option value="사원">사원</option>
											<option value="대리">대리</option>
											<option value="과장">과장</option>
											<option value="차장">차장</option>
											<option value="부장">부장</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
                                </div>
                            </div>
                        </div>
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="../resources/static/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="../resources/static/vendor/select2/select2.min.js"></script>

    <!-- Main JS-->
    <script src="../resources/static/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->