package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;

import com.badminton.dao.AthleteDao;
import com.badminton.entity.Athlete;
import com.badminton.utils.BaseDaoUtils;

public class AthleteDaoImpl implements AthleteDao {

	@Override
	public boolean athleteAdd(int athlete_id,String athlete_name,String athlete_sex,Date athlete_age,int coach_id,int event_id,String service_status,String experience) {
		// TODO Auto-generated method stub
		String sql="insert into athlete(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience) values(?,?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(athlete_id);
			arrylist.add(athlete_name);
			arrylist.add(athlete_sex);
			arrylist.add(athlete_age);
			arrylist.add(coach_id);
			arrylist.add(event_id);
			arrylist.add(service_status);
			arrylist.add(experience);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	
	}

	public boolean athleteDel(int athlete_id) {
		// TODO Auto-generated method stub
		String sql = "delete from athlete where athlete_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(athlete_id);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean athleteUpdate(int athlete_id,String athlete_name,String athlete_sex,Date athlete_age,
			int coach_id,int event_id,String service_status,String experience) {
		// TODO Auto-generated method stub
		String sql = "update athlete set athlete_name=?,athlete_sex=?,athlete_age=?,coach_id=?,event_id=?,service_status=?,experience=? where athlete_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		boolean result = false;
		int ret=0;
		try {
			
			 ret=baseDaoUtils.executeUpdate(sql, new Object[]{athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience,athlete_id});
					
			if (ret>0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Athlete> athleteList() {
		// TODO Auto-generated method stub
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		String sql="select * from athlete";
		ResultSet rs=null;
		ArrayList<Athlete> arr = new ArrayList<Athlete>();
		try{
			rs=baseDaoUtils.executeQuery(sql);
		while(rs.next())
		{
				
			Athlete athlete=new Athlete();
			athlete.setAthlete_id(rs.getInt("athlete_id"));
			athlete.setAthlete_name(rs.getString("athlete_name"));
			athlete.setAthlete_sex(rs.getString("athlete_sex"));
			athlete.setAthlete_age(rs.getDate("athlete_age"));
			athlete.setCoach_id(rs.getInt("coach_id"));
			athlete.setEvent_id(rs.getInt("event_id"));
			athlete.setService_status(rs.getString("service_status"));
			athlete.setExperience(rs.getString("experience"));
			arr.add(athlete);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	
	}
	@Override
	public ArrayList<Athlete> athleteList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		String sql = "select * from(select n.*,t.tname,rownum rn  from news n inner join newstitle t on n.id = t.id where rownum<="+currpage*pagesize+") where rn>"+(currpage-1)*pagesize+"";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Athlete> arrylist = new ArrayList<Athlete>();
		ResultSet rs = null;
		Athlete athlete = null;
		try {
			rs = baseDaoUtils.executeQuery(sql);
			while (rs.next()) {
				athlete = new Athlete();
//				athlete.setId(rs.getInt("id"));
//
//					
//				Athlete  athlete=new Athlete();     
//				athlete.setNewsId(rs.getInt(5));
//				athlete.setNewsTitle(rs.getString(6));
//		           
//				athlete.setNewtheme(title);
	           
         	arrylist.add(athlete);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrylist;
	}



	
}
