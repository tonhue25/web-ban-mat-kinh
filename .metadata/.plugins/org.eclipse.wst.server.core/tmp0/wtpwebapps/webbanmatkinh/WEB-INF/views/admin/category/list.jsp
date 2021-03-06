<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newAPI" value="/api/category" />
<c:url var="newURL" value="/quan-tri/the-loai/tat-ca-the-loai" />
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div class="mobile-menu-overlay"></div>
<div class="main-container">
	<form action="<c:url value='/quan-tri/the-loai/tat-ca-the-loai'/>" id="formSubmit" method="get">
		<div class="pd-ltr-20 xs-pd-20-10">
			<div class="min-height-100px">
				<div class="page-header">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="title">
								<h4>Categories</h4>
							</div>
							<nav aria-label="breadcrumb" role="navigation">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.html">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Categories</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="card-box mb-30">
				<div class="pd-20">
					<div class="row">
					<div class="col-md-4 col-sm-12">
						<h4 class="text-blue h4">Categories</h4>
					</div>
					<div class="col-md-6 col-sm-12"></div>
					<div class="col-md-2 col-sm-12">	
						<div class="dt-buttons btn-overlap btn-group">
						<c:url var="createNewURL" value="/quan-tri/the-loai/chinh-sua" />
						<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
							data-toggle="tooltip" title='Thêm thể loại'
							href='${createNewURL}'> 
							<span> <i class="fa fa-plus-circle bigger-110 purple"></i></span>
						</a>
						<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
							class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
							data-toggle="tooltip" title='Xóa thể loại'>
							<span> <i class="fa fa-trash-o bigger-110 pink"></i></span>
						</button>
					</div>
					</div>
				</div>
				</div>
				<div class="pb-20">
					<table class="data-table table stripe hover nowrap">
						<thead>
							<tr>
								<th>
									<input type="checkbox" id="checkAll">
								</th>
								<th class="table-plus datatable-nosort">Name</th>
								<th>Code</th>
								<th class="datatable-nosort"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
							<tr>
								<td>
									<input type="checkbox" id="checkbox_${item.id}" value="${item.id}" name = "check">
								</td>
								<td>${item.name}</td>
								<td>${item.code}</td>
								<td>
									<!-- <div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list"> -->
											
											<c:url var="updateNewURL" value="/quan-tri/the-loai/chinh-sua">
												<c:param name="id" value="${item.id}" />
											</c:url> 
											<a class="dropdown-item" href='${updateNewURL}'><i class="dw dw-edit2"></i></a>
											<%-- <a class="dropdown-item" href='${updateNewURL}'><i class="dw dw-edit2"></i> Edit</a>
											<!-- <a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a> -->
										</div>
									</div> --%>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<div class="col-md-4 col-sm-12"></div>
					<div class="col-md-4 col-sm-12">
						<ul class="pagination" id="pagination"></ul>
						<input type="hidden" value="" id="page" name="page" /> 
						<input	type="hidden" value="" id="limit" name="limit" />
					</div>
					<div class="col-md-4 col-sm-12"></div>
				</div>
			</div>
		</div>
	</div>
</form>
</div>
<content tag = "script">
	<script>
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(5);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});

		function warningBeforeDelete() {
			const swalWithBootstrapButtons = Swal.mixin({
				  customClass: {
				    confirmButton: 'btn btn-success',
				    cancelButton: 'btn btn-danger'
				  },
				  buttonsStyling: false
				})

				swalWithBootstrapButtons.fire({
				  title: 'Are you sure?',
				  text: "You won't be able to revert this!",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonText: 'Yes, delete it!',
				  cancelButtonText: 'No, cancel!',
				  reverseButtons: true
				}).then((result)=>{
				  if (result.isConfirmed) {
					  var ids = $('tbody input[type=checkbox]:checked')
						.map(function() {
							return $(this).val();
							}).get();
						deleteNew(ids);
					  
				    swalWithBootstrapButtons.fire(
				      'Deleted!',
				      'Your category has been deleted.',
				      'success'
				    )
				  } else if (
				    /* Read more about handling dismissals below */
				    result.dismiss === Swal.DismissReason.cancel
				  ) {
				    swalWithBootstrapButtons.fire(
				      'Cancelled',
				      'Your category file is safe :)',
				      'error'
				    )
				  }
				})
			}
		
		function deleteNew(data) {
			$.ajax({
				url : '${newAPI}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
					window.location.href = "${newURL}?page=1&limit=5&message=delete_success";
				},
				error : function(error) {
					window.location.href = "${newURL}?page=1&limit=5&message=error_system";
					}
			});
		}
		
		 $("#checkAll").change(function () {
	            $("input:checkbox").prop('checked', $(this).prop("checked"));
	        });
	</script>
</content>
</body>
</html>