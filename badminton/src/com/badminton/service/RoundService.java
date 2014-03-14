package com.badminton.service;

import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

public interface RoundService {

	public boolean roundAdd(String round_id,int coach_id,String stat_id,int serve_athleteId,int last_beat_athleteId,int score_Num,int score_den,int initiative,int serve_drop_area,
			   int catch_drop_area,int last_beat_drop_area,int gain,String gamename,Date gamedate,String gameaddress,String athletename);//Ìí¼ÓĞÂ¼ÍÂ¼
	
}
