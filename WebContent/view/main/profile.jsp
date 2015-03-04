<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<script src="assets/js/ace-extra.min.js"></script>

</head>
<body>

	

	<div class="page-content">
		<div class="page-header">
			<h1>个人信息</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->



				<div class="hr dotted"></div>

				<div>
					<div id="user-profile-1" class="user-profile row">
						<div class="col-xs-12 col-sm-3 center">
							<div>
								<span class="profile-picture"> <img id="avatar"
									class="editable img-responsive" alt="Alex's Avatar"
									src="assets/avatars/profile-pic.jpg" />
								</span>

								<div class="space-4"></div>

								<div
									class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
									<div class="inline position-relative">
										<a href="javascript:void(0)" class="user-title-label dropdown-toggle"
											data-toggle="dropdown"> <i
											class="icon-circle light-green middle"></i> &nbsp; <span
											class="white">${userinfo.userName }</span>
										</a>

										<ul
											class="align-left dropdown-menu dropdown-caret dropdown-lighter">
											<li class="dropdown-header">Change Status</li>

											<li><a href="#"> <i class="icon-circle green"></i>
													&nbsp; <span class="green">Available</span>
											</a></li>

											<li><a href="#"> <i class="icon-circle red"></i>
													&nbsp; <span class="red">Busy</span>
											</a></li>

											<li><a href="#"> <i class="icon-circle grey"></i>
													&nbsp; <span class="grey">Invisible</span>
											</a></li>
										</ul>
									</div>
								</div>
							</div>

							<div class="space-6"></div>

							<div class="profile-contact-info">
								<div class="profile-contact-links align-left">
								
									 <a class="btn btn-link" href="https://w.mail.qq.com/cgi-bin/loginpage"> <i
										class="icon-envelope bigger-120 pink"></i> 发送QQ邮件
									</a> <a class="btn btn-link" href="http://www.csdn.net/" target="_top" > <i
										class="icon-globe bigger-125 blue"></i> CSDN
									</a>
								</div>

								<div class="space-6"></div>

								<div class="profile-social-links center">
									<a href="#" class="tooltip-info" title=""
										data-original-title="Visit my Facebook"> <i
										class="middle icon-facebook-sign icon-2x blue"></i>
									</a> <a href="#" class="tooltip-info" title=""
										data-original-title="Visit my Twitter"> <i
										class="middle icon-twitter-sign icon-2x light-blue"></i>
									</a> <a href="#" class="tooltip-error" title=""
										data-original-title="Visit my Pinterest"> <i
										class="middle icon-pinterest-sign icon-2x red"></i>
									</a>
								</div>
							</div>

							<div class="hr hr12 dotted"></div>

				

							<div class="hr hr16 dotted"></div>
						</div>

						<div class="col-xs-12 col-sm-9">


							<div class="space-12"></div>

							<div class="profile-user-info profile-user-info-striped">
								<div class="profile-info-row">
									<div class="profile-info-name">账号</div>

									<div class="profile-info-value">
										<span class="editable" id=""> ${userinfo.userId }</span>&nbsp;
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">姓名</div>

									<div class="profile-info-value">
										<span class="editable" id=""> ${userinfo.userName }</span>&nbsp;
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">性别</div>

									<div class="profile-info-value">
										<span class="editable" id="">${userinfo.userSex }</span>&nbsp;
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">年龄</div>

									<div class="profile-info-value">
										<span class="editable" id="">${userinfo.userAge }</span>&nbsp;
									</div>
								</div>
					
								<div class="profile-info-row">
									<div class="profile-info-name">电话号码</div>

									<div class="profile-info-value">
										<span class="editable" id="">${userinfo.userPhone }</span>&nbsp;
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">创建时间</div>

									<div class="profile-info-value">
										<span class="editable" id="">
										<fmt:formatDate value="${userinfo.userCtime }" type="both" pattern="yyyy-MM-dd HH:mm:ss  EEEE"/>
										</span>&nbsp;
									</div>
								</div>
		
						
							</div>
							<div class="space-20"></div>	
				</div></div></div>

				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.page-content -->

</body>
</html>
