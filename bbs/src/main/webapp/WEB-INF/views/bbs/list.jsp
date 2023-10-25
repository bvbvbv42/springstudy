<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>목록보기</h1>
  
  <h3>전체개수 : ${total}</h3>
  <c:forEach items="${bbsList}" var="bbs"> <!-- 리스트라는것을 bbs라는이름으로 하나씩 꺼내겠다. -->
    <div class="bbs">   <!-- 위에이름 똑같이 해야함 -->
      <div>${bbs.bbsNo}</div>
      <div>${bbs.title}</div>  <!-- gettitle메소드가 실행될꺼임 -->
    </div>
  </c:forEach>
 
 <div class="paging">${paging}</div> 
  
</body>
</html>