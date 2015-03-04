<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>



</head>

<body>

<div  >

	<h4 class="page-header">系统管理<small>用户修改</small></h4>
	<div align="center" style="color: red" >${info }</div>
    <form  action="userInfoUpdateServlet" method="post" class="form-horizontal"  enctype="multipart/form-data">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 账号</label>
            <div class="col-xs-4">
            	<input type="text" name="userId"  placeholder="请输入账号" readonly="readonly" value="${user.userId }"  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 密码 </label>
            <div class="col-xs-4">
            	<input type="text" name="userPw" id="name" placeholder="请输入密码" value="${user.userPw }"   class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 姓名</label>
            <div class="col-xs-4">
            	<input type="text" name="userName"  placeholder="请输姓名" value="${user.userName }"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 头像</label>
            <div class="col-xs-4">
            	<input type="file" name="userUrl"  class="form-control"  />
            	<img alt="" src="${user.userUrl }" width="50" height="50">
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 性别</label>
            <div class="col-xs-4">
            	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="男"  ${user.userSex=='男'?'checked':'' }>男
                    </label>
                </div>
                          	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="女"  ${user.userSex=='女'?'checked':'' }>女
                    </label>
                </div>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 年龄</label>
            <div class="col-xs-4">
            	<input type="text" name="userAge"  placeholder="请输年龄"  value="${user.userAge }"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 电话号码</label>
            <div class="col-xs-4">
            	<input type="text" name="userPhone"  placeholder="请输电话号码"   value="${user.userPhone }"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea name="userBeizhu" class="form-control" rows="3">${user.userBeizhu }</textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改用户"/>
            	<a class="btn btn-default"  href="userInfListServlet"> 返回上一级</a>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
