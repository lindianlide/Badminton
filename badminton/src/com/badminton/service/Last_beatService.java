package com.badminton.service;

import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface Last_beatService {

	public boolean last_beatAdd(String last_beatId,int coach_id,int serve_athleteId,int last_beat_athleteId,int skill_id,int way_id,int initiative,int origin_area,int drop_area,
		    int score_Num,int score_den,int posture,int gain,String gamename,Date gamedate,String gameaddress,String athletename) ;//Ìí¼ÓĞÂ¼ÍÂ¼
	
}
