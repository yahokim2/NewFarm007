package com.farm.biz.service;

import java.util.List;

import com.farm.biz.dto.AddressVO;
import com.farm.biz.dto.MemberVO;

public interface MemberService {

	//  id를 조건으로 사용자 정보 조회 --> member-mapping.xml를 통해서 매핑
	MemberVO getMember(String id);

	// 회원 존재 여부 조회
	int confirmID(String id);

	//	
	//	 회원 로그인 인증 
	//	 입력 파라미터 : vo - 화면 입력데이터 (id, pwd)
	//	   - 리턴값:  ID가 존재하고 비밀번호가 같으면 1, 다르면 0, ID가 존재하지 않으면 -1
	//	
	int loginID(MemberVO vo);

	void insertMember(MemberVO vo);

	List<AddressVO> selectAddressByDong(String dong);

	List<MemberVO> listMember(String name);	 // 관리자용
	void updateMemberUseyn(String userid);   // 관리자용	
	
	String selectIdByNameEmail(MemberVO vo);
	
	String selectPwdByIdNameEmail(MemberVO vo);
	
	void changePwd(MemberVO vo);

}