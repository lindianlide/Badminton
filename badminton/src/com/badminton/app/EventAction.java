package com.badminton.app;

//import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Event;
import com.badminton.service.EventService;
import com.badminton.service.impl.EventServiceImpl;

public class EventAction {
	EventService eventservice=new EventServiceImpl();

	//添加新纪录
	public boolean eventAdd(int event_id,String event_name){
		return eventservice.eventAdd(event_id,event_name);
	}
   //列表
	public ArrayList<Event> eventList() {
		return eventservice.eventList();
	}
	//分页
	public ArrayList<Event> eventList(int currpage,int pagesize) {
		return eventservice.eventList(currpage, pagesize);
	}
    //删除
	public boolean eventDel(int event_id) {

		return eventservice.eventDel(event_id);

	}
    //修改
	public boolean eventUpdate(int event_id,String event_name) {
		return eventservice.eventUpdate(event_id,event_name);

	}
}
