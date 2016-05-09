package com.hsh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private DataSource dataSource;
	
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
		// TODO Auto-generated method stub
		return null;
	}

}
