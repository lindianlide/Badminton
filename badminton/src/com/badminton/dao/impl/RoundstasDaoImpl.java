package com.badminton.dao.impl;

import java.util.ArrayList;
//import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.RoundstasDao;
import com.badminton.utils.BaseDaoUtils;

public class RoundstasDaoImpl implements RoundstasDao{

	@Override
	public boolean roundstasAdd(String round_id,int coach_id,String stat_id,int rno,int rscore,int rclock,float rtime) {
		// TODO Auto-generated method stub
		String sql="insert into roundstas(round_id,coach_id,stat_id,rno,rscore,rclock,rtime) values(?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(round_id);
			arrylist.add(coach_id);
			arrylist.add(stat_id);
			arrylist.add(rno);
			arrylist.add(rscore);
			arrylist.add(rclock);
			arrylist.add(rtime);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
