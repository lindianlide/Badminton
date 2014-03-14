package com.badminton.app;

import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Athlete;
import com.badminton.service.AthleteService;
import com.badminton.service.impl.AthleteServiceImpl;


public class AthleteAction {
	AthleteService athleteservice=new AthleteServiceImpl();

	//����¼�¼
	public boolean athleteAdd(int athlete_id,String athlete_name,String athlete_sex,Date athlete_age,int coach_id,int event_id,String service_status,String experience){
		return athleteservice.athleteAdd(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);
	}
   //�б�
	public ArrayList<Athlete> athleteList() {
		return athleteservice.athleteList();
	}
	//��ҳ
	public ArrayList<Athlete> athleteList(int currpage,int pagesize) {
		return athleteservice.athleteList(currpage, pagesize);
	}
    //ɾ��
	public boolean athleteDel(int athlete_id) {

		return athleteservice.athleteDel(athlete_id);

	}
    //�޸�
	public boolean athleteUpdate(int athlete_id,String athlete_name,String athlete_sex,Date athlete_age,int coach_id,int event_id,String service_status,String experience) {
		return athleteservice.athleteUpdate(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);

	}
}
