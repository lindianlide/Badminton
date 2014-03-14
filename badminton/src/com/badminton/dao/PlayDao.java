package com.badminton.dao;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface PlayDao {

	public boolean playAdd(String play_id,int coach_id,String class_id,int cno,int cover);
}
