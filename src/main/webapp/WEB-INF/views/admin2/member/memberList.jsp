<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">

function go_member_exit() {
    var count = 0;
    /* checkbox에 체크된 항목이 있는지 확인 */
    if (document.frm.useyn.length == undefined) {
      if (document.frm.useyn.checked == true) {
        count++;
      }
    } else {
      for ( var i = 0; i < document.frm.useyn.length; i++) {
        if (document.frm.useyn[i].checked == true) {
          count++;
        }
      }
    }
    if (count == 0) {
      alert("미사용으로 등록할 대상을 선택해 주세요.");
    } else {
      document.frm.action = "admin_member_unused";
      document.frm.submit();
//       alert("!!! 미사용등록은 내일부터 가능합니다.");
    }
  }


  function go_search()
  {
     document.frm.action="admin_member_list";
     document.frm.submit();
  }
</script>

<article>
<h1>회원리스트</h1>  
<form name="frm" method="post">
<table style="float:right; ">
  <tr>
  <td> 
  회원 이름
  <input type="text" name="key" id="key">
  <input class="btn" type="button" value="검색" onclick="go_search()">
  </td>
  </tr>
</table>  
<br>
<table id="orderList">
  <tr>
    <th> 아이디 (미사용여부) </th>    <th> 이름 </th>
    <th> 이메일 </th>             <th> 우편번호 </th>  
    <th> 주소 </th>  <th> 전화 </th> <th> M-메일수신 </th> <th> 가입일 </th>
  </tr>
  <c:forEach items="${memberList}" var="memberVO">  
  <tr>
    <td>${memberVO.userid} 
    <c:choose>
      <c:when test='${memberVO.useyn=="y"}'>
      
        <span style="font-weight: bold; color: blue"></span>      
        (<input type="checkbox" name="useyn" value="${memberVO.userid}">)        
        
      </c:when>
      <c:otherwise>
      	<span style="font-weight: bold; color: red"></span>
          (<input type="checkbox" checked="checked" disabled="disabled">)                
      </c:otherwise>
    </c:choose>
    </td>
    <td> ${memberVO.name} </td>
    <td> ${memberVO.email} </td> 
    <td> ${memberVO.zip_num} </td>
    <td> ${memberVO.address} </td>
    <td> ${memberVO.phone} </td> 
     
    <c:choose>
      <c:when test='${memberVO.consent=="y"}'>
        <span style="font-weight: bold; color: blue"></span>      
          	<td> 동의 </td>         
      </c:when>
      <c:otherwise>
      	<span style="font-weight: bold; color: red"></span>
            <td> 미동의 </td>                
      </c:otherwise>
    </c:choose>
    
    
    <td> <fmt:formatDate value="${memberVO.regdate}"/></td>
  </tr>
  </c:forEach>
</table>

  <input type="button" class="btn" style="width: 200px"
      value="탈퇴후보(미사용) 등록" onClick="go_member_exit()">


</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>