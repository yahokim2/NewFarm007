<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>

<article>
<h1>상품수정</h1>  
<form name="frm" id="update_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="pdseq" value="${productVO.pdseq}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${productVO.image}"> <!-- 기존 이미지 저장  -->
<table id="list">
  <tr>
    <th>상품분류</th>
    <td colspan="4">
    <select name="kind" id="kind">
      <c:forEach items="${kindList}" var="kind" varStatus="status">
        <c:choose>
          <c:when test="${productVO.kind==status.count}">
            <option value="${status.count}" selected="selected">${kind}</option>
          </c:when>
          <c:otherwise>
            <option value="${status.count}">${kind}</option>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </select> 
    </td>
  </tr>
  <tr>
    <th>상품명</th>
    <td width="343" colspan="5">
      <input type="text" name="name" id="name" size="47" maxlength="100" value="${productVO.name}">
    </td>
  </tr>

<!-- 원산지 추가 (hjh0620)-->
  <tr>
    <th>원산지</th>
    <td width="343" colspan="5">
      <input type="text" name="origin" id="origin" size="47" maxlength="100" value="${productVO.origin}">
    </td>
  </tr>
<!-- ~~~~~~~~~~~~~~~ -->  
  <tr>
    <th>원가[A]</th>
    <td width="70">        
      <input type="text" name="price1" id="price1" size="11" onKeyUp='NumFormat(this)' value="${productVO.price1}">
    </td>
    <th>판매가[B]</th>
    <td width="70">
      <input type="text" name="price2" id="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="${productVO.price2}">
    </td>
    <th>[B-A]</th>
    <td width="72">
      <input type="text" name="price3" id="price3" size="11" readonly onKeyUp='NumFormat(this)'>
    </td>
  </tr>
  <tr>
    <th>베스트상품</th>
    <td>
      <c:choose>
        <c:when test='${productVO.bestyn=="y"}'>
          <input type="checkbox" name="bestyn" value="y" id="bestyn" onchange="set_bestyn()" checked="checked">
        </c:when>
        <c:otherwise>
          <input type="checkbox" name="bestyn" value="n" id="bestyn" onchange="set_bestyn()" >
        </c:otherwise>
      </c:choose>
    </td>        
    <th>사용유무</th>
    <td>
      <c:choose>
        <c:when test='${productVO.useyn=="y"}'>
          <input type="checkbox" name="useyn" id="useyn" onchange="set_useyn()" value="y" checked="checked">
        </c:when>
      <c:otherwise>
        <input type="checkbox" name="useyn" id="useyn" onchange="set_useyn()" value="n">
      </c:otherwise>
    </c:choose>
    </td>
  </tr>
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >${productVO.content}</textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td colspan="5">
      <img src="product_images/${productVO.image}" width="200pt">     
      <br>
      <input type="file" name="product_image" id="product_image">
      <input type="hidden" name="image" value="${productVO.image}">
    </td> 
  </tr>    
</table>
<input class="btn" type="button" value="수정" onClick="go_mod_save('${productVO.pdseq}')">           
<input class="btn" type="button" value="취소" onClick="location.href='admin_product_list'">	<!--hjh0626 onClick="go_mov()" -->
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>