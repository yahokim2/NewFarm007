package com.farm.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.CartDAO;
import com.farm.biz.dto.CartVO;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDao;
	
	@Override
	public void insertCart(CartVO vo) {
		
		cartDao.insertCart(vo);
	}

	@Override
	public List<CartVO> listCart(String id) {
		
		return cartDao.listCart(id);
	}

	@Override
	public void deleteCart(int ctseq) {
		
		cartDao.deleteCart(ctseq);
	}

	@Override
	public void updateCart(int ctseq) {
		
		cartDao.updateCart(ctseq);
	}

}
