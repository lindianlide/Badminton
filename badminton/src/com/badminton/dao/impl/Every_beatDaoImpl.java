package com.badminton.dao.impl;

import java.util.ArrayList;
//import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.Every_beatDao;
import com.badminton.utils.BaseDaoUtils;

public class Every_beatDaoImpl implements Every_beatDao{

	@Override
	public boolean every_beatAdd(String every_beatId,int coach_id,String round_id,int athlete_id,int skill_id,int way_id,float distance,int drop_area,int posture,int be_aggressive) {
		// TODO Auto-generated method stub
		String sql="insert into every_beat(every_beatId,coach_id,round_id,athlete_id,skill_id,way_id,distance,drop_area,posture,be_aggressive) values(?,?,?,?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(every_beatId);
			arrylist.add(coach_id);
			arrylist.add(round_id);
			arrylist.add(athlete_id);
			arrylist.add(skill_id);
			arrylist.add(way_id);
			arrylist.add(distance);
			arrylist.add(drop_area);
			arrylist.add(posture);
			arrylist.add(be_aggressive);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
