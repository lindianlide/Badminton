package com.badminton.servlet;

import java.io.IOException;
//import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.sql.Date;
//import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badminton.app.ClassAction;
import com.badminton.app.ClockstasAction;
import com.badminton.app.Every_beatAction;
import com.badminton.app.Last_beatAction;
import com.badminton.app.PlayAction;
import com.badminton.app.RoundAction;
import com.badminton.app.RoundstasAction;
import com.badminton.app.StatisticsAction;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray; 

public class JsonServerAll extends HttpServlet{

	public JsonServerAll() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        response.setContentType("text/xml");//��xml
        response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
        
	    //�����ñ�class��ʼ
		try {
			String json1 = request.getParameter("classhead");//����class���ͷ����
			String json2 = request.getParameter("class");//����class������
			json1 = java.net.URLDecoder.decode(json1,"UTF-8"); 
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:"+json1);
				JSONObject jsonObject1 =JSONObject.fromObject(json1);//�����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));//�õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:"+json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����
				
				ClassAction classaction = new ClassAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
				
		  		for(int i=0;i<jsonArray2.length();i++){ 
		            JSONObject resultObj = jsonArray2.optJSONObject(i);//����JSONArray����JSONObject
		            
		            String class_id=systemtime+" "+resultObj.getString("class_id"); //�ã�ϵͳʱ��+id��������µ�����
		            int coach_id=resultObj.getInt("coach_id");//coach_idһ�㲻����ô�õ���
		            String sdate=resultObj.getString("date");
		            Date date = Date.valueOf(sdate);//��Stringת����Date
		            int tno=resultObj.getInt("tno");
		            
		       		classaction.classAdd(class_id,coach_id,date,tno);
		   		}
		  
				String result = "�ñ�class�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else{
				
				String result = "�ñ�class�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		//�����ñ�class����
		
	    //���ճ���play��ʼ
		try {
			String json1 = request.getParameter("playhead");//����play���ͷ����
			String json2 = request.getParameter("play");//����play������
			json1 = java.net.URLDecoder.decode(json1,"UTF-8"); 
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:"+json1);
				JSONObject jsonObject1 =JSONObject.fromObject(json1);//�����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));//�õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:"+json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����
				
				PlayAction playaction = new PlayAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
				
		  		for(int i=0;i<jsonArray2.length();i++){ 
		            JSONObject resultObj = jsonArray2.optJSONObject(i);//����JSONArray����JSONObject
		            
		            String play_id=systemtime+" "+resultObj.getString("play_id"); //�ã�ϵͳʱ��+id��������µ�����
		            int coach_id=resultObj.getInt("coach_id");//coach_idһ�㲻����ô�õ���
		            String class_id=systemtime+" "+resultObj.getString("class_id"); //���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
		            int cno=resultObj.getInt("cno");
		            int cover=resultObj.getInt("cover");
		            
		            playaction.playAdd(play_id,coach_id,class_id,cno,cover);
		   		}
		  
				String result = "����play�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else{
				
				String result = "����play�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		//���ճ���play����
		
		//���վֱ�statistics��ʼ
		try {
			String json1 = request.getParameter("statisticshead");// ����statistics���ͷ����
			String json2 = request.getParameter("statistics");// ����statistics������
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				StatisticsAction statisticsaction = new StatisticsAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject

					String stat_id = systemtime + " "+ resultObj.getString("stat_id"); // �ã�ϵͳʱ��+id��������µ�����
					int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					String play_id = systemtime + " "+ resultObj.getString("play_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int athlete_id = resultObj.getInt("athlete_id");
					int roundno = resultObj.getInt("roundno");
					int clockno = resultObj.getInt("clockno");
					float time = resultObj.getLong("time");
					float score5 = resultObj.getLong("score5");
					float score4 = resultObj.getLong("score4");
					float score3 = resultObj.getLong("score3");
					float score2 = resultObj.getLong("score2");
					float score1 = resultObj.getLong("score1");
					float score0 = resultObj.getLong("score0");

					statisticsaction.statisticsAdd(stat_id, coach_id, play_id,athlete_id, roundno, clockno,
							time, score5, score4,score3, score2, score1, score0);
				}

				String result = "�ֱ�statistics�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "�ֱ�statistics�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		//���վֱ�statistics����
		
		// ���ջغϱ�roundstas��ʼ
		try {
			String json1 = request.getParameter("roundstashead");// ����roundstas���ͷ����
			String json2 = request.getParameter("roundstas");// ����roundstas������
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				RoundstasAction roundstasaction = new RoundstasAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject

					String round_id = systemtime + " "+ resultObj.getString("round_id"); // �ã�ϵͳʱ��+id��������µ�����
					int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					String stat_id = systemtime + " "+ resultObj.getString("stat_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int rno = resultObj.getInt("rno");
					int rscore = resultObj.getInt("rscore");
					int rclock = resultObj.getInt("rclock");
					float rtime = resultObj.getLong("rtime");

					roundstasaction.roundstasAdd(round_id,coach_id,stat_id,rno,rscore,rclock,rtime);
				}

				String result = "�غϱ�roundstas�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "�غϱ�roundstas�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		// ���ջغϱ�roundstas����
		
		// �����ı�clockstas��ʼ
		try {
			String json1 = request.getParameter("clockstashead");// ����clockstas���ͷ����
			String json2 = request.getParameter("clockstas");// ����clockstas������
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				ClockstasAction clockstasaction = new ClockstasAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject

					String clock_id = systemtime + " "+ resultObj.getString("clock_id"); // �ã�ϵͳʱ��+id��������µ�����
					int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int ckno = resultObj.getInt("ckno");
					int score = resultObj.getInt("score");

					clockstasaction.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
				}

				String result = "�غϱ�roundstas�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "�غϱ�roundstas�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		// �����ı�clockstas����
		
		// �������һ�ı�last_beat��ʼ
		try {
			String json1 = request.getParameter("last_beathead");// ����last_beat���ͷ����
			String json2 = request.getParameter("last_beat");// ����last_beat������
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				Last_beatAction last_beataction = new Last_beatAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject

					String last_beatId = systemtime + " "+ resultObj.getString("last_beatId"); // �ã�ϵͳʱ��+id��������µ�����
					int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					int serve_athleteId = resultObj.getInt("serve_athleteId"); 
					int last_beat_athleteId = resultObj.getInt("last_beat_athleteId");
					int skill_id = resultObj.getInt("skill_id");
					int way_id = resultObj.getInt("way_id");
					int initiative = resultObj.getInt("initiative");
					int origin_area = resultObj.getInt("origin_area");
					int drop_area = resultObj.getInt("drop_area");
					int score_Num = resultObj.getInt("score_Num");
					int score_den = resultObj.getInt("score_den");
					int posture = resultObj.getInt("posture");
					int gain = resultObj.getInt("gain");
					String gamename = resultObj.getString("gamename");
					
					String sgamedate=resultObj.getString("gamedate");
		            Date gamedate = Date.valueOf(sgamedate);
		            
					String gameaddress = resultObj.getString("gameaddress");
					String athletename = resultObj.getString("athletename");

					last_beataction.last_beatAdd(last_beatId,coach_id,serve_athleteId,last_beat_athleteId,skill_id,way_id,initiative,origin_area,drop_area,
						    score_Num,score_den,posture,gain,gamename,gamedate,gameaddress,athletename);
				}

				String result = "���һ�ı�last_beat�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "���һ�ı�last_beat�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		// �������һ�ı�last_beat����
		
		// ����ÿ�غ��б�round��ʼ
		try {
			String json1 = request.getParameter("roundhead");// ����round���ͷ����
			String json2 = request.getParameter("round");// ����round������
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				RoundAction roundaction = new RoundAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject

					String round_id = systemtime + " "+ resultObj.getString("round_id"); // �ã�ϵͳʱ��+id��������µ�����
					int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					String stat_id = systemtime + " "+ resultObj.getString("stat_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int serve_athleteId = resultObj.getInt("serve_athleteId");
					int last_beat_athleteId = resultObj.getInt("last_beat_athleteId");
					int score_Num = resultObj.getInt("score_Num");
					int score_den = resultObj.getInt("score_den");
					int initiative = resultObj.getInt("initiative");
					int serve_drop_area = resultObj.getInt("serve_drop_area");
					int catch_drop_area = resultObj.getInt("catch_drop_area");
					int last_beat_drop_area = resultObj.getInt("last_beat_drop_area");
					int gain = resultObj.getInt("gain");
					String gamename = resultObj.getString("gamename");

					String sgamedate = resultObj.getString("gamedate");
					Date gamedate = Date.valueOf(sgamedate);

					String gameaddress = resultObj.getString("gameaddress");
					String athletename = resultObj.getString("athletename");

					roundaction.roundAdd(round_id,coach_id,stat_id,serve_athleteId,last_beat_athleteId,score_Num,score_den,initiative,serve_drop_area,catch_drop_area,
							   last_beat_drop_area,gain,gamename,gamedate,gameaddress,athletename);
				}

				String result = "ÿ�غ��б�round�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "ÿ�غ��б�round�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		// ����ÿ�غ��б�round����
				
		// ����ÿ�ļ���ͳ�Ʊ�every_beat��ʼ
		try {
			String json1 = request.getParameter("every_beathead");// ����every_beat���ͷ����
			String json2 = request.getParameter("every_beat");// ����every_beat������
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
				System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				Every_beatAction every_beataction = new Every_beatAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject

					String every_beatId = systemtime + " "+ resultObj.getString("every_beatId"); // �ã�ϵͳʱ��+id��������µ�����
					int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int athlete_id = resultObj.getInt("athlete_id");
					int skill_id = resultObj.getInt("skill_id");
					int way_id = resultObj.getInt("way_id");
					float distance = resultObj.getLong("distance");
					int drop_area = resultObj.getInt("drop_area");
					int posture = resultObj.getInt("posture");
					int be_aggressive = resultObj.getInt("be_aggressive");

					every_beataction.every_beatAdd(every_beatId,coach_id,round_id,athlete_id,skill_id,way_id,distance,drop_area,posture,be_aggressive);
				}

				String result = "ÿ�ļ���ͳ�Ʊ�every_beat�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "ÿ�ļ���ͳ�Ʊ�every_beat�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ����"
							+ e.getMessage());
		}
		// ����ÿ�ļ���ͳ�Ʊ�every_beat����
		
		//������������������
		
		
	}
}
