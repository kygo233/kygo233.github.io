package com.spider.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spider.model.News;

public class SearchThread implements Callable<List<News>>{
     private String url;
     public  SearchThread(String keyword)
    {
    	this.url="http://news.baidu.com/ns?word="+keyword+"&tn=newsrss&sr=0&cl=2&rn=20&ct=0";
    }
	@Override
	public List<News> call() throws Exception {
		 List<News> list=new ArrayList<News>();
		 try {	
		    Document	doc = Jsoup.connect(url).get();
	 		Elements e=doc.getElementsByTag("item");
	 		for (Element link : e) {
	 			  News news=new News();
	 			 String title = link.select("title").first().text();
	 			 String url=link.select("link").first().text();
	 			 String author=link.select("author").first().text();
	 			 String time=link.select("pubDate").first().text();
	 			  news.setUrl(url);
	 			  news.setTitle(title);
	 			  news.setAuthor(author);
	 			  news.setTime(time);
	 			  list.add(news);
	 			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return list;
	}
	
		
}
