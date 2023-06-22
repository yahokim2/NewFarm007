package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.QnaVO;

@Repository
public class QnaDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<QnaVO> listQna(String id) {
		
		return mybatis.selectList("QnaMapper.listQna", id);
	}
	
	public QnaVO getQna(int qaseq) {
		
		return mybatis.selectOne("QnaMapper.getQna", qaseq);
	}
	
	public void insertQna(QnaVO vo) {
		
		mybatis.insert("QnaMapper.insertQna", vo);
	}
//	// 게시판 목록  #0522
//	public List<QnaVO> listAllQna(){
//		
//		return mybatis.selectList("QnaMapper.listAllQna");
//	}
//	// 게시판 답변 처리  #0522
//	public void updateQna(QnaVO vo){
//		
//		mybatis.update("QnaMapper.updateQna", vo);
//	}	
}
