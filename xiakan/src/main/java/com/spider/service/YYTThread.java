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
 * @site:音悦台MV实时排行
 * 
 */
public class YYTThread implements Callable<List<Media>>{
   private int id;
   public  YYTThread(int id) {
	  this.id=id;
   }
	@Override
	public List<Media> call() throws Exception {
		List<Media> list=new ArrayList<Media>();
		try {
			Document doc = Jsoup.connect(getUrl()).get();
    		Element e=doc.getElementById("rankList");
    		Elements e1=e.getElementsByClass("mvname");
    		Elements e2=e.getElementsByClass("special");
    	//	System.out.println(e);

    		for (int i = 0; i < e1.size(); i++) {
    			Media video=new Media();
    			video.setName(e1.get(i).text());
				video.setUrl(e1.get(i).attr("href"));
				video.setAuthor(e2.get(i).text());
				list.add(video);
			}
//    		for (Element link : e1) {
//			Video video=new Video();
//			  String linkHref = link.attr("href");
//			  String linkText = link.text();
//			  video.setName(linkText);
//			  video.setUrl(linkHref);
//			  list.add(video);
//			  
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getUrl() {
		switch (id) {
		case 1:
			return "http://vchart.yinyuetai.com/vchart/trends?area=ML";
		case 2:
			return "http://vchart.yinyuetai.com/vchart/trends?area=HT";
		case 3:
			return "http://vchart.yinyuetai.com/vchart/trends?area=US";
		case 4:
			return "http://vchart.yinyuetai.com/vchart/trends?area=KR";
		case 5:
			return "http://vchart.yinyuetai.com/vchart/trends?area=JP";
		default:
			return "http://vchart.yinyuetai.com/vchart/trends?area=ML";
		}
	}
}
