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
/**
 * @site:网易新闻网站热点
 * 
 */
public class WYNewsThread  implements Callable<List<News>>{
	 
	@Override
	public List<News> call() throws Exception {
		 List<News> list=new ArrayList<News>();
		 try {	
		    Document	doc = Jsoup.connect("http://news.163.com/").get();
	 		Element e=doc.getElementById("js_top_news");
	 		Elements f=e.select("a");
	
	 		for (Element link : f) {
	 			  News news=new News();
	 			  String linkHref = link.attr("href");
	 			  String linkText = link.text();
	 			  news.setUrl(linkHref);
	 			  news.setTitle(linkText);
	 			  list.add(news);
	 			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return list;
	}
}

