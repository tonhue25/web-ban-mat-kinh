<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/san-pham/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/san-pham/chinh-sua"/>
<c:url var="newAPI" value="/api/product"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="mobile-menu-overlay"></div>
	<div class="main-container">
		<div class="pd-ltr-20 xs-pd-20-10">
			<div class="min-height-200px">
				<div class="page-header">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="title">
								<h4>Form</h4>
							</div>
							<nav aria-label="breadcrumb" role="navigation">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.html">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Form Basic</li>
								</ol>
							</nav>
						</div>
						<div class="col-md-6 col-sm-12 text-right"></div>
					</div>
				</div>
				<div class="pd-20 card-box mb-30">
					<div class="clearfix">
						<div class="pull-left">
							<h4 class="text-blue h4">Default Basic Forms</h4>
							<p class="mb-30">All bootstrap element classies</p>
						</div>
						<div class="pull-right">
						</div>
					</div>
					
					<form class="form-horizontal" role="form" id="formSubmit" enctype="multipart/form-data" method="post" modelAttribute="model">
					<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Name</label>
							<div class="col-sm-12 col-md-10">
								<input name="name" class="form-control" type="text"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Price</label>
							<div class="col-sm-12 col-md-10">
								<input name="price" class="form-control" type="number"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Discount</label>
							<div class="col-sm-12 col-md-10">
								<input name="sale" class="form-control" type="number"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="categoryCode" class="col-sm-12 col-md-2 col-form-label">Category</label>
							<div class="col-sm-12 col-md-10">
								
							  	 <select name="categoryCode" id="categoryCode" class="custom-select col-12">
								<option value="" label="-- Chọn thể loại --"/>
								<c:forEach var="item" items="${categories}">
                            		<option value="${item.key}">${item.value}</option>
                            	</c:forEach> 
                            	</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Image</label>
							<div class="col-sm-9">
									<input name="file" class="col-xs-10 col-sm-5" id="file" type="file" />
								</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Short Description</label>
							<div class="col-sm-12 col-md-10">
							<textarea name= "shortDescription" class="form-control" id="shortDescription"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Detail</label>
							<div class="col-sm-12 col-md-10">
							<textarea name="detail"  class="form-control" id="detail"></textarea>
							</div>
						</div>
						<div class="row">
					<div class="col-md-3 col-sm-12"></div>
					<div class="col-md-6 col-sm-12">
						<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="submit" id="btnAddOrUpdateNew">
										<i class="ace-icon fa fa-check bigger-110"></i>Thêm sản phẩm
									</button>
									
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-danger" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>Hủy
									</button>
								</div>
							</div>
					</div>
					<div class="col-md-3 col-sm-12"></div>
				</div>
					</form>
					<div class="collapse collapse-box" id="basic-form1" >
						<div class="code-box">
							<div class="clearfix">
								<a href="javascript:;" class="btn btn-primary btn-sm code-copy pull-left"  data-clipboard-target="#copy-pre"><i class="fa fa-clipboard"></i> Copy Code</a>
								<a href="#basic-form1" class="btn btn-primary btn-sm pull-right" rel="content-y"  data-toggle="collapse" role="button"><i class="fa fa-eye-slash"></i> Hide Code</a>
							</div>
							<pre><code class="xml copy-pre" id="copy-pre">
							</code></pre>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>