<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/vai-tro/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/vai-tro/chinh-sua"/>
<c:url var="newAPI" value="/api/role"/>
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
									<li class="breadcrumb-item active" aria-current="page">Role</li>
								</ol>
							</nav>
						</div>
						<div class="col-md-6 col-sm-12 text-right"></div>
					</div>
				</div>
				<div class="pd-20 card-box mb-30">
					<div class="clearfix">
						<div class="pull-left">
							<h4 class="text-blue h4">Role</h4>
							<p class="mb-30"></p>
						</div>
						<div class="pull-right">
						</div>
					</div>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Name</label>
							<div class="col-sm-12 col-md-10">
								<form:input path="name" class="form-control" type="text"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-12 col-md-2 col-form-label">Code</label>
							<div class="col-sm-12 col-md-10">
								<form:input path="code" class="form-control" type="text"/>
							</div>
						</div>
						<form:hidden path="id" id="newId"/>
						<div class="row">
					<div class="col-md-2 col-sm-12"></div>
					<div class="col-md-8 col-sm-12">
						<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													C???p nh???t th??ng tin vai tr??
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Th??m vai tr??
												</button>
											</c:if>
											
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-danger" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>H???y
									</button>
								</div>
							</div>
					</div>
					<div class="col-md-2 col-sm-12"></div>
				</div>
					</form:form>
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
	<content tag = "script">
	<script>
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#newId').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});
	
	function addNew(data) {
		$.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	sc();
            	/* window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success"; */
            },
            error: function (error) {
            	oop();
            	/* window.location.href = "${newURL}?page=1&limit=5&message=error_system"; */
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	sc();
            	/* window.location.href = "${editNewURL}?id="+result.id+"&message=update_success"; */
            },
            error: function (error) {
            	oop();
            	/* window.location.href = "${editNewURL}?id="+result.id+"&message=error_system"; */
            }
        });
	}
	
	function sc() {
		Swal.fire({
			  position: 'center',
			  icon: 'success',
			  title: 'Your work has been saved',
			  showConfirmButton: false,
			  timer: 1500
			})
	        };
	
	function oop() {
	Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Something went wrong!',
		})
	};
</script>
</content>
</body>
</html>