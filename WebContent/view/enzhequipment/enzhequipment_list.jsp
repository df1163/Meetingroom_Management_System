<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/test/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div  >
	<h4 class="page-header">&nbsp;&nbsp;设备管理<small>查询</small></h4>

<div class="container">
<form class="form-inline" role="form" action="enquipmentListServlet" method="post">
  <div class="form-group">
    <label class=" col-xs-6" for="">名称</label>
    
    <input type="text" name="enzhequipmentName" class="form-control" id="" placeholder="请输入设备名称">
  </div>
  <div class="form-group">
    <label class="col-xs-6" for="">所属会议室</label>
   	<select name="meetingroomId" class="form-control">
   		<option value="">请选择</option>
   		<c:forEach items="#{meetroomlist }" var="meet">
   		<option value="${meet.meetingroomId }">${meet.meetingroomName }</option>
   		</c:forEach>
   	</select>
  </div>
   <div class="form-group">
    <label class="col-xs-6" for="">&nbsp;</label>
    <button type="submit" class="btn btn-default">查询</button>
  </div>
  
</form>
		<d:table name="list" pagesize="5" requestURI="enquipmentListServlet" class="table table-striped">
			<d:column property="enzhequipmentId" title="设备编号"></d:column>
			<d:column property="enzhequipmentName" title="设备名称"></d:column>
			<d:column property="procurementTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="采购时间"></d:column>
			<d:column property="enzhequipmentPrice" title="采购价格"></d:column>
			<d:column property="userName" title="采购人"></d:column>
			<d:column property="meetingroomName" title="所属会议室"></d:column>
			
			<d:column href="enquipmentShowServlet" paramId="enzhequipmentId" paramProperty="enzhequipmentId" value="查看" title="查看" ></d:column>
		</d:table>

</div>

    
</div>

</body>
</html>
