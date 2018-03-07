<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/web/thymeleaf/layout">
<head>
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content=""></meta>
<meta name="author" content=""></meta>

<title>Log in with your account</title>

<link href="/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
<link href="/signin.css" rel="stylesheet" type="text/css"></link>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<form method="POST" action="/welcome" class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="userName" class="sr-only">Email address</label> 
		<input id="userName" name="userName" class="form-control" placeholder="User Name" required autofocus> 
		<label for="password" class="sr-only">Password</label> 
		<input name="password" type="password" id="password" class="form-control" placeholder="Password" required>
		<c:if test="${not empty errorMessage}">
			<c:out value="${errorMessage}" />
		</c:if>
		<br><br>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>
	<script src="/jquery-2.2.1.min.js"></script>
	<script src="/bootstrap.min.js"></script>
</body>
</html>
