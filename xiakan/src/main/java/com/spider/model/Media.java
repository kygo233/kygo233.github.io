package com.spider.model;
/**
 * 
 * 
 * @model:��Ƶ������
 * 
 */
public class Media {
	
	
	  private int id;             // 
      private String name;        //  ��Ƶ���ƻ����
      private String url;         //   
      private String imgurl;       //  ����URl
      private String author;       //   ��Ƶ���߻����
      private String duration;       //   ����ʱ��
      
      @Override
  	public String toString() {
  		
  		return this.url+" "+this.name+" "+this.author+" "+this.getDuration();
  	}
      public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
      
      
}
