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

  <h1>작성화면</h1>
   <div>
    <form id="frm_add" method="post" action="${contextPath}/add.do">
      <div><input type="text" name="writer" id="writer" placeholder="작성자"></div>
      <div><input type="text" name="title" id="title" placeholder="제목" required></div>  <!-- title은 NOT NULL이라 정보가있어야한다 , required -> 이입력란을 입력하세요-->
      <div><input type="text" name="contents" id="contents" placeholder="작성자"></div>
      <div><button type="submit">추가하기</button></div>
    </form>
  </div>
  
  <hr>
  
   <c:forEach items="${boardList}" var="board"> 
    <div>${board.title} - ${board.createdAt}</div>  
  </c:forEach>
</body>
</html>
