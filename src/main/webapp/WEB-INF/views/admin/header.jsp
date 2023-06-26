<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농장몰 Admin</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script src="https://code.jquery.com/jquery-3.6.2.min.js" integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="admin/product/product.js"></script>
</head>

<body onload="go_ab()">  <!-- 페이지 로드시에 제품의 순매출 계산 -->
	<div id="wrap">
		<header>			
			<div id="logo">
				<a href="admin_login_form"> 
<!-- 					<img style="width:800px" src="admin/images/bar_01.gif"> -->
<!-- 					<img src="admin/images/text.gif"> -->
<!-- hjh 				        <img style="width:800px; display:block; margin:auto;" src="admin/images/bar_admin1.jpg"> -->
					<img style="width:700px" src="admin2/images/005.jpg" class="admin_img21"><br>
 					<img  style="height: 15px;" src="admin2/images/admin_home.jpg" class="admin_img22"> 
				</a>
			</div>	
			<input class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='admin_logout'">			
		</header>
		<div class="clear"></div>