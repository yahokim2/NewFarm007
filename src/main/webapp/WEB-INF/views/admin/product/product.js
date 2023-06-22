/**
 * 
 */
/*
 * 상품 상세정보 요청
 */
function go_detail(pageNum, rowsPerPage, pdseq) {
	var theform = document.getElementById("prod_form");
	var url = "admin_product_detail?pageNum=" + pageNum
				+ "&rowsPerPage=" + rowsPerPage
				+ "&pdseq=" + pdseq;
	
	theform.action = url;
	theform.submit();
}

/*
** 상품명으로 상품목록 조회
*/
function go_search() {
	var theform = document.getElementById("prod_form");
	
	theform.action="admin_product_list";
	theform.submit();
}

/*
 *  상품등록 화면 표시 요청
 */
function go_wrt(){
	var theform = document.getElementById("prod_form");
	theform.method="GET";
	theform.action = "admin_product_write_form";
	theform.submit();
	
}

/*
 *  price3(순익) 필드 계산
 */
function go_ab(){
	var price2 = document.getElementById("price2").value;
	var price1 = document.getElementById("price1").value;
	var price3 = price2 - price1;
	
	document.getElementById("price3").value = price3;
}

/*
 * 상품 등록 요청 
 */
function go_save() {
	
	if (document.getElementById("kind").value == "") {
		alert("상품 종류를 입력하세요.");
		document.getElementById("kind").focus();
		return false;
	} else if (document.getElementById("name").value == "") {
		alert("상품명을 입력하세요.");
		document.getElementById("name").focus();
		return false;
	} else if (document.getElementById("origin").value == "") {
		alert("상품의 원산지를 입력하세요.");
		document.getElementById("origin").focus();
		return false;
	} else if (document.getElementById("price1").value == "") {
		alert("상품원가를 입력하세요.");
		document.getElementById("price1").focus();
		return false;
	} else if (document.getElementById("price2").value == "") {
		alert("판매가를 입력하세요.");
		document.getElementById("price2").focus();
		return false;
	} else if (document.getElementById("price3").value == "") {
		alert("상품원가를 입력하세요.");
		document.getElementById("price2").focus();
		return false;
	} else if (document.getElementById("content").value == "") {
		alert("상품설명을 입력하세요.");
		document.getElementById("content").focus();
		return false;
	} else {
		var theform = document.getElementById("write_form");
		theform.action ="admin_product_write";
		theform.enctype = "multipart/form-data";
		theform.submit();
	}
}

	
function go_list(){
	var theform = document.getElementById("detail_form");
	theform.action = "admin_product_list";
	theform.submit();
}

function go_mod(){
	var theform = document.getElementById("detail_form");
	theform.action = "admin_product_update_form";
	theform.method = "GET";
	theform.submit();	
}

function go_mod_save(){
	if (document.getElementById("kind").value == "") {
		alert("상품 종류를 입력하세요.");
		document.getElementById("kind").focus();
		return false;
	} else if (document.getElementById("name").value == "") {
		alert("상품명을 입력하세요.");
		document.getElementById("name").focus();
		return false;
	} else if (document.getElementById("origin").value == "") {
		alert("상품의 원산지를 입력하세요.");
		document.getElementById("origin").focus();
		return false;
	} else if (document.getElementById("price1").value == "") {
		alert("상품원가를 입력하세요.");
		document.getElementById("price1").focus();
		return false;
	} else if (document.getElementById("price2").value == "") {
		alert("판매가를 입력하세요.");
		document.getElementById("price2").focus();
		return false;
	} else if (document.getElementById("price3").value == "") {
		alert("상품원가를 입력하세요.");
		document.getElementById("price2").focus();
		return false;
	} else if (document.getElementById("content").value == "") {
		alert("상품설명을 입력하세요.");
		document.getElementById("content").focus();
		return false;
	} else {
		var theform = document.getElementById("update_form");
		theform.enctype="multipart/form-data";
		theform.action="admin_product_update";
		theform.submit();
	}	
}

function set_useyn() {
	var is_checked = document.getElementById("useyn").checked;
	
	if (is_checked) {
		document.getElementById("useyn").value = 'y';
	} else {
		document.getElementById("useyn").value = 'n';
	}
	console.log("useyn="+document.getElementById("useyn").value);
}

function set_bestyn() {
	var is_checked = document.getElementById("bestyn").checked;
	
	if (is_checked) {
		document.getElementById("bestyn").value = 'y';
	} else {
		document.getElementById("bestyn").value = 'n';
	}
	console.log("bestyn="+document.getElementById("bestyn").value);
}