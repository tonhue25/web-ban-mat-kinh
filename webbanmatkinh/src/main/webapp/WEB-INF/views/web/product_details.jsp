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
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="<c:url value='/template/image/${item.image}'/>"
									alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>${item.name}</h2>
						<h5>
							<del>$${item.price}</del>$${item.salePrice}
						</h5>
						<h4>Short Description:</h4>
						<p>${item.detail}</p>
						<ul>
							<li>
								<div class="form-group quantity-box">
									<label class="control-label">Quantity</label> <input
										class="form-control" value="1" min="0" max="20" type="number">
								</div>
							</li>
						</ul>
						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<security:authorize access="isAuthenticated()">
									<a class="btn hvr-hover" data-fancybox-close="" href="#">Buy Now</a> 
									<a class="btn hvr-hover" data-fancybox-close="" href="<c:url value='/them-gio-hang/${item.id}'/>">Add to cart</a>
								</security:authorize>
								<security:authorize access="isAnonymous()">
									<a class="btn hvr-hover" data-fancybox-close="" href="<c:url value='/dang-nhap'/>">Buy Now</a> 
									<a class="btn hvr-hover" data-fancybox-close="" href="<c:url value='/dang-nhap'/>">Add to cart</a>
								</security:authorize>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>Featured Products</h1>
						<p></p>
					</div>
					<%--  --%>
					<div class="featured-products-box owl-carousel owl-theme">
						<c:forEach var="item" items="${products}">
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="<c:url value='/template/image/${item.image}'/>" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li>
												<a href="<c:url value='/chi-tiet-san-pham/${item.id}'/>" data-toggle="tooltip"
													data-placement="right" title="View">
													<i class="fas fa-eye"></i>
												</a>
											</li>
										</ul>
										<a class="cart" href="#">Add to Cart</a>
										<security:authorize access="isAuthenticated()">
											<a class="cart" data-fancybox-close="" href="<c:url value='/them-gio-hang/${item.id}'/>">Add to cart</a>
										</security:authorize>
										<security:authorize access="isAnonymous()">
											<a class="cart" data-fancybox-close="" href="<c:url value='/dang-nhap'/>">Add to cart</a>
										</security:authorize>
									</div>
								</div>
								<div class="why-text">
									<h4>${item.name}</h4>
									<h5>$${item.price}</h5>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>				
				</div>
			</div>
		</div>
	</div>
</body>
</html>