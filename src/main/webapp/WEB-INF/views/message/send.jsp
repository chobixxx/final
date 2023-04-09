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
    <title>Message Send</title>

    <!-- Icons font CSS-->
    <link href="/resources/static/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="/resources/static/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="/resources/static/https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="/resources/static/vendor/select2/select2.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="/resources/static/css/register_main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w960">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Message Send</h2>
                    <form method="POST" action="${pageContext.request.contextPath}/message/send">
                        <input type="hidden" id="sender" name="sender" value="${empNo}" required>
                        <div class="input-group">
                            <label class="label">받는 사람</label>
                            <input class="input--style-4" type="text" id="receiver" name="receiver" required>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">제목</label>
                                    <input class="input--style-4" type="text" id="title" name="title" required>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
									<label class="label">내용</label>
                                    <input class="input--style-4" type="text" id="content" name="content" required>
                                </div>
                            </div>
                        </div>
                        <div align="right" class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">발송</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="/resources/static/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="/resources/static/vendor/select2/select2.min.js"></script>

    <!-- Main JS-->
    <script src="/resources/static/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->