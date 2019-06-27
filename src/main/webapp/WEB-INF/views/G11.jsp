<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%
  //URL 管理社員情報照会　
			// FULL URL /G00-2/G10
			String URL_MembersInfomation = "G10";
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

.main_innerDiv {
	width: 100%;
	height: 100%;
	font-family: verdana;
	border: 1px solid red;
	font-size: 25px;
	text-align: left;
}

.table_memberInfoList {
	width: 50%;
	margin: auto;
}

.info_column {
	width: 20%;
}

.info_value {
	width: 75%;
}

.cancel_btn {
	width: 10%;
	margin-left: 65%;
	margin-top: 3px;
	background-color: #9DA8BD;
	border: 1px solid black;
	border-radius: 10px;
}
</style>
</head>
<%
  String strReferer = request.getHeader("referer");

			if (strReferer == null) {
%>
<script language="javascript">
	alert("URL 주소창에 주소를 직접 입력해서 접근하셨습니다.\n\n정상적인 경로를 통해 다시 접근해 주십시오.");
	document.location.href = "../G01";
</script>
<%
  return;
  }
%>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="main">
		<div class="main_innerDiv">
			<div
				style="width: 100%; padding-left: 1%; padding-top: 1%; font-size: 35px; font-weight: bold;">
				社員情報紹介</div>

			<table class="table_memberInfoList">
				<tr>
					<td class="info_column">ID</td>
					<td>:</td>
					<td class="info_value">${memberData.id}</td>
				</tr>
				<tr>
					<td class="info_column">名前</td>
					<td>:</td>
					<td class="info_value">${memberData.emp_name}</td>
				</tr>
				<tr>
					<td class="info_column">会社</td>
					<td>:</td>
					<td class="info_value">${memberData.comName_ryak}</td>
				</tr>
				<tr>
					<td class="info_column">部署</td>
					<td>:</td>
					<td class="info_value">${memberData.dep_name}</td>
				</tr>
				<tr>
					<td class="info_column">職位</td>
					<td>:</td>
					<td class="info_value">${memberData.pos_name}</td>
				</tr>
				<tr>
					<td class="info_column">性別</td>
					<td>:</td>
					<c:choose>
						<c:when test="${memberData.gender eq 1 }">
							<td>男性</td>
						</c:when>
						<c:otherwise>
							<td>女性</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td class="info_column">メール</td>
					<td>:</td>
					<td class="info_value">${memberData.mail}</td>
				</tr>
				<tr>
					<td class="info_column">電話番号</td>
					<td>:</td>
					<td class="info_value">${memberData.cellphone}</td>
				</tr>
				<tr>
					<td class="info_column">住所</td>
					<td>:</td>
					<td class="info_value">${memberData.address}</td>
				</tr>
				<tr>
					<td class="info_column">入社日</td>
					<td>:</td>
					<td class="info_value">${memberData.entry_date}</td>
				</tr>
			</table>

			<div class="cancel_btn">
				<a style="color: black; text-decoration: none;"
					href=<%=URL_MembersInfomation%>>キャンセル</a>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>