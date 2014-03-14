package com.badminton.dao;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface ClockstasDao {

	public boolean clockstasAdd(String clock_id,int coach_id,String round_id,int ckno,int score);
}
