package com.farm.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.farm.biz.dto.AddressVO;
import com.farm.biz.dto.MemberVO;
import com.farm.biz.service.MemberService;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	/*
	 * 약관화면 표시
	 */
	@GetMapping("/contract")
	public String contractView() {
		
		return "member/contract";
	}
	
	@PostMapping("/join_form")
	public String joinView() {
		 
		return "member/join";
	}
	//
	//로그인 화면 표시
	//
	@GetMapping("/login_form")
	public String loginView() {
		
		return "member/login";
	}
	//
	//로그인 처리
	//
	@PostMapping("/login")
	public String loginAction(MemberVO vo, Model model) {
		
		int result = memberService.loginID(vo);
		
		if(result == 1) {
			model.addAttribute("loginUser", memberService.getMember(vo.getUserid()));
			return "redirect:index";
		} else  {
			return "member/login_fail";
		}
	}
	//
	//로그아웃 처리
	//
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		
		return "member/login";
	}
	
	//
	// ID 중복체크 화면 표시 및 결과 전송
	//
	@GetMapping("/id_check_form")
	public String idCheckView(MemberVO vo, Model model) {
		// id 중복확인 조회
		System.out.println("GET------idcheck form --- vo" + vo + " //" + vo.getUserid());
		
		int result = memberService.confirmID(vo.getUserid());
		
		model.addAttribute("message", result);
		model.addAttribute("id", vo.getUserid());
		
		return "member/idcheck";
	}
	
	@PostMapping("/id_check_form")
	public String idCheckAction(MemberVO vo, Model model) {
		// id 중복확인 조회
		System.out.println("POST------idcheck form --- vo" + vo + " //" + vo.getUserid());
		int result = memberService.confirmID(vo.getUserid());
		
		model.addAttribute("message", result);
		model.addAttribute("id", vo.getUserid());
		
		return "member/idcheck";
	}	
	//	
	//	회원가입 처리
	//	
	@PostMapping("/join")
	public String joinAction(MemberVO vo,
			@RequestParam(value="addr1", defaultValue="") String addr1,
			@RequestParam(value="addr2", defaultValue="") String addr2) {
		
		vo.setAddress(addr1 + " "+ addr2);
		memberService.insertMember(vo);		
		
		return "member/login";
	}
	
	@GetMapping("/find_zip_num")
	public String findZipNumView() {
		
		return "member/findZipNum";
	}
	
	@PostMapping("/find_zip_num")
	public String  findZipNumAction(AddressVO vo, Model model) {
		
		List<AddressVO> addressList = memberService.selectAddressByDong(vo.getDong());
		
		model.addAttribute("addressList", addressList);
		
		return "member/findZipNum";
	}

	@GetMapping("/find_id_form") 
	public String findIdFormView() {
		// System.out.println("Get---find_id_form controller" );
		
		return "member/findIdAndPassword";
	}
	
	@PostMapping("/find_id")
	public String findIdAction(MemberVO vo, Model model) {
		// System.out.println("Get---find_id -- vo : " + vo);
		
		String userid = memberService.selectIdByNameEmail(vo);
		
		if(userid != null) {	// 아이디 존재
			model.addAttribute("id", userid);
			model.addAttribute("message", 1);
		}else {
			model.addAttribute("message", -1);
		}
		return "member/findResult";
	}
	
	@PostMapping("/find_pwd")
	public String findPwdAction(MemberVO vo, Model model) {
		
		// System.out.println("POST---find_pwd -- vo :" + vo);

		String pwd = memberService.selectPwdByIdNameEmail(vo);
		
		if(pwd != null) {	// 아이디 존재
			model.addAttribute("id", vo.getUserid());
			model.addAttribute("message", 1);
		}else {
			model.addAttribute("message", -1);
		}
		return "member/findPwdResult";
	}
	
	@PostMapping("/change_pwd")
	public String changePwdAction(MemberVO vo) {
		
		// System.out.println("POST---change_pwd -- vo : " + vo);
		
		memberService.changePwd(vo);;
		
		return "member/changePwdOk";
	}

	
}
