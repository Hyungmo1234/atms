<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// URL設定
	// FULL URL : /G00-2/G10/G11
	String URL_personal_information = "/G00-2/G10/G11";
	String URL_attendance_information="/G00-2/G10/G12";
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
				<tr>
					<td class="table_CountArea">番号</td>
					<td>会社</td>
					<td>職位</td>
					<td>名前</td>
					<td>部署</td>
					<td>性別</td>
					<td>メール</td>
					<td>근무시간(임시)</td>
				</tr>
				
				<c:forEach items="${membersData}" var="membersData">
					<tr>
						<td class="table_CountArea">번호(임시)</td>
						<td>${membersData.com_code}</td>
						<td>${membersData.pos_code}</td>
						<td onClick="document.getElementById('get_memeberInfoForm_${membersData.emp_name}').submit()">
							${membersData.emp_name}
						</td>
						<td>${membersData.dep_code}</td>
						<td>${membersData.gender}</td>
						<td>${membersData.mail}</td>
						<td onClick="document.getElementById('get_memeberAttdanceForm_${membersData.emp_name}').submit()">
						근무시간(임시)
						</td>
					</tr>
					<!-- 社員情報アクセス -->
					<form 
						id="get_memeberInfoForm_${membersData.emp_name}"
						action=<%= URL_personal_information %> 
						method="POST">
					<input type="hidden" name="name" value=${membersData.emp_name}>
					</form>
					<!-- 勤怠情報アクセス -->
					<form 
						id="get_memeberAttdanceForm_${membersData.emp_name}"
						action=<%= URL_attendance_information %> 
						method="POST">
						<input type="hidden" name="id" value=${membersData.id}>
					</form>
					
				</c:forEach>
			</table>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>