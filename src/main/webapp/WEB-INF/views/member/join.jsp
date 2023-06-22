<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>   
<%@ include file="sub_img.html"%> 
<%-- hjh 한글깨짐 <%@ include file="sub_menu.html" %>        --%>
<%@ include file="sub_menu.jsp" %>
  
  <article>
    <h2>Join Us</h2>
    <form id="join" action="join" method="post" name="formm">
      <fieldset>
<!--         <legend>Basic Info</legend> -->
<!--         <label>User ID</label> -->
<!-- 	        <input type="text"      name="userid"  id="id" value="${id}"  size="12"  > --!>
<!-- 	        <input type="hidden"    name="reid" id="reid" value="${reid}"> --!>
<!-- 	        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()"><br style="clear: left;"> -->
<!--         <label>Password</label>  -->
<!-- 	        <input type="password"  name="pwd" id="pwd"><br style="clear: left;">  -->
<!-- 	    <label>Retype Password</label>  -->
<!-- 	        <input type="password"  name="pwdCheck" id="pwdCheck"><br style="clear: left;">  -->
<!--         <label>Name</label> -->
<!-- 	        <input type="text" name="name" id="name"><br style="clear: left;">  -->
<!--         <label>E-Mail</label> -->
<!-- 	        <input type="text" name="email" id="email"><br style="clear: left;"> -->
        <legend>필수 정보</legend>
        <label>사용자 ID</label>
        <input type="text"      name="userid"  id="id" value="${id}"  size="12"  >
        <input type="hidden"    name="reid" id="reid" value="${reid}">
        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()"><br style="clear: left;">
        <label>비밀번호</label> 
        <input type="password"  name="pwd" id="pwd"><br style="clear: left;"> 
        <label>비밀번호확인</label> 
        <input type="password"  name="pwdCheck" id="pwdCheck"><br style="clear: left;"> 
        <label>성&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명</label>
        <input type="text" name="name" id="name"><br style="clear: left;"> 
        <label>전자우편</label>
        <input type="text" name="email" id="email"><br style="clear: left;">
      </fieldset>
      <fieldset>
<!--         <legend>Optional</legend> -->
<!--         <label>Zip Code</label>  -->
<!-- 	        <input type="text"       name="zip_num" id="zip_num"  size="10" >       -->
<!-- 	        <input type="button"     value="주소 찾기" class="dup" onclick="post_zip()"><br style="clear: left;"> -->
<!--         <label>Address</label>  -->
<!-- 	        <input type="text"        name="addr1"   id="addr1" size="50"> <br style="clear: left;"> -->
<!-- 	        <input type="text"        name="addr2"   size="25" style="margin-left: 140px"> <br style="clear: left;"> -->
<!--         <label>Phone Number</label>  -->
<!-- 	        <input  type="text"       name="phone"><br style="clear: left;"> -->
        <legend>선택 정보</legend>
        <label>우편번호</label> 
        <input type="text"   name="zip_num" id="zip_num"  size="10" >      
        <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br style="clear: left;">
        <label>주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</label> 
        <input type="text"   name="addr1"   id="addr1" size="50"> <br style="clear: left;"> 
        <input type="text"   name="addr2"   size="25" style="margin-left: 140px"> <br style="clear: left;">
        <label>전화번호</label> 
        <input  type="text"  name="phone"><br style="clear: left;">
<!-- hjh0616 추가~~~~~~~~~~~~~ -->
        <label>마케팅 메일</label>
       		<select name='consent'>
			  <option value='y'>수신 동의</option>
			  <option value='n'>수신 미동의</option>
			</select>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~ -->
      </fieldset>
 
      <div class="clear"></div>
      <div id="buttons">
        <input type="button"    value="회원가입"   class="submit" onclick="go_save()"> 
        <input type="reset"      value="취소"     class="cancel">
      </div>
      <br>
    </form>
  </article>
<%@ include file="../footer.jsp" %>
  