package com.spider.service;

import com.spider.dao.imp.UserDaoImp;

public class UserService {
    //����¼
	public boolean logincheck(String name ,String password){
		
		return new UserDaoImp().logincheck(name, password);
	}
	
	 //����û���
		public int namecheck(String name){
			
			return new UserDaoImp().namecheck(name);
		}

		public boolean register(String name, String password) {
			// TODO Auto-generated method stub
			return new UserDaoImp().insert(name, password);
		}
}
