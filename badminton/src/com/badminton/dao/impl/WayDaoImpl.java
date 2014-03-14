package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.ResultSet;

import com.badminton.dao.WayDao;
import com.badminton.entity.Way;
import com.badminton.utils.BaseDaoUtils;

public class WayDaoImpl implements WayDao {

	@Override
	public boolean wayAdd(int way_id,String way_name) {
		// TODO Auto-generated method stub
		String sql="insert into way(way_id,way_name) values(?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(way_id);
			arrylist.add(way_name);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	
	}

	public boolean wayDel(int way_id) {
		// TODO Auto-generated method stub
		String sql = "delete from way where way_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(way_id);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean wayUpdate(int way_id,String way_name) {
		// TODO Auto-generated method stub
		String sql = "update way set way_name=? where way_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		boolean result = false;
		int ret=0;
		try {
			
			 ret=baseDaoUtils.executeUpdate(sql, new Object[]{way_id,way_name});
					
			if (ret>0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Way> wayList() {
		// TODO Auto-generated method stub
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		String sql="select * from way";
		ResultSet rs=null;
		ArrayList<Way> arr = new ArrayList<Way>();
		try{
			rs=baseDaoUtils.executeQuery(sql);
		while(rs.next())
		{
				
			Way way=new Way();
			way.setWay_id(rs.getInt("way_id"));
			way.setWay_name(rs.getString("way_name"));
			arr.add(way);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	
	}
	@Override
	public ArrayList<Way> wayList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		String sql = "select * from(select n.*,t.tname,rownum rn  from news n inner join newstitle t on n.id = t.id where rownum<="+currpage*pagesize+") where rn>"+(currpage-1)*pagesize+"";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Way> arrylist = new ArrayList<Way>();
		ResultSet rs = null;
		Way way = null;
		try {
			rs = baseDaoUtils.executeQuery(sql);
			while (rs.next()) {
				way = new Way();
//				way.setId(rs.getInt("id"));
//
//					
//				Way way=new Way();     
//				way.setNewsId(rs.getInt(5));
//				way.setNewsTitle(rs.getString(6));
//		           
//				way.setNewtheme(title);
	           
         	arrylist.add(way);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrylist;
	}



	
}
