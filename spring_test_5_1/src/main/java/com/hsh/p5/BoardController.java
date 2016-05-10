package com.hsh.p5;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsh.board.BoardDTO;
import com.hsh.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public void c_list(int curPage, Model model){
		boardService.s_list(curPage, model);
	}
	
	@RequestMapping("/view")
	public void c_view(int num, Model model){
		boardService.s_view(num, model);
	}
	
	@RequestMapping("/delete")
	public String c_delete(int num){
		boardService.s_delete(num);
		return "redirect:/board/list?curPage=1";
	}
	
	@RequestMapping("/updateF")
	public void updatef(int num, Model model){
		boardService.s_view(num, model);
	}
	
	@RequestMapping("/update")
	public String update(BoardDTO bdDto){
		boardService.s_update(bdDto);
		return "redirect:/board/view?num="+bdDto.getNum();
	}
	
	@RequestMapping("/writeF")
	public void writerF(){ }

	@RequestMapping("/write")
	public String writer(BoardDTO bdDto){
		boardService.s_write(bdDto);
		return "list?curPage=1";/*return "redirect:/board/list?curPage=1";*/
	}
	
}







