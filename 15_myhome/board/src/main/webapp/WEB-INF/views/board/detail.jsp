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

  게시글번호: ${board.boardNo}<br>
  작성자: ${board.writer}<br>
  작성일: ${board.createdAt}<br>
  수정일: ${board.modifiedAt}<br>
  제목: ${board.title}<br>
  내용
  ${board.contents}<br>
  
  <hr>
  
  <form id="frm_btn" method="post">  
    <input type="hidden" name="boardNo" value="${board.boardNo}">
    <button type="button" id="btnEdit">편집</button>
    <button type="button" id="btnRemove">삭제</button>
    <button type="button" id="btnList">목록</button>
  </form>

  <script>

    var frmBtn = $('#frm_btn');
    
    function fnBoardEdit(){
      $('#btnEdit').on('click', function(){
        frmBtn.attr('action', '${contextPath}/board/edit.do');
        frmBtn.submit();
      })
    }
    
    function fnBoardRemove(){
      $('#btnRemove').on('click', function(){
        if(confirm('삭제할까요?')){
          frmBtn.attr('action', '${contextPath}/board/remove.do');
          frmBtn.submit();
        }
      })
    }
    
    function fnBoardList(){
      $('#btnList').on('click', function(){
        location.href='${contextPath}/board/list.do';
      })
    }
    
    function fnModifyResult(){
      let modifyResult = '${modifyResult}';
      if(modifyResult !== ''){
        if(modifyResult === '1'){
          alert('게시글이 수정되었습니다.');
        } else {
          alert('게시글이 수정되지 않았습니다.');
        }
      }
    }
    
    fnBoardEdit();
    fnBoardRemove();
    fnBoardList();
    fnModifyResult();
    
  </script>
  
</body>
</html>