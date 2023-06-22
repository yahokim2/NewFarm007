<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  

  <!--메인 이미지 들어가는 곳 시작 --->
  
  <div class="clear"></div>
  <div id="main_img">
    	<img src="images/four_img.jpg" >    
  </div>
       
  <!--메인 이미지 들어가는 곳 끝--->

  <div class="clear"></div>   

  <div id="front">   
  
    <h2> home-test용  jsp 화일 입니다. == 화면데이터 는 index 복사 </h2>
	<div id="newProduct">
		<c:forEach items="${newProductList}" var="productVO">
			<div id="item">
				<a href="product_detail?pdseq=${productVO.pdseq}"> <img
					src="product_images/${productVO.image}" />
					<h3>${productVO.name}</h3>
					<p>${productVO.price2}</p>
				</a>
			</div>
		</c:forEach>
	</div>
	<div class="clear"></div>

	<h2> 인기 상품</h2>
	<div id="bestProduct">
		<c:forEach items="${bestProductList}" var="productVO">
			<div id="item">
				<a href="product_detail?pdseq=${productVO.pdseq}"> <img
					src="product_images/${productVO.image}" />
					<h3>${productVO.name}</h3>
					<p>${productVO.price2}</p>
				</a>
			</div>
		</c:forEach>
		<div class="clear"></div>

	</div>
	
</div>							<!-- hjh0619 -->
<div id="blank_test"> </div>	<!-- hjh0619 -->

	<%@ include file="footer.jsp" %>    