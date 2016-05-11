package com.hsh.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Hashtable;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boarDAO;
	/*
	private final int perPage = 10;
	public void s_list(int curPage, Model model) {
		int startNum = (curPage-1)* perPage + 1;
		int lastNum = perPage * curPage;
		
		try {
			List<BoardDTO> list = boarDAO.list(startNum, lastNum);
			model.addAttribute("list", list);
			
			Hashtable<String, Integer> page = new Hashtable<>();
			page = boarDAO.getPage(curPage);
			model.addAttribute("page", page);
			
			//DAO 총카운트 조회
			int total = boarDAO.getTotal();
			BoardPageing bp = new BoardPageing();
			bp.setMember(curPage, perPage, total);
			model.addAttribute(bp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	//글목록
	@Override
	public void s_list(int curPage, Model model,int perPage) {
		int startNum = (curPage-1)* perPage + 1;
		int lastNum = perPage * curPage;
		
		try {
			List<BoardDTO> list = boarDAO.list(startNum, lastNum);
			model.addAttribute("list", list);
			
			/*Hashtable<String, Integer> page = new Hashtable<>();
			page = boarDAO.getPage(curPage);
			model.addAttribute("page", page);*/
			
			//DAO 총카운트 조회
			int total = boarDAO.getTotal();
			BoardPageing bp = new BoardPageing();
			bp.setMember(curPage, perPage, total);
			model.addAttribute(bp);
			model.addAttribute("perPage", perPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//글한개보기
	@Override
	public void s_view(int num, Model model) {
		try {
			BoardDTO bdDto = new BoardDTO();
			bdDto.setNum(num);
			bdDto = boarDAO.view(bdDto);
			model.addAttribute("bdDto", bdDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//jsonTest
	public List<BoardDTO> j_view(int num){/*BoardDTO*/
		List<BoardDTO> ar = null;
		/*BoardDTO bdDto = new BoardDTO();
		bdDto.setNum(num);*/
		try {
			ar = boarDAO.list(1, 5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	//xmlTest
	@Override
	public BoardDTO xml_view(int num) {
		BoardDTO bdDto = new BoardDTO();
		bdDto.setNum(num);
		try {
			bdDto = boarDAO.view(bdDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bdDto;
	}
	
	//글삭제
	@Override
	public void s_delete(int num) {
		try {
			int result = boarDAO.delete(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//글수정
	@Override
	public void s_update(BoardDTO bdDto) {
		try {
			int result = boarDAO.update(bdDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//글쓰기
	@Override
	public void s_write(BoardDTO bdDto) {
		try {
			int result = boarDAO.insert(bdDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
