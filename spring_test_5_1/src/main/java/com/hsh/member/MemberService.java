package com.hsh.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface MemberService {
	
	//회원가입
	public void s_join(MemberDTO memberDTO,Model model);
	
	//로그인
	public void s_login(MemberDTO memberDTO,HttpSession session);
	
	
	//회원정보수정
	public void s_update(MemberDTO memberDTO,HttpServletRequest request);
	
	//회원탈퇴
	public void s_delete(HttpServletRequest request);
	
}
