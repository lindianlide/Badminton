<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form id="form1" name="form1" method="post" action="UserLogin"> 
    <div id="login">
	
	     <div id="top">
		      <div id="top_left"><img src="images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			       <div id="user">用 户
			         <input type="text" name="username" />
			       </div>
				   <div id="password">密   码
				     <input type="password" name="password" />
				   </div>
				   <div id="btn">
				   <table width="160" border="0"  cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="80"><label>
                        <input type="submit" name="Submit" value="登录" style="width: 70px; ">
                        <br>
                      </label></td>
                      <td width="80"><label>
                        <input type="reset" name="Submit2" value="重置" style="width: 70px;">
                      </label></td>
                    </tr>
                  </table>
			  </div>
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">综合信息处理平台 2013 v1.0</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div>
</form>
</body>
</html>
