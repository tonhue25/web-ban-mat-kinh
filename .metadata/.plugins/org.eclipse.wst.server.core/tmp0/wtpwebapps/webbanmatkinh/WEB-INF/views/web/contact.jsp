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
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Contact Us</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Contact Us</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contact-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-sm-12">
					<div class="contact-form-right">
						<h2>GET IN TOUCH</h2>
						<p></p>
							<form:form id="contact"  modelAttribute="user">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="fullName" class="mb-0"> Full Name</label>
										<form:input path="fullName" type="text" class="form-control"
											id="fullName" placeholder="Enter sender" />
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label for="email" class="mb-0"> Email Address</label>
										<form:input path="email" type="email" class="form-control"
											id="email" placeholder="Enter Email" />
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label for="subject" class="mb-0"> Subject</label>
										<form:input type="text" class="form-control" id="subject"
											path="subject" placeholder="Subject" />
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<form:textarea class="form-control" path="content"
											placeholder="Your Message" rows="4"></form:textarea>
									</div>
								</div>
							</div>
							<button type="submit" class="btn hvr-hover" onclick="addtocart()">Send Message</button>
						</form:form>
					</div>
				</div>
				<div class="col-lg-4 col-sm-12">
					<div class="contact-info-left">
						<h2>CONTACT INFO</h2>
						<p></p>
						<ul>
							<li>
								<p>
									<i class="fas fa-map-marker-alt"></i>Address: PandaShop 279/24
									Ho??ng H???u Nam<br> TP Th??? ?????c, TP HCM
								</p>
							</li>
							<li>
								<p>
									<i class="fas fa-phone-square"></i> Phone: <a
										href="tel:+84 3333 99 450">+84 3333 99 450</a>
								</p>
							</li>
							<li>
								<p>
									<i class="fas fa-envelope"></i>Email: <a
										href="mailto:contactuspandashop@gmail.com">contactuspandashop@gmail.com</a>
								</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<content tag="script">
    <script>
	$(".addtocart").click(function() {
		$.ajax({
			url : "contact",
			type : 'POST',
			contentType : 'application/json',
			success : addtocart 
		});
	});
	
	function addtocart() {
       Swal.fire({
     	   position: 'center',
     	   icon: 'success',
			title: 'G???i mail th??nh c??ng!!',
     	   showConfirmButton: false,
     	   timer: 2500
     	 })
        };
	</script>
	</content>
</body>
</html>