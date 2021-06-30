<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style type="text/css">
    a:link { color: gray; text-decoration: none;}
    a:visited { color: gray; text-decoration: none;}
    a:hover { color: gray; text-decoration: underline;}
</style>
<div id="menu">
    <ul>
        <li>|</li>
        <li>처음이세요?
            <ul id="notice">
                <li id="viewSiteInfo" ><a href="/siteInfo">사이트 소개</a></li>
                <li id="viewSiteRule"><a href="/siteRule">이용방법</a></li>
            </ul>
        </li>
        <li>|</li>
        <li>설문 관련
            <ul>
                <li id="writeSurvey"><a href="/survey/write">설문 작성</a></li>
                <li id="participateSurvey"><a href="/survey/visit">설문 참여</a></li>
                <li id="viewEndedSurvey">마감 설문 보기</li>
            </ul>
        </li>
    </ul>

</div>