package com.badminton.dao;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface Every_beatDao {

	public boolean every_beatAdd(String every_beatId,int coach_id,String round_id,int athlete_id,int skill_id,int way_id,float distance,int drop_area,int posture,int be_aggressive);
}
