package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.ResultSet;

import com.badminton.dao.EventDao;
import com.badminton.entity.Event;
import com.badminton.utils.BaseDaoUtils;

public class EventDaoImpl implements EventDao {

	@Override
	public boolean eventAdd(int event_id,String event_name) {
		// TODO Auto-generated method stub
		String sql="insert into event(event_id,event_name) values(?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(event_id);
			arrylist.add(event_name);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	
	}

	public boolean eventDel(int event_id) {
		// TODO Auto-generated method stub
		String sql = "delete from event where event_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(event_id);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean eventUpdate(int event_id,String event_name) {
		// TODO Auto-generated method stub
		String sql = "update event set event_name=? where event_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		boolean result = false;
		int ret=0;
		try {
			
			 ret=baseDaoUtils.executeUpdate(sql, new Object[]{event_id,event_name});
					
			if (ret>0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Event> eventList() {
		// TODO Auto-generated method stub
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		String sql="select * from event";
		ResultSet rs=null;
		ArrayList<Event> arr = new ArrayList<Event>();
		try{
			rs=baseDaoUtils.executeQuery(sql);
		while(rs.next())
		{
				
			Event event=new Event();
			event.setEvent_id(rs.getInt("event_id"));
			event.setEvent_name(rs.getString("event_name"));
			arr.add(event);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	
	}
	@Override
	public ArrayList<Event> eventList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		String sql = "select * from(select n.*,t.tname,rownum rn  from news n inner join newstitle t on n.id = t.id where rownum<="+currpage*pagesize+") where rn>"+(currpage-1)*pagesize+"";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Event> arrylist = new ArrayList<Event>();
		ResultSet rs = null;
		Event event = null;
		try {
			rs = baseDaoUtils.executeQuery(sql);
			while (rs.next()) {
				event = new Event();
//				event.setId(rs.getInt("id"));
//
//					
//				Event event=new Event();     
//				event.setNewsId(rs.getInt(5));
//				event.setNewsTitle(rs.getString(6));
//		           
//				event.setNewtheme(title);
	           
         	arrylist.add(event);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrylist;
	}



	
}
