package com.farm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.biz.dto.MemberVO;
import com.farm.biz.dto.ProductCommentVO;
import com.farm.biz.dto.ProductVO;
import com.farm.biz.service.CommentService;

@RestController		// 데이터를 리턴하는 콘트롤러
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService; 
	
	@GetMapping("/list")
	public Map<String, Object> commentList(ProductCommentVO vo) {
		Map<String, Object> commentInfo = new HashMap<>();
		
		// 상품평 목록 조회
		List<ProductCommentVO> commentList = commentService.getListComment(vo.getPdseq());
		
		commentInfo.put("total", commentList.size());
		commentInfo.put("commentList", commentList);
		
		return commentInfo;
	}
	
	@PostMapping("/save")
	public String saveComments(ProductCommentVO vo, HttpSession session) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "not_logedin";
		} else {
			vo.setWriter(loginUser.getUserid());
			
			if (commentService.saveComment(vo) > 0) {
				
				return "success";
			} else {
				
				return "fail";
			}
		}
	}

}







