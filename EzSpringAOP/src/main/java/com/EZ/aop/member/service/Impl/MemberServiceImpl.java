package com.EZ.aop.member.service.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EZ.aop.member.domain.MemberVO;
import com.EZ.aop.member.service.MemberService;
import com.EZ.aop.member.store.MemberStore;
@Service
public class MemberServiceImpl implements MemberService{
@Autowired
private MemberStore mStore;

@Override
public int insertMember(MemberVO member) {
	int result = mStore.insertmember(member);
	return result;
}

@Override
public MemberVO CheckLogin(MemberVO member) {
	MemberVO result = mStore.CheckLogin(member);
	return result;
}


}
