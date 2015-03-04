<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<%@ taglib prefix="d"  uri="http://displaytag.sf.net"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会议室管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">会议室管理<small>查询</small></h4>

<div class="container">
<form class="form-inline" role="form" action="meetingRoomListServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">名称</label>
    <input type="text"  name="meetingroomName"  class="form-control" id="" placeholder="请输入名称">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>

<d:table name="list" class="table table-striped" pagesize="5" requestURI="meetingRoomListServlet"> 
	<d:column property="meetingroomId" title="编号"></d:column>
	<d:column property="meetingroomName" title="名称"></d:column>
	<d:column property="meetingroomSize" title="会议室大小"></d:column>
	<d:column href="meetingRoomShowServlet" paramId="meetingroomId" paramProperty="meetingroomId" value="查看" title="查看"></d:column>
</d:table>

</div>

    
</div>

</body>
</html>
