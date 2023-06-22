package com.farm.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.biz.dto.AddressVO;
import com.farm.biz.dto.MemberVO;

@Repository		// DB접근하므로 Controller에서 호출할 때 사용하려면 해 둔다.
public class MemberDAO2 {

	@Autowired	// 의존성 주입을 하기 위해서
	private SqlSessionTemplate mybatis;		//  MyBatis는 데이터베이스 연동 작업을 보다 쉽고 간편하게 수행할 수 있도록 도와주는 프레임워크 임.

	/* 회원 목록 조회 */
	public List<MemberVO> listMember(String name) {
		
		return mybatis.selectList("MemberMapper2.listMember", name);
	}

	/* 회원 사용구분 변경 (사용->미사용 */
	public void updateMemberUseyn(String userid) {
		
		mybatis.update("MemberMapper2.updateMemberUseyn", userid);
	}

	
}
