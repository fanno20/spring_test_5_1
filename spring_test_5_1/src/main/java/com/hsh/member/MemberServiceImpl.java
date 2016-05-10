package com.hsh.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

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
	public void s_join(MemberDTO memberDTO,Model model) {
		join2(memberDTO);
		model.addAttribute("message", "회원가입 완료");
	}
	
	public void join2(MemberDTO memberDTO){
		try {
			memberDAO.join(memberDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//로그인
	@Override
	public void s_login(MemberDTO memberDTO, HttpSession session) {
		try {
			memberDTO = memberDAO.login(memberDTO);
			if(memberDTO != null){
				session.setAttribute("member", memberDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//회원정보수정
	@Override
	public void s_update(MemberDTO memberDTO, HttpServletRequest request) {
		try {
			memberDTO = memberDAO.update(memberDTO);
			if(memberDTO != null){
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//회원탈퇴
	@Override
	public void s_delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		try {
			int result = memberDAO.delete(memberDTO);
			if(result > 0){
				session.invalidate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
