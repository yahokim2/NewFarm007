package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.QnaVO;

public interface QnaService {

	List<QnaVO> listQna(String id);

	QnaVO getQna(int qseq);

	void insertQna(QnaVO vo);

	List<QnaVO> getListQna(String id);

}