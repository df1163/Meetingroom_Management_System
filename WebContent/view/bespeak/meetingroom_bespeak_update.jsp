<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		var userIdstr = "";
		var userNamestr = "";
		$('input[name="enzheq"]:checked').each(function(){
			var enzheqs = $(this).val().split(",");
			userIdstr+=enzheqs[0]+",";
			userNamestr+=enzheqs[1]+",";
			
		});
		$("#userIds").val(userIdstr);
		$("#info").html(userNamestr);
	});	
	
});

</script>

</head>

<body>
<div  >
	<h4 class="page-header">会议室预约<small>预约修改</small></h4>
   <div align="center" style="color: red" >${info }</div>
    <form class="form-horizontal" action="meetingroomBespeakUpdateServlet" method="post">
    <input type="hidden" name="userIds" id="userIds" value=""/>
        <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 预约编号</label>
            <div class="col-xs-4">
            	<p class=" form-control-static">100123</p>
            	<input  type="hidden" readonly="readonly" name="bespeakId" value="${bespeak.bespeakId }"  placeholder="请输会议名称"  class="form-control" />
             </div>
        </div>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 会议名称</label>
            <div class="col-xs-4">
            	<input type="text" name="meetingName"  value="${bespeak.meetingName }"  placeholder="请输会议名称" value="会议管理系统分析"  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议室 </label>
            <div class="col-xs-3">
            		<select name="meetingroomId" class="form-control" >
            			<c:forEach items="${meetingroomlist }" var="meetroom">
                    		<option value="${meetroom.meetingroomId }"  ${bespeak.meetingroomId==meetroom.meetingroomId?'selected':'' } >${meetroom.meetingroomName }</option>
                        </c:forEach>
                    </select>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label "  > 开始时间</label>
            <div class="col-xs-4">
            	<input type="text" name="stratTimestr" id="stratTime" value='<fmt:formatDate value="${bespeak.stratTime }" type="both" />'   placeholder="请输会议开始时间"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 结束时间</label>
            <div class="col-xs-4">
            	<input type="text" name="endTimestr" id="endTime" placeholder="请输会议结束时间"  value='<fmt:formatDate value="${bespeak.endTime }" type="both" />' class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议人员</label>
            <div class="col-xs-4">
            	<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                  请选择
                </button>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    
                     <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                  </div>
                  <div class="modal-body">
                   <table class="table table-striped">
                <thead>
                <tr>
                <th></th>
                    <th>用户编号</th>
                    <th>用户姓名</th>
                    <th>用户性别</th>
              		<th>用户年龄</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userlist }" var="user">
                    <tr>
                        <td><input type="checkbox" name="enzheq"  value="${user.userId },${user.userName}"></td>
                        <td>${user.userId} </td>
                        <td>${user.userName} </td>
                        <td>${user.userSex}</td>
                  		<td>${user.userAge} </td>
                    </tr> 
                 </c:forEach>               
                </tbody>
            </table>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="xuanzhe" class="btn btn-primary" data-dismiss="modal" >选择</button>
                  </div>
                 </div>
                 </div>   
                </div>
                <div id="info" style="display:inline"></div>
				<div style="display:inline">
					<c:forEach items="${mulist}" var="mu">
						${mu.userName },
					</c:forEach>
				</div>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea class="form-control" rows="3" name="meetingroomNote">${bespeak.meetingroomNote }</textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改"/>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
