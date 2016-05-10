package com.hsh.board;

import org.springframework.ui.Model;

public interface BoardService {

	//글목록
	public void s_list(int curPage,Model model);
	
	//글한개보기
	public void s_view(int num, Model model);
	
	//글삭제
	public void s_delete(int num);
	
	//글수정
	public void s_update(BoardDTO bdDto);
	
	//글쓰기
	public void s_write(BoardDTO bdDto);
	
}
