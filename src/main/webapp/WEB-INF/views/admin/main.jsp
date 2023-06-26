<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농산품Mall-Admin</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script type="text/javascript">
function admin_check()
{
  if(document.frm.id.value==""){
      alert("아이디를 입력하세요.");
      return false;
  } else if(document.frm.pwd.value==""){
     alert("비밀번호를 입력하세요.");
      return false;
  }
  
  return true;  
}
</script>
</head>

<body>
  <div id="wrap_AdLogin">
    <header>      
      <div id="logo">
        <a href="admin_login_form"> 
<!--         <img src="admin/images/bar_01.gif" style="float:left"> -->
<!--         <img src="admin/images/text.gif"> -->
        <img style="width:700px;  display:block; margin:auto;" src="admin/images/bar_admin1.jpg">
        </a>
      </div>      
    </header>
    <div class="clear"></div>
    
    
    <article>
      <div id="loginform">
      <form name="frm" method="post" action="admin_login">
      <table>
        <tr>
          <td> 아 이 디 </td>
          <td> <input type="text" id="workId" name="aid" size="10" value="admin"></td>
          <td></td>
        </tr>
        <tr>
          <td> 비밀번호 </td>
          <td> 
            <input type="password" id="workPw" name="pwd" size="10" value="admin">
          </td>
          <td></td>
        </tr>
        <tr align="center" >
<!--           <td  colspan="2">           -->
<!--             <input class="btn" type="submit" value="업무 로그인" onclick="return admin_check()"><br><br> -->
<%--             <h4 style="color:red">${message}</h4> --%>
<!--           </td> -->
			<td colspan="2">
	            <input class="btn" type="submit" value="업무 로그인" onclick="return admin_check()" style="background-color: black; color: white;">
<%-- 	            <h4 style="color:red">${message}</h4> --%>
					${message}
			</td>
			<td>
				<input class="btn" type="reset"  value="초기 화면" onclick="location.href='index'" style="background-color: black; color: white;"> 
<%-- 	            <h4 style="color:blue">${message}</h4> --%>
					${message}
			</td>
<!-- ~~~~~~~~~~~ -->
        </tr>
      </table>
      </form>
      </div>
    </article>
  </div>
</body>
</html>