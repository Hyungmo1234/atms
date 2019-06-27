<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<style type="text/css">
#main {
	height: 70%;
}

#list {
	font-size: 20px;
}

#btn {
	text-align: center;
}

#btn input {
	font-size: 15px;
}
</style>
</head>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
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

		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
			<h2>社員情報照会</h2>
			<form action="G03" method="POST">
				<table id="list" style="margin-left: auto; margin-right: auto;">
					<tr>
						<td><label>ID</label></td>
						<td>: ${listAll.id}</td>
					</tr>

					<tr>
						<td><label>名前</label></td>
						<td>: ${listAll.emp_name}</td>
					</tr>

					<tr>
						<td><label>会社</label></td>
						<td>: ${listAll.comName_ryak}</td>
					</tr>
					<tr>


						<td><label>部署</label></td>
						<td>: ${listAll.dep_name}</td>
					</tr>
					<tr>
						<td><label>職位</label></td>
						<td>: ${listAll.pos_name}</td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${listAll.gender eq 1 }">
								<td><label>性別</label></td>
								<td>: 男性</td>
							</c:when>
							<c:otherwise>
								<td><label>性別</label></td>
								<td>: 女性</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td><label>メール</label></td>
						<td>: ${listAll.mail}</td>
					</tr>
					<tr>
						<td><label>住所</label></td>
						<td>: ${listAll.address}</td>
					</tr>
					<tr>
						<td><label>入社日</label></td>
						<td>: ${listAll.entry_date}</td>
					</tr>


				</table>
			</form>
			<div id="btn">
				<a href="G04?id=${listAll.id}"><input type="button" value="情報修正" /></a>
				<a href="G05"><input type="button" value="パスワード 変更" /></a> <input
					type="button" class="btn_list" value="キャンセル" onclick="goBack()">
			</div>




		</div>
	</div>
</body>

<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</html>