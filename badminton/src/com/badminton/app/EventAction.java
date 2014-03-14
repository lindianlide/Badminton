package com.badminton.app;

//import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Event;
import com.badminton.service.EventService;
import com.badminton.service.impl.EventServiceImpl;

public class EventAction {
	EventService eventservice=new EventServiceImpl();

	//����¼�¼
	public boolean eventAdd(int event_id,String event_name){
		return eventservice.eventAdd(event_id,event_name);
	}
   //�б�
	public ArrayList<Event> eventList() {
		return eventservice.eventList();
	}
	//��ҳ
	public ArrayList<Event> eventList(int currpage,int pagesize) {
		return eventservice.eventList(currpage, pagesize);
	}
    //ɾ��
	public boolean eventDel(int event_id) {

		return eventservice.eventDel(event_id);

	}
    //�޸�
	public boolean eventUpdate(int event_id,String event_name) {
		return eventservice.eventUpdate(event_id,event_name);

	}
}
