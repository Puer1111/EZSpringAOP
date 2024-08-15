package com.EZ.aop.member.service;

import com.EZ.aop.member.domain.MemberVO;

public interface MemberService {

	int insertMember(MemberVO member);

	MemberVO CheckLogin(MemberVO member);

}
