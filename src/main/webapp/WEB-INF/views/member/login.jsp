<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.html"%> 
<%-- hjh 한글깨짐 <%@ include file="sub_menu.html" %>        --%>
<%@ include file="sub_menu.jsp" %>
  
<article>
  <h1>로그인 하기</h1>
  <form method="post" action="login">
   <fieldset>
   <legend></legend>
    <label>사용자 ID</label>
      <input name="userid" type="text" value="${id}"><br style="clear: left;"> 
    <label>비밀 번호</label> 
      <input name="pwd" type="password"><br> 
   </fieldset>
      <div class="clear"></div>
      <div id="buttons">
       <input type="submit" value="로그인" class="submit">
       <input type="button" value="회원가입" class="joinup"
       		onclick="location='contract'"> 			<!-- "cancel" or "joinup" -->
       <input type="button" value="아이디/비밀번호 찾기" class="submit"
            onclick="find_id_form()">
      </div>
  </form>  
</article>

<%@ include file="../footer.jsp" %>      
