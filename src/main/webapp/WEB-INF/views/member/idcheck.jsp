<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
  background-color:#99aec2; 
  font-family: Verdana;
}
<%-- hjh-0613 color change #B96DB5; --%>

#wrap{     
  margin: 0 20px;
}
h1 {
  font-family: "Times New Roman", Times, serif;
  font-size: 45px;
  color: #CCC;
  font-weight: normal;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function idok(){
  opener.formm.id.value="${id}"; 
  opener.formm.reid.value="${id}";		// reid에 값이 있으면 중복체크 완료한 상태임..
  self.close();								// opener = join.jsp화면, self = ID 중복체크 윈도우 (닫기))
}
</script>
</head>
<body>
<div id="wrap">
  <h1>ID 중복확인</h1>
  <form method="post" name="formm" id="theform" style="margin-right:0 "
  		action="id_check_form" >
    	사용자 ID	<input type="text" name="userid" value="${id}"> 
            	<input type="submit" value="검색" class="submit"><br>    
    <div style="margin-top: 20px">   
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.id.value="";
        </script>
        ${id}는 이미 사용중인 아이디입니다.
      </c:if>
      <c:if test="${message == -1}">
        ${id}는 사용 가능한 ID입니다.
        <input type="button" value="사용" class="cancel" onclick="idok()">
      </c:if>
    </div>
  </form>
</div>  
</body>
</html>