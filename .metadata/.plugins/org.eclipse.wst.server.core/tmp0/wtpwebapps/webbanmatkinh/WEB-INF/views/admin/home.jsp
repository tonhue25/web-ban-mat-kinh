<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.webbanmatkinh.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mobile-menu-overlay"></div>
	<div class="main-container">
		<div class="xs-pd-20-10 pd-ltr-20">
			<div class="page-header">
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<div class="title">
							<h4>Dashboard</h4>
						</div>
						<nav aria-label="breadcrumb" role="navigation">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="index.html">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Dashboard</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		<%-- <div class="xs-pd-20-10 pd-ltr-20">
			<div class="row clearfix progress-box">
				<div class="col-lg-3 col-md-6 col-sm-12 mb-30">
					<div class="card-box pd-30 height-100-p">
						<div class="progress-box text-center">
							 <input type="text" class="knob dial1" value="80" data-width="120" data-height="120" data-linecap="round" data-thickness="0.12" data-bgColor="#fff" data-fgColor="#1b00ff" data-angleOffset="180" readonly>
							<h5 class="text-blue padding-top-10 h5">Products</h5>
							<span class="d-block">${product} product<i class="fa fa-line-chart text-blue"></i></span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 mb-30">
					<div class="card-box pd-30 height-100-p">
						<div class="progress-box text-center">
							 <input type="text" class="knob dial2" value="70" data-width="120" data-height="120" data-linecap="round" data-thickness="0.12" data-bgColor="#fff" data-fgColor="#00e091" data-angleOffset="180" readonly>
							<h5 class="text-light-green padding-top-10 h5">Business Captured</h5>
							<span class="d-block">75% Average <i class="fa text-light-green fa-line-chart"></i></span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 mb-30">
					<div class="card-box pd-30 height-100-p">
						<div class="progress-box text-center">
							 <input type="text" class="knob dial3" value="90" data-width="120" data-height="120" data-linecap="round" data-thickness="0.12" data-bgColor="#fff" data-fgColor="#f56767" data-angleOffset="180" readonly>
							<h5 class="text-light-orange padding-top-10 h5">Projects Speed</h5>
							<span class="d-block">90% Average <i class="fa text-light-orange fa-line-chart"></i></span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 mb-30">
					<div class="card-box pd-30 height-100-p">
						<div class="progress-box text-center">
							 <input type="text" class="knob dial4" value="65" data-width="120" data-height="120" data-linecap="round" data-thickness="0.12" data-bgColor="#fff" data-fgColor="#a683eb" data-angleOffset="180" readonly>
							<h5 class="text-light-purple padding-top-10 h5">Panding Orders</h5>
							<span class="d-block">65% Average <i class="fa text-light-purple fa-line-chart"></i></span>
						</div>
					</div>
				</div>
			</div>
		</div> --%>
		<div class="row">
				<div class="col-xl-4 mb-30">
					<div class="card-box height-100-p widget-style1">
						<div class="d-flex flex-wrap align-items-center">
							<div class="progress-data">
								<div id="chart"></div>
							</div>
							<div class="widget-data">
								<div class="h4 mb-0">${product}</div>
								<div class="weight-600 font-14">Products</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-4 mb-30">
					<div class="card-box height-100-p widget-style1">
						<div class="d-flex flex-wrap align-items-center">
							<div class="progress-data">
								<div id="chart2"></div>
							</div>
							<div class="widget-data">
								<div class="h4 mb-0">${user}</div>
								<div class="weight-600 font-14">Register User</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-4 mb-30">
					<div class="card-box height-100-p widget-style1">
						<div class="d-flex flex-wrap align-items-center">
							<div class="progress-data">
								<div id="chart3"></div>
							</div>
							<div class="widget-data">
								<div class="h4 mb-0">${category}</div>
								<div class="weight-600 font-14">Categories</div>
							</div>
						</div>
					</div>
				</div>
				<!-- <div class="col-xl-3 mb-30">
					<div class="card-box height-100-p widget-style1">
						<div class="d-flex flex-wrap align-items-center">
							<div class="progress-data">
								<div id="chart4"></div>
							</div>
							<div class="widget-data">
								<div class="h4 mb-0">$6060</div>
								<div class="weight-600 font-14"></div>
							</div>
						</div>
					</div>
				</div> -->
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6 col-sm-12 mb-30">
					<div class="card-box pd-30 pt-10 height-100-p">
						<h2 class="mb-30 h4">Browser Visit</h2>
						<div class="browser-visits">
							<ul>
								<li class="d-flex flex-wrap align-items-center">
									<div class="icon"><img src="<c:url value='/template/admin/vendors/images/chrome.png'/>" alt=""></div>
									<div class="browser-name">Google Chrome</div>
									<div class="visit"><span class="badge badge-pill badge-primary">50%</span></div>
								</li>
								<li class="d-flex flex-wrap align-items-center">
									<div class="icon"><img src="<c:url value='/template/admin/vendors/images/firefox.png'/>" alt=""></div>
									<div class="browser-name">Mozilla Firefox</div>
									<div class="visit"><span class="badge badge-pill badge-secondary">40%</span></div>
								</li>
								<li class="d-flex flex-wrap align-items-center">
									<div class="icon"><img src="<c:url value='/template/admin/vendors/images/safari.png'/>" alt=""></div>
									<div class="browser-name">Safari</div>
									<div class="visit"><span class="badge badge-pill badge-success">40%</span></div>
								</li>
								<li class="d-flex flex-wrap align-items-center">
									<div class="icon"><img src="<c:url value='/template/admin/vendors/images/edge.png'/>" alt=""></div>
									<div class="browser-name">Microsoft Edge</div>
									<div class="visit"><span class="badge badge-pill badge-warning">20%</span></div>
								</li>
								<li class="d-flex flex-wrap align-items-center">
									<div class="icon"><img src="<c:url value='/template/admin/vendors/images/opera.png'/>" alt=""></div>
									<div class="browser-name">Opera Mini</div>
									<div class="visit"><span class="badge badge-pill badge-info">20%</span></div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-8 col-md-6 col-sm-12 mb-30">
					<div class="card-box pd-30 pt-10 height-100-p">
						<h2 class="h4 mb-20">Target</h2>
						<div id="chart6"></div>
					</div>
				</div>
			</div>
	</div>
	</div>
</body>
</html>