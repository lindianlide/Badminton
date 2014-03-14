package com.badminton.dao;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface StatisticsDao {

	public boolean statisticsAdd(String stat_id,int coach_id,String play_id,int athlete_id,int roundno,int clockno,
			       float time,float score5,float score4,float score3,float score2,float score1,float score0);
}
