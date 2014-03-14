package com.badminton.service.impl;

//import java.sql.Date;
//import java.util.ArrayList;

import com.badminton.dao.ClockstasDao;
import com.badminton.dao.impl.ClockstasDaoImpl;
import com.badminton.service.ClockstasService;

public class ClockstasServiceImpl implements ClockstasService {
	ClockstasDao clockstasdao = new ClockstasDaoImpl();
	@Override
	public boolean clockstasAdd(String clock_id,int coach_id,String round_id,int ckno,int score) {
		// TODO Auto-generated method stub
		return clockstasdao.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
	}

}
