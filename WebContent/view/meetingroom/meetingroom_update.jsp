<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
// 获得本项目的地址(例如: http://localhost:8080/meeting/)
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>


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
			var enid = "";//设备编号
			var enname = "";//设备名称
			$('input[name="enzheq"]:checked').each(function(){
				var enzheq=  $(this).val().split(",");
				enid+=enzheq[0]+",";
				enname+=enzheq[1]+",";
			});
			$("#enzhequipmentId").val(enid);
			$("#info").html(enname);
		});	
		
	});

</script>

</head>

<body>
<div  >
	<h4 class="page-header">会议室管理<small>修改</small></h4>
   	<div align="center" style="color: red" >${info }</div>
    <form class="form-horizontal" action="meetingRoomUpdateServlet" method="post">
    <input type="hidden" name="enzhequipmentIds" id="enzhequipmentId" value=""/>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 编号</label>
            <div class="col-xs-4">
            	<input type="text" name="meetingroomId"  readonly="readonly" value="${meetingroom.meetingroomId }" placeholder="请输入编号"  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 名称 </label>
            <div class="col-xs-4">
            	<input type="text"  value="${meetingroom.meetingroomName }"  name="meetingroomName" id="name" placeholder="请输入名称"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 大小</label>
            <div class="col-xs-4">
            	<input type="text"   value="${meetingroom.meetingroomSize }"  name="meetingroomSize" id="name" placeholder="请输会议室大小"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 内置设备</label>
            <div class="col-xs-4">
            	<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  请选择
</button>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    
                     <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">设备信息</h4>
                  </div>
                  <div class="modal-body">
                   <table class="table table-striped">
                <thead>
                <tr>
                <th></th>
                    <th>设备编号</th>
                    <th>设备名称</th>
                    <th>设备价格</th>
                    <th>采购时间</th>
                </tr>
                </thead>
                <tbody>
                
                	<c:forEach items="${enlist }" var="en">
                	  <tr> <td><input type="checkbox" checked="checked"  value="${en.enzhequipmentId },${en.enzhequipmentName }"></td>
                        <td>${en.enzhequipmentId }</td>
                        <td>${en.enzhequipmentName }</td>
                        <td>${en.enzhequipmentPrice }</td>
                        <td>${en.procurementTime }</td>
                        </tr>
                	</c:forEach>
                	<c:forEach items="${eninfolist }" var="eninfo">
                    <tr>
                        <td><input type="checkbox" name="enzheq"  value="${eninfo.enzhequipmentId },${eninfo.enzhequipmentName }"></td>
                        <td>${eninfo.enzhequipmentId }</td>
                        <td>${eninfo.enzhequipmentName }</td>
                        <td>${eninfo.enzhequipmentPrice }</td>
                        <td>${eninfo.procurementTime }</td>
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
					<c:forEach items="${enlist }" var="en">
						${en.enzhequipmentName },
					</c:forEach>
				</div>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea class="form-control" name="meetingroomNote" rows="3">${meetingroom.meetingroomNote }</textarea>
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
