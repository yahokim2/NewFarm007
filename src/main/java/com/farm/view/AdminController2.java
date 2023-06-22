package com.farm.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.farm.biz.dto.MemberVO;
import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.QnaVO;
import com.farm.biz.dto.SalesQuantity;
import com.farm.biz.service.MemberService;
import com.farm.biz.service.OrderService2;
import com.farm.biz.service.QnaService;
import com.farm.biz.service.QnaService2;

@Controller
@SessionAttributes("/admin")
public class AdminController2 {


	@Autowired
	private OrderService2 orderService2;		
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private QnaService  qnaService;
	@Autowired
	private QnaService2 qnaService2;

	
	
	@RequestMapping("/admin_order_list")
	public String adminOrderList(
			@RequestParam(value="key", defaultValue="") String mname,
			Model model) {
		// System.out.println("admin_order_list ~~~~~~ mname : " + mname);
		
		List<OrderVO> orderList = orderService2.getListOrder(mname);
		
		model.addAttribute("orderList", orderList);
		
		return "/admin2/order/orderList";
	}
	
	/*
	 * 주문 완료 처리(입금 확인)
	 * 입력 파라미터:
	 * 		주문완료 처리한 result 항목의 상세주문번호(ordetailseq) 배열이 전달됨
	 */
	@PostMapping("/admin_order_save")
	public String adminOrderSave(@RequestParam(value="result") int[] ordetailseq) {
		// System.out.println("admin_order_save ~~~~~~ ");
		
		for(int i=0; i<ordetailseq.length; i++) {
		//	System.out.println("ordetailseq [" + i + "] : " + ordetailseq[i]);

			orderService2.updateOrderResult(ordetailseq[i]);
		}
				
		return "redirect:admin_order_list";
	}
	
	
	@RequestMapping("/admin_member_list")	
	public String adminMemberList(
			@RequestParam(value="key", defaultValue="") String name,
			Model model) {
		// System.out.println("admin_member_list ~~~~~~ ");
		List<MemberVO> memberList = memberService.listMember(name);
		
		model.addAttribute("memberList", memberList);
		
		return "admin2/member/memberList";
	}
	
	@PostMapping("/admin_member_unused")
	public String adminMemberUnused(@RequestParam(value="useyn") String[] userid) {
		//System.out.println("admin_member_unused ~~~~~~ ");
		//System.out.println("userid.length  : " + userid.length);

		for(int i=0; i< userid.length; i++) {
		//System.out.println("userid [" + i + "] : " + userid[i]);
			memberService.updateMemberUseyn(userid[i]);
		}
		
		return "redirect:admin_member_list";
	}
	
	
	
	@GetMapping("/admin_qna_list")
	public String adminQnaList(Model model) {
		
		// System.out.println("admin_qna_list ~~~~~~ ");
		List<QnaVO> qnaList = qnaService2.listAllQna();
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin2/qna/qnaList";
	}
	
	@PostMapping("/admin_qna_detail")
	public String adminQnaDetail(QnaVO vo, Model model) {		
		
		// System.out.println("admin_qna_detail ~~~~~~ ");
		QnaVO qna = qnaService.getQna(vo.getQaseq());
		
		model.addAttribute("qnaVO", qna);
		
		return "admin2/qna/qnaDetail";
	}
	
	/*
	 * QnA 게시글 답변 작성
	 */
	@PostMapping("/admin_qna_repsave")
	public String adminQnaRepSave(QnaVO vo) {
		
		// System.out.println("admin_qna_repsave ~~~~~~ vo : " + vo);
		qnaService2.updateQna(vo);
		
		return "redirect:admin_qna_list";
	}
	
	@RequestMapping("/admin_sales_record_form")
	public String adminSalesRecordForm() {
		// System.out.println("admin_sales_record_form ~~~~~~ ");
		// 차트를 표시할 JSP 화면을 표시
		return "admin2/order/salesRecords";
	}
	
	@RequestMapping("/sales_record_chart")
	@ResponseBody
	public List<SalesQuantity> salesRecordChart() {
		
		// System.out.println("sales_record_chart ~~~~~~ ");
		List<SalesQuantity> listSales = orderService2.getProductSales();
		
		return listSales;
	}
	
}
