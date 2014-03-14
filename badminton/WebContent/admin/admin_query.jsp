<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ page import="java.sql.*,java.util.*,com.badminton.app.UserAction,com.badminton.entity.User"%>
<%
    UserAction useraction = new UserAction();
	ArrayList<User> arraylist = useraction.userList();
	request.setCharacterEncoding("utf-8"); 
	String username=request.getParameter("username");
    int i=0;
    if(arraylist!=null) 
 	  for(int j=0;j<arraylist.size();j++){
 		 if(arraylist.get(j).getUsername().equals(username))
 			{
 			 i=j;
			 break;
 			}
 	  }
    System.out.println(i);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>运动员基本信息</title>
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

<form name="form1" id="form1" method="post" action="./admin_query.jsp">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
		   <table width="89%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="89">&nbsp;</td>
			<td width="984">按管理员姓名：<input name="athlete_name" type="text" size="25"/>
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
                    <td height="35" colspan="7" class="tablestyle_title">管理员基本信息列表</td>
                    </tr>
                  <tr>
				    <td width="10%" height="30" align="center" bgcolor="#EEEEEE">管理员编号</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">管理员员姓名</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">密码</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">角色</td>
                  </tr>       
                  <tr align="center">
				    <td height="30" bgcolor="#FFFFFF"><%=arraylist.get(i).getUserid()%></td>
				    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getUsername()%></td>
				    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getPassword()%></td>
				    <td bgcolor="#FFFFFF"><%=arraylist.get(i).getRole()%></td>
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
     </table>
      </table>
</form>

</body>

</html>