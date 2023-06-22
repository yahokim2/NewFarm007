/**
 * 
 */

/*
*	약관 동의 여부 확인 및 회원가입 화면 요청
*/
function go_next() {
	if(document.formm.okon1[0].checked == true){		// contract.jsp에서 okon1 첫번째 해당
		// 회원가입 화면 요청
		document.formm.action = "join_form";	// 요청 URL  ,  action은 속성
		document.formm.submit();						// Controller로 전송
		
	} else if (document.formm.okon1[1].checked == true){
		//  경고창 표시
		alert("약관에 동의하셔야 합니다.")
	}
}
//
// 사용자 ID 중복체크 화면 표시
// 
function idcheck(){
	// ID 값 입력 여부 확인
	if(document.getElementById("id").value == ""){
		alert("아이디를 입력해 주세요");
		document.getElementById("id").focus();		// 마우스를 찍은 상태를 focus 라고 함.
		
		return false;
	}
	// 아이디가 입력된 경우 작은 팝업 윈도우 표시
	var url = "id_check_form?userid=" + document.getElementById("id").value;
	window.open(url, "_blank_", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=350"); 	// 미리 창 만들고 난 후 체크 요청
}

//
// 회원가입 시 필수 입력 확인
//
function go_save(){
	if(document.getElementById("id").value == ""){
		alert("사용자 아이디를 입력해 주세요.");
		document.getElementById("id").focus();
		return false;
	} else if(document.getElementById("reid").value == ""){
		alert("아이디 중복체크를 해 주세요.");
		document.getElementById("id").focus();
		return false;
	} else	if(document.getElementById("pwd").value == ""){
		alert("비밀번호를 입력해 주세요.");
		document.getElementById("pwd").focus();
		return false;
	} else	if(document.getElementById("pwd").value != document.getElementById("pwdCheck").value ){
		alert("비밀번호가 일치하지 않습니다.");
		document.getElementById("pwd").focus();
		return false;
	} else	if(document.getElementById("name").value == "" ){
		alert("이름을 입력해 주세요.");
		document.getElementById("name").focus();
		return false;
	} else	if(document.getElementById("email").value== "" ){
		alert("이메일을 입력해 주세요.");
		document.getElementById("email").focus();
		return false;
	} else{
		document.getElementById("join").action = "join";	// 회원가입 요청
		document.getElementById("join").submit();
	}
}
//
// 우편번호 찾기 화면 요청
//
function post_zip(){
	var url = "find_zip_num";
	window.open(url, "_blank_", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=700, height=500"); 	// 미리 창 만들고 난 후 체크 요청
	
}

function find_id_form(){
	var url = "find_id_form";

	window.open(url, "_blank_", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=450");
}
/*
 *  이름과 이메일로 아이디 찾기 요청
 */
function findMemberId() {
	if (document.getElementById("name").value=="") {
		alert("이름을 입력해 주세요");
		document.getElementById("name").focus();
		return false;
	} else if (document.getElementById("email").value=="") {
		alert("이메일을 입력해 주세요");
		document.getElementById("email").focus();
		return false;
	} else {
		var form = document.getElementById("findId");
		form.action = "find_id";
		form.submit();
	}
}

function findPassword() {
	if (document.getElementById("id2").value=="") {
		alert("아이디를 입력해 주세요");
		document.getElementById("id2").focus();
		return false;
	}else if (document.getElementById("name2").value=="") {
		alert("이름을 입력해 주세요");
		document.getElementById("name2").focus();
		return false;
	} else if (document.getElementById("email2").value=="") {
		alert("이메일을 입력해 주세요");
		document.getElementById("email2").focus();
		return false;
	} else {
		var form = document.getElementById("findPW");
		form.action = "find_pwd";
		form.submit();
	}
}

function changePassword() {
	if (document.getElementById("pwd").value == "") {
		alert("비밀번호를 입력해 주세요");
		document.getElementById("pwd").focus();
		return false;
	} else if (document.getElementById("pwd").value
				!= document.getElementById("pwdcheck").value) {
		alert("비밀번호가 맞지 않습니다.");
		document.getElementById("pwd").focus();
		return false;
	} else {
		var form = document.getElementById("pwd_form");
		form.action = "change_pwd";
		form.submit();
	}
}


