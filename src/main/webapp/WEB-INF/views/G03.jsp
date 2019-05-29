<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
<style type="text/css">
th {
	text-align: left;
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
	<br>
	<div
		style="font-family: verdana; padding: 5px; border: 1px solid red; font-size: 25px; text-align: left; height: 80%">
		<h1>社員情報照会</h1>
		<center>
			<table>
				<tr>
					<th>ID</th>
					<td>: honggildong</td>
				</tr>
				<tr>
					<th>名前</th>
					<td>: 李永泰</td>
				</tr>
				<tr>
					<th>会社</th>
					<td>: GCS</td>
				</tr>
				<tr>
					<th>部署</th>
					<td>: 第一事業部 開発1部</td>
				</tr>
				<tr>
					<th>職位</th>
					<td>: MB</td>
				</tr>
				<tr>
					<th>性別</th>
					<td>: 男</td>
				</tr>
				<tr>
					<th>メール</th>
					<td>: gildong@gmail.com</td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td>: 070-1234-5678</td>
				</tr>
				<tr>
					<th>住所</th>
					<td>: 東京都品川区八潮5丁目6番37-315号</td>
				</tr>
				<tr>
					<th>入社日</th>
					<td>: 2019年4月6日</td>
				</tr>
			</table>
			<br> <input type="button" value="情報修正"
				onclick="location.href='/G04'" /> <input type="button"
				value="パスワード変更" onclick="location.href='/G05'" /> <input
				type="button" value="キャンセル" onclick="history.back();" />
		</center>
	</div>
</body>
<footer style="margin-top: 20px">
	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</footer>
</html>