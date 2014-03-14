package com.badminton.app;

import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;

import com.badminton.service.ClassService;
import com.badminton.service.impl.ClassServiceImpl;

public class ClassAction {

	ClassService classservice=new ClassServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean classAdd(String class_id,int coach_id,Date date,int tno){
		return classservice.classAdd(class_id,coach_id,date,tno);
	}
	
}
