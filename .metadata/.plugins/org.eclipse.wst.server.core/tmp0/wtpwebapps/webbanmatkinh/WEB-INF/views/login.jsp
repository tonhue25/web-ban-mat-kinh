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
                        <h3>Account Login</h3>
                    </div>
                    <h5>
                    	<a data-toggle="collapse" href="#formLogin" role="button" aria-expanded="false">Click here to Login</a>
                    </h5>
                    <form class="mt-3 collapse review-form-box" id="formLogin" action="j_spring_security_check" method="post">
                    	
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="name" class="mb-0">Username</label>
                                <input type="text" class="form-control" id="name" name="j_username" value=""
                                            placeholder="Username">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="password" class="mb-0">Password</label>
                                <input type="password" class="form-control" id="password" name="j_password" value=""
                                	placeholder="Password">
                            </div>
                        </div>
                        <button type="submit" class="btn hvr-hover" onclick="login()">Login</button>
                    </form>
                </div>
               <div class="col-sm-2 col-lg-2">
               		 <div class="col-12 d-flex shopping-box"><a href="<c:url value='/dang-ki'/>" class="ml-auto btn hvr-hover">Register</a> </div>
     
               </div>
            </div>
        </div>
    </div>
    <!-- the nay nha, khi ma login thanh cong: can thong bao và chuyen vo trang chinh -->
    <content tag="script">
    	<script>
           function login() {
           /* Swal.fire({
        	   position: 'center',
        	   icon: 'success',
				title: 'Username or password invalid',
        	   showConfirmButton: false,
        	   timer: 2500
        	 })*/ 
           } 
           
    	</script>	
    </content>															
</body>
</html>