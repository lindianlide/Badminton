package com.badminton.servlet;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
//import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badminton.app.AthleteAction;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray; 

public class JsonServer extends HttpServlet {
	public JsonServer() {
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

		try {
			String json1 = request.getParameter("athletehead");//接收athlete表的头数据
			String json2 = request.getParameter("athlete");//接收athlete表数据
			json1 = java.net.URLDecoder.decode(json1,"UTF-8"); 
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");
		//	System.out.println("json1:"+json1);
		//	System.out.println("json2:"+json2);

			if ((json1 != "") && (json2 != "")) {

				System.out.println("json1:"+json1);
				JSONObject jsonObject1 =JSONObject.fromObject(json1);//根据字符串生成json对象
				System.out.println(jsonObject1.getString("coach_id"));

				System.out.println("json2:"+json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组
				
				AthleteAction athleteaction=new AthleteAction();
		  		for(int i=0;i<jsonArray2.length();i++){ 
		            JSONObject resultObj = jsonArray2.optJSONObject(i);//根据JSONArray生成JSONObject
		            int athlete_id=resultObj.getInt("athlete_id");
		            String athlete_name=resultObj.getString("athlete_name");
		            String athlete_sex=resultObj.getString("athlete_sex");
		            
		            String age=resultObj.getString("athlete_age");
		            Date athlete_age = Date.valueOf(age);//把String转换成Date
		           
		            int coach_id=resultObj.getInt("coach_id");
		            int event_id=resultObj.getInt("event_id");
		            System.out.println(athlete_name);
		            String service_status=resultObj.getString("service_status");
		            String experience=resultObj.getString("experience");
		            
		       		athleteaction.athleteAdd(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);
		   		}
		  		
		  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String time = df.format(new java.util.Date());// new Date()为获取当前系统时间
				String play_id = "1";
				String newid = time+" "+play_id;        //用（系统时间 id）构造成新的主键
				System.out.println(newid);

				String result = "数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else{
				
				String result = "传输过程出错，请重传！";
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
	}

/* 传多个参数没有用到
 * 	private String readJSONStringFromRequestBody(HttpServletRequest request){
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
		  BufferedReader reader = request.getReader();
		  while((line = reader.readLine()) != null) {
		     json.append(line);
		  }
		}
		catch(Exception e) {
		  System.out.println(e.toString());
		}
	    return json.toString();
	}
*/	
	
	public void init() throws ServletException {
	}
	
	
}
