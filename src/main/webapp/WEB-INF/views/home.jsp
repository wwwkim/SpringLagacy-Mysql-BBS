<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jspf"%>
	<nav class="navbar navbar-default">
		<div class="nabvar-haeder">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-nabvar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main">wwwkim</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main">main</a>
				<li><a href="bbs">board</a>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">menu<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">login</a></li>
						<li><a href="join">join</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1>掲示板システム</h1>
				<p>Bootstrap＋JSP＋Mysql</p>
				<p>
					<a class="btn btn-primary btn-pull" href="#" role="button">자세히
						알아보기</a>
				</p>
			</div>
		</div>
	</div>

	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-tatget="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-tatget="#myCarousel" data-slide-to="1"></li>
				<li data-tatget="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="<c:url value="/resources/images/1.jpg"/>">
				</div>
				<div class="item">
					<img src="<c:url value="/resources/images/2.jpg"/>">
				</div>
				<div class="item">
					<img src="<c:url value="/resources/images/3.jpg"/>">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a> 
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>

</html>