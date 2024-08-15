package com.EZ.aop.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.EZ.aop.member.domain.MemberVO;
import com.EZ.aop.member.service.MemberService;

@Controller
public class MemberController {
@Autowired
MemberService mService;
	
@RequestMapping(value="/member/register.kh" ,method=RequestMethod.GET)
public String RegisterMember(Model model) {
	return "member/register";
}
@RequestMapping(value="/member/register.kh" ,method=RequestMethod.POST)
public String RegisterMember(@ModelAttribute MemberVO member)
{
 int result=mService.insertMember(member);	 
 return "redirect:/index.jsp";
}

@RequestMapping(value="/member/login.kh" ,method=RequestMethod.POST)
public String checkLogin(@RequestParam("memberId")String memberId,
		@RequestParam("memberPw")String memberPw,Model model,HttpSession session) {
	MemberVO member = new MemberVO();
	member.setMemberId(memberId);
	member.setMemberPw(memberPw);
	member = mService.CheckLogin(member);
	if(member!=null) {
	session.setAttribute("memberId", member.getMemberId());
	session.setAttribute("memberName", member.getMemberName());
		return "redirect:/index.jsp";	
	}else {
		model.addAttribute("msg","로그인 x ");
		return "common/errorPage";
	}
}
@RequestMapping(value="/member/logout.kh",method=RequestMethod.GET)
public String checkLogout(HttpSession session,Model model) {
	if(session!=null) {
		session.invalidate();
		return "redirect:/index.jsp";
	}else {
		model.addAttribute("msg","정보 x ");
		return "common/errorPage";
	}
}

}
