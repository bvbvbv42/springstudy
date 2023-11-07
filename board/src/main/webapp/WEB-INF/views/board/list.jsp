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
    <div class="board">   <!--bbs 위에이름 똑같이 해야함  // 데이터속성에서 카멜케이스 쓰지말것 -->
      <div>${board.title}</div>  <!-- gettitle메소드가 실행될꺼임 -->
    </div>
  </c:forEach>
  
  <script>
 /* 
 $('.bbs').click(function(){
    // 클릭한 대상 : 이벤트 대상 (this)
    let bbsNo = $(this).data('bbs_no');  // 데이터속성에서 카멜케이스 쓰지말것
    alert(bbsNo);
  })
  */
   
  $('.board').click((ev) => {
    // 클릭한 대상 : 이벤트 대상 (이벤트객체의 target 속성)
    
      let boardNo = $(ev.target).parent().data('board_no');  // 데이터속성에서 카멜케이스 쓰지말것
     location.href = '${contextPath}/list.do?boardNo=' + boardNo;    
   })
   
   $('#frm_add').submit((ev) => {
       let title = $('#title');
     if(title.val() === ''){      //값이 없으면
      alert('제목은 필수입니다.');
        title.focus();
        ev.preventDefault();
        return;
    }
   })
   
   const addResult = '${addResult}';          //addResult가질수있는값은 '', '0', '1'
   if(addResult !== ''){
     if(addResult === '1'){
       alert('추가 성공');
     } else{
       alert('추가 실패');
     }
   }
   
   
 </script>
</body>
</html>
