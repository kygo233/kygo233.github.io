package com.spider.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spider.dao.DBManage;
import com.spider.model.Suggession;

public class SugDaoImp extends DBManage{
	public boolean  add(String content) {  //添加反馈
		try {
			Conn();
			String sql = "insert into  suggestion  values (null,?,?,null)";
			psst = conn.prepareStatement(sql);
			psst.setString(1, content);
			psst.setTimestamp(2,new java.sql.Timestamp(new java.util.Date().getTime()));

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
	
	
	
	
	

	
	public List<Suggession>  getSug() {  //查找所有公告
		List<Suggession> rc=new ArrayList<Suggession>();
		
		try {
			Conn();
			String sql = "select * from  suggestion  ";
			psst = conn.prepareStatement(sql);
			
			rs=psst.executeQuery();
			while(rs.next())
			{	
				Suggession re=new Suggession();
			    re.setId(rs.getInt("id"));
			    re.setContent(rs.getString("content"));
			    re.setTime(rs.getDate("time"));
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
