package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.QnaVO;

public interface QnaService2 {
	
	List<QnaVO> listAllQna();

	void updateQna(QnaVO vo);
	

}
