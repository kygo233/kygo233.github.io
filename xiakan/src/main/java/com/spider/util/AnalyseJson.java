package com.spider.util;
/*
 * 
 * 
 * @version 2017��4��8�� 06:15:24 
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
			// ����һ��matcher������ƥ��
			Matcher matcher = pattern.matcher(targetStr);
			// ����ҵ���
			while (matcher.find()) {
		        
				System.out.println(matcher.group(1));
			}
			if (list.isEmpty())
				System.out.println("δƥ�䵽");
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
