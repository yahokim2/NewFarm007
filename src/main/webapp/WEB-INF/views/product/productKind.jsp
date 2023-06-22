<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.html"%> 
<%-- <%@ include file="sub_menu.html" %>        --%>
<%@ include file="sub_menu.jsp" %>       
  <article>
<!-- hjh-0513  <h2> Item</h2>      -->
	<c:if test="${kind == 1}">
	    <h2> 과일</h2>
	</c:if>
	
	<c:if test="${kind == 2}">
	    <h2> 채소</h2>
	</c:if>
	
	<c:if test="${kind == 3}">
	    <h2> 곡물</h2>
	</c:if>
	
	<c:if test="${kind == 4}">
	    <h2> 견과</h2>
	</c:if>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    <c:forEach items="${productKindList}"  var="productVO">
      <div id="item">
        <a href="product_detail?pdseq=${productVO.pdseq}"> 
          <img src="product_images/${productVO.image}" />
          <h3>${productVO.name} </h3>        
<!-- hjh0616 원산지 추가 -->
	      <c:choose>
			<c:when test="${productVO.origin eq null}">
           		<h4>국산</h4> 
			</c:when>
		    <c:otherwise>
         		<h4>${productVO.origin} </h4>  
            </c:otherwise>
		  </c:choose>  
<!--   ~~~~~~~~~~~~~ -->
          <p>${productVO.price2} 원</p>
        </a>  
      </div>
    </c:forEach>    
    <div class="clear"></div>
  </article>
<%@ include file="../footer.jsp" %>    