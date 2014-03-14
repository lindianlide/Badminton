package com.badminton.service;

import java.util.ArrayList;

import com.badminton.entity.Event;

public interface EventService {
	
	public boolean eventAdd(int event_id,String event_name) ;//Ìí¼ÓĞÂ¼ÍÂ¼

	public ArrayList<Event> eventList();
	
	public ArrayList<Event> eventList(int currpage, int pagesize);

	public boolean eventDel(int event_id);

	public boolean eventUpdate(int event_id,String event_name);

}
