package com.badminton.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.badminton.app.UserAction;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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

			String id1=request.getParameter("userid");
			   int userid=Integer.parseInt(id1); 
		    String username=request.getParameter("username");
			String password=request.getParameter("password");
			String role=request.getParameter("role");
			System.out.println(id1);

		   UserAction useraction=new UserAction();
		boolean result = useraction.userAdd(userid,username,password,role);
		        if (result){
		        	System.out.println("增加成功,查看后台程序");
		           // response.sendRedirect("./admin/athlete_infor.jsp");
		        }
				else
					System.out.println("增加失败,查看后台程序");
		}
		
		else if(flag.equals("2")){
		String id=request.getParameter("id");
			int userid=Integer.parseInt(id);
			UserAction useraction=new UserAction();
		boolean result=useraction.userDel(userid);
		 
		if (result){
			System.out.println("删除成功,查看后台程序");
			response.sendRedirect("./admin/admin_list.jsp");
		}
		  else
			System.out.println("删除失败,查看后台程序");
		}
	}

}
