package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.AddressVO;
import com.farm.biz.dto.MemberVO;

@Repository		// DB접근하므로 Controller에서 호출할 때 사용하려면 해 둔다.
public class MemberDAO {

	@Autowired	// 의존성 주입을 하기 위해서
	private SqlSessionTemplate mybatis;		//  MyBatis는 데이터베이스 연동 작업을 보다 쉽고 간편하게 수행할 수 있도록 도와주는 프레임워크 임.

	//  id를 조건으로 사용자 정보 조회 --> member-mapping.xml를 통해서 매핑
	public MemberVO getMember(String id) {
		
		return mybatis.selectOne("MemberMapper.getMember", id);
	}
	
	// 회원 존재 여부 조회
	public int confirmID(String id) {
		
		String pwd = mybatis.selectOne("MemberMapper.confirmID", id);
		
		if (pwd != null) {
			return 1;		// ID 존재함을 의미
		}
		else {
			return -1;
		}
	}
	//	
	//	 회원 로그인 인증 
	//	 입력 파라미터 : vo - 화면 입력데이터 (id, pwd)
	//	   - 리턴값:  ID가 존재하고 비밀번호가 같으면 1, 다르면 0, ID가 존재하지 않으면 -1
	//	
	public int loginID(MemberVO vo) {
		int result=-1;
		String pwd = mybatis.selectOne("MemberMapper.confirmID", vo);
		
		if(pwd == null) {
			result = -1;		// ID 존재하지 않음
		} else if (pwd.equals(vo.getPwd())) {	
			result = 1;		// 정상 로그인
		} else {	
			result = 0;		// 비밀번호 불일치
		}
		
		return result;
	}
	
	public void insertMember(MemberVO vo) {		// vo객체로 항목별로 다 입력함
		
		mybatis.insert("MemberMapper.insertMember", vo);
	}

	public List<AddressVO> selectAddressByDong(String dong) {
		
		return mybatis.selectList("MemberMapper.selectAddressByDong", dong);
	}
	// 회원 목록 #0522
	public List<MemberVO> listMember(String name) {
		
		return mybatis.selectList("MemberMapper.listMember", name);
	}	
	
	// 이름과 이메일로 아이디 찾기 #0522
	public String selectIdByNameEmail(MemberVO vo) {
		System.out.println("DAO 이름과 이메일로 아이디 찾기~~ vo : " + vo);
		return mybatis.selectOne("MemberMapper.selectIdByNameEmail", vo);
	}

	// 아이디, 이름, 이메일로 비밀번호 찾기 
	public String selectPwdByIdNameEmail(MemberVO vo) {
		
		return mybatis.selectOne("MemberMapper.selectPwdByIdNameEmail", vo);
	}	
	// 비밀번호 변경
	public void changePwd(MemberVO vo) {
		mybatis.update("MemberMapper.changePwd", vo);
	}

}
