package com.diworksdev.webproj5.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj5.dto.InquiryDTO;
import com.diworksdev.webproj5.util.DBConnector;

public class InquiryCompleteDAO {
	
	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
	
	public List<InquiryDTO> select() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		String sql = "select * from inquiry";
		try {
			PreparedStatemnt ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inquiryDTOList;
	}
	
	public int insert(String name, String qtype, String body) {
		int ret = 0;
	}

}
