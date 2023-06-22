<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html" %>
<%-- hjh 한글깨짐 <%@ include file="sub_menu.html" %>        --%>
<%@ include file="sub_menu.jsp" %>       

  <article>
 <!-- hjh-0612 -->
<!--     <h1> Item </h1> -->
    <h1> 구매 / 장바구니 </h1>
    <div id="itemdetail" >
      <form  method="post" action="cart_insert" name="formm" id="theform">    
        <fieldset>
          <legend> 상품 상세 정보</legend> <!-- Item detail Info -->  
          <a href="product_detail?pdseq=${productVO.pdseq}">         
            <span style="float: left;">
              <img src="product_images/${productVO.image}" />
            </span>              
            <h2> ${productVO.name} </h2>  
          </a>    
          <label> 가 격 :  </label>  
          <p> <fmt:formatNumber type="currency" value="${productVO.price2}"/></p>  
          <label> 수 량 : </label>
          <input  type="text"   name="quantity" id="quantity" size="2" value="1"><br>
<%--		<p> 원산지는 * ${productVO.origin} * 입니다 </p>  hjh0616 원산지 추가 --%>
<!-- hjh0616 원산지 추가 -->
	        <c:choose>
			  <c:when test="${productVO.origin eq null}">
			    <p>원산지는 * 국산 * 입니다.</p>
			  </c:when>
			  <c:otherwise>
			    <p>원산지는 * ${productVO.origin} * 입니다.</p>
			  </c:otherwise>
			</c:choose>
<!--   ~~~~~~~~~~~~~ -->
          <input  type="hidden" name="pdseq" value="${productVO.pdseq}" id="pdseq"><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
          <input type="button" value="장바구니에 담기" class="submit" onclick="go_cart()"> 
          <input type="button" value="즉시 구매"     class="submit" onclick="go_dir_order()"> 
          <input type="reset"  value="취소"        class="cancel" onclick="location.href='index'">
        </div>
      </form>  
    </div>
    
  <!-- 상품평 처리 -->
  	<%@ include file="comment.jsp" %>	
  </article>
<%@ include file="../footer.jsp" %>  





  