package com.hsh.member;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {
	
	//회원가입
	public void s_join(MemberDTO memberDTO);
	
	//로그인
	public void s_login(MemberDTO memberDTO,HttpServletRequest request);
	
	//로그아웃
	
	//회원정보수정
	
	//회원탈퇴

}
