package com.farm.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.OrderDAO;
import com.farm.biz.dto.CartVO;
import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.SalesQuantity;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired 
	private OrderDAO orderDao;
	@Autowired
	private CartService cartService;
	
	@Override
	public int selectMaxOseq() {
		
		return orderDao.selectMaxOseq();
	}

	@Override
	public int insertOrder(OrderVO vo) {
		// (1) 신규 주문 번호를 생성
		int orseq = selectMaxOseq();
		vo.setOrseq(orseq);
		
		// (2) 신규주문을 주문테이블에 저장
		orderDao.insertOrder(vo);
		
		// (3) 장바구니 목록을 읽어 order_detail 테이블에 저장
		List<CartVO> cartList = cartService.listCart(vo.getUserid());
		
		for (CartVO cart : cartList) {
			OrderVO order = new OrderVO();
			
			order.setOrseq(orseq);
			order.setPdseq(cart.getPdseq());
			order.setQuantity(cart.getQuantity());
			
			insertOrderDetail(order);
						
			/* 트랜잭션 처리 테스트
			if (true)
				throw new IllegalArgumentException("장바구니 데이터를 수정할 수 없습니다.");
			*/
			// 장바구니 테이블 업데이트(주문처리 결과 업데이트)
			cartService.updateCart(cart.getCtseq());
		}

		return orseq;
	
	}
//----다이렉트 주문 (hjh-0615)--------------------------------
	@Override
	public int insertDirOrder(OrderVO order) {
		// (1) 신규 주문 번호를 생성
		int orseq = selectMaxOseq();
		order.setOrseq(orseq);
		
		// (2) 신규주문을 주문테이블에 저장
		orderDao.insertOrder(order);		//입력 : orseq, userid

		order.setPdseq(order.getPdseq());
		order.setQuantity(order.getQuantity());
		
		insertOrderDetail(order);
					
		return orseq;
	
	}
//------------------------------------------
	
	@Override
	public void insertOrderDetail(OrderVO vo) {
		
		orderDao.insertOrderDetail(vo);
	}


	@Override
	public List<OrderVO> getListOrderById(OrderVO vo) {
		
		return orderDao.listOrderById(vo);
	}

	@Override
	public List<Integer> getSeqOrdering(OrderVO vo) {
		
		return orderDao.getSeqOrdering(vo);
	}

}
