package com.badminton.service.impl;

import java.sql.Date;
//import java.util.ArrayList;



import com.badminton.dao.Last_beatDao;
import com.badminton.dao.impl.Last_beatDaoImpl;
import com.badminton.service.Last_beatService;

public class Last_beatServiceImpl implements Last_beatService {
	Last_beatDao last_beatdao = new Last_beatDaoImpl();
	@Override
	public boolean last_beatAdd(String last_beatId,int coach_id,int serve_athleteId,int last_beat_athleteId,int skill_id,int way_id,int initiative,int origin_area,int drop_area,
		    int score_Num,int score_den,int posture,int gain,String gamename,Date gamedate,String gameaddress,String athletename) {
		// TODO Auto-generated method stub
		return last_beatdao.last_beatAdd(last_beatId,coach_id,serve_athleteId,last_beat_athleteId,skill_id,way_id,initiative,origin_area,drop_area,
			    score_Num,score_den,posture,gain,gamename,gamedate,gameaddress,athletename);
	}

}
