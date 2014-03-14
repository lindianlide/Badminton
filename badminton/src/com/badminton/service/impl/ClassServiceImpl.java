package com.badminton.service.impl;

import java.sql.Date;
//import java.util.ArrayList;



import com.badminton.dao.ClassDao;
import com.badminton.dao.impl.ClassDaoImpl;
import com.badminton.service.ClassService;

public class ClassServiceImpl implements ClassService {
	ClassDao classdao = new ClassDaoImpl();
	@Override
	public boolean classAdd(String class_id,int coach_id,Date date,int tno) {
		// TODO Auto-generated method stub
		return classdao.classAdd(class_id,coach_id,date,tno);
	}

}
