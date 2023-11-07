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
<style>
  .blind {
    display: none;
  }
</style>
</head>
<body>

  <a href="${contextPath}/board/write.do">작성하러가기</a>
  
  <hr>

  <form id="frm_list" method="post" action="${contextPath}/board/removeList.do">

    <div>
      <button>선택삭제</button>
    </div>
  
    <table border="1">
      <thead>
        <tr>
          <td>
            <label for="checkAll">전체선택</label>
            <input type="checkbox" id="checkAll" class="blind">
          </td>
          <td>게시글번호</td>
          <td>작성자</td>
          <td>제목</td>
          <td>작성일</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="board" items="${boards}">
          <tr data-board_no="${board.boardNo}">
            <td><input type="checkbox" name="boardNoList" value="${board.boardNo}" class="checkOne"></td>
            <td>${board.boardNo}</td>
            <td>${board.writer}</td>
            <td>${board.title}</td>
            <td>${board.createdAt}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

  </form>

  <script>

    function fnBoardDetail(){
      $('tbody td:not(td:first-of-type)').on('click', function(){
        var boardNo = $(this).parent().data('board_no');
        location.href='${contextPath}/board/detail.do?boardNo=' + boardNo;
      })
    }
    
    function fnBoardRemoveList(){
      $('#frm_list').on('submit', function(event){
        if(!confirm('선택한 게시글을 삭제할까요?')){
          event.preventDefault();
          return;
        }
        if($('.checkOne:checked').length === 0){
          alert('선택된 게시글이 없습니다.');
          event.preventDefault();
          return;
        }
      })
    }
    
    function fnCheckAll(){
      $('#checkAll').on('click', function(){
        $('.checkOne').prop('checked', $('#checkAll').prop('checked'));
      })
    }
    
    function fnCheckOne(){
      $('.checkOne').on('click', function(){
        let checkCount = 0;
        for(let i = 0; i < $('.checkOne').length; i++){
          checkCount += $($('.checkOne')[i]).prop('checked');        
        }
        $('#checkAll').prop('checked', checkCount === $('.checkOne').length);
      })
    }
    
    function fnAddResult(){
      let addResult = '${addResult}';
      if(addResult !== ''){
        if(addResult === '1'){
          alert('게시글이 등록되었습니다.');
        } else {
          alert('게시글이 등록되지 않았습니다.');
        }
      }
    }
    
    function fnRemoveResult(){
      let removeResult = '${removeResult}';
      if(removeResult !== ''){
        if(removeResult === '1'){
          alert('게시글이 삭제되었습니다.');
        } else {
          alert('게시글이 삭제되지 않았습니다.');
        }
      }
    }
    
    function fnRemoveListResult(){
      let removeListResult = '${removeListResult}';
      if(removeListResult !== ''){
        if(removeListResult > 0){
          alert('게시글이 모두 삭제되었습니다.');
        } else {
          alert('게시글이 삭제되지 않았습니다.');
        }
      }
    }
    
    fnBoardDetail();
    fnBoardRemoveList();
    fnCheckAll();
    fnCheckOne();
    fnAddResult();
    fnRemoveResult();
    fnRemoveListResult();
    
  </script>

</body>
</html>