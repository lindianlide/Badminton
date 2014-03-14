package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.badminton.dao.UserDao;
import com.badminton.entity.User;
import com.badminton.utils.BaseDaoUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean userAdd(int userid,String username,String password,String role) {
		// TODO Auto-generated method stub
		String sql="insert into users(userid,username,password,role) values(?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(userid);
			arrylist.add(username);
			arrylist.add(password);
			arrylist.add(role);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	
	}

	public boolean userDel(int userid) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userid=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(userid);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	

	@Override
	public ArrayList<User> userList() {
		// TODO Auto-generated method stub
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		String sql="select * from users";
		ResultSet rs=null;
		ArrayList<User> arr = new ArrayList<User>();
		try{
			rs=baseDaoUtils.executeQuery(sql);
		while(rs.next())
		{
			User user=new User();
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));

			arr.add(user);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	
	}
	@Override
	public ArrayList<User> userList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		String sql = "select * from(select n.*,t.tname,rownum rn  from news n inner join newstitle t on n.id = t.id where rownum<="+currpage*pagesize+") where rn>"+(currpage-1)*pagesize+"";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<User> arrylist = new ArrayList<User>();
		ResultSet rs = null;
		User user = null;
		try {
			rs = baseDaoUtils.executeQuery(sql);
			while (rs.next()) {
				user = new User();
//				athlete.setId(rs.getInt("id"));
//
//					
//				Athlete  athlete=new Athlete();     
//				athlete.setNewsId(rs.getInt(5));
//				athlete.setNewsTitle(rs.getString(6));
//		           
//				athlete.setNewtheme(title);
	           
         	arrylist.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrylist;
	}



	
}
