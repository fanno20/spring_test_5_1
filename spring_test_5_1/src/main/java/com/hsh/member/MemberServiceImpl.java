package com.hsh.member;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	//회원가입
	@Override
	public void s_join(MemberDTO memberDTO) {
		join(memberDTO);
	}
	
	public void join(MemberDTO memberDTO){
		try {
			memberDAO.join(memberDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//로그인
	@Override
	public void s_login(MemberDTO memberDTO, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

}
