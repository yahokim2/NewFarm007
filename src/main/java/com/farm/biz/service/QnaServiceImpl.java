package com.farm.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.QnaDAO;
import com.farm.biz.dto.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDAO qnaDao;
	
	@Override
	public List<QnaVO> getListQna(String id) {
		
		return qnaDao.listQna(id);
	}

	@Override
	public QnaVO getQna(int qseq) {
		
		return qnaDao.getQna(qseq);
	}

	@Override
	public void insertQna(QnaVO vo) {
		
		qnaDao.insertQna(vo);
	}

	@Override
	public List<QnaVO> listQna(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
