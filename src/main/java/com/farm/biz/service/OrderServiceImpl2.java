package com.farm.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.OrderDAO2;
import com.farm.biz.dto.OrderVO;
import com.farm.biz.dto.SalesQuantity;

@Service
public class OrderServiceImpl2 implements OrderService2 {

	@Autowired
	private OrderDAO2 orderDao2;
	
	@Override
	public List<OrderVO> getListOrder(String mname) {
		// TODO Auto-generated method stub
		return orderDao2.listOrder(mname);
	}

	@Override
	public void updateOrderResult(int ordetailseq) {
		
		orderDao2.updateOrderResult(ordetailseq);
	}

	@Override
	public List<SalesQuantity> getProductSales() {
		
		return orderDao2.getProductSales();
	}

}
