<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<title>freeboard read</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">




</HEAD>

			<table align="center" cellpadding="5" cellspacing="2" width="60%"
				border='1'>
				<tr>
					<td width="1220" height="20" colspan="4" bgcolor="black">
						<p align="center">
							<font color="white" size="3"> <b>${boardData.no}번 게시물 자세히보기</b>
							</font>
						</p>
					</td>
				</tr>

				<tr>
					<td width="100" height="20">
						<p align="right">
							<b><span style="font-size: 12pt;">작성자</span></b>
						</p>
					</td>
					<td width="450" height="20" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.empNo.name}</b></span>
					</td>
				</tr>


				<tr>
					<td width="100" height="20">
						<p align="right">
							<b><span style="font-size: 12pt;">작성일</span></b>
						</p>
					</td>
					<td width="450" height="20" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.writedate}</b></span>
					</td>
				</tr>
				<tr>
				<tr>
					<td width="100" height="20">
						<p align="right">
							<b><span style="font-size: 12pt;">제 목</span></b>
						</p>
					</td>
					<td width="450" height="20" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.title}</b></span>
					</td>
				</tr>


				<tr>
					<td width="100" height="200" valign="top">
						<p align="right">
							<b><span style="font-size: 12pt;">내 용</span></b>
						</p>
					</td>
					
					<td width="450" height="200" valign="top" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.content}</b></span></td>
				</tr>
				

				<tr>
					<td height="20" colspan="4" align="center" valign="middle">

							<div id = "myId">
							
							<button type="button" onClick="location.href = '../board/boardupdate'">수정</button><br>
							
							<form action=boarddelete method="get">
							비밀번호: 
  							<input type="hidden" name="no" value="${boardData.no}">
  							<input type="password" name="password">
  							<button type="submit">삭제</button>
</form></div> 

					</td>
				</tr>
			</table>

			
			<hr>
			<div align=right>
				<span style="font-size: 12pt;">&lt;
				<a href="${pageContext.request.contextPath}/board/boardallview">리스트로 돌아가기</a>&gt;
				</span>
			</div>
			
		
</body>
</html>



<%@ include file="reply.jsp" %>


