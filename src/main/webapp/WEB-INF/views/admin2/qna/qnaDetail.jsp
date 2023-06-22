<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
   function go_list()
   {
	   var theForm = document.frm;
	   theForm.action="admin_qna_list";
	   theForm.method="GET";
	   theForm.submit();
   }

   function go_rep(qaseq)
   {	   

	   var theForm = document.frm;
	   
	   var rptext = document.getElementById("reply");
	  
	   if(rptext.value == ""){
			alert("답변할 내용을 입력해 주세요");
			rptext.focus();		
			
			return false;
		
	   } else {
	   	
	   		theForm.action="admin_qna_repsave";
	   		theForm.submit();
   	   }  
	   
   }
</script>
<article>
<h1>Q&amp;A 게시판</h1>   
<form name="frm" method="post">
<input type="hidden" name="qaseq" value="${qnaVO.qaseq}">
<table id="orderList">
    <tr>
        <th width="20%">제목</th>
        <td> ${qnaVO.subject} ${qnaVO.rep} </td>
    </tr>
   <tr>
         <th>등록일</th>
         <td> <fmt:formatDate value="${qnaVO.indate}"/> </td>  
    </tr>
    <tr>
        <th>내용</th>
        <td> ${qnaVO.content}</td>  
    </tr>
</table>
<c:choose>          
  <c:when test='${qnaVO.rep=="1"}'>
  <table id="orderList">
      <tr>
          <td colspan="2">
      <img src="admin/images/opinionimg01.gif">
      </td>
      </tr>
    <tr>
          <td colspan="2">    
      <textarea name="reply" id="reply" rows="3" cols="50"></textarea>
      <input type="button" class="btn" value="저장" onClick="go_rep('${qnaVO.qaseq}')">    
      
      </td>
      </tr>
  </table>
  <br>
  </c:when>
  <c:otherwise>  
  <table id="orderList">
    <tr>
     <th>댓글</th>
     <td> ${qnaVO.reply}</td>
    </tr>
  </table>
  </c:otherwise>
</c:choose>    
<input type="button" class="btn" value="목록" onClick="go_list()">
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>