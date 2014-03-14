package com.badminton.app;

//import java.sql.Date;
//import java.util.ArrayList;

//import badminton.server.entity.Athlete;
import com.badminton.service.PlayService;
import com.badminton.service.impl.PlayServiceImpl;

public class PlayAction {

	PlayService playservice=new PlayServiceImpl();

	//Ìí¼ÓÐÂ¼ÍÂ¼
	public boolean playAdd(String play_id,int coach_id,String class_id,int cno,int cover){
		return playservice.playAdd(class_id,coach_id,class_id,cno,cover);
	}
	
}
