<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
//当前目录变了，变成什么了？导致字体的路径也变了
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加管理员</title>
<base href="<%=basePath%>">
<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">

function save()
{
	//检查
	alert("数据库中已经有该管理员的信息！");
	//insert操作
}

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
<form action="UserServlet?flag=1" method="post"  name="form">
<div class="MainDiv">

<!-- 加上body的约束，蓝条就没有空隙了 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr><td align="left" height="62" background="../images/nav04.gif"></td></tr>
  <tr><td>
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >添加管理员页面</th>
  </tr>
  <tr>
    <td class="CPanel"> 
		<div align="center">
		  <table width="60%" border="0" cellpadding="0" cellspacing="0" style="width:60%">
		    <tr><td align="left"></td></tr>
		    <TR>
		      <TD width="100%" height="103">
		        <fieldset style="height:100%;">
		          <legend>添加</legend>
				      <table width="85%" border="0" cellpadding="2" cellspacing="1" style="width:100%"> 
				          <tr>
				            <td  width="35%" height="82" align="center" nowrap>管理员编号:</td>
				            <td colspan="3"><input name="userid" type="text" size="25"/>
				            
				            <td  width="35%" height="82" align="center" nowrap>管理员姓名:</td>
				            <td colspan="3"><input name="username" type="text" size="25"/>
				          </tr>
				           <tr>
				            <td  width="35%" height="82" align="center" nowrap>密码:</td>
				            <td colspan="3"><input name="password" type="text" size="25"/>
				            
				            <td  width="35%" height="82" align="center" nowrap>角色:</td>
				            <td colspan="3"><input name="role" type="text" size="25"/>
				          </tr>
			          </table>
			      <br />
	            </fieldset>			
	          </TD>
		  </TR>
		 </table>
	    </div>
	</td>
  </tr>

   <TR>
      <TD colspan="2" align="center" height="72">
	  <input type="Submit" name="Submit" value="保存" />　
	  <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/></TD>
   </TR>
</table>
</td>
</tr>
</table>
</div>
</form>
</body>
</html>
