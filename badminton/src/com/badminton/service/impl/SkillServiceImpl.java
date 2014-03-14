package com.badminton.service.impl;

import java.util.ArrayList;

import com.badminton.dao.SkillDao;
import com.badminton.dao.impl.SkillDaoImpl;
import com.badminton.entity.Skill;
import com.badminton.service.SkillService;

public class SkillServiceImpl implements SkillService {
	SkillDao skilldao=new SkillDaoImpl();
	@Override
	public boolean skillAdd(int skill_id,String skill_name) {
		// TODO Auto-generated method stub
		return skilldao.skillAdd(skill_id,skill_name);
	}

	@Override
	public ArrayList<Skill> skillList() {
		// TODO Auto-generated method stub
		return skilldao.skillList();
	}
	
	@Override
	public ArrayList<Skill> skillList(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean skillDel(int skill_id) {
		// TODO Auto-generated method stub
		return skilldao.skillDel(skill_id);
	}

	@Override
	public boolean skillUpdate(int skill_id,String skill_name) {
		// TODO Auto-generated method stub
		return skilldao.skillUpdate(skill_id,skill_name);
	}

}
