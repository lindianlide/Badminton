package com.badminton.service.impl;

import java.util.ArrayList;

import com.badminton.dao.WayDao;
import com.badminton.dao.impl.WayDaoImpl;
import com.badminton.entity.Way;
import com.badminton.service.WayService;

public class WayServiceImpl implements WayService {
	WayDao waydao=new WayDaoImpl();
	@Override
	public boolean wayAdd(int way_id,String way_name) {
		// TODO Auto-generated method stub
		return waydao.wayAdd(way_id,way_name);
	}

	@Override
	public ArrayList<Way> wayList() {
		// TODO Auto-generated method stub
		return waydao.wayList();
	}
	
	@Override
	public ArrayList<Way> wayList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wayDel(int way_id) {
		// TODO Auto-generated method stub
		return waydao.wayDel(way_id);
	}

	@Override
	public boolean wayUpdate(int way_id,String way_name) {
		// TODO Auto-generated method stub
		return waydao.wayUpdate(way_id,way_name);
	}

}
