<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//URL 管理社員情報照会
	// FULL URL /G00-2/G10
	String URL_MembersInfomation = "/G00-2/G10"; 
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
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="main">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
			
			<table class="table_memberInfoList">
					<tr>
						<td>ID</td><td>:</td>
						<td>${memberData.id}</td>
					</tr>
					<tr>
						<td>名前</td><td>:</td>
						<td>${memberData.emp_name}</td>
					</tr>
					<tr>
						<td>会社</td><td>:</td>
						<td>${memberData.com_name}</td>
					</tr>
					<tr>
						<td>部署</td><td>:</td>
						<td>${memberData.dep_name}</td>
					</tr>
					<tr>
						<td>職位</td><td>:</td>
						<td>${memberData.pos_name}</td>
					</tr>
					<tr>
						<td>性別</td><td>:</td>
						<td>${memberData.gender}</td>
					</tr>
					<tr>
						<td>メール</td><td>:</td>
						<td>${memberData.mail}</td>
					</tr>
					<tr>
						<td>住所</td><td>:</td>
						<td>${memberData.address}</td>
					</tr>
					<tr>
						<td>入社日</td><td>:</td>
						<td>${memberData.entry_date}</td>
					</tr>
					<tr>
						<td colspan="3">
							<a href="#">勤怠情報 </a>
							<a href=<%= URL_MembersInfomation %>>キャンセル</a>
						</td>
					</tr>
			</table>
			
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>