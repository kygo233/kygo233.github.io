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
 * @site:3DM”Œœ∑Õ¯’æ–¬Œ≈
 * 
 * 
 */
public class DM3Thread  implements Callable<List<News>>{
	 
	@Override
	public List<News> call() throws Exception {
		 List<News> list=new ArrayList<News>();
		 try {	
		    Document	doc = Jsoup.connect("http://www.3dmgame.com/").get();
	 		Element e1=doc.getElementById("previous");
	 		Element e2=doc.getElementById("next");
	 		Element e3=doc.getElementById("next2");
	 		Elements f=e1.select("a");
	 	//	System.out.println(e1);
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
