package com.farm.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.biz.dao.AdminDAO;
import com.farm.biz.dto.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;
	
	@Override
	public int adminCheck(AdminVO vo) {
		String pwd_in_db = adminDao.adminCheck(vo.getAid());
		
		if (pwd_in_db == null) {
			return -1;	// 관리자 ID가 존재하지 않음
		} else if (pwd_in_db.equals(vo.getPwd())) {
			return 1;	// 정상적인 관리자 ID
		} else {
			return 0;	// 비밀번호 틀림
		}
	}

	@Override
	public AdminVO getAdmin(String id) {

		return adminDao.getAdmin(id);
	}



}
