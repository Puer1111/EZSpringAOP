package com.EZ.aop.member.store.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EZ.aop.member.domain.MemberVO;
import com.EZ.aop.member.store.MemberStore;
@Repository
public class MemberStoreImpl implements MemberStore{
@Autowired
private SqlSession session;

@Override
public int insertmember(MemberVO member) {
	int result=session.insert("MemberMapper.insertmember",member);
	return result;
}

@Override
public MemberVO CheckLogin(MemberVO member) {
	MemberVO result = session.selectOne("MemberMapper.checkLoginMember",member);
	return result;
}
	
	
}
