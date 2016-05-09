package com.hsh.member;

import java.sql.SQLException;

public interface MemberDAO {

	//회원가입
	public void join(MemberDTO memberDTO) throws SQLException;
	
	//로그인
	public MemberDTO login(MemberDTO memberDTO) throws SQLException;
	
	//정보수정
	
	//회원탈퇴
	
	
}
