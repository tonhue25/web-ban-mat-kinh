<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="login-header box-shadow">
		<div class="container-fluid d-flex justify-content-between align-items-center">
			<div class="brand-logo">
				<a href="login.html">
					<img src="vendors/images/deskapp-logo.svg" alt="">
				</a>
			</div>
			<div class="login-menu">
				<ul>
					<li><a href="<c:url value='/dang-nhap'/>">Login</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6">
					<img src="<c:url value='/template/admin/vendors/images/forgot-password.png'/>" alt="">
				</div>
				<div class="col-md-6">
					<div class="login-box bg-white box-shadow border-radius-10">
						<div class="login-title">
							<h2 class="text-center text-primary">Reset Password</h2>
						</div>
						<h6 class="mb-20">Enter your new password, confirm and submit</h6>
						<form action = "doi-mat-khau" method = "post">
						<input type="hidden" name = "token" value = "${token}"/>
							<div class="input-group custom">
								<input type="password" name="password" id="password" class="form-control form-control-lg" placeholder="New Password" required="required" autofocus="autofocus" />
							</div>
							<div class="input-group custom">
								<input type="password" name="confirmpassword" id="confirmpassword" class="form-control form-control-lg" placeholder="Confirm New Password" required="required" autofocus="autofocus" 
								onkeyup='check();'/>
							</div>
							<span id='message'></span>
							<div class="row align-items-center">
								<div class="col-5">
									<div class="input-group mb-0">
									<button class="btn btn-outline-primary btn-lg btn-block" type="submit" class="btn hvr-hover"> Submit</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<content tag = "script">
		<script>
			var check = function() {
				  if (document.getElementById('password').value ==
				    document.getElementById('confirmpassword').value) {
				    document.getElementById('message').style.color = 'green';
				    document.getElementById('message').innerHTML = 'matching';
				  } else {
				    document.getElementById('message').style.color = 'red';
				    document.getElementById('message').innerHTML = 'not matching';
				  }
				} 
		</script>
	</content>
</body>
</html>