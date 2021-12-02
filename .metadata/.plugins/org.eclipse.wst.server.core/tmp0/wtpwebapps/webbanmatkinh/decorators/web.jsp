<%@ page import="com.webbanmatkinh.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>PandaShop</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    
	<link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/template/image/avatar.jpg'/>">
	<link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/template/image/avatar.jpg'/>">
    
    <link rel="shortcut icon" href="<c:url value='/template/web/images/favicon.ico'/>" type="image/x-icon">
    <link rel="apple-touch-icon" href="<c:url value='/template/web/images/apple-touch-icon.png'/>">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css'/>">
    <!-- Site CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/responsive.css'/>">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/custom.css'/>">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
	
</head>
<body>
	 <%@ include file="/common/web/header.jsp" %>
	  
	<dec:body/>
	 <%@ include file="/common/web/footer.jsp" %>
	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

    <!-- ALL JS FILES -->
    <script src="<c:url value='/template/web/js/jquery-3.2.1.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/popper.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
    <!-- ALL PLUGINS -->
    <script src="<c:url value='/template/web/js/jquery.superslides.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/bootstrap-select.js'/>"></script>
    <script src="<c:url value='/template/web/js/inewsticker.js'/>"></script>
    <script src="<c:url value='/template/web/js/bootsnav.js'/>"></script>
    <script src="<c:url value='/template/web/js/images-loded.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/isotope.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/baguetteBox.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/form-validator.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/contact-form-script.js'/>"></script>
    <script src="<c:url value='/template/web/js/custom.js'/>"></script>
	
	 <!-- phan trang -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script> 
	<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
   
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
   
	<dec:getProperty property="page.script"></dec:getProperty>
</body>
</html>