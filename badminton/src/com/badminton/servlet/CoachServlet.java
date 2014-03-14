package com.badminton.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badminton.app.CoachAction;

/**
 * Servlet implementation class CoachServlet
 */
public class CoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoachServlet() {
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
			String id1=request.getParameter("coach_id");
			   int coach_id=Integer.parseInt(id1); 
		String coach_name=request.getParameter("coach_name");
			String coach_sex=request.getParameter("coach_sex");
			String sdate=request.getParameter("coach_age");
	        	Date coach_age = Date.valueOf(sdate);//把String转换成Date	
			/*	String id2=request.getParameter("coach_id");
				int coach_id=Integer.parseInt(id2);
				*/
			String id3=request.getParameter("event_id");
				int event_id=Integer.parseInt(id3);
			String service_status=request.getParameter("service_status");
			String experience=request.getParameter("experience");
			System.out.println(id1);

		CoachAction coachaction=new CoachAction();
		boolean result = coachaction.coachAdd(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience);
		        if (result){
		        	System.out.println("增加成功,查看后台程序");//换成跳到原页面
		            response.sendRedirect("./admin/coach_list.jsp");
		        }
				else
					System.out.println("增加失败,查看后台程序");

		}
		else if(flag.equals("2")){
		String id=request.getParameter("id");
			int coach_id=Integer.parseInt(id);
		CoachAction coachaction=new CoachAction();
		boolean result=coachaction.coachDel(coach_id);
		 
		if (result){
			System.out.println("删除失败,查看后台程序");
			response.sendRedirect("./admin/coach_list.jsp");
		}
		  else
			System.out.println("删除失败,查看后台程序");
		}

		else if(flag.equals("3")){

			String id1=request.getParameter("coach_id");
			   int coach_id=Integer.parseInt(id1); 
		String coach_name=request.getParameter("coach_name");
			String coach_sex=request.getParameter("coach_sex");
			String sdate=request.getParameter("coach_age");
	        	Date coach_age = Date.valueOf(sdate);//把String转换成Date	
			/*	String id2=request.getParameter("coach_id");
				int coach_id=Integer.parseInt(id2);
				*/
			String id3=request.getParameter("event_id");
				int event_id=Integer.parseInt(id3);
			String service_status=request.getParameter("service_status");
			String experience=request.getParameter("experience");
			System.out.println(id1);

		CoachAction coachaction=new CoachAction();
		boolean result = coachaction.coachUpdate(coach_id,coach_name,coach_sex,coach_age,event_id,service_status,experience);
		        if (result){
		        	System.out.println("修改成功,查看后台程序");
		            response.sendRedirect("./admin/coach_infor.jsp");
		        }
				else
					System.out.println("修改失败,查看后台程序");

		}
		
	}
	

}
