<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(../images/left.gif);
}
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>

function list(idstr){             //点击某主菜单事件
	
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.getElementById(name1);          //得到子菜单表格的id
	var imgobj=document.getElementById(name2);             //得到主菜单的id
	
	if(objectobj.style.display=="none"){        //如果子菜单表格没有显示  //那就让其显示
		for(var i=1;i<8;i++)        //共有n个子菜单表格（即n个主菜单）//我们的系统有几个？先暂定7个
	    {                     
			var name3="img"+i;
			var name4="subtree"+i;
			var o=document.getElementById(name4);
			if(o!=undefined)
			{
				o.style.display="none";           //让所有的子菜单表格隐藏
				var image=document.getElementById(name3);
				image.src="../images/ico04.gif";   //让所有的主菜单图标为朝右三角形（ico04）
			}
		}
		objectobj.style.display="";           //只让点击的该子菜单表格显示
		imgobj.src="../images/ico03.gif";      //只让点击的该主菜单图标为朝下三角形（ico03）
	}
	
	else    //如果子菜单表格已经显示了，说明主菜单之前已经点击过，本次点击就是让其归位   //那就让其隐藏
	{    
		objectobj.style.display="none";         //让该子菜单表格隐藏
		imgobj.src="../images/ico04.gif";          //让该主菜单图标为朝右三角形（ico04）
	}
}

function tu(idt){              //点击某个子菜单事件
    var nametu1="xiao"+idt;
    var tp1 = document.getElementById(nametu1);     //得到该子菜单的id
    tp1.src="../images/ico05.gif";                 //让该子菜单的图标变成蓝色的小方块（ico05）
	
	for(var i=1;i<19;i++)           //检查所有的子菜单图标，检查了18个
	{
	  var nametu2="xiao"+i; 
	  if(i!=idt*1)            //如果不是被点击的子菜单
	  {
	    var tp2=document.getElementById(nametu2);       //得到其id
		if(tp2!=undefined)
	    {tp2.src="../images/ico06.gif";}      //让子菜单（其他没有被点击的）图标变成初始的白色的小方块（ico06）
	  }
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="../images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="../images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">管理员</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="../login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<!--  权限管理开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('1');" >权限管理</td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiao1" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="admin_list.jsp" target="mainFrame" class="left-font03" onClick="tu('1');">管理系统管理员</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiao2" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="coach_list.jsp" target="mainFrame" class="left-font03" onClick="tu('2');">管理教练员</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiao3" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="athlete_list.jsp" target="mainFrame" class="left-font03" onClick="tu('3');">管理运动员</a></td>
				</tr>
      </table>
		<!--  权限管理结束    -->

		

		<!--  人员基本信息管理开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('2');" >人员基本信息管理</td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiao4" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="coach_infor.jsp" target="mainFrame" class="left-font03" onClick="tu('4');">教练员信息</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiao5" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
					<a href="athlete_infor.jsp" target="mainFrame" class="left-font03" onClick="tu('5');">运动员信息</a></td>
				</tr>
      </table>
		<!--  人员基本信息管理结束    -->



        <!--  信息资料库开始    -->
        
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img3" id="img3" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('3');" >信息资料库</td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiao6" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('6');">预留</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiao7" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('7');">预留</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiao8" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('8');">预留</a></td>
				</tr>
		</table>
		<!--  信息资料库结束    -->



	  <!--  视频资料管理开始    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img4" id="img4" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('4');" >视频资料管理</td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree4" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
          <td width="9%" height="20" ><img id="xiao9" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('9');">预留</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiao10" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('10');">预留</a></td>
        </tr>
      </table>

	  <!--  视频资料管理结束    -->



	  <!--  辅助信息管理开始    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img5" id="img5" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('5');" >辅助信息管理</td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree5" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20" ><img id="xiao11" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('11');">预留</a></td>
        </tr>
		<tr>
          <td width="9%" height="20" ><img id="xiao12" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('12');">预留</a></td>
        </tr>
		<tr>
          <td width="9%" height="20" ><img id="xiao13" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('13');">预留</a></td>
        </tr>
      </table>
	
	  <!--  辅助信息管理结束    -->



	   <!--  数据挖掘开始    -->
	   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img6" id="img6" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('6');" >数据挖掘</td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree6" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
		<tr>
          <td width="9%" height="20" ><img id="xiao14" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('14');">场信息挖掘</a></td>
        </tr>
	  	<tr>
          <td width="9%" height="20" ><img id="xiao15" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('15');">局信息挖掘</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiao16" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('16');">回合信息挖掘</a></td>
        </tr>
	  	<tr>
          <td width="9%" height="20" ><img id="xiao17" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('17');">进攻回合信息挖掘</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiao18" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tu('18');">最后一拍信息挖掘</a></td>
        </tr>
      </table>

      <!--  数据挖掘结束    -->



	  <!-- 个人管理开始 -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%"><img name="img7" id="img7" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%" style="cursor:pointer;" class="left-font03" onClick="list('7');">个人管理</td>
                </tr>
            </table></td>
          </tr>
      </table>
	  <!-- 个人管理结束-->
    </TD>
  </tr> 
</table>

</body>
</html>