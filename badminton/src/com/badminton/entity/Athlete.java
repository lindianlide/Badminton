package com.badminton.entity;

import java.sql.Date;
//import java.util.Date;

public class Athlete {
	int athlete_id;//运动员编号
	String athlete_name;//运动员姓名
	String athlete_sex;//运动员性别
	Date athlete_age;//运动员出生年月日
	//String athlete_age;
	int coach_id;//所属教练员编号
	int event_id;//运动项目编号
	String service_status;//是否现役
	String experience;//经历
	
	public int getAthlete_id() {
		return athlete_id;
	}
	public void setAthlete_id(int athlete_id) {
		this.athlete_id = athlete_id;
	}
	public String getAthlete_name() {
		return athlete_name;
	}
	public void setAthlete_name(String athlete_name) {
		this.athlete_name = athlete_name;
	}
	public String getAthlete_sex() {
		return athlete_sex;
	}
	public void setAthlete_sex(String athlete_sex) {
		this.athlete_sex = athlete_sex;
	}
	
	public Date getAthlete_age() {
		return athlete_age;
	}
	public void setAthlete_age(Date athlete_age) {
		this.athlete_age = athlete_age;
	}

/*	
	public String getAthlete_age() {
		return athlete_age;
	}
	public void setAthlete_age(String athlete_age) {
		this.athlete_age = athlete_age;
	}
*/
	
	public int getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}
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
