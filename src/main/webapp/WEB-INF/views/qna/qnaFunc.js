/**
 *  게시판 글쓰기 창에 입력 여부 체크 후 저장
 */
function go_check_blank(){

	var q_w = document.getElementById("qna_write");
	var sbjt = document.getElementById("subject");
	var cntnt = document.getElementById("content");
	
	if(sbjt.value == ""){
		alert("제목을 입력해 주세요");
		sbjt.focus();		// 마우스를 찍은 상태를 focus 라고 함.
		
		return false;
	}else if(cntnt.value == ""){
		alert("내용을 입력해 주세요");
		cntnt.focus();		// 마우스를 찍은 상태를 focus 라고 함.
		
		return false;
	}
	else{
		q_w.action = "qna_write";
		q_w.submit();	// 콘트롤러로 데이터 전송
	}
}



