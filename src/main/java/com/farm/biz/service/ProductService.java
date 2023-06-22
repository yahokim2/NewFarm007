package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.ProductVO;

import utils.Criteria;

public interface ProductService {

	// 신상품 목록 얻어오기
	List<ProductVO> getNewProductList();

	// 베스트 상품 목록 얻어오기
	List<ProductVO> getBestProductList();

	// 상품번호로 하나의 상품정보 얻어오기
	ProductVO getProduct(ProductVO vo);

	// 상품 종류별 상품 목록 얻어오기
	List<ProductVO> getProductListByKind(String kind);
	
	//---hjh0620 추가 ---
	List<ProductVO> 
	getListProductWithPaging(Criteria criteria, String name);

	int countProductList(String name);
	
	List<ProductVO> getListProduct(String name);

	void insertProduct(ProductVO vo);

	void updateProduct(ProductVO vo);
	//------------------
}
