package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.Last_beatDao;
import com.badminton.utils.BaseDaoUtils;

public class Last_beatDaoImpl implements Last_beatDao{

	@Override
	public boolean last_beatAdd(String last_beatId,int coach_id,int serve_athleteId,int last_beat_athleteId,int skill_id,int way_id,int initiative,int origin_area,int drop_area,
		    int score_Num,int score_den,int posture,int gain,String gamename,Date gamedate,String gameaddress,String athletename) {
		// TODO Auto-generated method stub
		String sql="insert into last_beat(last_beatId,coach_id,serve_athleteId,last_beat_athleteId,skill_id,way_id,initiative,origin_area,drop_area,score_Num,score_den,posture,gain,gamename,gamedate,gameaddress,athletename) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(last_beatId);
			arrylist.add(coach_id);
			arrylist.add(serve_athleteId);
			arrylist.add(last_beat_athleteId);
			arrylist.add(skill_id);
			arrylist.add(way_id);
			arrylist.add(initiative);
			arrylist.add(origin_area);
			arrylist.add(drop_area);
			arrylist.add(score_Num);
			arrylist.add(score_den);
			arrylist.add(posture);
			arrylist.add(gain);
			arrylist.add(gamename);
			arrylist.add(gamedate);
			arrylist.add(gameaddress);
			arrylist.add(athletename);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
