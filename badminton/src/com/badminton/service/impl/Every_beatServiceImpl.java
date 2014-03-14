package com.badminton.service.impl;

//import java.sql.Date;
//import java.util.ArrayList;

import com.badminton.dao.Every_beatDao;
import com.badminton.dao.impl.Every_beatDaoImpl;
import com.badminton.service.Every_beatService;

public class Every_beatServiceImpl implements Every_beatService {
	Every_beatDao every_beatdao = new Every_beatDaoImpl();
	@Override
	public boolean every_beatAdd(String every_beatId,int coach_id,String round_id,int athlete_id,int skill_id,int way_id,float distance,int drop_area,int posture,int be_aggressive) {
		// TODO Auto-generated method stub
		return every_beatdao.every_beatAdd(every_beatId,coach_id,round_id,athlete_id,skill_id,way_id,distance,drop_area,posture,be_aggressive);
	}

}
