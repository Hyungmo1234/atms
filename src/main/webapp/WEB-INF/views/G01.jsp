<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title></title>
<style type="text/css">
#login {
	text-align: left;
	height: 70%;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="login">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
			<h1>ログイン</h1>

			<form action="G00-1" method="post">
				<table style="margin-left: auto; margin-right: auto;">
					<tr>
						<td><label>ID</label>
						<td><input type="text" id="id" name="id" placeholder="ID"></td>

					</tr>
					<tr>
						<td><label>パスワード</label>
						<td><input type="password" id="password" name="password"
							placeholder="パスワード"></td>
					</tr>
					<tr>
						<td style="margin-left: auto; margin-right: auto;"></td>
						<td><input type="submit" id="login" name="login" value="ログイン" />
							<button id="new_co">新規登録</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
</html>