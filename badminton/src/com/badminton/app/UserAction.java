package com.badminton.app;


import java.util.ArrayList;





import com.badminton.entity.User;
import com.badminton.service.UserService;
import com.badminton.service.impl.UserServiceImpl;

public class UserAction {
	UserService userservice=new UserServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean userAdd(int userid,String username,String password,String role){
		return userservice.userAdd(userid,username,password,role);
		}
	public ArrayList<User> userList() {
		return userservice.userList();
	}
	

	public ArrayList<User> userList(int currpage, int pagesize) {
		return null;
	}

	public boolean userDel(int userid) {
		return userservice.userDel(userid);

}
	}

