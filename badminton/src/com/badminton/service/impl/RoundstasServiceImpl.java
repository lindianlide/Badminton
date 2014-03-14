package com.badminton.service.impl;

//import java.sql.Date;
//import java.util.ArrayList;

import com.badminton.dao.RoundstasDao;
import com.badminton.dao.impl.RoundstasDaoImpl;
import com.badminton.service.RoundstasService;

public class RoundstasServiceImpl implements RoundstasService {
	RoundstasDao roundstasdao = new RoundstasDaoImpl();
	@Override
	public boolean roundstasAdd(String round_id,int coach_id,String stat_id,int rno,int rscore,int rclock,float rtime) {
		// TODO Auto-generated method stub
		return roundstasdao.roundstasAdd(round_id,coach_id,stat_id,rno,rscore,rclock,rtime);
	}

}
