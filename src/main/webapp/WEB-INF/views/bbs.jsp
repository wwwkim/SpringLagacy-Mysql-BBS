<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="head.jspf"%>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
		<li><a href="main">main</a>
		<li class="active"><a href="bbs">board</a>
	</ul>
	<c:choose>
		<c:when test="${not empty user}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">menu<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logout">Logout</a></li>
					</ul></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">menu<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">Login</a></li>
						<li><a href="join">Join</a></li>
					</ul></li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
</nav>
<div class="container">
	<div class="row">
		<table class="table table-striped"
			style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">No</th>
					<th style="background-color: #eeeeee; text-align: center;">Title</th>
					<th style="background-color: #eeeeee; text-align: center;">Writer</th>
					<th style="background-color: #eeeeee; text-align: center;">Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="bbsdto">
					<tr>
						<td>${bbsdto.bbsID}</td>
						<td><a href="view?bbsID=${bbsdto.bbsID}">${bbsdto.bbsTitle}</a></td>
						<td>${bbsdto.userID}</td>
						<td>${bbsdto.bbsDate.substring(0,11)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
			<c:if test="${pageNumber!=1}">
				<a href="bbs?pageNumber=${pageNumber-1 }"
					class="btn btn-success btn-arrow-left">before</a>
			</c:if>
			<c:if test="${nextPage }">
			<a href="bbs?pageNumber=${pageNumber+1}"
					class="btn btn-success btn-arrow-left">next</a>
			</c:if>
	
		<a href="write" class="btn btn-primary pull-right">Write</a>
	</div>
</div>

${msg}
<!-- 에니메이션 담당 -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>

</html>