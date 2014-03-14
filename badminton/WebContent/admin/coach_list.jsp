<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*,com.badminton.app.CoachAction,com.badminton.entity.Coach"%>
<%
    CoachAction coachaction = new CoachAction();
	ArrayList<Coach> arraylist = coachaction.coachList();
%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教练员列表</title>
<base href="<%=basePath%>">
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

<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE2 {font-size: 16px}
-->
</style>
</head>
<SCRIPT language=JavaScript>

function insert()
{
	window.open('./admin/coach_insert.jsp','mainFrame','top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}

</SCRIPT>

<body>
<form name="form1" id="form1" method="post" action="./admin/coach_query.jsp">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="./images/nav04.gif">
		   <table width="89%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="89">&nbsp;</td>
			<td width="984">按教练员姓名：<input name="coach_name" type="text" size="25"/>
			<img src="./images/ico07.gif" width="20" height="18" />
			  <input name="Submit" type="Submit" class="right-button02" value="查 询" />
			  
			 </td>
			 <td width="175" align="left">
			   <input name="Submit" type="Submit" class="right-button07" value="添加教练员" onClick="insert()"/>
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
                    <td height="35" colspan="6" class="tablestyle_title">教练员列表</td>
                    </tr>
                  <tr>
				    <td width="50%" height="30" align="center" bgcolor="#EEEEEE">教练员姓名</td>
                    <td width="50%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <%if(arraylist!=null) 
                	  for(int i=0;i<arraylist.size();i++){ %>
                  <tr align="center">
				    <td height="30" bgcolor="#FFFFFF"><%=arraylist.get(i).getCoach_name()%></td>
                    <td bgcolor="#FFFFFF"><a href="CoachServlet?id=<%=arraylist.get(i).getCoach_id()%>&flag=2">删除</a></td>
                  </tr>
                  <%} %>
                </table></td>
              </tr>
            </table>
            </td>
        </tr>
      </table>
      
      <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="./images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">1</span> 页 | 第 <span class="right-text09">1</span> 页</td>
                <td width="48%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至：</td>
                <td width="2%"><table width="29" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table>
   </td>
  </tr>
</table>
</form>

</body>

</html>