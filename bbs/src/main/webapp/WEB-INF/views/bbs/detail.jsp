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
</head>
<body>

  <h1>상세보기</h1>
       
       <%-- submit하려면 form이 있어야함  --%>
      <form id = "frm_detail" method="post">
      <div>게시글 번호 : ${bbs.bbsNo}</div>
      <div>작성자 : ${bbs.editor}</div> 
      <div>제목 :  <input type="text" name="title" value="${bbs.title}" required></div>
      <div>내용 :  <input type="text" nane="contents" value=" ${bbs.contents}"></div>
      <div>작성일 : ${bbs.createdAt}</div>
      <div>수정일 : ${bbs.modifiedAt == null ? '없음' : bbs.modifiedAt}</div>
      <input type="hidden" name="bbsNo" value="${bbs.bbsNo}">    <%-- 키값 :${bbs.bbsNo}  --%>
      <button type="button" id="btn-modify">수정</button>
      <button type="button" id="btn_remove">삭제</button>
      </form>
      
      <script>
      
      var frmDetail = $('#frm_detail');  //form 을 몇번쓸꺼니깐 변수선언
      
      
      // 수정
      $('#btn_modify').click(() => {   <%-- 버튼클릭하면 익명함수--%>
    	frmDetail.attr('action', '${contextPath}/modify.do');
    	frmDetail.submit();
      }) 
      
      // 삭제
      $('#btn_remove').click(() => {   <%-- 버튼클릭하면 익명함수--%>
    	if(confirm('삭제할까?')){
    		frmDetail.attr('action', '${contextPath}/remove.do')
    		frmDetail.submit();
    	}
      }) 
      
     const modifyResult = '${modifyResult}';          //addResult가질수있는값은 '', '0', '1'
 	 if(modifyResult !== ''){
 		 if(modifyResult === '1'){
 			 alert('수정 성공');
 		 } else{
 			 alert('수정 실패');
 		 }
 	 }
 	 
      
      
      </script>
      

            
</body>
</html>