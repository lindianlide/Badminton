package com.badminton.app;

//import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Skill;
import com.badminton.service.SkillService;
import com.badminton.service.impl.SkillServiceImpl;

public class SkillAction {
	SkillService skillservice=new SkillServiceImpl();

	//添加新纪录
	public boolean skillAdd(int skill_id,String skill_name){
		return skillservice.skillAdd(skill_id,skill_name);
	}
   //列表
	public ArrayList<Skill> skillList() {
		return skillservice.skillList();
	}
	//分页
	public ArrayList<Skill> skillList(int currpage,int pagesize) {
		return skillservice.skillList(currpage, pagesize);
	}
    //删除
	public boolean skillDel(int skill_id) {

		return skillservice.skillDel(skill_id);

	}
    //修改
	public boolean skillUpdate(int skill_id,String skill_name) {
		return skillservice.skillUpdate(skill_id,skill_name);

	}
}
