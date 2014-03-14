package com.badminton.service;

import java.util.ArrayList;

import com.badminton.entity.User;

public interface UserService {
	
	public boolean userAdd(int userid,String username,String password,String role) ;//����¼�¼

	public ArrayList<User> userList();
	
	public ArrayList<User> userList(int currpage, int pagesize);

	public boolean userDel(int userid);


}
