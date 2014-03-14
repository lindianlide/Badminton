package com.badminton.dao;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface RoundstasDao {

	public boolean roundstasAdd(String round_id,int coach_id,String stat_id,int rno,int rscore,int rclock,float rtime);
}
