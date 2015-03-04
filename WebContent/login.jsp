<%@ page language="java" contentType="text/html;"  pageEncoding="UTF-8"%>
<% String path = request.getContextPath();      
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>

<!DOCTYPE html>
<html lang="en">
<head>

<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<script type="text/javascript">

	function check(){
		//ID
		var userId = document.getElementById("userId").value;
		if(userId.length == 0){
			alert('User id cannot be empty!');
			return false;
		}
		//PASSWORD
		var userPw = document.getElementById("userPw").value;
		if(userPw.length == 0){
			alert('Password cannot be empty!');
			return false;
		}
		
	}

</script>
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">MEETING</span> <span
									class="white">Demo management</span>
							</h1>
							<h4 class="blue">&copy;Cisco Connected Platform BU</h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> Please input user id and password
										</h4>
										<div style="color: red;">${info }  </div>
										<div class="space-6"></div>
										<form action="loginServlet" method="post" onsubmit="return check()" >
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> 
													<input id="userId"
														name="userId" type="text" class="form-control"
														placeholder="Please input account number" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right">
													 <input id="userPw"
														name="passWord" type="password" class="form-control"
														placeholder="Please input password" /> <i class="icon-lock"></i>
												</span>
												</label>

												<div class="clearfix">
											

													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> Login
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>

								</div>

							</div>


					</div>

				</div>
			</div>

		</div>
</div>
	</div>
</body>
</html>
