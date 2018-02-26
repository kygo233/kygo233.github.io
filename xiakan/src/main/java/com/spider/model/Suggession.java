package com.spider.model;

import java.sql.Date;

public class Suggession {
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private int id;        //留言id
    private String content;//留言内容
    private Date time;     //留言时间
    private int  user_id ; //用户id
}
