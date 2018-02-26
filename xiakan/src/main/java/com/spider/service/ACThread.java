package com.spider.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spider.model.Media;
/**
 * @site:ACFUN ”∆µÕ¯’æ≈≈––
 * 
 * 
 */
public class ACThread implements Callable<List<Media>>{
  

	@Override
	public List<Media> call() throws Exception {
		List<Media> list=new ArrayList<Media>();
		try {
			
			Document doc = Jsoup.connect("http://www.acfun.cn/rank/").get();
    		Element e=doc.getElementById("unit-rank-0");
    		Elements e1=e.getElementsByClass("title");
    		for (Element link : e1) {
    			Media video=new Media();
    			  String linkHref = link.attr("href");
    			  String linkText = link.attr("title");
    			  video.setName(linkText);
    			  video.setUrl(linkHref);
    			  list.add(video);
    			  
    			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
