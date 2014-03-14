package com.badminton.app;

import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

import com.badminton.service.Last_beatService;
import com.badminton.service.impl.Last_beatServiceImpl;

public class Last_beatAction {

	Last_beatService last_beatservice=new Last_beatServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean last_beatAdd(String last_beatId,int coach_id,int serve_athleteId,int last_beat_athleteId,int skill_id,int way_id,int initiative,int origin_area,int drop_area,
		    int score_Num,int score_den,int posture,int gain,String gamename,Date gamedate,String gameaddress,String athletename){
		return last_beatservice.last_beatAdd(last_beatId,coach_id,serve_athleteId,last_beat_athleteId,skill_id,way_id,initiative,origin_area,drop_area,
			    score_Num,score_den,posture,gain,gamename,gamedate,gameaddress,athletename);
	}
	
}
