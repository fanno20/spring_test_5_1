package com.hsh.board;

import java.util.List;

import org.springframework.ui.Model;

public interface BoardService {

	//글목록
	public void s_list(int curPage,Model model, int perPage);
	
	//글한개보기
	public void s_view(int num, Model model);
	
	//글삭제
	public void s_delete(int num);
	
	//글수정
	public void s_update(BoardDTO bdDto);
	
	//글쓰기
	public void s_write(BoardDTO bdDto);
	
	//jsonTest
	public List<BoardDTO> j_view(int num);
	
	//xmlTest
	public BoardDTO xml_view(int num);
	
}
