package com.spider.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spider.dao.DBManage;
import com.spider.model.Record;

public class RecordDaoImp extends DBManage{
	
	public boolean  add(String url, String title,String category,int user_id) {  //ÃÌº”‰Ø¿¿º«¬º
		try {
			Conn();
			String sql = "insert into  record  values (null,?,?,?,?,?)";
			psst = conn.prepareStatement(sql);
			psst.setInt(1, user_id);
			psst.setString(2, category);
			psst.setString(3, url);
			psst.setString(4, title);
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			java.sql.Date date=java.sql.Date.valueOf(sdf.format()) ;
			psst.setTimestamp(5,new java.sql.Timestamp(new java.util.Date().getTime()));
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
	
	
	public List<Record>  getRecord(int user_id) {  //≤È’“‰Ø¿¿º«¬º
		List<Record> rc=new ArrayList<Record>();
		
		try {
			Conn();
			String sql = "select * from  record  where user_id=? order by time desc";
			psst = conn.prepareStatement(sql);
			psst.setInt(1, user_id);
			rs=psst.executeQuery();
			while(rs.next())
			{	
			    Record re=new Record();
			    re.setCategory(rs.getString("category"));
			    re.setTitle(rs.getString("title"));
			    re.setUrl(rs.getString("url"));
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
