package com.spider.service;

import java.util.List;

import com.spider.dao.imp.SugDaoImp;
import com.spider.model.Suggession;

public class SugService {

	public List<Suggession> getsug() {
		// TODO Auto-generated method stub
		return new SugDaoImp().getSug();
	}

	public Boolean addsug(String content) {
		// TODO Auto-generated method stub
		return new SugDaoImp().add(content);
	}

}
