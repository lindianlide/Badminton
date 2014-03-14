package com.badminton.app;

import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Coach;
import com.badminton.service.CoachService;
import com.badminton.service.impl.CoachServiceImpl;

public class CoachAction {
	CoachService coachservice=new CoachServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean coachAdd(int coach_id,String coach_name,String coach_sex,Date coach_age,int event_id,String service_status,String experience){
		return coachservice.coachAdd(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience);
	}

	public ArrayList<Coach> coachList() {
		return coachservice.coachList();
	}
	
	public ArrayList<Coach> coachList(int currpage,int pagesize) {
		return coachservice.coachList(currpage, pagesize);
	}

	public boolean coachDel(int coach_id) {

		return coachservice.coachDel(coach_id);

	}

	public boolean coachUpdate(int coach_id,String coach_name,String coach_sex,Date coach_age,int event_id,String service_status,String experience) {
		return coachservice.coachUpdate(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience);

	}
}
