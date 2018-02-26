package com.spider.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spider.model.Media;

/**
 * @site:Õ¯“◊‘∆“Ù¿÷ µ ±≈≈––
 * 
 */
public class WYYThread implements Callable<List<Media>> {
	private int id;

	public WYYThread(int id) {
		this.id = id;
	}

	@Override
	public List<Media> call() throws Exception {
		List<Media> list = new ArrayList<Media>();
		try {
			Document doc = Jsoup.connect(getUrl()).get();
		
			Elements e2 = doc.getElementsByTag("textarea");
			String s = e2.get(0).text();
			SimpleDateFormat sfFormat = new SimpleDateFormat("mm:ss");

			JsonParser parser = new JsonParser();
			JsonArray Jarray = parser.parse(s).getAsJsonArray();
			int m=1;
			for (JsonElement jsonElement : Jarray) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				Media media = new Media();
				String name="";
				if(jsonObject.get("alias").getAsJsonArray().size()==0)
				 
				{ name=jsonObject.get("name").getAsString();}
				else{
					
					name=jsonObject.get("name").getAsString() + "-(" + jsonObject.get("alias").getAsString() + ")";
				}		
				media.setName(name);
				media.setDuration(sfFormat.format(jsonObject.get("duration").getAsLong()));

				media.setUrl("http://music.163.com/song?id=" + jsonObject.get("id").getAsString());

				JsonArray Jarray1 = jsonObject.get("artists").getAsJsonArray();
				String author = "";
				if(Jarray1.size()==1)
				{
					author = author + Jarray1.get(0).getAsJsonObject().get("name").getAsString();
				}
				else{
				    for (JsonElement jsonElement1 : Jarray1) {
				    	
					    author = author + jsonElement1.getAsJsonObject().get("name").getAsString()+"/";
				    }
				    author=author.substring(0, author.length()-1);
				}
				media.setAuthor(author);
				media.setId(m);
				list.add(media);
				m++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getUrl() {
		switch (id) {
		case 1:
			return "http://music.163.com/discover/toplist?id=19723756";// ‘∆“Ù¿÷Ï≠…˝∞Ò
		case 2:
			return "http://music.163.com/discover/toplist?id=180106";// UK
		case 3:
			return "http://music.163.com/discover/toplist?id=60198";// BB
		case 4:
			return "http://music.163.com/discover/toplist?id=64016";// ÷–π˙TOP≈≈––∞Ò£®ƒ⁄µÿ∞Ò£©
		case 5:
			return "http://music.163.com/discover/toplist?id=10520166";// ‘∆“Ù¿÷µÁ“Ù∞Ò
		default:
			return "http://music.163.com/discover/toplist?id=19723756";
		}
	}
}