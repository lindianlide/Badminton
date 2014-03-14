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
		
        response.setContentType("text/xml");//��xml
        response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		
	    PrintWriter out = response.getWriter();

	    try {
			//String json1 = request.getParameter("json1");// ����clockstas���ͷ����
			String json2 = request.getParameter("json2");// ����clockstas������
			//json1 = java.net.URLDecoder.decode(json1, "UTF-8");
			json2 = java.net.URLDecoder.decode(json2, "UTF-8");

//			if ((json1 != "")&&(json2 != "")) {
				if (json2 != "") {

			//	System.out.println("json1:" + json1);
			//	JSONObject jsonObject1 = JSONObject.fromObject(json1);// �����ַ�������json����
			//	System.out.println(jsonObject1.getString("coach_id"));// �õ�ͷ�����еĸ����ֶΣ�һ����coach_id

			//	System.out.println("json2:" + json2);
				JSONArray jsonArray2 = JSONArray.fromObject(json2);// �����ַ�������JSON����

				ClockstasAction clockstasaction = new ClockstasAction();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String systemtime = df.format(new java.util.Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
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
					String clock_id = systemtime + " "+resultObj.getString("clock_id"); // �ã�ϵͳʱ��+id��������µ�����
					//int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					int coach_id=101;
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int ckno = resultObj.getInt("ckno");
					int score = resultObj.getInt("score");
					//System.out.println(resultObj.getString("clock_id"));
					clockstasaction.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
				}
				System.out.println("�ı������ϴ��ɹ���");
				
				
				
				/*for (int i = 0; i <list.size(); i++) {
					//JSONObject resultObj = jsonArray2.optJSONObject(i);// ����JSONArray����JSONObject
					
					String clock_id = systemtime + " "+resultObj.getString("clock_id"); // �ã�ϵͳʱ��+id��������µ�����
					//int coach_id = resultObj.getInt("coach_id");// coach_idһ�㲻����ô�õ���
					int coach_id=101;
					String round_id = systemtime + " "+ resultObj.getString("round_id"); // ���ֵ���뱣֤���������ֵһ�£�����timeҪһ��
					int ckno = resultObj.getInt("ckno");
					int score = resultObj.getInt("score");

					clockstasaction.clockstasAdd(clock_id,coach_id,round_id,ckno,score);
				}*/
				//JSONObject resultObj = jsonArray2.optJSONObject(0);
               
				
				
				String result = "�ı�clockstas�������ϴ��ɹ���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();

				// �������ݿ�

			} else {

				String result = "�ı�clockstas�����ݴ�����̳������ش���";
				out.println("<response>");
				out.println("<result>" + result + "</result>");
				out.println("</response>");
				out.close();
			}

		} catch (Exception e) {
			System.out
					.println("JsonServer doPost(HttpServletRequest request, HttpServletResponse response) ��"
							+ e.getMessage());
		}
	}
		// �����ı�clockstas����
	
	public void init() throws ServletException {
	}
	
	
}
