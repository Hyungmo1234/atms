<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header {
	height: 10%;
	border: 1px solid red;
	margin-bottom:1%;
}
</style>
</head>
<body>
	<header>
		<table style="width: 100%;">
			<tr>
				<c:if test="${Logininfo.id eq null}">
				<td style="width: 90%"><img src="resources/images/logo.png" width="10%"></td>
				<td style="width: 5%"><a href="G02">社員登録</a></td>
				<td style="width: 5%"><a href="G01">ログイン</a></td>
				</c:if>
				<c:if test="${Logininfo.id ne null}">
				<td style="width: 59%"><img src="resources/images/logo.png" width="10%"></td>
				<td style="width: 5%">${Logininfo.comName_ryak}</td>
				<td style="width: 11%">${Logininfo.dep_name}</td>
				<td style="width: 5%">${Logininfo.pos_name}</td>
				<td style="width: 5%">${Logininfo.emp_name}</td>
				<td style="width: 5%">${Logininfo.id}</td>
				<td style="width: 5%"><form action="/logout" method="GET"><input type="submit" value="ログアウト"/></form></td>
				</c:if>
			</tr>
		</table>
	</header>
</body>
</html>