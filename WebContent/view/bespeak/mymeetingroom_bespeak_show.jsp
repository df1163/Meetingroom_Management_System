<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script language="javascript">
	$(document).ready(function(){
		
		$("#xuanzhe").click(function(){
			var str = "";
			$('input[name="enzheq"]:checked').each(function(){
				str=str+" "+$(this).val();	
			});
			
			$("#info").html(str);
		});	
		
	});

</script>

</head>

<body>
<div  >
	<h4 class="page-header">会议室预约<small>预约查看</small></h4>
    <form class="form-horizontal">
        <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 预约编号</label>
            <div class="col-xs-4">
            	<p class=" form-control-static">${bespeak.bespeakId }</p>
            	
             </div>
        </div>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 会议名称</label>
            <div class="col-xs-4">
            <p class=" form-control-static">${bespeak.meetingName }</p>
            	
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议室 </label>
            <div class="col-xs-3">
            		<p class="form-control-static">${bespeak.meetingroomName }</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label "  > 开始时间</label>
            <div class="col-xs-4">
            <p class="form-control-static">
            
            <fmt:formatDate value="${bespeak.stratTime }"  type="both"/>
            </p>
            
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 结束时间</label>
            <div class="col-xs-4">
            	<p class="form-control-static">  <fmt:formatDate value="${bespeak.endTime }"  type="both"/></p>
             </div>
        </div>
                <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 申请人</label>
            <div class="col-xs-4">
            	<p class="form-control-static">  ${bespeak.userName }</p>
             </div>
        </div>
                 <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 申请时间</label>
            <div class="col-xs-4">
            	<p class="form-control-static">   <fmt:formatDate value="${bespeak.applyTime }"  type="both"/></p>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议人员</label>
            <div class="col-xs-4">
            	
<p class="form-control-static">
	<c:forEach items="${mulist }" var="mu">
	
		${mu.userName },
	</c:forEach>

</p>
               
				
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${bespeak.meetingroomNote }</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 审核状态</label>
            <div class="  col-xs-4">
            	<p class=" form-control-static">
				${bespeak.bespeakState=='0'?'未审核':'' }
				${bespeak.bespeakState=='1'?'审核通过':'' }
				${bespeak.bespeakState=='2'?'审核未通过':'' }
				</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 审核人</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${bespeak.useUserName }</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 审核时间</label>
            <div class="col-xs-4">
            	<p class="form-control-static">
            	 <fmt:formatDate value="${bespeak.auditingTime}"  type="both"/>
            	</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " >审核信息</label>
            <div class="col-xs-4">
            	<p class=" form-control-static">${bespeak.auditingInfo }</p>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<a class="btn btn-default" href="mymeetingroomBespeakQueryServlet" >返回上一级</a>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
