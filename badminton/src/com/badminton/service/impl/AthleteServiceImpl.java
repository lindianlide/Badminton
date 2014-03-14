package com.badminton.service.impl;

import java.sql.Date;
import java.util.ArrayList;

import com.badminton.dao.AthleteDao;
import com.badminton.dao.impl.AthleteDaoImpl;
import com.badminton.entity.Athlete;
import com.badminton.service.AthleteService;

public class AthleteServiceImpl implements AthleteService {
	AthleteDao athletedao=new AthleteDaoImpl();
	@Override
	public boolean athleteAdd(int athlete_id,String athlete_name,String athlete_sex,Date athlete_age,int coach_id,int event_id,String service_status,String experience) {
		// TODO Auto-generated method stub
		return athletedao.athleteAdd(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);
	}

	@Override
	public ArrayList<Athlete> athleteList() {
		// TODO Auto-generated method stub
		return athletedao.athleteList();
	}
	
	@Override
	public ArrayList<Athlete> athleteList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean athleteDel(int athlete_id) {
		// TODO Auto-generated method stub
		return athletedao.athleteDel(athlete_id);
	}

	@Override
	public boolean athleteUpdate(int athlete_id, String athlete_name,
			String athlete_sex, Date athlete_age, int coach_id, int event_id,
			String service_status, String experience) {
		// TODO Auto-generated method stub
		return athletedao.athleteUpdate(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);
	}

}
