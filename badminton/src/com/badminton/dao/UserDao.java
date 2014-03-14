package com.badminton.dao;


import java.util.ArrayList;

import com.badminton.entity.User;

public interface UserDao {
	
	public boolean userAdd(int userid,String username,String password,String role) ;

	public ArrayList<User> userList();
	
	public ArrayList<User> userList(int currpage, int pagesize);

	public boolean userDel(int userid);

}
