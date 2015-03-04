<%@ page language="java" contentType="text/html;"  import="com.bfw.domain.UserInfo" pageEncoding="UTF-8"%>


<%
//获取当前用户登录的权限

UserInfo user = (UserInfo)session.getAttribute("userinfo");

if(user!=null){
	
	//普通用户权限
	if("1".equals(user.getUserAnthority())){
		%>
		
		<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="meetingRoomBespeakServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室预约
		</a></li>
		<li><a href="meetingRoomBespeakListServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 会议室预约修改
		</a></li>
		<li><a href="mymeetingroomBespeakQueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 我的预约查询
		</a></li>

	</ul></li>
		
		<%
	}
	
	//普通管理员权限
	if("2".equals(user.getUserAnthority())){
		%>
		
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 设备管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">
		<li><a href="view/enzhequipment/enzhequipment_add.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i> 添加设备
		</a></li>
		<li><a href="enquipmentMainServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 设备管理
		</a></li>
		<li><a href="enquipmentListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 设备查询
		</a></li>

	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 会议室管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="meetingRoomAddServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 添加会议室
		</a></li>
		<li><a href="meetingRoomServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室管理
		</a></li>
		<li><a href="meetingRoomListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室查询
		</a></li>

	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="meetingRoomBespeakServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室预约
		</a></li>
		<li><a href="meetingRoomBespeakListServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 会议室预约修改
		</a></li>
		<li><a href="meetingRoomBespeakAuditingServlet"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				会议室预约审核
		</a></li>
		<li><a href="mymeetingroomBespeakQueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 我的预约查询
		</a></li>
		<li><a href="meetingroomBespeakQueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 预约查询
		</a></li>
		<li><a href="mymeetingroomBespeakAudqueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 我的审核
		</a></li>
	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 系统管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="view/userinfo/userinfo_add.jsp" target="mainframe">
				<i class="icon-double-angle-right"></i> 添加用户
		</a></li>
		<li><a href="userInfListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 用户信息管理
		</a></li>
		<li><a href="userInfoQueryServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 查询用户信息
		</a></li>


	</ul></li>
		<%
	}
	
	//系统管理员权限
	if("3".equals(user.getUserAnthority())){
		%>
		
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 设备管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">
		<li><a href="view/enzhequipment/enzhequipment_add.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i> 添加设备
		</a></li>
		<li><a href="enquipmentMainServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 设备管理
		</a></li>
		<li><a href="enquipmentListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 设备查询
		</a></li>

	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 会议室管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="meetingRoomAddServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 添加会议室
		</a></li>
		<li><a href="meetingRoomServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室管理
		</a></li>
		<li><a href="meetingRoomListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室查询
		</a></li>

	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="meetingRoomBespeakServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 会议室预约
		</a></li>
		<li><a href="meetingRoomBespeakListServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 会议室预约修改
		</a></li>
		<li><a href="meetingRoomBespeakAuditingServlet"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				会议室预约审核
		</a></li>
		<li><a href="mymeetingroomBespeakQueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 我的预约查询
		</a></li>
		<li><a href="meetingroomBespeakQueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 预约查询
		</a></li>
		<li><a href="mymeetingroomBespeakAudqueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 我的审核
		</a></li>
	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 系统管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="view/userinfo/userinfo_add.jsp" target="mainframe">
				<i class="icon-double-angle-right"></i> 添加用户
		</a></li>
		<li><a href="userInfListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 用户信息管理
		</a></li>
		<li><a href="userInfoQueryServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 查询用户信息
		</a></li>
		<li><a href="userAuthorityServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 权限变更
		</a></li>

	</ul></li>
             
		<%
	}
	
	//审核人员权限
	if("4".equals(user.getUserAnthority())){
		%>
		<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-desktop"></i> <span
		class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
</a>
	<ul class="submenu">
		<li><a href="meetingRoomBespeakAuditingServlet"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				会议室预约审核
		</a></li>
		<li><a href="meetingroomBespeakQueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 预约查询
		</a></li>
		<li><a href="mymeetingroomBespeakAudqueryServlet" target="mainframe">
				<i class="icon-double-angle-right"></i> 我的审核
		</a></li>
	</ul></li>
		<%
	}
}


%>
   