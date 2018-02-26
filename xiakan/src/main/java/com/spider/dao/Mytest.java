package com.spider.dao;

import java.sql.SQLException;

public class Mytest extends DBManage{

	public static void main(String[] args) {
		Conn();
		String sql = "select * from User";
		try {
			psst = conn.prepareStatement(sql);
			rs = psst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			Close();
		}
	}

}
