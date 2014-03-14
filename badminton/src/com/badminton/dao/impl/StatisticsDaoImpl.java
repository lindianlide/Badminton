package com.badminton.dao.impl;

import java.util.ArrayList;
//import java.sql.Date;
//import java.sql.ResultSet;



import com.badminton.dao.StatisticsDao;
import com.badminton.utils.BaseDaoUtils;

public class StatisticsDaoImpl implements StatisticsDao{

	@Override
	public boolean statisticsAdd(String stat_id,int coach_id,String play_id,int athlete_id,int roundno,int clockno,
			             float time,float score5,float score4,float score3,float score2,float score1,float score0) {
		// TODO Auto-generated method stub
		String sql="insert into statistics(stat_id,coach_id,play_id,athlete_id,roundno,clockno,time,score5,score4,score3,score2,score1,score0) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(stat_id);
			arrylist.add(coach_id);
			arrylist.add(play_id);
			arrylist.add(athlete_id);
			arrylist.add(roundno);
			arrylist.add(clockno);
			arrylist.add(time);
			arrylist.add(score5);
			arrylist.add(score4);
			arrylist.add(score3);
			arrylist.add(score2);
			arrylist.add(score1);
			arrylist.add(score0);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
