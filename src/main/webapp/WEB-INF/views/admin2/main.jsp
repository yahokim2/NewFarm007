<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Admin</title>
<link rel="stylesheet" href="admin2/css/admin.css">
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
  <div id="wrap">
    <header>      
      <div id="logo">
        <a href="admin_login_form"> 
        <img src="admin2/images/bar_01.gif" style="float:left">
        <img src="admin2/images/text.gif">
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
          <td> <input type="text" id="workId" name="id" size="10" value="admin"></td>
        </tr>
        <tr>
          <td> 비밀번호 </td>
          <td> 
            <input type="password" id="workPw" name="pwd" size="10" value="admin">
          </td>
        </tr>
        <tr align="center" >
          <td  colspan="2">          
            <input class="btn" type="submit" value="업무 로그인" onclick="return admin_check()"><br><br>
            <h4 style="color:red">${message}</h4>
          </td>
        </tr>
      </table>
      </form>
      </div>
    </article>
  </div>
</body>
</html>