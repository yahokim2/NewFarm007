package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.SalesQuantity;

public interface OrderService {

	int selectMaxOseq();

	int insertOrder(OrderVO vo);

	void insertOrderDetail(OrderVO vo);
	
	List<OrderVO> getListOrderById(OrderVO vo);
	
	// 로그인한 사용자의 현재 진행중인 주문번호 목록 조회
	// 진행중은 result = '1'의 의미
	List<Integer> getSeqOrdering(OrderVO vo);

	//---hjh-0615---
	int insertDirOrder(OrderVO order);
	//===============
	
}