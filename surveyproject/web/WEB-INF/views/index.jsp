<%--
  Created by IntelliJ IDEA.
  User: jeonka
  Date: 2021/06/03
  Time: 8:00 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="/resources/script/jquery-3.5.0.min.js"></script>
    <script src="/resources/script/topMenu.js"></script>
    <script src="/resources/script/index.js"></script>
    <script src="/resources/script/sendEmail.js"></script>
    <script src="/resources/script/changePass.js"></script>
    <script src="/resources/script/signUp.js"></script>
    <script src="/resources/script/surveyList.js"></script>

    <c:choose>
        <c:when test='${result == null || result == false }'>
            <script src="/resources/script/login.js"></script>
        </c:when>
        <c:otherwise>
            <script src="/resources/script/login.js"></script>
            <script src="/resources/script/myPage.js"></script>
        </c:otherwise>
    </c:choose>

    <link rel="stylesheet" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/sendEmail.css">
    <link rel="stylesheet" href="/resources/css/changePass.css">
    <link rel="stylesheet" href="resources/css/login.css">
    <link rel="stylesheet" href="resources/css/myPage.css">
    <link rel="stylesheet" href="resources/css/signUp.css">
    <link rel="stylesheet" href="resources/css/surveyList.css">
    <link rel="stylesheet" href="resources/css/topMenu.css">


    <title>surVey conneCtion</title>

</head>
<body>

<div class="wrap">
    <div class="top">
        <div id="logo">&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion</div>
        <jsp:include page="topMenu.jsp"></jsp:include>
    </div>
    <div class="mid">
        <div id="content">
            <jsp:include page="surveyList.jsp"></jsp:include>
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