package com.hsh.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private DataSource dataSource;
	private int perPage = 10;
	
	/*//페이징
	@Override
	public Hashtable<String, Integer> getPage(int curPage) {
		int totla = getTotal(); //전체게시글수
		int totalPage = sum(totla,perPage); // 전체페이지수
		int perBlock = 5; // 한블럭당 페이지 수 
		int curBlock = sum(curPage, perBlock); // curPage가 속한 블럭번호
		int start = (curBlock - 1) * perBlock + 1; // 블럭의 시작 번호
		int last = curBlock * perBlock; // 블럭의 마지막 번호
		int totalBlock = sum(totalPage, perBlock); // 전체 블럭 수
		if(curBlock == totalBlock){
			last = totalBlock;
		}
		Hashtable<String, Integer> hs = new Hashtable<>();
		hs.put("start", start);
		hs.put("last", last);
		hs.put("totalBlock", totalBlock);
		hs.put("curBlock", curBlock);
		return hs;
	}
	
	//페이징 계산
	private int sum(int num1, int num2) {
		int result = 0;
		if (num1 % num2 == 0) {
			result = num1 / num2;
		} else {
			result = num1 / num2 + 1;
		}
		return result;
	}*/

	//전체 게시물 수 
	@Override
	public int getTotal() throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "select count(num) from NOTICE_BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		int result = 0;
		if(rs.next()){
			result = rs.getInt(1);
		}
		rs.close();
		st.close();
		con.close();
		return result;
	}
	/*public int getTotal(){
		int result = 0;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(num) from NOTICE_BOARD";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}*/
	
	//글목록
	@Override
	public List<BoardDTO> list(int startNum, int lastNum) throws SQLException {
		ArrayList<BoardDTO> list = new ArrayList<>();
		/*int start = (curPage-1)* PER_PAGE;
		int last = PER_PAGE * curPage;*/
		Connection con = dataSource.getConnection();
		String sql = "select * from (select rownum R, A.* from "
					+ "(select * from NOTICE_BOARD order by num)A )"
					+ " where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, startNum);
		st.setInt(2, lastNum);
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			BoardDTO bdDto = new BoardDTO();
			bdDto.setNum(rs.getInt("num"));
			bdDto.setWriter(rs.getString("writer"));
			bdDto.setTitle(rs.getString("title"));
			bdDto.setContents(rs.getString("contents"));
			bdDto.setCounts(rs.getInt("counts"));
			bdDto.setReg_date(rs.getDate("reg_date"));
			list.add(bdDto);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	//글한개보기
	@Override
	public BoardDTO view(BoardDTO bdDto) throws SQLException{
		Connection con = dataSource.getConnection();
		String sql = "select * from NOTICE_BOARD where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bdDto.getNum());
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			bdDto.setNum(rs.getInt("num"));
			bdDto.setWriter(rs.getString("writer"));
			bdDto.setTitle(rs.getString("title"));
			bdDto.setContents(rs.getString("contents"));
			bdDto.setCounts(rs.getInt("counts"));
			bdDto.setReg_date(rs.getDate("reg_date"));
		}else{
			bdDto = null;
		}
		rs.close();
		st.close();
		con.close();
		return bdDto;
	}

	//글삭제
	@Override
	public int delete(int num) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "delete NOTICE_BOARD where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	//글수정
	@Override
	public int update(BoardDTO bdDto) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "update NOTICE_BOARD set title=?, contents=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bdDto.getTitle());
		st.setString(2, bdDto.getContents());
		st.setInt(3, bdDto.getNum());
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	//글쓰기
	@Override
	public int insert(BoardDTO bdDto) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "insert into NOTICE_BOARD values(NOTICE_SEQ.nextVal,?,?,?,0,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bdDto.getWriter());
		st.setString(2, bdDto.getTitle());
		st.setString(3, bdDto.getContents());
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}


}
