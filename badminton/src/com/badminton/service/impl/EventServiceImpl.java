package com.badminton.service.impl;

import java.util.ArrayList;

import com.badminton.dao.EventDao;
import com.badminton.dao.impl.EventDaoImpl;
import com.badminton.entity.Event;
import com.badminton.service.EventService;

public class EventServiceImpl implements EventService {
	EventDao eventdao=new EventDaoImpl();
	@Override
	public boolean eventAdd(int event_id,String event_name) {
		// TODO Auto-generated method stub
		return eventdao.eventAdd(event_id,event_name);
	}

	@Override
	public ArrayList<Event> eventList() {
		// TODO Auto-generated method stub
		return eventdao.eventList();
	}
	
	@Override
	public ArrayList<Event> eventList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eventDel(int event_id) {
		// TODO Auto-generated method stub
		return eventdao.eventDel(event_id);
	}

	@Override
	public boolean eventUpdate(int event_id,String event_name) {
		// TODO Auto-generated method stub
		return eventdao.eventUpdate(event_id,event_name);
	}

}
