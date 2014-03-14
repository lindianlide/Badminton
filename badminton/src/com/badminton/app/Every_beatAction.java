package com.badminton.app;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;
import com.badminton.service.Every_beatService;
import com.badminton.service.impl.Every_beatServiceImpl;

public class Every_beatAction {

	Every_beatService every_beatservice=new Every_beatServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean every_beatAdd(String every_beatId,int coach_id,String round_id,int athlete_id,int skill_id,int way_id,float distance,int drop_area,int posture,int be_aggressive){
		return every_beatservice.every_beatAdd(every_beatId,coach_id,round_id,athlete_id,skill_id,way_id,distance,drop_area,posture,be_aggressive);
	}
	
}
