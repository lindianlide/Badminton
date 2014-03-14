package com.badminton.dao;

import java.util.ArrayList;

import com.badminton.entity.Way;

public interface WayDao {
	
	public boolean wayAdd(int way_id,String way_name);

	public ArrayList<Way> wayList();
	
	public ArrayList<Way> wayList(int currpage, int pagesize);

	public boolean wayDel(int way_id);

	public boolean wayUpdate(int way_id,String way_name);

}
