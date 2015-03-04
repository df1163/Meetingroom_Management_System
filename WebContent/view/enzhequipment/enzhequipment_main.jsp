<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/test/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备添加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div>
	<h4 class="page-header">设备管理<small>修改删除</small></h4>
	<div align="center" style="color: red;">${info }</div>
		<div class="container">
			<form class="form-inline" role="form" action="enquipmentMainServlet" method="post"> 
			  <div class="form-group">
			    <label class="sr-only" for="">名称</label>
			    <input type="text" name="enzhequipmentName" class="form-control" id="" placeholder="请输入设备名称">
			  </div>
			  <button type="submit" class="btn btn-default">查询</button>
			</form>
			<d:table name="list" pagesize="5" requestURI="enquipmentMainServlet" class="table table-striped">
				<d:column property="enzhequipmentId" title="设备编号"></d:column>
				<d:column property="enzhequipmentName" title="设备名称"></d:column>
				<d:column property="procurementTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="采购时间"></d:column>
				<d:column property="enzhequipmentPrice" title="采购价格"></d:column>
				<d:column href="enquipmentUpdateServlet" paramId="enzhequipmentId" paramProperty="enzhequipmentId" value="修改" title="修改"></d:column>
				<d:column href="enquipmentDeleteServlet" paramId="enzhequipmentId" paramProperty="enzhequipmentId" value="删除" title="删除" ></d:column>
			</d:table>
		</div>
	</div>
</body>
</html>

