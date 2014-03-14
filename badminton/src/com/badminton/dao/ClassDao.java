package com.badminton.dao;

import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface ClassDao {

	public boolean classAdd(String class_id,int coach_id,Date date,int tno);
}
