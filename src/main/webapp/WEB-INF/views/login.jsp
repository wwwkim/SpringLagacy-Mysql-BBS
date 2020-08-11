<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li ><a href="main">main</a>
				<li><a href="bbs">board</a>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">menu<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login">Login</a></li>
						<li><a href="join">Join</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="jumbotron" style="padding-top: 20px;">
					<form method="post" action="loginAction">
						<h3 style="text-align: center;">Login Page</h3>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="ID"
								name="userID" maxlength="20">
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="PASSWORD" name="userPassword" maxlength="20">
						</div>
						<input type="submit" class="btn btn-primary form-control"
							value="Login">
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