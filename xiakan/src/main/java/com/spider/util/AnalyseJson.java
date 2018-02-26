package com.spider.util;
/*
 * 
 * 
 * @version 2017年4月8日 06:15:24 
 * 
 * */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.model.Media;


public class AnalyseJson {
	
	 static ArrayList<Media> RegexString(String targetStr, String patternStr) {
			ArrayList<Media> list = new ArrayList<Media>();
		
			Pattern pattern = Pattern.compile(patternStr,Pattern.DOTALL);
			// 定义一个matcher用来做匹配
			Matcher matcher = pattern.matcher(targetStr);
			// 如果找到了
			while (matcher.find()) {
		        
				System.out.println(matcher.group(1));
			}
			if (list.isEmpty())
				System.out.println("未匹配到");
			return list;
		}
	 
	 
//	public static ArrayList<Music> getStreamer(String json) {
////	//	String json=readTxtFile("C:\\Users\\ys\\Desktop\\json.txt");
////		String zzString = "\\({{1}.*?\\}{1}),";
////		ArrayList<Music> result = RegexString(json, zzString);
//////		for (Streamer streamer : result) {
//////			System.out.println(streamer.toString());
//////		}
////		return result;
//	}

}
