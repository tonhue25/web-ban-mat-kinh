<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>PandaShop</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/template/admin/vendors/images/apple-touch-icon.png'/>">
	<link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/template/image/avatar.jpg'/>">
	<link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/template/image/avatar.jpg'/>">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/vendors/styles/core.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/vendors/styles/icon-font.min.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/src/plugins/jquery-steps/jquery.steps.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/vendors/styles/style.css'/>">


	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-119386393-1');
	</script>
	
</head>
<body>
	<dec:body/>
	<script src="<c:url value='/template/admin/vendors/scripts/core.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/scripts/script.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/scripts/process.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/scripts/layout-settings.js'/>"></script>
	<script src="<c:url value='/template/admin/src/plugins/jquery-steps/jquery.steps.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/scripts/steps-setting.js'/>"></script>
	<dec:getProperty property="page.script"></dec:getProperty>
</body>
</html>