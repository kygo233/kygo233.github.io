package com.spider.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * 
 * 
 * 
 * */
public class DBManage {
public	static Connection conn = null;
public	static PreparedStatement psst = null;
public	static ResultSet rs = null;
	public static  void Conn() { // 建立连接
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/spider?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT", "root", "123456");
//			if(conn==null){System.out.println("连接失败");}
//			else{System.out.println("连接成功");}
	    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void Close() { // 关闭数据库
		try {
			if (rs != null)
				rs.close();
			if (psst != null)
				psst.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

