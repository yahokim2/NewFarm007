<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>   
	<article>
	    <h2> 1:1 고객 게시판 </h2>
	    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
		<form id="qna_write" name="formm" method="post" action="qna_write">
			<fieldset>	
				<legend>게시글 정보</legend>		
			    <label>제  목 : </label>
			    <input type="text" name="subject" id="subject" size="63" ><br style="clear: left;">
				<label>내 용 : </label>
			    <textarea rows="8" cols="65" name="content" id="content"></textarea><br style="clear: left;">
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
<!-- 			<input type="submit"  value="글쓰기"     class="submit" >  -->
			<input type="button"  value="글쓰기"     class="submit" onclick="go_check_blank()"> 
			<input type="reset"   value="취소"     class="cancel" onclick="location.href='qna_list'">
			<input type="button"  value="쇼핑 계속하기"  class="submit"  onclick="location.href='index'">	
		  </div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>