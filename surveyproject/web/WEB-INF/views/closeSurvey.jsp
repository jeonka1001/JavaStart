<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/script/jquery-3.5.0.min.js"></script>
<script src="/resources/script/myPage.js"></script>
<script src="/resources/script/closeSurveyList.js"></script>
<script src="/resources/script/closeSurvey.js"></script>
<%
	if( session==null || session.getAttribute("userInfo")==null ){
%>
	<script>
		alert("잘못 된 접근입니다.");
		location.href = "index.jsp";
	</script>
	
<% 	
	}
%>
<script src="/resources/script/index.js"></script>
<script src="/resources/script/sendEmail.js"></script>
<script src="/resources/changePass.js"></script>
<script src="/resources/script/login.js"></script>
<script src="/resources/script/myPage.js"></script>
<script src="/resources/script/signUp.js"></script>
<script src="/resources/closeSurveyList.js"></script>
<script src="/resources/script/topMenu.js"></script>


<link rel="stylesheet" href="/resources/css/index.css">
<link rel="stylesheet" href="/resources/css/sendEmail.css">
<link rel="stylesheet" href="/resources/css/changePass.css">
<link rel="stylesheet" href="/resources/css/login.css">
<link rel="stylesheet" href="/resources/css/myPage.css">
<link rel="stylesheet" href="/resources/css/signUp.css">
<link rel="stylesheet" href="/resources/css/topMenu.css">
<link rel="stylesheet" href="/resources/css/closeSurveyList.css">


<title>마감 완료된 설문</title>
</head>
<body>

<div class="wrap">
	<div class="top">
		<div id="logo">&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion</div>
		<jsp:include page="topMenu.jsp"></jsp:include>
	</div>
	<div class="mid">
			<div id="content">
				<jsp:include page="closeSurveyList.jsp"></jsp:include>
			</div>
			<div id="side">
				<div id="member">
					<c:choose>
					<c:when test='${result == null || result == false }'>
						<jsp:include page="login.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="myPage.jsp"></jsp:include>
					</c:otherwise>
					</c:choose>
				</div>
				<div id="changePass">
					<c:choose>
					<c:when test='${result == null || result == false }'>
						<jsp:include page="sendEmail.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="changePass.jsp"></jsp:include>
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	<div class="bottom">
		<div id="ad">광고 띄우기</div>
	</div>
</div>

</body>
</html>