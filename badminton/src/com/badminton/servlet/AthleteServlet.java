package com.badminton.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badminton.app.AthleteAction;

/**
 * Servlet implementation class AthleteServlet
 */
public class AthleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AthleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		request.setCharacterEncoding("utf-8");

		String flag=request.getParameter("flag");
		//flag 1:增加 2:删除
		if(flag.equals("1")){

			String id1=request.getParameter("athlete_id");
			   int athlete_id=Integer.parseInt(id1); 
		String athlete_name=request.getParameter("athlete_name");
			String athlete_sex=request.getParameter("athlete_sex");
			String sdate=request.getParameter("athlete_age");
	        	Date athlete_age = Date.valueOf(sdate);//把String转换成Date	
			/*	String id2=request.getParameter("coach_id");
				int coach_id=Integer.parseInt(id2);
				*/
	        	int coach_id=102;
			String id3=request.getParameter("event_id");
				int event_id=Integer.parseInt(id3);
			String service_status=request.getParameter("service_status");
			String experience=request.getParameter("experience");
			System.out.println(id1);

		AthleteAction athleteaction=new AthleteAction();
		boolean result = athleteaction.athleteAdd(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);
		        if (result){ 
		           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "增加成功", "提示框", JOptionPane.ERROR_MESSAGE);
		           response.sendRedirect("./admin/athlete_list.jsp");
		        }
				else
					System.out.println("增加失败,查看后台程序");
		}
		
		else if(flag.equals("2")){
		String id=request.getParameter("id");
			int athlete_id=Integer.parseInt(id);
		AthleteAction athleteaction=new AthleteAction();
		boolean result=athleteaction.athleteDel(athlete_id);
		 
		if (result){
			System.out.println("删除失败,查看后台程序");
			response.sendRedirect("./admin/athlete_list.jsp");
		}
		  else
			System.out.println("删除失败,查看后台程序");
		}

		else if(flag.equals("3")){

			String id1=request.getParameter("athlete_id");
			   int athlete_id=Integer.parseInt(id1); 
		String athlete_name=request.getParameter("athlete_name");
			String athlete_sex=request.getParameter("athlete_sex");
			String sdate=request.getParameter("athlete_age");
	        	Date athlete_age = Date.valueOf(sdate);//把String转换成Date	
			/*	String id2=request.getParameter("coach_id");
				int coach_id=Integer.parseInt(id2);
				*/
	        	int coach_id=102;
			String id3=request.getParameter("event_id");
				int event_id=Integer.parseInt(id3);
			String service_status=request.getParameter("service_status");
			String experience=request.getParameter("experience");
			System.out.println(id1);

		AthleteAction athleteaction=new AthleteAction();
		boolean result = athleteaction.athleteUpdate(athlete_id,athlete_name,athlete_sex,athlete_age,coach_id,event_id,service_status,experience);
		        if (result){
		        	System.out.println("修改成功,查看后台程序");
		            response.sendRedirect("./admin/athlete_infor.jsp");
		        }
				else
					System.out.println("修改失败,查看后台程序");

		}
		
	}
	

}
