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
	<!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Cart</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">Cart</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Promotion Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${Cart}">
                                <tr>
                                    <td class="thumbnail-img">
                                        <a href="<c:url value='/chi-tiet-san-pham/${item.key}'/>">
									<img class="img-fluid" src="<c:url value='/template/image/${item.value.product.image}'/>" alt="" />
								</a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="#">
									${item.value.product.name}
								</a>
                                    </td>
                                    <td class="price-pr">
                                        <p> $${item.value.product.price}</p>
                                    </td>
                                    <td class="price-pr">
                                        <p> $${item.value.product.salePrice}</p>
                                    </td>
                                    <td class="quantity-box">
                                    	<input value="${item.value.quantity}" type="number" size="4" min="0" step="1" 
                                    	class="c-input-text qty text editQuantityCart" data-id="${item.key}" id="quantity-cart-${item.key}">
                                    </td>
                                    <td class="total-pr">
                                        <p> $${item.value.product.salePrice*item.value.quantity}</p>
                                    </td>
                                    <td class="remove-pr">
                                        <a class ="remove" onclick="remove()" data-id="${item.key}" href="<c:url value='/xoa-gio-hang/${item.key}'/>">
											<i class="fas fa-times"></i>
										</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-10 col-sm-10">
                </div>
                <div class="col-lg-2 col-sm-2">
                    <div class="update-box">
                     <div class="col-12 d-flex shopping-box"><a href="<c:url value='/cart'/>" class="ml-auto btn hvr-hover">Update cart</a> </div>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-8 col-sm-12"></div>
                <div class="col-lg-4 col-sm-12">
                    <div class="order-box">
                        <h3>Order summary</h3>
                        <div class="d-flex">
                            <h4>Sub Total</h4>
                            <div class="ml-auto font-weight-bold"> $${noPromotionPrice} </div>
                        </div>
                       <div class="d-flex">
                            <h4>Discount</h4>
                            <div class="ml-auto font-weight-bold">$${noPromotionPrice-totalPriceCart} </div>
                        </div>
                        <hr class="my-1">
                      <div class="d-flex gr-total">
                            <h5>Grand Total</h5>
                            <div class="ml-auto h5"> $ ${totalPriceCart} </div>
                        </div> 
                        <hr> </div>
                </div>
                <div class="col-12 d-flex shopping-box"><a href="<c:url value='/dat-hang'/>" class="ml-auto btn hvr-hover">Checkout</a> </div>
            </div>
        </div>
    </div>
    <!-- End Cart -->
	<content tag="script"> 
		<script type="text/javascript">
		$(".editQuantityCart").click(function() {
			var id = $(this).data("id");
			var quantity = $("#quantity-cart-" + id).val();
			$.ajax({
				url : "sua-gio-hang/" + id + "/" + quantity,
				type : 'GET',
				contentType : 'application/json',
				data : {
					id : id,
					quantity : quantity
				},
			});
		});
		
		$(".remove").click(function() {
			var id = $(this).data("id");	
			$.ajax({
				url : "xoa-gio-hang/" + id,
				type : 'PUT',
				contentType : 'application/json',
				data : {
					id:id,
				},
				success : remove 
			});
		});
		
		function remove() {
		       Swal.fire({
		     	   position: 'center',
		     	   icon: 'success',
					title: '???? x??a th??nh c??ng!!',
		     	   showConfirmButton: false,
		     	   timer: 2500
		     	 })
		        };
		</script> 
	</content>
</body>
</html>