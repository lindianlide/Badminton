<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*,com.badminton.app.CoachAction,com.badminton.entity.Coach"%>
<%
    CoachAction coachaction = new CoachAction();
	ArrayList<Coach> arraylist = coachaction.coachList();
	String event_name="";
	String status="";
	request.setCharacterEncoding("utf-8"); 
	String coach_name=request.getParameter("coach_name");
    int i=0;
    if(arraylist!=null) 
 	  for(int j=0;j<arraylist.size();j++){
 		 System.out.println(arraylist.get(j).getCoach_name());
 		 if(arraylist.get(j).getCoach_name().equals(coach_name))
 			{
 			 i=j;
			 break;
 			}
 	  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教练员基本信息</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
.tablestyle_title{
	/*height: 20px; font-style: normal; font-variant: normal; font-weight: bold; font-size: 16px;letter-spacing: 2px; text-align: middle; border-top: 2px solid #ff7300; padding-left: 10px; background-color: #f0f0f0;text-align:center;*/
	background:#6795B4;
	padding:5px;
	text-align:center;
	color:#FFFFFF;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	height: 20px;
	font-style: normal; font-variant: normal; font-weight: bold; font-size: 16px;letter-spacing: 2px; padding-left: 10px; 
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form name="form2" id="form2" method="post" action="./coach_query2.jsp">
<table id="mainpage2" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
		   <table width="89%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="89">&nbsp;</td>
			<td width="984">按教练员姓名：<input name="coach_name" type="text" size="25"/>
			<img src="../images/ico07.gif" width="20" height="18" />
			  <input name="Submit" type="Submit" class="right-button02" value="查 询" />
			 </td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="30">&nbsp;</td>
          	 </tr>
              <tr>
                <td class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
					                  
					                  <tr>
                    <td height="35" colspan="7" class="tablestyle_title">教练员基本信息列表</td>
                    </tr>
                  <tr>
				    <td width="10%" height="30" align="center" bgcolor="#EEEEEE">教练员编号</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">教练员姓名</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">教练员性别</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">出生年月</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">运动项目</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">服役状态</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">经历</td>
                  </tr>
                  <% 
                         if(arraylist.get(i).getEvent_id()==1)
                		   event_name="单打";
                		  else if(arraylist.get(i).getEvent_id()==2)
                		   event_name="双打";
                		  else
                			  event_name="混双";
                		      
                         //联用if就乱了
                         int x=Integer.parseInt(arraylist.get(i).getService_status());
                         switch(x){
                              case(1):
                    	            status="是";
                                    break;
                              case(2):
                                 	status="否";
                                    break;
                         }
                   %>
                  <tr align="center">
				    <td height="30" bgcolor="#FFFFFF"><%=arraylist.get(i).getCoach_id()%></td>
				    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getCoach_name()%></td>
				    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getCoach_sex()%></td>
				    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getCoach_age()%></td>
				    <td bgcolor="#FFFFFF"><%=event_name%></td>
				    <td bgcolor="#FFFFFF"><%=status%></td>
                    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getExperience()%></td>
                  </tr>
                </table></td>
              </tr>
            </table>
            </td>
        </tr>
      </table>
      
     <table width="100%" border="0" cellpadding="0" cellspacing="0" style="width:90%">
      <tr>
      <TD colspan="1" align="right" height="72">
	  <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/></TD>
	  </tr>
     </table></td>
              </tr>
          </table>
</form>

</body>

</html>