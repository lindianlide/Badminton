package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.ClassDao;
import com.badminton.utils.BaseDaoUtils;

public class ClassDaoImpl implements ClassDao{

	@Override
	public boolean classAdd(String class_id,int coach_id,Date date,int tno) {
		// TODO Auto-generated method stub
		String sql="insert into class(class_id,coach_id,date,tno) values(?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(class_id);
			arrylist.add(coach_id);
			arrylist.add(date);
			arrylist.add(tno);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
