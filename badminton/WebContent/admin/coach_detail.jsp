<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*,com.badminton.app.CoachAction,com.badminton.entity.Coach"%>
<%
    CoachAction coachaction = new CoachAction();
	ArrayList<Coach> arraylist = coachaction.coachList();
    String id=request.getParameter("id");
    int id1=Integer.parseInt(id);
  // System.out.print(arraylist.get(0).getCoach_id()==id1);
    int i=0;
    if(arraylist!=null) 
 	  for(int j=0;j<arraylist.size();j++){
 		 if(arraylist.get(j).getCoach_id()==id1)
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
<title>运动员基本信息</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">

</script>
<style type="text/css">
<!--

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.CContent{
	border-top: 1px solid #5F8FB0;
	border-right: 1px solid #5F8FB0;
	border-bottom: 1px solid #5F8FB0;
	border-left: 1px solid #5F8FB0;
	background-color: #FFFFFF;
}
.red{color: #f00;}
.tablestyle_title{
	/*height: 20px; font-style: normal; font-variant: normal; font-weight: bold; font-size: 16px;letter-spacing: 2px; text-align: middle; border-top: 2px solid #ff7300; padding-left: 10px; background-color: #f0f0f0;text-align:center;*/
	background:#6795B4;
	padding:5px;
	text-align:left;
	color:#FFFFFF;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	height: 20px;
	font-style: normal; font-variant: normal; font-weight: bold; font-size: 16px;letter-spacing: 2px; padding-left: 10px; 
}
-->
</style>
</head>
<body>
<form action="" method="post" enctype="multipart/form-data" name="form" target="sypost">
<div class="MainDiv">

<!-- 加上body的约束，蓝条就没有空隙了 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr><td align="left" height="62" background="../images/nav04.gif"></td></tr>
  <tr><td>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >查看运动员基本信息页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<div align="center">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" style="width:60%">
		    <tr><td align="left"></td></tr>
		    <TR>
		      <TD width="100%" height="103">
		        <fieldset style="height:100%;">
		          <legend>基本信息</legend>
				      <table width="100%" border="1" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td width="100" align="right" nowrap>运动员编号：</td>
					    <td width="300" align="left"><%=id%></td>
				        	
					    <td width="100" align="right" nowrap>运动员姓名：</td>
					    <td width="300" align="left"><%=arraylist.get(i).getCoach_name()%></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right">运动员性别：</td>
					    <td align="left"><%=arraylist.get(i).getCoach_sex()%></td>
                        
				        <td nowrap align="right">出生年月：</td>
					    <td align="left"><%=arraylist.get(i).getCoach_age()%></td>	
						</tr>
						
						<tr>	
							<td nowrap align="right">运动项目：</td>
							<td align="left"><%=arraylist.get(i).getEvent_id()%></td>
							
							<td nowrap align="right">是否现役：</td>
							<td align="left"><%=arraylist.get(i).getService_status()%></td>
				        </tr>
				        
					  <tr>
					    <td nowrap align="right">经历：</td>
					    <td colspan="3"> <%=arraylist.get(i).getExperience()%></td>
					   </tr>
					  </table>
			  <br />
				</fieldset>			
			</TD>
		</TR>
		</TABLE>
	</div>
	
	 </td>
  </tr>
  	
		<TR>
      <TD colspan="1" align="center" height="72">
	  <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/></TD>
       </TR>
   </TABLE>
  </td>
  </tr>
 </table>
</div>
</form>
</body>
</html>
