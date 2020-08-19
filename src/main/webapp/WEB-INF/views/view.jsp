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
		<c:when test="${not empty sessionScope.userID}">
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
<div class="container" style="width:80%;">
	<div class="row">

		<table class="table table-striped"
			style="  text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3"
						style=" background-color: #eeeeee; text-align: center;">content</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 30%;">title</td>
					<td colspan="2" class=text-left >${bbs.bbsTitle }</td>
				</tr>
				<tr>
					<td>writer</td>
					<td colspan="2" class=text-left >${bbs.userID }</td>
				</tr>
				<tr>
					<td>reg_date</td>
					<td colspan="2" class=text-left >${bbs.bbsDate.substring(0,11)}</td>
				</tr>
				<tr>
					<td>content</td>
					<td colspan="2" style="height: 200px;" class=text-left >${bbs.bbsContent}</td>
				</tr>

			</tbody>
		</table>
		<a href="bbs" class="btn btn-primary">list</a>

		<c:if test="${not empty sessionScope.userID}">
			<c:if test="${sessionScope.userID == bbs.userID }">
				<a href="update?bbsID=${bbs.bbsID}" class="btn btn-primary">update</a>
				<a onclick="return confirm('Are you sure to delete it?')"href="deleteAction?bbsID=${bbs.bbsID}" class="btn btn-primary">delete</a>
			</c:if>
		</c:if>
	</div>
</div>
${msg}

<!-- 에니메이션 담당 -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>

</html>