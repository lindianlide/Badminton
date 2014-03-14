package com.badminton.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badminton.app.ClockstasAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonClockstas extends HttpServlet {
	public JsonClockstas() {
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
			//String json1 = request.getParameter("json1");// 接收clockstas表的头数据
			String json2 = request.getParameter("json2");// 接收clockstas表数据
			//json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

//			if ((json1 != "")&&(json2 != "")) {
				if (json2 != "") {

			//	System.out.println("json1:" + json1);
			//	JSONObject jsonObject1 = JSONObject.fromObject(json1);// 根据字符串生成json对象
			//	System.out.println(jsonObject1.getString("coach_id"));// 得到头数据中的各个字段，一般有coach_id

			//	System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// 根据字符串生成JSON数组

				ClockstasAction clockstasaction = new ClockstasAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String systemtime = df.format(new java.util.Date());// new Date()为获取当前系统时间
				int size=0;
				int i1=0;
				for(Object resultObj: jsonArray2.toArray())
				{ 
					i1++;
				}
				size=i1;
				List list=jsonArray2.toList(jsonArray2);
				Iterator it=list.iterator();
				while(it.hasNext())
				{
					JSONObject resultObj=(JSONObject.fromObject(it.next())) ;
					String clock_id = systemtime + " "+resultObj.getString("clock_id"); // 用（系统时间+id）构造成新的主键
					//int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					int coach_id=101;
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // 外键值必须保证与主键表的值一致，所以time要一样
					int ckno = resultObj.getInt("ckno");
					int score = resultObj.getInt("score");
					//System.out.println(resultObj.getString("clock_id"));
					clockstasaction.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
				}
				System.out.println("拍表数据上传成功！");
				
				
				
				/*for (int i = 0; i <list.size(); i++) {
					//JSONObject resultObj = jsonArray2.optJSONObject(i);// 根据JSONArray生成JSONObject
					
					String clock_id = systemtime + " "+resultObj.getString("clock_id"); // 用（系统时间+id）构造成新的主键
					//int coach_id = resultObj.getInt("coach_id");// coach_id一般不是这么得到的
					int coach_id=101;
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // 外键值必须保证与主键表的值一致，所以time要一样
					int ckno = resultObj.getInt("ckno");
					int score = resultObj.getInt("score");

					clockstasaction.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
				}*/
				//JSONObject resultObj = jsonArray2.optJSONObject(0);
               
				
				
				String result = "拍表clockstas的数据上传成功！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// 操作数据库

			} else {

				String result = "拍表clockstas的数据传输过程出错，请重传！";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ："
							+ e.getMessage());
		}
	}
		// 接收拍表clockstas结束
	
	public void init() throws ServletException {
	}
	
	
}
