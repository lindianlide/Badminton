package com.badminton.service;

import java.util.ArrayList;

import com.badminton.entity.Way;

public interface WayService {
	
	public boolean wayAdd(int way_id,String way_name) ;//Ìí¼ÓÐÂ¼ÍÂ¼

	public ArrayList<Way> wayList();
	
	public ArrayList<Way> wayList(int currpage, int pagesize);

	public boolean wayDel(int way_id);

	public boolean wayUpdate(int way_id,String way_name);

}
