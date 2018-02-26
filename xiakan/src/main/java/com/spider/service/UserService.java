package com.spider.service;

import com.spider.dao.imp.UserDaoImp;

public class UserService {
    //¼ì²âµÇÂ¼
	public boolean logincheck(String name ,String password){
		
		return new UserDaoImp().logincheck(name, password);
	}
	
	 //¼ì²âÓÃ»§Ãû
		public int namecheck(String name){
			
			return new UserDaoImp().namecheck(name);
		}

		public boolean register(String name, String password) {
			// TODO Auto-generated method stub
			return new UserDaoImp().insert(name, password);
		}
}
