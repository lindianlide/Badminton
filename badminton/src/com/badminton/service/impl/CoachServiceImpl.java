package com.badminton.service.impl;

import java.sql.Date;
import java.util.ArrayList;

import com.badminton.dao.CoachDao;
import com.badminton.dao.impl.CoachDaoImpl;
import com.badminton.entity.Coach;
import com.badminton.service.CoachService;

public class CoachServiceImpl implements CoachService {
	CoachDao coachdao=new CoachDaoImpl();
	@Override
	public boolean coachAdd(int coach_id,String coach_name,String coach_sex,Date coach_age,int event_id,String service_status,String experience) {
		// TODO Auto-generated method stub
		return coachdao.coachAdd(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience);
	}

	@Override
	public ArrayList<Coach> coachList() {
		// TODO Auto-generated method stub
		return coachdao.coachList();
	}

	@Override
	public ArrayList<Coach> coachList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean coachDel(int coach_id) {
		// TODO Auto-generated method stub
		return coachdao.coachDel(coach_id);
	}

	@Override
	public boolean coachUpdate(int coach_id, String coach_name,
			String coach_sex, Date coach_age, int event_id,
			String service_status, String experience) {
		// TODO Auto-generated method stub
		return coachdao.coachUpdate(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience);
	}

}
