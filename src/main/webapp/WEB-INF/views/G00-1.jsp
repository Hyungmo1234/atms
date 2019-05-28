<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#main {
	text-align: left;
	height: 70%;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="main">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: center; height: 100%">

		<h2>${Logininfo.id} 님.</h2>
		<div><a href="attendanceGET">data input</a></div>
		<div><a href="G06-2">all data search</a></div>
		<div><a href="G03">member data</a></div>
		
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>