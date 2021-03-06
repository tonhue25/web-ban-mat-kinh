<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="cart-box-main">
		<div class="container">
			<div class="row new-account-login">
				<div class="col-sm-4 col-lg-4">
					<%@ include file="/common/web/menu.jsp" %>
				</div>
				<div class="col-sm-8 col-lg-8 mb-3">
					<div class="title-left">
						<h3><i class="fa fa-user s_color"></i> Account</h3>
					</div>
					<form:form class="mt-3 review-form-box" id="formRegister"
						method="post" modelAttribute="user">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="fullName" class="mb-0"> Full Name</label>
								<input name="fullName" value = "${user.fullName}" type="text" class="form-control" readonly 
									id="fullName" placeholder="Enter Fullname" />
							</div>
							<div class="form-group col-md-6">
								<label for="userName" class="mb-0"> User Name</label>
								<input name="userName" value= "${user.userName}" type="text" class="form-control" readonly
									id="userName" placeholder="Enter Username" />
							</div>
							<div class="form-group col-md-6">
								<label for="email" class="mb-0"> Email Address</label>
								<form:input path="email" type="email" class="form-control"
									id="email" placeholder="Enter Email" />
							</div>
							<div class="form-group col-md-6">
								<label for="phone" class="mb-0"> Phone</label>
								<form:input path="phone" type="tel" class="form-control"
									id="phone" placeholder="Enter Phone" />
							</div>
							<div class="form-group col-md-12">
								<label for="address" class="mb-0"> Address</label>
								<form:input path="address" type="text" class="form-control"
									id="address" placeholder="Enter Address" />
							</div>
						</div>
						<button type="submit" class="btn hvr-hover">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>