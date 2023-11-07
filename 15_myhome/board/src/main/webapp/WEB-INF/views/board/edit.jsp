<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

  <form id="frm_edit" action="${contextPath}/board/modify.do" method="post">
    <div><input type="hidden" name="boardNo" value="${board.boardNo}"></div>
    <div><input type="text" name="title" id="title" value="${board.title}"></div>
    <div><textarea name="contents" id="contents">${board.contents}</textarea></div>
    <div>
      <button type="submit">수정</button>
      <button type="reset">다시작성</button>
      <button type="button" onclick="location.href='${contextPath}/board/list.do'">목록</button>
    </div>
  </form>

  <script>
    
    function fnBoardModify(){
      $('#frm_edit').on('submit', function(event){
        if($('#title').val() == ''){
          alert('제목은 필수입니다.');
          event.preventDefault();
          return;
        }
      })
    }
    
    fnBoardModify();
    
  </script>
  
</body>
</html>