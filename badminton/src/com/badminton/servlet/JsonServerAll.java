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
		
        response.setContentType("text/xml");//是xml
        response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
        
	    //接收堂表class开始
		try {
			String json1 = request.getParameter("classhead");//接收class表的头数据
			String json2 = request.getParameter("class");//接收class表数据
			json1 = java.net.URLDecoder.decode(json1,"UTF-8"); 
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:"+json1);
				JSONObject jsonObject1 =JSONObject.fromObject(json1);//根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));//得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:"+json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组
				
				ClassAction classaction = new ClassAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间
				
		  		for(int i=0;i<jsonArray2.length();i++){ 
		            JSONObject resultObj = jsonArray2.optJSONObject(i);//根据JSONArray生成JSONObject
		            
		            String class_id=systemtime+" "+resultObj.getString("class_id"); //用（系统时间+id）构造成新的主键
		            int coach_id=resultObj.getInt("coach_id");//coach_id一般不是这么得到的
		            String sdate=resultObj.getString("date");
		            Date date = Date.valueOf(sdate);//把String转换成Date
		            int tno=resultObj.getInt("tno");
		            
		       		classaction.classAdd(class_id,coach_id,date,tno);
		   		}
		  
				String result = "堂表class的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else{
				
				String result = "堂表class的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		//接收堂表class结束
		
	    //接收场表play开始
		try {
			String json1 = request.getParameter("playhead");//接收play表的头数据
			String json2 = request.getParameter("play");//接收play表数据
			json1 = java.net.URLDecoder.decode(json1,"UTF-8"); 
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:"+json1);
				JSONObject jsonObject1 =JSONObject.fromObject(json1);//根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));//得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:"+json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组
				
				PlayAction playaction = new PlayAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间
				
		  		for(int i=0;i<jsonArray2.length();i++){ 
		            JSONObject resultObj = jsonArray2.optJSONObject(i);//根据JSONArray生成JSONObject
		            
		            String play_id=systemtime+" "+resultObj.getString("play_id"); //用（系统时间+id）构造成新的主键
		            int coach_id=resultObj.getInt("coach_id");//coach_id一般不是这么得到的
		            String class_id=systemtime+" "+resultObj.getString("class_id"); //外键值必须保证与主键表的值一致，所以time要一样
		            int cno=resultObj.getInt("cno");
		            int cover=resultObj.getInt("cover");
		            
		            playaction.playAdd(play_id,coach_id,class_id,cno,cover);
		   		}
		  
				String result = "场表play的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else{
				
				String result = "场表play的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		//接收场表play结束
		
		//接收局表statistics开始
		try {
			String json1 = request.getParameter("statisticshead");// 接收statistics表的头数据
			String json2 = request.getParameter("statistics");// 接收statistics表数据
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				StatisticsAction statisticsaction = new StatisticsAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject

					String stat_id = systemtime + " "+ resultObj.getString("stat_id"); // 用（系统时间+id）构造成新的主键
					int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					String play_id = systemtime + " "+ resultObj.getString("play_id"); // 外键值必须保证与主键表的值一致，所以time要一样
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

				String result = "局表statistics的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "局表statistics的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		//接收局表statistics结束
		
		// 接收回合表roundstas开始
		try {
			String json1 = request.getParameter("roundstashead");// 接收roundstas表的头数据
			String json2 = request.getParameter("roundstas");// 接收roundstas表数据
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				RoundstasAction roundstasaction = new RoundstasAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject

					String round_id = systemtime + " "+ resultObj.getString("round_id"); // 用（系统时间+id）构造成新的主键
					int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					String stat_id = systemtime + " "+ resultObj.getString("stat_id"); // 外键值必须保证与主键表的值一致，所以time要一样
					int rno = resultObj.getInt("rno");
					int rscore = resultObj.getInt("rscore");
					int rclock = resultObj.getInt("rclock");
					float rtime = resultObj.getLong("rtime");

					roundstasaction.roundstasAdd(round_id,coach_id,stat_id,rno,rscore,rclock,rtime);
				}

				String result = "回合表roundstas的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "回合表roundstas的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		// 接收回合表roundstas结束
		
		// 接收拍表clockstas开始
		try {
			String json1 = request.getParameter("clockstashead");// 接收clockstas表的头数据
			String json2 = request.getParameter("clockstas");// 接收clockstas表数据
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				ClockstasAction clockstasaction = new ClockstasAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject

					String clock_id = systemtime + " "+ resultObj.getString("clock_id"); // 用（系统时间+id）构造成新的主键
					int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // 外键值必须保证与主键表的值一致，所以time要一样
					int ckno = resultObj.getInt("ckno");
					int score = resultObj.getInt("score");

					clockstasaction.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
				}

				String result = "回合表roundstas的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "回合表roundstas的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		// 接收拍表clockstas结束
		
		// 接收最后一拍表last_beat开始
		try {
			String json1 = request.getParameter("last_beathead");// 接收last_beat表的头数据
			String json2 = request.getParameter("last_beat");// 接收last_beat表数据
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				Last_beatAction last_beataction = new Last_beatAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject

					String last_beatId = systemtime + " "+ resultObj.getString("last_beatId"); // 用（系统时间+id）构造成新的主键
					int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
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

				String result = "最后一拍表last_beat的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "最后一拍表last_beat的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		// 接收最后一拍表last_beat结束
		
		// 接收每回合列表round开始
		try {
			String json1 = request.getParameter("roundhead");// 接收round表的头数据
			String json2 = request.getParameter("round");// 接收round表数据
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				RoundAction roundaction = new RoundAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject

					String round_id = systemtime + " "+ resultObj.getString("round_id"); // 用（系统时间+id）构造成新的主键
					int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					String stat_id = systemtime + " "+ resultObj.getString("stat_id"); // 外键值必须保证与主键表的值一致，所以time要一样
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

				String result = "每回合列表round的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "每回合列表round的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		// 接收每回合列表round结束
				
		// 接收每拍技术统计表every_beat开始
		try {
			String json1 = request.getParameter("every_beathead");// 接收every_beat表的头数据
			String json2 = request.getParameter("every_beat");// 接收every_beat表数据
			json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:" + json1);
				JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

				System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				Every_beatAction every_beataction = new Every_beatAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间

				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject

					String every_beatId = systemtime + " "+ resultObj.getString("every_beatId"); // 用（系统时间+id）构造成新的主键
					int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // 外键值必须保证与主键表的值一致，所以time要一样
					int athlete_id = resultObj.getInt("athlete_id");
					int skill_id = resultObj.getInt("skill_id");
					int way_id = resultObj.getInt("way_id");
					float distance = resultObj.getLong("distance");
					int drop_area = resultObj.getInt("drop_area");
					int posture = resultObj.getInt("posture");
					int be_aggressive = resultObj.getInt("be_aggressive");

					every_beataction.every_beatAdd(every_beatId,coach_id,round_id,athlete_id,skill_id,way_id,distance,drop_area,posture,be_aggressive);
				}

				String result = "每拍技术统计表every_beat的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "每拍技术统计表every_beat的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) 报错："
							+ e.getMessage());
		}
		// 接收每拍技术统计表every_beat结束
		
		//接收其他表。。。。。
		
		
	}
}
