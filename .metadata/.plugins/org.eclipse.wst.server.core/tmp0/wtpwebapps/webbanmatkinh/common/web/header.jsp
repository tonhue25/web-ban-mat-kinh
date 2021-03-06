<%@ page import="com.webbanmatkinh.util.SecurityUtils" %>
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
    <div class="main-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">				
                    <div class="right-phone-box">
                    </div>
                    <div class="our-link">
                        <ul>
                        	<security:authorize access = "isAuthenticated()">
                            	<li><a href="<c:url value='/tai-khoan'/>"><i class="fa fa-user s_color"></i> My Account</a></li>
                            </security:authorize>
                            <li><a href="<c:url value='/contact'/>"><i class="fas fa-headset"></i> Contact Us</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <header class="main-header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="index.html"><img src="images/logo.png" class="logo" alt=""></a>
                    <security:authorize access = "isAuthenticated()">
                    	<div class="title-left">
							<a href="<c:url value='/tai-khoan'/>" class="list-group-item list-group-item-action">
								<h3>Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></h3>
							</a>
						</div>
                	</security:authorize>
                </div>
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                        <li class="nav-item active"><a class="nav-link" href="<c:url value='/trang-chu'/>">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/about'/>">About Us</a></li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/san-pham/danh-sach'/>">Products</a>
                             <%-- <a class="nav-link" href="<c:url value='/san-pham/danh-sach?&page=1&limit=6'/>">Products</a> --%>
                        </li>
                        <security:authorize access = "isAuthenticated()">
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/contact'/>">Contact Us</a></li>
                        </security:authorize>
                    </ul>
                </div>
                <div class="attr-nav">
                    <ul>
                        
                        <security:authorize access = "isAuthenticated()">
                        	<li class="side-menu">
								<a href="#">
									<i class="fa fa-shopping-bag"></i>
									<span class="badge"></span>
									<p>My Cart</p>
								</a>
							</li>
							<li>
                              	<a href="<c:url value='/thoat'/>">
                              		<i class="fa fa-sign-out-alt"></i>
                              		Logout
                              	</a>
                           </li>
						</security:authorize>
						<security:authorize access = "isAnonymous()">
							<li>
                              	<a href="<c:url value='/dang-nhap'/>">
                              		<span class="fa fa-user"></span>
                              	</a>
                           </li>
                        </security:authorize> 
                    </ul>
                </div>
            </div>
            <div class="side">
                <a href="#" class="close-side"><i class="fa fa-times"></i></a>
                <li class="cart-box">
                    <ul class="cart-list">
                     <security:authorize access = "isAuthenticated()">
                    <c:forEach var="item" items="${Cart}">
                        <li>
                            <a href="<c:url value='/chi-tiet-san-pham/${item.key}'/>" class="photo"><img src="<c:url value='/template/image/${item.value.product.image}'/>" class="cart-thumb" alt="" /></a>
                            <h6><a href="#"> ${item.value.product.name}</a></h6>
                            <p> x${item.value.quantity} - <span class="price">$${item.value.product.salePrice}</span></p>
                        </li>
                        </c:forEach>
                        
                        <li class="total">
                            <a href="<c:url value='/cart'/>" class="btn btn-default hvr-hover btn-cart">VIEW CART</a>
                           <span class="float-right"><strong>Total</strong>:  $${totalPriceCart}</span>
                        </li>
                        <li class="total">
                           <a href="<c:url value='/dat-hang'/>" class="btn btn-default hvr-hover btn-cart">CHECKOUT</a>
                        </li>
                        </security:authorize>
                    </ul>
                </li>
            </div>
        </nav>
    </header>
    <div class="top-search">
        <div class="container">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-search"></i></span>
                <input type="text" class="form-control" placeholder="Search">
                <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
            </div>
        </div>
    </div>
</body>
</html>