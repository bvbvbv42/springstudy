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

  <form id="frm_write" action="${contextPath}/board/add.do" method="post">
    <div><input type="text" name="writer" id="writer" placeholder="작성자" autofocus></div>
    <div><input type="text" name="title" id="title" placeholder="제목"></div>
    <div><textarea name="contents" id="contents"></textarea></div>
    <div>
      <button type="submit">저장</button>
      <button type="reset">다시작성</button>
      <button type="button" id="btnList">목록</button>
    </div>
  </form>

  <script>
    
    function fnBoardAdd(){
      $('#frm_write').on('submit', function(event){
        if($('#writer').val() === '' || $('#title').val() === ''){
          alert('작성자와 제목은 필수입니다.');
          event.preventDefault();
          return;
        }
      })
    }
    
    function fnBoardList(){
      $('#btnList').on('click', function(){
        location.href='${contextPath}/board/list.do';
      })
    }
    
    fnBoardAdd();
    fnBoardList();
    
  </script>

</body>
</html>