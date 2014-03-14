package com.badminton.dao.impl;

import java.util.ArrayList;
//import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.PlayDao;
import com.badminton.utils.BaseDaoUtils;

public class PlayDaoImpl implements PlayDao{

	@Override
	public boolean playAdd(String play_id,int coach_id,String class_id,int cno,int cover) {
		// TODO Auto-generated method stub
		String sql="insert into play(play_id,coach_id,class_id,cno,cover) values(?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(play_id);
			arrylist.add(coach_id);
			arrylist.add(class_id);
			arrylist.add(cno);
			arrylist.add(cover);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
