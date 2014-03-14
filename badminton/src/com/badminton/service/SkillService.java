package com.badminton.service;

import java.util.ArrayList;

import com.badminton.entity.Skill;

public interface SkillService {
	
	public boolean skillAdd(int skill_id,String skill_name) ;//����¼�¼

	public ArrayList<Skill> skillList();
	
	public ArrayList<Skill> skillList(int currpage, int pagesize);

	public boolean skillDel(int skill_id);

	public boolean skillUpdate(int skill_id,String skill_name);

}
