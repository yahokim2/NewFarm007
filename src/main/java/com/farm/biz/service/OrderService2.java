package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.SalesQuantity;

public interface OrderService2 {

	List<OrderVO> getListOrder(String mname);
	
	void updateOrderResult(int ordetailseq);
	
	List<SalesQuantity> getProductSales();
	
}