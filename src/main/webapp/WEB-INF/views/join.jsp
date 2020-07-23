<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=divice-width" , initial-scale="1">
<!-- css link -->

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<title>掲示板システム</title>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="nabvar-haeder">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-nabvar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					　class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">BBS</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">main</a>
				<li><a href="bbs.jsp">board</a>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">menu<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">Login</a></li>
						<li class="active"><a href="join">Join</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="joinAction">
					<h3 style="text-align: center;">Join us</h3>

					<div class="form-group">
						<input type="text" class="form-control" placeholder="ID"
							name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="PASSWORD"
							name="userPassword" maxlength="20">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="NAME"
							name="userName" maxlength="20">
					</div>
					<div class="form-group" style="text-align: center">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <input
								type="radio" name="userGender" autocomplete="off" value="male"
								checked>male
							</label> <label class="btn btn-primary active"> <input
								type="radio" name="userGender" autocomplete="off" value="female"
								checked>female
							</label>
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="Email"
							name="userEmail" maxlength="50">
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="Join">
				</form>
			</div>
		</div>

		<div class="col-lg-4"></div>
	</div>
	${msg }


	<!-- 에니메이션 담당 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>

</html>