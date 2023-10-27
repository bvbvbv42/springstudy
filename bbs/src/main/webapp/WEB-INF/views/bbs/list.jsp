<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .bbs {                         /* 빈공간을 눌러도 클릭이되어 조정  */
    width: 300px;
    border: 1px solid gray;
    cursor: pointer;
  }
</style>
</head>
<body>

  <h1>작성화면</h1>
  
  <div>
    <form id="frm_add" method="post" action="${contextPath}/add.do">
      <div><input type="text" name="editor" id="editor" placeholder="작성자"></div>
      <div><input type="text" name="title" id="title" placeholder="제목" required></div>  <!-- title은 NOT NULL이라 정보가있어야한다 , required -> 이입력란을 입력하세요-->
      <div><input type="text" name="contents" id="contents" placeholder="작성자"></div>
      <div><button type="submit">등록하기</button></div>
    </form>
  </div>
  
  <h3>전체개수 : ${total}</h3>
  <c:forEach items="${bbsList}" var="bbs"> <!-- 리스트라는것을 bbs라는이름으로 하나씩 꺼내겠다. -->
    <div class="bbs" data-bbs_no="${bbs.bbsNo}">   <!--bbs 위에이름 똑같이 해야함  // 데이터속성에서 카멜케이스 쓰지말것 -->
      <div>${bbs.bbsNo}</div>
      <div>${bbs.title}</div>  <!-- gettitle메소드가 실행될꺼임 -->
    </div>
  </c:forEach>
 
 <div class="paging">${paging}</div> 
 
 <script>
 /*	
 $('.bbs').click(function(){
 		// 클릭한 대상 : 이벤트 대상 (this)
 		let bbsNo = $(this).data('bbs_no');  // 데이터속성에서 카멜케이스 쓰지말것
 		alert(bbsNo);
 	})
 	*/
 	 
 	$('.bbs').click((ev) => {
 		// 클릭한 대상 : 이벤트 대상 (이벤트객체의 target 속성)
 		
 	    let bbsNo = $(ev.target).parent().data('bbs_no');  // 데이터속성에서 카멜케이스 쓰지말것
 	   location.href = '${contextPath}/detail.do?bbsNo=' + bbsNo; 	 
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