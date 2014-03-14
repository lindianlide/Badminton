package com.badminton.app;

//import java.sql.Date;
import java.util.ArrayList;

import com.badminton.entity.Way;
import com.badminton.service.WayService;
import com.badminton.service.impl.WayServiceImpl;

public class WayAction {
	WayService wayservice=new WayServiceImpl();

	//����¼�¼
	public boolean wayAdd(int way_id,String way_name){
		return wayservice.wayAdd(way_id,way_name);
	}
   //�б�
	public ArrayList<Way> wayList() {
		return wayservice.wayList();
	}
	//��ҳ
	public ArrayList<Way> wayList(int currpage,int pagesize) {
		return wayservice.wayList(currpage, pagesize);
	}
    //ɾ��
	public boolean wayDel(int way_id) {

		return wayservice.wayDel(way_id);

	}
    //�޸�
	public boolean wayUpdate(int way_id,String way_name) {
		return wayservice.wayUpdate(way_id,way_name);

	}
}
