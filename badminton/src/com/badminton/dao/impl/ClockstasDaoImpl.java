package com.badminton.dao.impl;

import java.util.ArrayList;
//import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.ClockstasDao;
import com.badminton.utils.BaseDaoUtils;

public class ClockstasDaoImpl implements ClockstasDao{

	@Override
	public boolean clockstasAdd(String clock_id,int coach_id,String round_id,int ckno,int score) {
		// TODO Auto-generated method stub
		String sql="insert into clockstas(clock_id,coach_id,round_id,ckno,score) values(?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(clock_id);
			arrylist.add(coach_id);
			arrylist.add(round_id);
			arrylist.add(ckno);
			arrylist.add(score);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
