package com.farm.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.ProductVO;

import utils.Criteria;

@Repository
public class ProductDAO  {

	@Autowired
	SqlSessionTemplate mybatis;		//  MyBatis는 데이터베이스 연동 작업을 보다 쉽고 간편하게 수행할 수 있도록 도와주는 프레임워크 임.

	// 신상품 목록 얻어오기
	public List<ProductVO> getNewProductList() {

		return mybatis.selectList("ProductMapper.getNewProductList");
	}
	// 베스트 상품 목록 얻어오기
	public List<ProductVO> getBestProductList() {

		return mybatis.selectList("ProductMapper.getBestProductList");
	}
	// 상품번호로 하나의 상품정보 얻어오기
	public ProductVO getProduct(ProductVO vo) {

		return mybatis.selectOne("ProductMapper.getProduct", vo);
	}
	// 상품 종류별 상품 목록 얻어오기 (????)
	public List<ProductVO> getProductListByKind(String kind) {

		return mybatis.selectList("ProductMapper.getProductListByKind", kind);
	}

	//--- hjh0620 추가 -----
	/*
	 * 전체 상품목록에 대한 상품 갯수 조회
	 * 입력 파라미터:
	 * 		name : 검색할 상품명 (값이 ""인 경우 전체 상품갯수 조회)
	 */
	public int countProductList(String name) {
		
		return mybatis.selectOne("ProductMapper.countProductList", name);
	}
	
	public List<ProductVO> listProduct(String name) {
		
		return mybatis.selectList("ProductMapper.listProduct", name);
	}
	
	/*
	 * 페이지별 상품 목록 조회
	 * 입력 파라미터:
	 * 		Criteria - 현재 페이지 정보
	 * 		name - 상품명 검색어
	 */
	public List<ProductVO> listProductWithPaging(Criteria criteria, String name) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("name", name);
		
		return mybatis.selectList("ProductMapper.listProductWithPaging", map);
	}

	public void insertProduct(ProductVO vo){
		
		mybatis.insert("ProductMapper.insertProduct", vo);
	}
	
	public void updateProduct(ProductVO vo) {
		
		mybatis.update("ProductMapper.updateProduct", vo);
	}
	//--------------------

}
