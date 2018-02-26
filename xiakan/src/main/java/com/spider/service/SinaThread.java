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
 * @site:新浪新闻网站热点
 * 
 */
public class SinaThread  implements Callable<List<News>>{ 
	@Override
	public List<News> call() throws Exception {
		 List<News> list=new ArrayList<News>();
		 try {	
		    Document	doc = Jsoup.connect("http://news.sina.com.cn/china/").get();
	 		Elements e=doc.getElementsByClass("blk122");
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
