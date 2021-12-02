<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body class="login-page">
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
				<div class="col-md-6 col-lg-7">
					<img src="<c:url value='/template/admin/vendors/images/register-page-img.png'/>" alt="">
				</div>
				<div class="col-md-6 col-lg-5">
					<div class="login-box bg-white box-shadow border-radius-10">
						<div class="login-title">
							<h2 class="text-center text-primary">Register</h2>
						</div>
						<form:form id="formRegister" modelAttribute="user">
							<section>
								<div class="form-wrap max-width-600 mx-auto">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Email Address*</label>
										<div class="col-sm-8">
											<form:input path="email" type="email" class="form-control"
												id="email" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Username*</label>
										<div class="col-sm-8">
											<form:input path="userName" type="text" class="form-control"
												id="userName" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Password*</label>
										<div class="col-sm-8">
											<form:input path="password" type="password"
												class="form-control" id="password" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Confirm
											Password*</label>
										<div class="col-sm-8">
											<input type="password" class="form-control">
										</div>
									</div>
								</div>
							</section>
							<section>
								<div class="form-wrap max-width-600 mx-auto">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Full Name*</label>
										<div class="col-sm-8">
											<form:input path="fullName" type="text" class="form-control"
												id="fullName" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Phone*</label>
										<div class="col-sm-8">
											<form:input path="phone" type="text" class="form-control"
												id="phone" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Address</label>
										<div class="col-sm-8">
											<form:input path="address" type="text" class="form-control"
												id="address" />
										</div>
									</div>
								</div>
							</section>
							<button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>