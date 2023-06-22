package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.CartVO;

public interface CartService {

	// 장바구니에 저장
	void insertCart(CartVO vo);

	// 회원별 장바구니 내역 보기
	List<CartVO> listCart(String id);

	// 장바구니에서 항목 삭제
	void deleteCart(int ctseq);

	// 장바구니 처리결과 업데이트
	void updateCart(int ctseq);

}