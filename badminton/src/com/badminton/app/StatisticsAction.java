package com.badminton.app;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;
import com.badminton.service.StatisticsService;
import com.badminton.service.impl.StatisticsServiceImpl;

public class StatisticsAction {

	StatisticsService statisticsservice=new StatisticsServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean statisticsAdd(String stat_id,int coach_id,String play_id,int athlete_id,int roundno,int clockno,
			           float time,float score5,float score4,float score3,float score2,float score1,float score0){
		return statisticsservice.statisticsAdd(stat_id,coach_id,play_id,athlete_id,roundno,clockno,
				       time,score5,score4,score3,score2,score1,score0);
	}
	
}
