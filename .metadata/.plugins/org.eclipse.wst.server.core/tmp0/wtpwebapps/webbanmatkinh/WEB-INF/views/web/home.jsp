<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
     <%@ include file="/common/web/slider.jsp" %>
    <div class="categories-shop">
        <div class="container">
            <div class="row">
             <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box">
                        <img class="img-fluid" src="<c:url value='/template/image/mat-kinh-nam.png'/>" alt="" />
                        <a class="btn hvr-hover" href="<c:url value='/san-pham/mat-kinh-nam?page=1&limit=6'/>">Mắt kính nam</a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box">
                        <img class="img-fluid" src="<c:url value='/template/image/mat-kinh-nu.png'/>" alt="" />
                        <a class="btn hvr-hover" href="<c:url value='/san-pham/mat-kinh-nu?page=1&limit=6'/>">Mắt kính nữ</a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box">
                        <img class="img-fluid" src="<c:url value='/template/image/mat-kinh-tre-em.png'/>" alt="" />
                        <a class="btn hvr-hover" href="<c:url value='/san-pham/mat-kinh-tre-em?page=1&limit=6'/>">Mắt kính trẻ em</a>
                    </div>
                </div>
               
            </div>
        </div>
    </div>

    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>New arrival</h1>
                    </div>
                </div>
            </div>
           <div class="row special-list">        		
				<c:forEach var="item" items="${newproduct}" begin="0" end="3">
                <div class="col-lg-3 col-md-6 special-grid top-featured">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                                <p class="new">New</p>
                            </div>
                            <img src="<c:url value='/template/image/${item.image}'/>" class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                   <li><a href="<c:url value='/chi-tiet-san-pham/${item.id}'/>" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                </ul>
                                <security:authorize access = "isAuthenticated()">
									<a class="cart hvr-hover addtocart" onclick="addtocart()" data-id="${item.id}"
																	href="<c:url value='/them-gio-hang/${item.id}'/>"
																	>Add to Cart</a>
								</security:authorize>	
								<security:authorize access = "isAnonymous()">
              						<a class="cart" href="<c:url value='/dang-nhap'/>">Add to Cart</a>
								</security:authorize>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4> ${item.name}</h4>
                            <h5> $${item.salePrice}</h5>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    
     <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>Best seller</h1>
                    </div>
                </div>
            </div>
           <div class="row special-list">        		
				<c:forEach var="item" items="${hotproduct}" begin="0" end="3">
                <div class="col-lg-3 col-md-6 special-grid top-featured">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                                <p class="sale">Sale</p>
                            </div>
                            <img src="<c:url value='/template/image/${item.image}'/>" class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="<c:url value='/chi-tiet-san-pham/${item.id}'/>" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                               </ul>
                                <security:authorize access = "isAuthenticated()">
									
									<a class="cart hvr-hover addtocart" onclick="addtocart()" data-id="${item.id}"
																	href="<c:url value='/them-gio-hang/${item.id}'/>"
																	>Add to Cart</a>
								</security:authorize>	
								<security:authorize access = "isAnonymous()">
              						<a class="cart" href="<c:url value='/dang-nhap'/>">Add to Cart</a>
								</security:authorize>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4> ${item.name}</h4>
                            <h5> $${item.salePrice}</h5>
                        </div>
                    </div>
                </div>
				</c:forEach>			
            </div>
        </div>
    </div>
    <content tag="script">
    <script>
	$(".addtocart").click(function() {
		var id = $(this).data("id");	
		$.ajax({
			url : "them-gio-hang/" + id,
			type : 'POST',
			contentType : 'application/json',
			data : {
				id:id,
			},
			success : addtocart 
		});
	});
	
	function addtocart() {
       Swal.fire({
     	   position: 'center',
     	   icon: 'success',
			title: 'Đã thêm vào giỏ hàng!!',
     	   showConfirmButton: false,
     	   timer: 2500
     	 })
        };
	</script>
	</content>
</body>
</html>