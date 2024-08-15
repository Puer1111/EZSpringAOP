<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="../resources/css/main.css">
</head>
<body>
	<h1>로그인</h1>
	<c:if test="${memberId eq null }">
	<form action="/member/login.kh" method="POST">
		<fieldset>
		아이디: <input type="text" name="memberId" id="memberId"> <br>
		비밀번호: <input type="password" name="memberPw" id="memberPw">
		<input type="submit" value="로그인"> <br>
		<a href="/member/register.kh">회원가입하러가기</a>
		</fieldset>
	</form>
	</c:if>
	<c:if test="${memberId ne null }">
		${memberName }님 환영합니다.
		<a href="/member/logout.kh">로그아웃</a>
		<a href="/member/mypage.kh">마이페이지</a>
		<c:if test="${memberId eq  'admin' }">
		<a href="/notice/register.kh">공지사항 등록</a>
		<a href="/board/register.kh">보드 등록</a>
		<a href="/notice/list.kh">공지사항 바로가기</a>
		</c:if>
	</c:if>
	
</body>
</html>