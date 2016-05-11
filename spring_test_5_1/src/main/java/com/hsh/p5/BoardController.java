package com.hsh.p5;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsh.board.BoardDTO;
import com.hsh.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public void c_list(int curPage, Model model,int perPage){
		boardService.s_list(curPage, model, perPage);
		
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
	
	@RequestMapping("/jsonTest")
	public void getJson(){ }
	
	@RequestMapping("/jsontest")
	@ResponseBody
	public List<BoardDTO> getJson_board(){
		return boardService.j_view(1);
	}
	
	@RequestMapping("/xmlTest")
	public void getXml(){ }
	
	@RequestMapping("/xmltest")
	@ResponseBody
	public BoardDTO getXml_board(){
		return boardService.xml_view(1);
	}
}







