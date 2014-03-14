<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*,com.badminton.app.CoachAction,com.badminton.entity.Coach"%>

 <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
//当前目录变了，变成什么了？导致字体的路径也变了
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改教练员信息</title>
<base href="<%=basePath%>">
<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
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
<body onLoad="xiala()">
<form action="CoachServlet?flag=1" method="post" name="form">
<div class="MainDiv">

<!-- 加上body的约束，蓝条就没有空隙了 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr><td align="left" height="62" background="./images/nav04.gif"></td></tr>
  <tr><td>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >修改教练员基本信息页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<div align="center">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" style="width:60%">
		    <tr><td align="left"></td></tr>
		    <TR>
		      <TD width="100%" height="103">
		        <fieldset style="height:100%;">
		          <legend>修改</legend>
				      <table width="100%" border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td width="100" align="right" nowrap>教练员编号：</td>
					    <td width="300" align="left"><input name='coach_id' id='coach_id' type="text" class="text" style="width:154px"  />
				        <span class="red">*（不能修改）</span></td>
				        	
					    <td width="100" align="right" nowrap> 教练员姓名：</td>
					    <td width="300" align="left"><input name='coach_name' id='coach_name' type="text" class="text" style="width:154px" />
				        </td>
					    </tr>
						
						<tr>
					    <td nowrap align="right">教练员性别：</td>
					    <td align="left">
					         <select name="coach_sex" id="coach_sex">
									<option value="男">男</option>
									<option value="女">女</option>
							</select>
                        </td>
                        
				        <td nowrap align="right">出生年月：</td>
					    <td align="left"><input name='coach_age' id='coach_age' type="text" class="text" style="width:154px"  />
					    </td>	
						</tr>
						
						<tr>	
							<td nowrap align="right">运动项目：</td>
							<td align="left">
								<select name="event_id" id="event_id">
									<option  value=1>单打</option>
									<option  value=2>双打</option>
									<option  value=3>混双</option>
								</select>
							</td>
							
							<td nowrap align="right">是否现役：</td>
							<td align="left">
							<select name="service_status" id="service_status">
								<option  value=1>是</option>
								<option  value=2>否</option>
							</select>
							</td>
				        </tr>
				        
					  <tr>
					    <td nowrap align="right">经历：</td>
					    <td colspan="3"><textarea name="experience" id="experience" cols="100" rows="10"></textarea></td>
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
      <TD colspan="2" align="center" height="72">
	  <input type="submit" name="Submit" value="保存" />　
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
