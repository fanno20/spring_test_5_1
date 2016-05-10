package com.hsh.p5;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		memberService.s_join(memberDTO,model);
		return "member/join";
	}
	
	@RequestMapping("loginF.me")
	public void loginF(){ }
	@RequestMapping("login.me")
	public String login(MemberDTO memberDTO,HttpSession session,Model model, RedirectAttributes redirectAttributes){
		memberService.s_login(memberDTO, session);
		redirectAttributes.addFlashAttribute("result", "로그인성공");
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
	public String update(MemberDTO memberDTO,HttpServletRequest request){
		memberService.s_update(memberDTO, request);
		return "redirect:/";
	}
	
	@RequestMapping("delete.me")
	public String delete(HttpServletRequest request){
		memberService.s_delete(request);
		return "redirect:/";
	}
	
}
