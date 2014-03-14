package com.badminton.service.impl;

//import java.sql.Date;
//import java.util.ArrayList;

import com.badminton.dao.StatisticsDao;
import com.badminton.dao.impl.StatisticsDaoImpl;
import com.badminton.service.StatisticsService;

public class StatisticsServiceImpl implements StatisticsService {
	StatisticsDao statisticsdao = new StatisticsDaoImpl();
	@Override
	public boolean statisticsAdd(String stat_id,int coach_id,String play_id,int athlete_id,int roundno,int clockno,
			             float time,float score5,float score4,float score3,float score2,float score1,float score0) {
		// TODO Auto-generated method stub
		return statisticsdao.statisticsAdd(stat_id,coach_id,play_id,athlete_id,roundno,clockno,time,score5,score4,score3,score2,score1,score0);
	}

}
