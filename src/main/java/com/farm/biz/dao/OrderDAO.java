package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.SalesQuantity;

@Repository
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int selectMaxOseq() {
		
		return mybatis.selectOne("OrderMapper.selectMaxOseq");
	}
	
	public void insertOrder(OrderVO vo) {
		
		mybatis.insert("OrderMapper.insertOrder", vo);
	}
	
	public void insertOrderDetail(OrderVO vo) {
		
		mybatis.insert("OrderMapper.insertOrderDetail", vo);
	}
	
	public List<OrderVO> listOrderById(OrderVO vo) {
		
		return mybatis.selectList("OrderMapper.listOrderById", vo);
	}
	
	// 로그인한 사용자의 현재 진행중인 주문번호 목록 조회
	// 진행중은 result = '1'의 의미
	public List<Integer> getSeqOrdering(OrderVO vo) {
		
		return mybatis.selectList("OrderMapper.getSeqOrdering", vo);
	}
	
	
//	/*
//	 *  주문 전체 조회 메소드 추가
//	 */
//	public List<OrderVO> listOrder(String mname){
//		
//		return mybatis.selectList("OrderMapper.listOrder", mname);
//	}
//	/*
//	 *  주문상태 갱신 메소드 추가
//	 */
//	public void updateOrderResult(int odseq){
//		
//		mybatis.update("OrderMapper.updateOrderResult", odseq);
//	}
//
//	/*
//	 *  제품별 실적 조회
//	 */
//	public List<SalesQuantity> getProductSales(){
//		
//		return mybatis.selectList("OrderMapper.listProductSales");
//	}	
}











