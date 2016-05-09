package com.hsh.p5;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsh.member.MemberDTO;
import com.hsh.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping("joinF.me")
	public void joinF(){ }
	@RequestMapping("join.me")
	public String getJoin(MemberDTO memberDTO,Model model){
		memberService.s_join(memberDTO);
		model.addAttribute("message", "회원가입 완료");
		return "member/join";
	}
	
	@RequestMapping("loginF.me")
	public void loginF(){ }
	@RequestMapping("login.me")
	public String login(MemberDTO memberDTO){
		
		return "redirect:/";
	}
	
	@RequestMapping("logout.me")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("updateF.me")
	public void updateF(){ }
	@RequestMapping("update.me")
	public String update(MemberDTO memberDTO){
		
		return "redirect:/";
	}
	
	@RequestMapping("delete.me")
	public String delete(HttpSession session){
		
		return "redirect:/";
	}
	
}
