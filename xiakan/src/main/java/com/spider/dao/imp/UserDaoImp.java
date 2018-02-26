package com.spider.dao.imp;

import java.sql.SQLException;

import com.spider.dao.DBManage;

public class UserDaoImp extends DBManage{
     
	public int  namecheck(String name) {  //检测用户名
		int id=0;
		Conn();
		String sql = "select id from  User where name=?";
		try {
			psst = conn.prepareStatement(sql);
			psst.setString(1, name);
			rs=psst.executeQuery();
			if(rs.next())
			{	id=rs.getInt("id");}
				
			return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		} finally {
			Close();
		}
	}
	
	public boolean logincheck(String name ,String password) {  //查找用户
		
		try {
			Conn();
			String sql = "select * from  User where name=? and password=? ";
			psst = conn.prepareStatement(sql);
			psst.setString(1, name);
			psst.setString(2, password);
			rs=psst.executeQuery();
			if (rs.next())
			{	System.out.println("正确");
				return true; }
			else
			{	return false;}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			Close();
		}
	}
	
	
	
	public boolean insert(String name ,String password) {  //插入用户
		Conn();
		String sql = "insert into User values (null,?,?) ";
		try {
			psst = conn.prepareStatement(sql);
			psst.setString(1, name);
			psst.setString(2, password);
			if(psst.executeUpdate()==1)
				 return true;
			else 
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			Close();
		}
	}
	
}
