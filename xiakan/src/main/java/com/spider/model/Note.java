package com.spider.model;

public class Note {
   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
   public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
   private int id;
   
   private String title;
   private String content;
   private int state ;
}
