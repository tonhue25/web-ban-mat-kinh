<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="url" value="/phan-hoi" />
<%@ page import="com.webbanmatkinh.constant.SystemConstant" %>

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
					<h2>Checkout</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Shop</a></li>
						<li class="breadcrumb-item active">Checkout</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="cart-box-main">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="checkout-address">
						<div class="title-left">
							<h3>Billing address</h3>
						</div>
						<form:form action="thanh-toan" method="post" modelAttribute="user">
							<div class="mb-3">
								<label for="fullName">Full name *</label>
								<form:input path="fullName" type="text" class="form-control"
									id="fullName"/>
							</div>
							<div class="mb-3">
								<label for="username">User name *</label>
								<div class="input-group">
									<form:input path="userName" type="text" class="form-control" id="username" />
								</div>
							</div>
							<div class="mb-3">
								<label for="email">Email Address *</label> 
								<form:input path="email" type="email"
									class="form-control" id="email" placeholder=""/>
								
							</div>
							<div class="mb-3">
								<label for="address">Address *</label> 
								<form:input path="address" type="text"
									class="form-control" id="address"/>
								
							</div>
							<div class="mb-3">
								<label for="phone">Phone *</label> 
								<form:input path="phone" type="text"
									class="form-control" id="phone" placeholder=""/>
							</div>
							<hr class="mb-1">
						</form:form>
					</div>
				</div>
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="row">
						<div class="col-md-12 col-lg-12">
							
                            <div class="shipping-method-box">
                                <div class="title-left">
                                    <h3>Shipping Method</h3>
                                </div>
                                <div class="mb-4">
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption1" name="shipping-option" class="custom-control-input" type="radio" value = "standard">
                                        <label class="custom-control-label" for="shippingOption1">Standard Delivery</label> <span class="float-right font-weight-bold">FREE</span> </div>
                                    <div class="ml-4 mb-2 small">(3-7 business days)</div>
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption2" name="shipping-option" class="custom-control-input" type="radio"  value = "express">
                                        <label class="custom-control-label" for="shippingOption2">Express Delivery</label> <span class="float-right font-weight-bold">$10.00</span> </div>
                                    <div class="ml-4 mb-2 small">(2-4 business days)</div>
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption3" name="shipping-option" class="custom-control-input" type="radio"  value = "next_business">
                                        <label class="custom-control-label" for="shippingOption3">Next Business day</label> <span class="float-right font-weight-bold">$20.00</span> </div>
                                </div>
                            </div>
                        
						</div>
						<div class="col-md-12 col-lg-12">
							<div class="order-box">
								<div class="title-left">
									<h3>Shopping cart</h3>
								</div>
								<div class="rounded p-2 bg-light">
									<c:forEach var="item" items="${Cart}">
									<div class="media mb-2 border-bottom">
										<div class="media-body">
											<a href="<c:url value='/chi-tiet-san-pham/${item.key}'/>"> ${item.value.product.name}</a>
											<div class="small text-muted">
												Price: $${item.value.product.price} <span class="mx-2">|</span> 
												Promotion Price: $${item.value.product.salePrice} <span class="mx-2">|</span> 
												Quantity: ${item.value.quantity} <span class="mx-2"></span>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
						
						<div class="col-md-12 col-lg-12">
							<div class="order-box">
								<div class="title-left">
									<h3>Your order</h3>
								</div>
								<div class="d-flex">
									<div class="font-weight-bold">Product</div>
									<div class="ml-auto font-weight-bold">Total</div>
								</div>
								<hr class="my-1">
								<div class="d-flex">
									<h4>Sub Total</h4>
									<div class="ml-auto font-weight-bold">$${noPromotionPrice}</div>
								</div>
								<div class="d-flex">
									<h4>Discount</h4>
									<div class="ml-auto font-weight-bold">$${noPromotionPrice - totalPriceCart}</div>
								</div>
								<hr class="my-1">
								<div class="d-flex">
									<h4>Price</h4>
									<div class="ml-auto font-weight-bold">$${totalPriceCart}</div>
								</div>
								<div class="d-flex">
									<h4>Tax</h4>
									<div class="ml-auto font-weight-bold">$${SystemConstant.TAX}</div>
								</div>
								<div class="d-flex">
									<h4>Shipping Cost</h4>
									<p class="ml-auto font-weight-bold" id = "value"></p>
								</div>
								<hr>
								<div class="d-flex gr-total">
									<h5>Grand Total</h5>
									<p class="ml-auto h5" id = "total"></p>
								</div>
								<hr>
							</div>
						</div> 
						<div class="col-12 d-flex shopping-box">		
							<a id ="btn1" class="ml-auto btn hvr-hover">Place Order</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	   
	<content tag = "script">
		<script type="text/javascript">
		document.getElementById("btn1").onclick = function ()
        {
            var checkbox = document.getElementsByName("shipping-option");
            for (var i = 0; i < checkbox.length; i++){
                if (checkbox[i].checked === true){
                    if(checkbox[i].value == "standard"){
                    	window.location.href = "${url}?ship=standard";
                    }
                    if(checkbox[i].value == "express"){
                    	window.location.href = "${url}?ship=express"; 
                    }
                    if(checkbox[i].value == "next_business"){
                    	window.location.href = "${url}?ship=next_business"; 
                    }
                }
            }
        };
        
       function displayVals() {
       document.getElementById('shippingOption1').onclick = function(e){
            if (this.checked){
            	$("#value").html("$${SystemConstant.STANDARD}");
            	$("#total").html("$${totalPriceCart+SystemConstant.TAX + SystemConstant.STANDARD}");
            }
        };
        document.getElementById("shippingOption2").onclick = function () {
        	if (this.checked){
               $("#value").html("$${SystemConstant.EXPRESS}");
               $("#total").html("$${totalPriceCart+SystemConstant.TAX+ SystemConstant.EXPRESS}");
            }
        };
        document.getElementById("shippingOption3").onclick = function () {
        	if (this.checked){
        		$("#value").html("$${SystemConstant.NEXT_BUSINESS}");
        		$("#total").html("$${totalPriceCart+SystemConstant.TAX+ SystemConstant.NEXT_BUSINESS}");
            }
        };
        }
        $( "#value" ).change( displayVals );
        displayVals();
		</script>
	</content>
</body>
</html>