package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.SalesQuantity;

@Repository
public class OrderDAO2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	/*
	 *  주문 전체 조회 메소드 추가
	 */
	public List<OrderVO> listOrder(String mname){
		
		return mybatis.selectList("OrderMapper2.listOrder", mname);
	}
	/*
	 *  주문상태 갱신 메소드 추가
	 */
	public void updateOrderResult(int odseq){
		
		mybatis.update("OrderMapper2.updateOrderResult", odseq);
	}

	/*
	 *  제품별 실적 조회
	 */
	public List<SalesQuantity> getProductSales(){
		
		return mybatis.selectList("OrderMapper2.listProductSales");
	}	
	
}











