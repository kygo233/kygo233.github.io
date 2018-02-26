package com.spider.service;

import java.util.List;

import com.spider.dao.imp.RecordDaoImp;
import com.spider.model.Record;



public class RecordService {

	public boolean add(String url, String title, String category,int user_id) {
		return new RecordDaoImp().add(url, title, category, user_id);
		
	}

	public List<Record> getRecord(int user_id) {
		// TODO Auto-generated method stub
		return new RecordDaoImp().getRecord(user_id);
	}

}
