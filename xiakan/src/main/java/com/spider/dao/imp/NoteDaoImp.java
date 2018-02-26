package com.spider.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spider.dao.DBManage;
import com.spider.model.Note;

public class NoteDaoImp extends DBManage{
	public boolean  add(String title,String content) {  //添加公告
		try {
			Conn();
			String sql = "insert into  note  values (null,?,?,0)";
			psst = conn.prepareStatement(sql);
			psst.setString(1, title);
			psst.setString(2, content);

			int n=psst.executeUpdate();
			if(n==1)
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
	
	
	
	public boolean  changeto1(int id) {  //修改公告
		try {
			Conn();
			String sql = "update note set state=1 where id=? ";
			psst = conn.prepareStatement(sql);
			psst.setInt(1, id);
			int n=psst.executeUpdate();
			if(n==1)
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
	public boolean  changeto0(int id) {  //修改公告
		try {
			Conn();
			String sql = "update note set state=0 where id=? ";
			psst = conn.prepareStatement(sql);
			psst.setInt(1, id);
			int n=psst.executeUpdate();
			if(n==1)
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
	
	public Note  getCurNote() {  //查找当前公告
		 Note re=new Note();
		try {
			Conn();
			String sql = "select * from  note  where state=1";
			psst = conn.prepareStatement(sql);
			
			rs=psst.executeQuery();
			while(rs.next())
			{	
			   
			    re.setId(rs.getInt("id"));
			    re.setTitle(rs.getString("title"));
			    re.setContent(rs.getString("content"));
			    re.setState(rs.getInt("state"));			  

			}				
			return re;		
		} catch (SQLException e) {
			e.printStackTrace();
			return re;	
		} finally {
			Close();
		}
	}
	
	

	
	public List<Note>  getNote() {  //查找所有公告
		List<Note> rc=new ArrayList<Note>();
		
		try {
			Conn();
			String sql = "select * from  note  ";
			psst = conn.prepareStatement(sql);
			
			rs=psst.executeQuery();
			while(rs.next())
			{	
			    Note re=new Note();
			    re.setId(rs.getInt("id"));
			    re.setTitle(rs.getString("title"));
			    re.setContent(rs.getString("content"));
			    re.setState(rs.getInt("state"));
			    rc.add(re);

			}				
			return rc;		
		} catch (SQLException e) {
			e.printStackTrace();
			return rc;	
		} finally {
			Close();
		}
	}
}
