<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h4 class="page-header">会议室管理<small>查看</small></h4>
    <form class="form-horizontal">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 编号</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${meetingroom.meetingroomId }</p>
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 名称 </label>
            <div class="col-xs-4">
            		<p class="form-control-static">${meetingroom.meetingroomName }</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 大小</label>
            <div class="col-xs-4">
            		<p class="form-control-static">${meetingroom.meetingroomSize }人</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 内置设备</label>
            <div class="col-xs-4">
				<p class="form-control-static">
				<c:forEach items="${enlist }" var="eninfo">
				${eninfo.enzhequipmentName }&nbsp;
				</c:forEach>
				</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${meetingroom.meetingroomNote }</p>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<a href="meetingRoomListServlet" class="btn btn-default">返回上一级</a>

             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
