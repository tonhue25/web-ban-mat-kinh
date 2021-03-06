<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div class="login-header box-shadow">
		<div class="container-fluid d-flex justify-content-between align-items-center">
			<div class="brand-logo"></div>
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
							<h2 class="text-center text-primary">Forgot Password</h2>
						</div>
						<h6 class="mb-20">Enter your email address to reset your password</h6>
						<form method="post" action = "quen-mat-khau" modelAttribute="user">
							<div class="input-group custom">
								<input name="email" type="email" class="form-control" autofocus="autofocus"
									id="email" placeholder="Enter Email" />
							</div>
							<div class="row align-items-center">
								<div class="col-5">
									<button class="btn btn-outline-primary btn-lg btn-block" type="submit" class="btn hvr-hover"> Submit</button>
								</div>
								<div class="col-5">
									<div class="input-group mb-0">
										<a class="btn btn-outline-primary btn-lg btn-block" href="<c:url value='/dang-nhap'/>">Login</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>