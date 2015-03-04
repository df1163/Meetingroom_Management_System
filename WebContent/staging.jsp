<%@ page language="java" contentType="text/html;" import="com.bfw.domain.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/meeting/)
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%UserInfo user= (UserInfo)session.getAttribute("userinfo"); %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>工作台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet" />
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
<%if(user!=null){
	if(user.getUserAnthority().equals("1")|| user.getUserAnthority().equals("2") || user.getUserAnthority().equals("3")){
	%>

	<div class="alert alert-warning">
		<h4>我的预约</h4>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">我的预约</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>预约编号</th>
							<th>名称</th>
							<th>查看</th>
						</tr>
						<c:forEach items="${mylist }" var="mb">
							<tr>
								<td>${mb.bespeakId }</td>
								<td>${mb.meetingName }</td>
								<td><a href="mymeetingroomBespeakShowServlet?bespeakId=${mb.bespeakId }">查看</a></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>

		<div class="col-xs-4">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">审核通过</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>预约编号</th>
							<th>名称</th>
							<th>查看</th>
						</tr>
						<c:forEach items="${myyeslist }" var="mb">
							<tr>
								<td>${mb.bespeakId }</td>
								<td>${mb.meetingName }</td>
								<td><a href="mymeetingroomBespeakShowServlet?bespeakId=${mb.bespeakId }">查看</a></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>

		<div class="col-xs-4">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">审核未通过</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>预约编号</th>
							<th>名称</th>
							<th>查看</th>
						</tr>
						<c:forEach items="${mynolist }" var="mb">
							<tr>
								<td>${mb.bespeakId }</td>
								<td>${mb.meetingName }</td>
								<td><a href="mymeetingroomBespeakShowServlet?bespeakId=${mb.bespeakId }">查看</a></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>
	</div>
<%} %>
<%if(user.getUserAnthority().equals("4")|| user.getUserAnthority().equals("2") || user.getUserAnthority().equals("3")){ %>
	<div class="alert alert-warning">
		<h4>我的审核</h4>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">未审核</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>预约编号</th>
							<th>名称</th>
							<th>查看</th>
						</tr>
						<c:forEach items="${noaanditlist }" var="mb">
							<tr>
								<td>${mb.bespeakId }</td>
								<td>${mb.meetingName }</td>
								<td><a href="bespeakAuditingServlet?bespeakId=${mb.bespeakId }">审核</a></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>
		<div class="col-xs-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">已审核</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>预约编号</th>
							<th>名称</th>
							<th>查看</th>
						</tr>
						<c:forEach items="${yesaanditlist }" var="mb">
							<tr>
								<td>${mb.bespeakId }</td>
								<td>${mb.meetingName }</td>
								<td><a href="mymeetingroomBespeakShowServlet?bespeakId=${mb.bespeakId }">查看</a></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>
	</div>
	<% } 
} %>
</body>
</html>