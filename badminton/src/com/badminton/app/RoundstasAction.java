package com.badminton.app;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;
import com.badminton.service.RoundstasService;
import com.badminton.service.impl.RoundstasServiceImpl;

public class RoundstasAction {

	RoundstasService roundstasservice=new RoundstasServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean roundstasAdd(String round_id,int coach_id,String stat_id,int rno,int rscore,int rclock,float rtime){
		return roundstasservice.roundstasAdd(round_id,coach_id,stat_id,rno,rscore,rclock,rtime);
	}
	
}
