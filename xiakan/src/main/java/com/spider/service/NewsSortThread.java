package com.spider.service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spider.model.News;
/**
 * @site:新闻 分类
 * 
 */
public class NewsSortThread implements Callable<List<News>> {
		private int id=1;

		public NewsSortThread(int id) {
			this.id = id;
		}

		@Override
		public List<News> call() throws Exception {
			 List<News> list=new ArrayList<News>();
			 try {	
			    Document	doc = Jsoup.connect(getUrl()).get();
		 		Elements e=doc.getElementsByTag("item");
		 		
		 		for (Element link : e) {
		 			  News news=new News();
		 			 
		 			 String title = link.select("title").first().text();
		 			
		 			 String url=getRexurl(link.html());
		 			 String author=link.select("author").first().text();
		 			 String time=link.select("pubDate").first().text();
		 			  news.setUrl(url);
		 			
		 			  news.setTitle(title.substring(9, title.length()-3));
		 			  news.setAuthor(author);
		 			  news.setTime(time);
		 			 
		 			  list.add(news);
		 			}
				} catch (IOException e) {
					e.printStackTrace();
				}
			return list;
		}

		public String getUrl() {
			switch (id) {
			case 1:
				return "http://news.baidu.com/n?cmd=4&class=civilnews&tn=rss";// 国内									
			case 2:
				return "http://news.baidu.com/n?cmd=4&class=internews&tn=rss";// 国际
			case 3:
				return "http://news.baidu.com/n?cmd=4&class=mil&tn=rss";// 军事
			case 4:
				return "http://news.baidu.com/n?cmd=4&class=socianews&tn=rss";// 社会
			case 5:
				return "http://news.baidu.com/n?cmd=4&class=internet&tn=rss";// 互联网
			case 6:
				return "http://news.baidu.com/n?cmd=4&class=housenews&tn=rss";// 房产
			case 7:
				return "http://news.baidu.com/n?cmd=4&class=autonews&tn=rss";// 汽车
			case 8:
				return "http://news.baidu.com/n?cmd=4&class=sportnews&tn=rss";// 体育
			case 9:
				return "http://news.baidu.com/n?cmd=4&class=enternews&tn=rss";// 娱乐
			case 10:
				return "http://news.baidu.com/n?cmd=4&class=gamenews&tn=rss";// 游戏
			case 11:
				return "http://news.baidu.com/n?cmd=4&class=edunews&tn=rss";// 教育
				
			default:
				return "http://news.baidu.com/n?cmd=4&class=civilnews&tn=rss";
			}
		}
		
		 public  String getRexurl(String str)  
		    {  String rs="";
			 String  s1=str.replaceAll("\n", "").replaceAll(" " , "");
		        Pattern p=Pattern.compile("<link>(.*?)<description>");    
		        Matcher m=p.matcher(s1);    
		        while(m.find())  
		        {    
		          rs=m.group(1);    
		        }    
		      return rs;
		    }  
	}

