package com.hsh.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

/*@Service*/
public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

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
