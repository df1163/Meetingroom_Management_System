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
	<h4 class="page-header">系统管理<small>用户添加</small></h4>
	<div>${info }</div>

    <form  action="userinfoadd" method="post" class="form-horizontal"  enctype="multipart/form-data">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 账号</label>
            <div class="col-xs-4">
            	<input type="text" name="userId"  placeholder="请输入账号"  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 密码 </label>
            <div class="col-xs-4">
            	<input type="text" name="userPw" id="name" placeholder="请输入密码"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 姓名</label>
            <div class="col-xs-4">
            	<input type="text" name="userName"  placeholder="请输姓名"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 头像</label>
            <div class="col-xs-4">
            	<input type="file" name="userUrl"  class="form-control"  />
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 性别</label>
            <div class="col-xs-4">
            	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="男" checked>男
                    </label>
                </div>
                          	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="女">女
                    </label>
                </div>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 年龄</label>
            <div class="col-xs-4">
            	<input type="text" name="userAge"  placeholder="请输年龄"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 电话号码</label>
            <div class="col-xs-4">
            	<input type="text" name="userPhone"  placeholder="请输电话号码"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea name="userBeizhu" class="form-control" rows="3"></textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="添加用户"/>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
