package com.badminton.entity;

import java.sql.Date;//����java.util.Date

public class Coach {
	int coach_id;//����Ա���
	String coach_name;//����Ա����
	String coach_sex;//����Ա�Ա�
	Date coach_age;//����Ա����������
	//String coach_age;
	int event_id;//�˶���Ŀ���
	String service_status;//����״̬
	String experience;//����
	
	public int getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public String getCoach_sex() {
		return coach_sex;
	}
	public void setCoach_sex(String coach_sex) {
		this.coach_sex = coach_sex;
	}
	
	public Date getCoach_age() {
		return coach_age;
	}
	public void setCoach_age(Date coach_age) {
		this.coach_age = coach_age;
	}

/*	
	public String getCoach_age() {
		return coach_age;
	}
	public void setCoach_age(String coach_age) {
		this.coach_age = coach_age;
	}
*/	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getService_status() {
		return service_status;
	}
	public void setService_status(String service_status) {
		this.service_status = service_status;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
    
}
