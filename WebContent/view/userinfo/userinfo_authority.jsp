<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<%@ taglib prefix="d" uri="http://displaytag.sf.net/el" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">用户管理<small>权限变更</small></h4>

<div class="container">
<form  method="post" action="userAuthorityServlet" class="form-inline" role="form">
  <div class="form-group">
    <label  for="">姓名</label>
    <input type="text" name="userName" class="form-control" id="" placeholder="请输入姓名">
  </div>
    <div class="form-group">
    <label for="">性别</label><br/>
   	<select name="userSex" class="form-control">
   		<option value="">请选择</option>
   		<option value="男">男</option>
   		<option value="女">女</option>
   	</select>
  </div>
  <div class="form-group">
  <label for="" >&nbsp;</label>
  <br/>
  <button type="submit" class="btn btn-default">查询</button>
  </div>
</form>
<d:table name="list"  class="table table-striped" pagesize="5" requestURI="userAuthorityServlet">
	<d:column property="userId" title="编号"></d:column>
	<d:column property="userName" title="姓名"></d:column>
	<d:column property="userUrl" title="头像地址"></d:column>
	<d:column property="userSex" title="性别"></d:column>
	<d:column property="userAge" title="年龄"></d:column>
	<d:column property="userPhone" title="电话号码"></d:column>
	<d:column property="userCtime"  format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="创建时间"></d:column>
	<d:column href="userAnthorityChangeServlet" paramId="userId" paramProperty="userId" value="权限变更" title="查看"></d:column>
	
</d:table>										
</div>

    
</div>

</body>
</html>
