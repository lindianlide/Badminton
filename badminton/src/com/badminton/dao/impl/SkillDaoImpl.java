package com.badminton.dao.impl;

import java.util.ArrayList;
import java.sql.ResultSet;

import com.badminton.dao.SkillDao;
import com.badminton.entity.Skill;
import com.badminton.utils.BaseDaoUtils;

public class SkillDaoImpl implements SkillDao {

	@Override
	public boolean skillAdd(int skill_id,String skill_name) {
		// TODO Auto-generated method stub
		String sql="insert into skill(skill_id,skill_name) values(?,?)";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(skill_id);
			arrylist.add(skill_name);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());//变成数组
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	
	}

	public boolean skillDel(int skill_id) {
		// TODO Auto-generated method stub
		String sql = "delete from skill where skill_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Object> arrylist = new ArrayList<Object>();
		boolean result = false;
		int k = 0;
		try {
			arrylist.add(skill_id);
			k = baseDaoUtils.executeUpdate(sql, arrylist.toArray());
			if (k > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean skillUpdate(int skill_id,String skill_name) {
		// TODO Auto-generated method stub
		String sql = "update skill set skill_name=? where skill_id=?";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		boolean result = false;
		int ret=0;
		try {
			
			 ret=baseDaoUtils.executeUpdate(sql, new Object[]{skill_id,skill_name});
					
			if (ret>0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Skill> skillList() {
		// TODO Auto-generated method stub
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		String sql="select * from skill";
		ResultSet rs=null;
		ArrayList<Skill> arr = new ArrayList<Skill>();
		try{
			rs=baseDaoUtils.executeQuery(sql);
		while(rs.next())
		{
				
			Skill skill=new Skill();
			skill.setSkill_id(rs.getInt("skill_id"));
			skill.setSkill_name(rs.getString("skill_name"));
			arr.add(skill);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	
	}
	@Override
	public ArrayList<Skill> skillList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		String sql = "select * from(select n.*,t.tname,rownum rn  from news n inner join newstitle t on n.id = t.id where rownum<="+currpage*pagesize+") where rn>"+(currpage-1)*pagesize+"";
		BaseDaoUtils baseDaoUtils = new BaseDaoUtils();
		ArrayList<Skill> arrylist = new ArrayList<Skill>();
		ResultSet rs = null;
		Skill skill = null;
		try {
			rs = baseDaoUtils.executeQuery(sql);
			while (rs.next()) {
				skill = new Skill();
//				skill.setId(rs.getInt("id"));
//
//					
//				Skill skill=new Skill();     
//				skill.setNewsId(rs.getInt(5));
//				skill.setNewsTitle(rs.getString(6));
//		           
//				skill.setNewtheme(title);
	           
         	arrylist.add(skill);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrylist;
	}



	
}
