<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: center; height: 100%">
		<input type="button" value="calendar" onclick="javascript_:window.open('G07','pop', 'menubar=no,status=no,scrollbars=no,resizable=no ,width=500,height=300,top=50,left=50');"/>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>