package com.badminton.service.impl;


import java.util.ArrayList;

import com.badminton.dao.UserDao;
import com.badminton.dao.impl.UserDaoImpl;
import com.badminton.entity.User;
import com.badminton.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userdao=new UserDaoImpl();
	@Override
	public boolean userAdd(int userid,String username,String password,String role){
		// TODO Auto-generated method stub
		return userdao.userAdd(userid,username,password,role);
	}

	@Override
	public ArrayList<User> userList() {
		// TODO Auto-generated method stub
		return userdao.userList();
	}
	
	@Override
	public ArrayList<User> userList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userDel(int userid) {
		// TODO Auto-generated method stub
		return userdao.userDel(userid);
	}



}
