package com.farm.biz.service;

import com.farm.biz.dto.AdminVO;

public interface AdminService {

	AdminVO getAdmin(String id);

	int adminCheck(AdminVO vo);

}