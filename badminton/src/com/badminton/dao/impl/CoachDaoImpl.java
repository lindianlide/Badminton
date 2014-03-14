package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;

import com.badminton.dao.CoachDao;
import com.badminton.entity.Coach;
import com.badminton.utils.BaseDaoUtils;

public class CoachDaoImpl implements CoachDao {

	@Override
	public boolean coachAdd(int coach_id,String coach_name,String coach_sex,Date coach_age,int event_id,String service_status,String experience) {
		// TODO Auto-generated method stub
		String sql="insert into coach(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience) values(?,?,?,?,?,?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(coach_id);
			arrylist.add(coach_name);
			arrylist.add(coach_sex);
			arrylist.add(coach_age);
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

	public boolean coachDel(int coach_id) {
		// TODO Auto-generated method stub
		String sql = "delete from coach where coach_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(coach_id);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean coachUpdate(int coach_id,String coach_name,String coach_sex,Date coach_age,
			int event_id,String service_status,String experience) {
		// TODO Auto-generated method stub
		String sql = "update coach set coach_name=?,coach_sex=?,coach_age=?,event_id=?,service_status=?,experience=? where coach_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		boolean result = false;
		int ret=0;
		try {
			
			 ret=baseDaoUtils.executeUpdate(sql, new Object[]{coach_name,coach_sex,coach_age,event_id,service_status,experience,coach_id});
					
			if (ret>0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Coach> coachList() {
		// TODO Auto-generated method stub
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		String sql="select * from coach";
		ResultSet rs=null;
		ArrayList<Coach> arr = new ArrayList<Coach>();
		try{
			rs=baseDaoUtils.executeQuery(sql);
		while(rs.next())
		{
				
			Coach coach=new Coach();
			coach.setCoach_id(rs.getInt("coach_id"));
			coach.setCoach_name(rs.getString("coach_name"));
			coach.setCoach_sex(rs.getString("coach_sex"));
			coach.setCoach_age(rs.getDate("coach_age"));
			coach.setEvent_id(rs.getInt("event_id"));
			coach.setService_status(rs.getString("service_status"));
			coach.setExperience(rs.getString("experience"));
			arr.add(coach);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	}
	@Override
	public ArrayList<Coach> coachList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		String sql = "select * from(select n.*,t.tname,rownum rn  from news n inner join newstitle t on n.id = t.id where rownum<="+currpage*pagesize+") where rn>"+(currpage-1)*pagesize+"";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Coach> arrylist = new ArrayList<Coach>();
		ResultSet rs = null;
		Coach coach = null;
		try {
			rs = baseDaoUtils.executeQuery(sql);
			while (rs.next()) {
				coach = new Coach();
//				coach.setId(rs.getInt("id"));
//
//					
//				Coach  coach=new Coach();     
//				coach.setNewsId(rs.getInt(5));
//				coach.setNewsTitle(rs.getString(6));
//		           
//				coach.setNewtheme(title);
	           
         	arrylist.add(coach);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrylist;
	}

	
}
