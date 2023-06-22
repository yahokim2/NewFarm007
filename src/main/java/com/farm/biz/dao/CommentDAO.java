package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.ProductCommentVO;

@Repository
public class CommentDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int saveComment(ProductCommentVO vo) {
		
		return mybatis.insert("CommentMapper.saveComment", vo);
	}
	
	public List<ProductCommentVO> listComment(int pdseq) {
		
		return mybatis.selectList("CommentMapper.commentList", pdseq);
	}
}





