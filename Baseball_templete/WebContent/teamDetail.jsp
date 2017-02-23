<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BaseballTeam</title>
<link href="resources/css/bootstrap_modify.css" rel="stylesheet">
<link href="resources/css/layout.css" rel="stylesheet">
<style>
.feature {
	display: block;
	width: 100%;
	margin: 0;
}

.blog-stripe .block-title {
	background: black;
	width: 100%;
	color: white;
	height: 100px;
	padding-top: 20px;
}

.all-blogs .media {
	margin-left: -40px;
	padding-bottom: 20px;
	border-bottom: 1px solid #CCCCCC;
}
</style>
<script src="resources/js/jquery-2.1.3.js"></script>
</head>
<body>

	<!-- Main Navigation ================================================================================= -->
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="list.do">BaseballTeam</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="list.do">홈</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="list.do">팀목록</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="playerList.do">선수목록</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- Header ========================================================================================== -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="jumbotron">
						<h2>야구팀 정보</h2>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<ol class="breadcrumb">
						<li>홈</li>
						<li>야구팀</li>
						<li class="active">${base.name }</li>
					</ol>
				</div>
			</div>
		</div>
	</header>

	<!-- Container ======================================================================================= -->


	<div class="container">
		<div class="row">
			<div class="col-md-1 col-lg-1">
			</div>
			<div class="col-md-3 col-lg-3">
				<div class="blog-stripe" >
					<img
						src="resources/img/${base.logo }"
						alt="${base.name}" class="feature">
				</div>
			</div>
			<div class="col-md-1 col-lg-1"></div>
			<div class="col-md-7 col-lg-7">
				<ul class="all-blogs">
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">${base.name }</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">감독 : ${base.manager }</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">연고지 : ${base.region}</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">홈구장 : ${base.stadium}</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">
								등록선수 : <a href="playerList.do">5</a>명
							</h4>
						</div>
					</li>
				</ul>
			</div>
			<div class="text-right">
				<a href="list.do">
					<button type="button" class="btn btn btn-warning">팀목록</button>
				</a>
			</div>
		</div>

		<!-- Footer ========================================================================================== -->
		<footer>
			<hr>
			<p>© NamooBaseball 2016.</p>
		</footer>
	</div>
</body>
</html>