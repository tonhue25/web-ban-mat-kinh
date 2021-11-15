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
    <div class="cart-box-main">
        <div class="container">
            <div class="row new-account-login">
                <div class="col-sm-2 col-lg-2"></div>
                <div class="col-sm-8 col-lg-8 mb-3">
                    <div class="title-left">
                        <h3>Create New Account</h3>
                    </div>
                    <h5><a data-toggle="collapse" href="#formRegister" role="button" aria-expanded="false">Click here to Register</a></h5>
                    <form:form class="mt-3 collapse review-form-box" id="formRegister" action="dang-ki" method="post" modelAttribute="user" >
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="fullName" class="mb-0">Full Name</label>
                                <form:input path="fullName" type="text" class="form-control" id="fullName" placeholder="Enter Fullname"/> 
                            </div>
                            <div class="form-group col-md-6">
                                <label for="userName" class="mb-0">User Name</label>
                                <form:input path="userName" type="text" class="form-control" id="userName" placeholder="Enter Username"/> 
                            </div>
                            <div class="form-group col-md-6">
                                <label for="email" class="mb-0">Email Address</label>
                                <form:input path="email" type="email" class="form-control" id="email" placeholder="Enter Email"/> 
                            </div>
                            <div class="form-group col-md-6">
                                <label for="phone" class="mb-0">Phone</label>
                                <form:input path="phone" type="text" class="form-control" id="phone" placeholder="Enter Phone"/> 
                            </div>
                            <div class="form-group col-md-6">
                                <label for="password" class="mb-0">Password</label>
                                <form:input path="password" type="password" class="form-control" id="password" placeholder="Enter Password"/> 
                            </div>
                            <div class="form-group col-md-6">
                                <label for="address" class="mb-0">Address</label>
                                <form:input path="address" type="text" class="form-control" id="address" placeholder="Enter Address"/> 
                            </div>
                        </div>
                        <button type="submit" class="btn hvr-hover">Register</button>
                    </form:form>
                </div>
                <div class="col-sm-2 col-lg-2">
                	<div class="col-12 d-flex shopping-box"><a href="<c:url value='/dang-nhap'/>" class="ml-auto btn hvr-hover">Login</a> </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>