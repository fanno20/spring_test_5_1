package com.hsh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO {

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	//회원가입
	@Override
	public void join(MemberDTO memberDTO) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "insert into member2 values(?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.executeUpdate();
		st.close();
		con.close();
	}

	//로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "select * from member2 where id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			memberDTO.setName(rs.getString("name"));
		}else{
			memberDTO = null;
		}
		st.close();
		con.close();
		return memberDTO;
	}

	//회원정보수정
	@Override
	public MemberDTO update(MemberDTO memberDTO) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "update member2 set pw=?,name=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getName());
		st.setString(3, memberDTO.getId());
		if(st.executeUpdate() < 0){
			memberDTO = null;
		}
		st.close();
		con.close();
		return memberDTO;
	}

	//회원탈퇴
	@Override
	public int delete(MemberDTO memberDTO) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "delete member2 where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

}
