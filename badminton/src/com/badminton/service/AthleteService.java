package com.badminton.service;

import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Athlete;

public interface AthleteService {
	
	public boolean athleteAdd(int athlete_id,String athlete_name,String athlete_sex,Date athlete_age,
			int coach_id,int event_id,String service_status,String expericence) ;//Ìí¼ÓÐÂ¼ÍÂ¼

	public ArrayList<Athlete> athleteList();
	
	public ArrayList<Athlete> athleteList(int currpage, int pagesize);

	public boolean athleteDel(int athlete_id);

	public boolean athleteUpdate(int athlete_id, String athlete_name,
			String athlete_sex, Date athlete_age, int coach_id, int event_id,
			String service_status, String experience);

}
