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
<div class="header">
		<div class="header-left">
			
		</div>
		<div class="header-right">
			<div class="user-notification">
				<div class="dropdown">
					<a class="dropdown-toggle no-arrow" role="button" data-toggle="dropdown">
						Wellcome, <%=SecurityUtils.getPrincipal().getFullName()%>
					</a>
					
				</div>
			</div>
			<div class="user-notification">
				<div class="dropdown">
					<a class="dropdown-toggle no-arrow"  href="<c:url value = '/thoat'/>" role="button" >
						<i class="dw dw-logout"></i>
					</a>
				</div>
			</div>
			
		</div>
	</div>
	</body>
</html>