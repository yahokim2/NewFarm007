package com.farm.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.farm.biz.dto.CartVO;
import com.farm.biz.dto.MemberVO;
import com.farm.biz.dto.OrderVO;
import com.farm.biz.service.CartService;
import com.farm.biz.service.OrderService;

@Controller
public class MypageController {

	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/cart_insert")
	public String insertCart(CartVO vo, HttpSession session) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {
		// 로그인이 되어 있을 경우, 
		// 회원 ID를 설정하고 장바구니에 insert 수행
			vo.setUserid(loginUser.getUserid());
			
			cartService.insertCart(vo);
			
			return "redirect:cart_list";
		}
	}
	
	@GetMapping("/cart_list")
	public String listCart(HttpSession session, Model model) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {		
			// 로그인이 되어있으면 cartService의 장바구니 목록 실행
			List<CartVO> cartList = cartService.listCart(loginUser.getUserid());
		
			// 장바구니 총액 계산
			int totalAmount = 0;
			for(CartVO vo : cartList) {
				totalAmount += vo.getQuantity() * vo.getPrice2();
			}
		
			// model 객체에 데이터 저장하여 jsp에 전달
			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalAmount);
		
			return "mypage/cartList";
		}
	}
	
	@PostMapping("/cart_delete")
	public String cartDelete(@RequestParam(value="ctseq") int[] ctseq) {
		
		for(int i=0; i<ctseq.length; i++) {
			System.out.println(ctseq[i]);
			cartService.deleteCart(ctseq[i]);
		}
		
		return "redirect:cart_list";
	}
	
	/*
	 * 장바구니에서 주문처리를 하기위한 메소드
	 */
	@PostMapping("/order_insert")
	public String orderInsert(HttpSession session, OrderVO order, RedirectAttributes reAttr) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {
			// OrderVO 객체에 id를 저장
			order.setUserid(loginUser.getUserid());
			
			int orseq = orderService.insertOrder(order);
			
			// 주문확인 화면을 표시하기 위해 주문번호(oseq) 전달
			// addAttribute는 GET방식이며 새로고침을 해도 유지되는 데이터 전송
			// addFlashAttribute는 POST방식이며 새로고침을 해도 유지되지 않는다.
			reAttr.addAttribute("orseq", orseq);
			
			return "redirect:order_list";
		}
	}
	
	/*
	 * 주문처리 화면 표시
	 */
	@GetMapping("/order_list")
	public String orderListView(HttpSession session, OrderVO vo, Model model) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {
			// oseq는 insert_order에서 전달된 데이터가 
			// command 객체에 저장되어 있음
			vo.setUserid(loginUser.getUserid());
			vo.setResult("1");  // 처리결과: '미처리' 만 조회
			
			// 로그인한 회원의 방금 전에 처리한 주문 내역을 조회
			List<OrderVO> orderList = orderService.getListOrderById(vo);
			
			// 주문 총액 계산
			int totalAmount = 0;
			for(OrderVO order : orderList) {
				totalAmount += order.getQuantity() * order.getPrice2();
			}
			
			// 화면에 표시할 데이터 저장
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalAmount);
			
			
			return "mypage/orderList";
		}
	}
	
	/*
	 * 진행중인 주문 내역 요청 처리  (참고: 진행중인 주문내역 처리)
	 */
	@GetMapping("/mypage")
	public String myPageView(HttpSession session, OrderVO vo, Model model) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null){
			return "member/login";
		} else {
			
			// (1) 진행중인 주문번호 목록 조회
			vo.setUserid(loginUser.getUserid());
			vo.setResult("1");
			List<Integer> orseqList = orderService.getSeqOrdering(vo);
			
			// (2) 위의 각 주문번호에 대해 주문정보를 조회하고
			//     요약 정보를 생성한다.
			List<OrderVO> summaryList = new ArrayList<>(); // 주문 요약정보 저장 목록 
			for(int orseq : orseqList) {
				// (2-1) 각 주문번호의 주문내역 조회
				OrderVO order = new OrderVO();
				
				order.setUserid(loginUser.getUserid());
				order.setOrseq(orseq);
				order.setResult("1");  // 처리결과: '미처리'
				// 주문번호별 주문목록
				List<OrderVO> orderList = orderService.getListOrderById(order);
				
				// (2-2) 각 주문요약 정보 생성
				OrderVO summary = new OrderVO();  // 요약정보 저장 변수
				summary.setOrseq(orderList.get(0).getOrseq()); // 첫번째 요소 주문번호 저장
				summary.setIndate(orderList.get(0).getIndate());
				
				// 상품명 요약정보 생성
				if (orderList.size() >= 2) {
					summary.setPname(orderList.get(0).getPname() + " 외 " + (orderList.size()-1) + " 건");
				} else {  // 주문에 포함된 상품이 1개임.
					summary.setPname(orderList.get(0).getPname());
				}
				
				// 각 주문별 합계금액
				int amount = 0;
				for (OrderVO item : orderList) {
					amount += item.getQuantity() * item.getPrice2();
				}
				summary.setPrice2(amount);  // 합계금액 저장
				
				// 각 주문요약 정보를 리스트에 추가
				summaryList.add(summary);
			}
			
			// (3) 화면에 전달한 데이터를 저장
			model.addAttribute("orderList", summaryList);
			model.addAttribute("title", "진행 중");
		}
		
		return "mypage/mypage";
	}
	
	/*
	 * 주문 상세 정보 표시 처리
	 */
	@GetMapping("/order_detail")
	public String orderDetailView(OrderVO vo, HttpSession session, Model model) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {
			// (1) 주문번호에 대한 주문목록 조회
			vo.setUserid(loginUser.getUserid());
			vo.setResult("");  // 처리결과: 미처리, 처리 모두 조회
			List<OrderVO> orderList = orderService.getListOrderById(vo);
			
			// (2) 주문자 정보 생성 
			OrderVO orderDetail = new OrderVO();
			orderDetail.setOrseq(orderList.get(0).getOrseq());
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setMname(orderList.get(0).getMname());
			
			// (3) 주문총액 계산
			int totalAmount = 0;
			for(int i=0; i<orderList.size(); i++) {
				totalAmount += orderList.get(i).getQuantity()
								* orderList.get(i).getPrice2();
			}
			
			// (4) 화면에 표시할 정보 저장
			model.addAttribute("title", "마이 쇼핑(주문 상세 정보)");
			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("totalPrice", totalAmount);
			model.addAttribute("orderList", orderList);
			
			// (5) mypage 화면 호출
			return "mypage/orderDetail";
		}
	}
	
	/*
	 * 전체 주문내역(처리, 미처리 포함) 표시 처리  (참고: 총 주문 내역 처리)
	 */
	@GetMapping("/order_all")
	public String orderAllView(OrderVO vo, HttpSession session, Model model) {
		// 로그인이 되어 있는지 확인. 
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {
			
			// (1) 진행중인 주문번호 목록 조회
			vo.setUserid(loginUser.getUserid());
			vo.setResult("");  // 모든 처리결과 조회
			List<Integer> orseqList = orderService.getSeqOrdering(vo);
			
			// (2) 위의 각 주문번호에 대해 주문정보를 조회하고
			//     요약 정보를 생성한다.
			List<OrderVO> summaryList = new ArrayList<>(); // 주문 요약정보 저장 목록 
			for(int orseq : orseqList) {
				// (2-1) 각 주문번호의 주문내역 조회
				OrderVO order = new OrderVO();
				
				order.setUserid(loginUser.getUserid());
				order.setOrseq(orseq);
				order.setResult("");  // 처리결과: '처리,미처리 모두 포함'
				// 주문번호별 주문목록
				List<OrderVO> orderList = orderService.getListOrderById(order);
				
				// (2-2) 각 주문요약 정보 생성
				OrderVO summary = new OrderVO();  // 요약정보 저장 변수
				summary.setOrseq(orderList.get(0).getOrseq()); // 첫번째 요소 주문번호 저장
				summary.setIndate(orderList.get(0).getIndate());
				
				// 상품명 요약정보 생성
				if (orderList.size() >= 2) {
				 	summary.setPname(orderList.get(0).getPname() + " 외 " + (orderList.size()-1) + " 건");
				} else {  // 주문에 포함된 상품이 1개임.
					summary.setPname(orderList.get(0).getPname());
				}
				
				// 각 주문별 합계금액
				int amount = 0;
				for (OrderVO item : orderList) {
					amount += item.getQuantity() * item.getPrice2();
				}
				summary.setPrice2(amount);  // 합계금액 저장
				
				// 각 주문요약 정보를 리스트에 추가
				summaryList.add(summary);
			}
			
			// (3) 화면에 전달한 데이터를 저장
			model.addAttribute("orderList", summaryList);
			model.addAttribute("title", "전체 리스트");
		}
		
		return "mypage/mypage";		
	}	
	/******************************************************************************
	 * 바로구매 처리하기 위한 메소드 (hjh-0615)(<- 장바구니에서 주문처리를 하기위한 메소드)
	 */
	@PostMapping("/order_dir_insert")
	public String orderDirInsert(HttpSession session, OrderVO order, RedirectAttributes reAttr) {
		// 로그인이 되어 있는지 확인. 
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인이 안되어 있는 경우 로그인 페이지로 이동
		if (loginUser == null) {
			return "member/login";
		} else {
			// OrderVO 객체에 id를 저장
			order.setUserid(loginUser.getUserid());
			
			int orseq = orderService.insertDirOrder(order);
			
			// 주문확인 화면을 표시하기 위해 주문번호(oseq) 전달
			// addAttribute는 GET방식이며 새로고침을 해도 유지되는 데이터 전송
			// addFlashAttribute는 POST방식이며 새로고침을 해도 유지되지 않는다.
			reAttr.addAttribute("orseq", orseq);
			
			return "redirect:order_list";
		}
	}
	/**********************************************************************/


}













