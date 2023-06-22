package com.farm.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.CommentDAO;
import com.farm.biz.dto.ProductCommentVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public int saveComment(ProductCommentVO vo) {
		
		return commentDao.saveComment(vo);
	}

	public List<ProductCommentVO> getListComment(int pdseq) {
		
		return commentDao.listComment(pdseq);
	}

	public List<ProductCommentVO> listComment(int pdseq) {
		return commentDao.listComment(pdseq);
	}

}
