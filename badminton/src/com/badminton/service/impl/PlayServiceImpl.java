package com.badminton.service.impl;

//import java.sql.Date;
//import java.util.ArrayList;

import com.badminton.dao.PlayDao;
import com.badminton.dao.impl.PlayDaoImpl;
import com.badminton.service.PlayService;

public class PlayServiceImpl implements PlayService {
	PlayDao playdao = new PlayDaoImpl();
	@Override
	public boolean playAdd(String play_id,int coach_id,String class_id,int cno,int cover) {
		// TODO Auto-generated method stub
		return playdao.playAdd(class_id,coach_id,class_id,cno,cover);
	}

}
