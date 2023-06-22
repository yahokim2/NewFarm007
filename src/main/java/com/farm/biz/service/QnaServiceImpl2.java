package com.farm.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.QnaDAO2;
import com.farm.biz.dto.QnaVO;

@Service
public class QnaServiceImpl2 implements QnaService2 {
	
	
	@Autowired
	private QnaDAO2 qnaDao2;

	@Override
	public List<QnaVO> listAllQna() {
		
		return qnaDao2.listAllQna();
	}

	@Override
	public void updateQna(QnaVO vo) {

		qnaDao2.updateQna(vo);
	}

}
