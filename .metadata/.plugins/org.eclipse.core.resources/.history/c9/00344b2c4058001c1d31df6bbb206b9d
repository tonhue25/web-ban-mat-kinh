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
                    <h2>Invoice</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">Invoice</li>
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
                                	<th>Invoice no</th>
                                   	<th>Subtotal</th>
                                   	<th>Discount</th> <!-- cai nay tu tinh -->
                                    <th>Tax</th>
                                    <th>Shipping</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${bill.listResult}">
                                <tr>
                                	<td class="price-pr">
                                        <p> ${item.id}</p>
                                    </td>
                                    <td class="price-pr">
                                        <p> $${item.subtotal}</p>
                                    </td>
                                    <td class="price-pr">
                                        <p> $${item.total - item.subtotal -  item.tax -  item.shipping}</p>
                                    </td>
                                    
                                    <td class="price-pr">
                                        <p> $${item.tax}</p>
                                    </td>
                                    <td class="price-pr">
                                        <p> $${item.shipping}</p>
                                    </td>
                                    <td class="price-pr">
                                        <p> $${item.total}</p>
                                    </td>
                                    
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>