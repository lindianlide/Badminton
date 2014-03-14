package com.badminton.app;

//import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Skill;
import com.badminton.service.SkillService;
import com.badminton.service.impl.SkillServiceImpl;

public class SkillAction {
	SkillService skillservice=new SkillServiceImpl();

	//����¼�¼
	public boolean skillAdd(int skill_id,String skill_name){
		return skillservice.skillAdd(skill_id,skill_name);
	}
   //�б�
	public ArrayList<Skill> skillList() {
		return skillservice.skillList();
	}
	//��ҳ
	public ArrayList<Skill> skillList(int currpage,int pagesize) {
		return skillservice.skillList(currpage, pagesize);
	}
    //ɾ��
	public boolean skillDel(int skill_id) {

		return skillservice.skillDel(skill_id);

	}
    //�޸�
	public boolean skillUpdate(int skill_id,String skill_name) {
		return skillservice.skillUpdate(skill_id,skill_name);

	}
}
