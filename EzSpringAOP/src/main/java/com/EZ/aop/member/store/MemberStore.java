package com.EZ.aop.member.store;

import com.EZ.aop.member.domain.MemberVO;

public interface MemberStore {

	int insertmember(MemberVO member);

	MemberVO CheckLogin(MemberVO member);

}
