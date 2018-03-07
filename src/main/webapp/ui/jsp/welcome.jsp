<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Create an account</title>

<link href="/bootstrap.min.css" rel="stylesheet">
<link href="/form-validation.css" rel="stylesheet">
<script src="/jquery-2.2.1.min.js"></script>
<script src="/bootstrap.min.js"></script>

<script type="text/javascript">
	//Refresh page
	function refreshPage() {
		window.parent.location = window.parent.location.href;
	}


	function openSuccessModal() {
		$(document).ready(function() {
			$("#successModal").modal();
		});
	}
</script>


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bg-light">

	<div class="container">
		<div class="py-5 text-center">
			<h2>Welcome</h2>
		</div>

		<div class="row">
			<div class="col-md-8 order-md-1">

				<form method="POST" action="/cpsOperation">
					<div class="row">
						<div class="col-md-6 mb-3">
							<h2 class="mb-3">Ticket No.</h2>
						</div>
						<div class="col-md-6 mb-3" style="margin-top: 20px">
							<input type="text" class="form-control" id="ticketNumber" name="ticketNumber" placeholder="Ticket number"
								value="" required>

						</div>
					</div>
					<br> <br>
					<div class="row">
						<button class="btn btn-primary btn-lg" type="submit">Proceed</button>
						<button class="btn btn-primary btn-lg" type="button" data-toggle="modal" data-target="#cancelModal">Cancel</button>
					</div>
					<c:if test="${not empty success}">
						<script>
							openSuccessModal();
						</script>
					</c:if>
				</form>
			</div>
		</div>


		<!--Cancel Modal -->
		<div class="modal fade" id="cancelModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Cancel transaction ?</h4>
					</div>
					<div class="modal-body">
						<p>Are you sure you want to cancel this transaction ?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick="refreshPage()">Yes</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					</div>
				</div>
			</div>
		</div>


		<!-- Sucess Modal -->
		<div class="modal fade" id="successModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Success</h4>
					</div>
					<div class="modal-body">
						<p>Transaction Process completed successfully.!</p>
						<a href="#" class="btn btn-success btn-lg"> <span class="glyphicon glyphicon-ok"></span>
						</a>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
					</div>
				</div>
			</div>
		</div>


		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2017-2018 Company Name</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacy</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Support</a></li>
			</ul>
		</footer>
	</div>

</body>
</html>
