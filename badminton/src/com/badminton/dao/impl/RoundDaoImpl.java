package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.RoundDao;
import com.badminton.utils.BaseDaoUtils;

public class RoundDaoImpl implements RoundDao{

	@Override
	public boolean roundAdd(String round_id,int coach_id,String stat_id,int serve_athleteId,int last_beat_athleteId,int score_Num,int score_den,int initiative,int serve_drop_area,
			   int catch_drop_area,int last_beat_drop_area,int gain,String gamename,Date gamedate,String gameaddress,String athletename) {
		// TODO Auto-generated method stub
		String sql="insert into round(round_id,coach_id,stat_id,serve_athleteId,last_beat_athleteId,score_Num,score_den,initiative,serve_drop_area,catch_drop_area,last_beat_drop_area,gain,gamename,gamedate,gameaddress,athletename) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(round_id);
			arrylist.add(coach_id);
			arrylist.add(stat_id);
			arrylist.add(serve_athleteId);
			arrylist.add(last_beat_athleteId);
			arrylist.add(score_Num);
			arrylist.add(score_den);
			arrylist.add(initiative);
			arrylist.add(serve_drop_area);
			arrylist.add(catch_drop_area);
			arrylist.add(last_beat_drop_area);
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
