package com.badminton.service;

import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Coach;

public interface CoachService {
	
	public boolean coachAdd(int coach_id,String coach_name,String coach_sex,Date coach_age,
			int event_id,String service_status,String expericence) ;//Ìí¼ÓÐÂ¼ÍÂ¼

	public ArrayList<Coach> coachList();
	
	public ArrayList<Coach> coachList(int currpage, int pagesize);

	public boolean coachDel(int coach_id);

	public boolean coachUpdate(int coach_id, String coach_name,
			String coach_sex, Date coach_age, int event_id,
			String service_status, String experience);

}
