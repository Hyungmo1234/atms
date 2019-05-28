<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// URL設定
	// FULL URL : /G00-2/G10/G11
	String URL_personal_information = "/G00-2/G10/G11";
%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#main {
	text-align: left;
	height: 70%;
}

.table_CountArea {
	background-color : yellow;
}

.table_memberInfoList, .table_memberInfoList td {
	border : 1px solid black;
}

</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="main">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
			<table class="table_memberInfoList">
				<c:forEach items="${membersData}" var="membersData">
					<tr>
						<td class="table_CountArea">번호(임시)</td>
						<td>${membersData.com_name3}</td>
						<td>${membersData.dep_name}</td>
						<td>${membersData.emp_name}</td>
						<td>${membersData.pos_name1}</td>
						<td>${membersData.gender}</td>
						<td>${membersData.mail}</td>
						<td>근무시간(임시)</td>
						<td>
							<form action=<%= URL_personal_information %> method="POST">
								<button type="submit">클릭</button>
								<input type="hidden" name="name" value=${membersData.emp_name}>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>