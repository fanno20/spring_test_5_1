package com.hsh.board;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

public interface BoardDAO {
	//글목록
	public List<BoardDTO> list(int startNum, int lastNum) throws SQLException;

	//글한개보기
	public BoardDTO view(BoardDTO bdDto) throws SQLException;
	
	//글삭제
	public int delete(int num) throws SQLException;
	
	//글수정
	public int update(BoardDTO bdDto) throws SQLException;
	
	//글수정
	public int insert(BoardDTO bdDto) throws SQLException;
	
	/*//페이징
	public Hashtable<String, Integer> getPage(int curPage);*/
	
	//전체 게시물 수 
	public int getTotal() throws SQLException;
}
