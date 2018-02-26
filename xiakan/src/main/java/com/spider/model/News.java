package com.spider.model;
/**
 * 
 * 
 * @model: 新闻
 *
 */
public class News {
      public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	  
      @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.url+" "+this.title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
     public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	  private int id;    //id
	  private String url; //链接地址
      private String author; //作者
      private String title;//标题
      private String time;// 时间
}
