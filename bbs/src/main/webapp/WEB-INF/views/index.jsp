<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>Hello World</h1>
  <a href="${contextPath}/bbs/list.do">게시판</a>  <!-- page=안쓰면 서비스임플이 1을 사용함 -->
  
</body>
</html>

<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!-- <c:set var="contextPath" value="${pageContext.request.contextPath}" />-->

<!-- 위에두개가없으면 contextPath가 없는 경우로나온다. -->