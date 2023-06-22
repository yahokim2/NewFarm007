package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.CartVO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 장바구니에 저장
	public void insertCart(CartVO vo) {
		
		mybatis.insert("CartMapper.insertCart", vo);
	}
	
	// 회원별 장바구니 내역 보기
	public List<CartVO> listCart(String id) {
		
		return mybatis.selectList("CartMapper.listCart", id);
	}
	
	// 장바구니에서 항목 삭제
	public void deleteCart(int ctseq) {
		
		mybatis.delete("CartMapper.deleteCart", ctseq);
	}
	
	// 장바구니 처리결과 업데이트
	public void updateCart(int cseq) {
		
		mybatis.update("CartMapper.updateCart", cseq);
	}
}






