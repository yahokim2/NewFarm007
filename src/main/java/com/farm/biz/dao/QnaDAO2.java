package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.QnaVO;

@Repository
public class QnaDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 게시판 목록 
	public List<QnaVO> listAllQna(){
		
		return mybatis.selectList("QnaMapper2.listAllQna");
	}
	// 게시판 답변 처리  
	public void updateQna(QnaVO vo){
		
		mybatis.update("QnaMapper2.updateQna", vo);
	}	
}
