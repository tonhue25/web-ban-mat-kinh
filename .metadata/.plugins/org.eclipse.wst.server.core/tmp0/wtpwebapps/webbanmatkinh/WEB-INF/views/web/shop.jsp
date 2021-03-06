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
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Shop</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Shop</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div
					class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<form action="<c:url value='/san-pham/danh-sach'/>"
							id="formSubmit" method="get">
							<div class="product-item-filter row">
								<div class="col-12 col-sm-6 text-center text-sm-left">
									<input name="name" type="text" class="form-control"
										value="${name}" id="name" />
								</div>
								<div class="col-12 col-sm-2 text-center">
									<button class="btn btn-info" type="submit">Search</button>
								</div>
						</form>
						<div class="col-12 col-sm-4 text-center text-sm-right">
							<ul class="nav nav-tabs ml-auto">
								<li><a class="nav-link active" href="#grid-view"
									data-toggle="tab"> <i class="fa fa-th"></i></a></li>
								<li><a class="nav-link" href="#list-view" data-toggle="tab">
										<i class="fa fa-list-ul"></i>
								</a></li>
							</ul>
						</div>
					</div>
					<div class="product-categorie-box">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane fade show active"
								id="grid-view">
								<div class="row">
									<c:forEach var="item" items="${products.content}">
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<c:if test="${item.price > (item.price - item.price*item.sale)}">
															<p class="sale">Sale ${item.sale}%</p>
														</c:if>
													</div>
													<a href="<c:url value='/chi-tiet-san-pham/${item.id}'/>">
														<img src="<c:url value='/template/image/${item.image}'/>"
														class="img-fluid" alt="Image">
													</a>
													<div class="mask-icon">
														<ul>
															<li><a
																href="<c:url value='/chi-tiet-san-pham/${item.id}'/>"
																data-toggle="tooltip" data-placement="right"
																title="View"><i class="fas fa-eye"></i></a></li>
														</ul>
														<security:authorize access="isAuthenticated()">
															<a class="cart hvr-hover addtocart" onclick="addtocart()"
																data-id="${item.id}"
																href="<c:url value='/them-gio-hang/${item.id}'/>">Add
																to Cart</a>
														</security:authorize>
														<security:authorize access="isAnonymous()">
															<a class="cart" href="<c:url value='/dang-nhap'/>">Add
																to Cart</a>
														</security:authorize>
													</div>
												</div>
												<div class="why-text">
													<h4>${item.name}</h4>
													<h5>$${item.price - item.price*item.sale/100}</h5>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="list-view">
								<c:forEach var="item" items="${products.content}">
									<div class="list-view-box">
										<div class="row">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
														<div class="type-lb">
														</div>
														<a href="<c:url value='/chi-tiet-san-pham/${item.id}'/>">
															<img src="<c:url value='/template/image/${item.image}'/>"
															class="img-fluid" alt="Image">
														</a>
														<div class="mask-icon">
															<ul>
																<li><a href="<c:url value='/chi-tiet-san-pham/${item.id}'/>"
																	data-toggle="tooltip" data-placement="right"
																	title="View"><i class="fas fa-eye"></i></a></li>
															</ul>
														</div>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
												<div class="why-text full-width">
													<h4>${item.name}</h4>
													<h5>
														<del>$${item.price}</del>
														$${item.price - item.price*item.sale/100}
													</h5>
													<p>${item.detail}</p>
													<security:authorize access="isAuthenticated()">
														<a class="btn hvr-hover addtocart" onclick="addtocart()"
															data-id="${item.id}"
															href="<c:url value='/them-gio-hang/${item.id}'/>">Add
															to Cart</a>
													</security:authorize>
													<security:authorize access="isAnonymous()">
														<a class="btn hvr-hover"
															href="<c:url value='/dang-nhap'/>">Add to Cart</a>
													</security:authorize>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
				<div class="product-categori">
					<div class="search-product"></div>
					<div class="filter-sidebar-left">
						<div class="title-left">
							<h3>Categories</h3>
						</div>
						<div
							class="list-group list-group-collapse list-group-sm list-group-tree"
							id="list-group-men" data-children=".sub-men">
							<form action="<c:url value='/san-pham/danh-sach'/>"
								id="ds" method="get">
								<c:forEach var="item" items="${categories}">
									<a href="<c:url value='/san-pham/danh-sach?name=${item.key}'/>"
										class="list-group-item list-group-item-action">
										${item.value} <small class="text-muted"> </small>
									</a>
								</c:forEach>
							</form>
						</div>
					</div>
					<div class="filter-price-left">
						<div class="title-left"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- ph??n trang. -->
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-xs-12"></div>
			<div class="col-xl-4 col-lg-4 col-sm-12 col-xs-12">
				<nav>
					<c:if test="${products.totalPages > 0}">
						<ul class = "row" >
							<c:forEach var="pageNumber" items="${pageNumbers}">
								<c:if test = "${pageNumber < products.totalPages}">
									<li class="btn hvr-hover"> <c:if test = "${1 == products.number - 2}" ></c:if>
										<a href = "<c:url value='/san-pham/danh-sach?name=${name}&size=${products.size}&page=${pageNumber}'/>">
										<c:if test = "${pageNumber == 0}">First</c:if>
										<c:if test = "${pageNumber > 0}"><c:if test = "${pageNumber < products.totalPages - 1}">${pageNumber}</c:if></c:if>
										<c:if test = "${pageNumber == products.totalPages - 1}">Last</c:if>
										</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</c:if>
				</nav>
			</div>
			<div class="col-xl-4 col-lg-4 col-sm-12 col-xs-12"></div>
		</div>
	</div>
	<content tag="script"> <script>
		$(".addtocart").click(function() {
			var id = $(this).data("id");
			$.ajax({
				url : "them-gio-hang/" + id,
				type : 'POST',
				contentType : 'application/json',
				data : {
					id : id,
				},
				success : addtocart
			});
		});

		function addtocart() {
			Swal.fire({
				position : 'center',
				icon : 'success',
				title : '???? th??m v??o gi??? h??ng!!',
				showConfirmButton : false,
				timer : 2500
			})
		};
	</script> 
	</content>
</body>
</html>