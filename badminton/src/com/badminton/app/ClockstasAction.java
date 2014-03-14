package com.badminton.app;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;
import com.badminton.service.ClockstasService;
import com.badminton.service.impl.ClockstasServiceImpl;

public class ClockstasAction {

	ClockstasService clockstasservice=new ClockstasServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean clockstasAdd(String clock_id,int coach_id,String round_id,int ckno,int score){
		return clockstasservice.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
	}
	
}
