<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#join {
	text-align: left;
	height: 70%;
}
#tab2 {
	margin-top:20%;
	margin-left:200%;
	width:100%;
}
#joinbtn1 {
}
#joinbtn2 {
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="join">
	<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
		<table id="tab1">
			<tr>
				<td><h1>社員登録画面</h1></td>
			</tr>
			<tr>
				<td>
					<table id="tab2">
						<tr>
							<td>ID</td>
							<td>: <input type="text"></td>
						</tr>
						<tr>
							<td>パスワード</td>
							<td>: <input type="password"></td>
						</tr>
						<tr>
							<td>パスワード確認</td>
							<td>: <input type="password"></td>
						</tr>
						<tr>
							<td>名前</td>
							<td>: <input type="text"></td>
						</tr>
						<tr>
							<td>会社</td>
							<td>: <select name=company>
									<option value="">会社を選択してください。</option>
									<option value="FOS">FOS</option>
									<option value="PSS">PSS</option>
									<option value="GCS">GCS</option>
									<option value="CSS">CSS</option>
									<option value="NCB">NCB</option>
									<option value="ISS">ISS</option>
							</select></td>
						</tr>
						<tr>
							<td>部署</td>
							<td>: <select name=department>
									<option value="">部署を選択してください。</option>
									<option value="">戦略企画室</option>
									<option value="">人事総括本部 対内人事部</option>
									<option value="">人事総括本部 対外人事部</option>
									<option value="">開発事業本部 開発1部</option>
									<option value="">開発事業本部 開発2部</option>
									<option value="">開発事業本部 開発3部</option>
									<option value="">開発事業本部 開発4部</option>
									<option value="">開発事業本部 開発5部</option>
									<option value="">個人契約</option>
									<option value="">営業部</option>
									<option value="">管理部</option>
							</select></td>
						</tr>
						<tr>
							<td>職位</td>
							<td>: <select name=position>
									<option value="">職位を選択してください。</option>
									<option value="">会長</option>
									<option value="">社長</option>
									<option value="">室長</option>
									<option value="">本部長</option>
									<option value="">本部長代理</option>
									<option value="">部長</option>
									<option value="">部長代理</option>
									<option value="">マネージャー</option>
									<option value="">マネージャー代理</option>
									<option value="">総括リーダ</option>
									<option value="">リーダ</option>
									<option value="">メンバー</option>
							</select></td>
						</tr>
						<tr>
							<td>メール</td>
							<td>: <input type="text"></td>
						</tr>
						<tr>
							<td>性別</td>
							<td>:  男性 <input type="radio" name="fruit" value="men" />
								  女性 <input type="radio" name="fruit" value="women" />
							</td>
						</tr>
						<tr>
							<td>入社日</td>
							<td>: <input type="date" id="userdate" name="userdate" value="2019-05-14">
							</td>
						</tr>
						<tr>
							<td>電話番号</td>
							<td>: <input type="text"></td>
						</tr>
						<tr>
							<td>住所</td>
							<td>: <input type="text"></td>
						</tr>
						<tr>
							<td rowspan="2">
								<input type="button" value="キャンセル" onclick="history.back();"/>
								<input type="button" value="登録完了" onclick=""/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
</html>