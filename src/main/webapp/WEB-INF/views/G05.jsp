<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#pw_change {
	text-align: left;
	height: 70%;
}
#btn{
	text-align: center;	
}
tr{
	margin 20px;
}
label{
	font-size: 20px;
	margin-right: 50px;
}
input{
	font-size: 20px;
}
</style>
<script type="text/javascript">
	function back_click() {
		window.history.back();
	}
	
</script>
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
	<div id="pw_change">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">

		<h2>パスワード変更</h2>
		<form action="/G05/pw_change" method="post">
			<table style="margin-left: auto; margin-right: auto; margin-top: 50px">
				<tr>
					<td><label>ID</label></td>
					<td>:</td>
					<td>${Logininfo.id}</td>
				</tr>
				<tr>
					<td><label>既存パスワード</label></td>
					<td>:</td>
					<td><input type="password" name="pw" name="pw" placeholder="pw"></td>
				</tr>
				<tr>
					<td><label>変更するパスワード</label></td>
					<td>:</td>
					<td><input type="password" name="new_pw" name="new_pw" placeholder="new_pw"></td>
				</tr>
				<tr>
					<td><label>変更するパスワード確認</label></td>
					<td>:</td>
					<td><input type="password" name="re_new_pw" name="new_pw" placeholder="new_pw"></td>
				</tr>
			</table>
		
			<div id="btn">
				<input type="submit" value="変更完了" onclick="change_click()">
				<input type="button" value="キャンセル" onclick="back_click()">
			</div>
		
		</form>
				
			
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>