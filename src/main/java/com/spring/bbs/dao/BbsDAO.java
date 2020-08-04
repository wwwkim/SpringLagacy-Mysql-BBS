package com.spring.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.bbs.dto.BbsDTO;

@Repository
public class BbsDAO {

	private Connection conn;
	private ResultSet rs;

	public BbsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public String getDate(BbsDTO bbs) {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bbs.setBbsDate(rs.getString(1));
				
				return bbs.getBbsDate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";// DB error
	}

	public int getNext(BbsDTO bbs) {
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bbs.setBbsID(rs.getInt(1) + 1);
				return bbs.getBbsID();
			}
			return 1;// ç≈èâÇÃÉRÉìÉeÉìÉc

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// DB error
	}

	public int write(BbsDTO bbs) {
		String SQL = "INSERT INTO BBS VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext(bbs));
			pstmt.setString(2, bbs.getBbsTitle());
			pstmt.setString(3, bbs.getUserID());
			pstmt.setString(4, getDate(bbs));
			pstmt.setString(5, bbs.getBbsContent());
			pstmt.setInt(6, 1);

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//DB error
	}
	
	
}
