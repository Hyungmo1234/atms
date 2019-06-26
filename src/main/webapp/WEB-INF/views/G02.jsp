﻿<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#join {
	text-align: center;
	height: 70%;
	margin: 0 auto;
}

#tab2 {
	
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
			<h1>社員登録画面</h1>
			<form action="/JoinPOST" id="JoinPOST" name="JoinPOST" method="post"
				style="margin-left: 40%;">
				<table id="tab1">
					<tr>
						<td style="width: 158px;">ID</td>
						<td>: <input type="text" id="id" name="id"
							placeholder="半角英数字、8~12字"></td>
					</tr>
				</table>

				<table id="tab3">
					<tr id="p1">
						<td id="pw1" style="width: 158px;">パスワード</td>
						<td id="password1" style="width: 158px;">: <input
							type="password" id="password" name="password"
							placeholder="半角英数字、8～16字入力" /></td>
					</tr>
					<tr id="p2">
						<td id="pw2">パスワード確認</td>
						<td id="password2">: <input type="password"
							id="passwordCheck" name="passwordCheck"
							placeholder="もう一度入力してください" />
						</td>
					</tr>
				</table>

				<table>
					<tr>
						<td>名前</td>
						<td>: <input type="text" id="emp_name" name="emp_name"></td>
					</tr>
					<tr>
						<td>会社</td>
						<td>: <select name="com_code" id="com_code">
								<option value="">会社を選択してください。</option>
								<option value="21">PSS</option>
								<option value="11">GCS</option>
								<option value="12">NCB</option>
								<option value="13">CSS</option>
								<option value="22">FOS</option>
								<option value="23">ISS</option>
						</select>

						</td>

					</tr>

					<tr>
						<td>部署</td>
						<td id="dep_area">: <select name="dep_code" id="dep_code">
								<c:forEach items="${JoinGET}" var="JoinGET">
									<option value="${JoinGET.dep_code}">${JoinGET.dep_name}</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td>職位</td>
						<td>: <select name="pos_code" id="pos_code">
								<option value="">職位を選択してください。</option>
								<option value="ONE">会長</option>
								<option value="PD">社長</option>
								<option value="DIR">室長</option>
								<option value="EM">本部長</option>
								<option value="AEM">本部長代理</option>
								<option value="GM">部長</option>
								<option value="AGM">部長代理</option>
								<option value="MG">マネージャー</option>
								<option value="AMG">マネージャー代理</option>
								<option value="SLD">総括リーダ</option>
								<option value="LD">リーダ</option>
								<option value="MB">メンバー</option>
						</select></td>
					</tr>
					<tr>
						<td>メール</td>
						<td>: <input type="text" id="mail" name="mail"></td>
					</tr>
					<tr>
						<td>性別</td>
						<td>: 男性 <input type="radio" id="gender" name="gender"
							value="1" /> 女性 <input type="radio" id="gender" name="gender"
							value="2" />
						</td>
					</tr>
					<tr>
						<td>入社日</font>
						</td>
						<td>: <input type="number" name="entry_date" id="datepicker"
							placeholder="ex)20190528">
						</td>
					</tr>
					<tr>
						<td>住所</td>
						<td>: <input type="text" name="address" id="address"></td>
					</tr>
					<tr>
						<td rowspan="2">
							<button type="button" onclick="check()">キャンセル</button>
							<button type="submit" id="join" name="join"
								onclick="return finish()">登録完了</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">
	function check() {
		if (confirm("本当にキャンセルしますか。") == true) {
			//document.form.submit();
			location.href = "G01";
		} else { //취소
			return;
		}
	}

	function finish() {

		if (document.JoinPOST.id.value == "") {
			alert("IDを入力してください。")
			JoinPOST.id.focus()
			return false;
		}

		if (document.JoinPOST.id.value.indexOf(" ") >= 0) {
			alert("IDに空白は使用できません。")
			document.JoinPOST.id.focus()
			document.JoinPOST.id.select()
			return false;
		}

		if (document.JoinPOST.id.value.length < 8) {
			alert("IDの形式が正しくありません。")
			document.JoinPOST.id.value = ""
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.value = ""
			document.JoinPOST.id.focus()
			return false;
		} else if (document.JoinPOST.id.value.length > 12) {
			alert("IDの形式が正しくありません。")
			document.JoinPOST.id.value = ""
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.value = ""
			document.JoinPOST.id.focus()
			return false;
		}

		if (!document.JoinPOST.id.value.match(/^[a-zA-Z0-9]*$/)) {
			alert("IDの形式が正しくありません。");
			document.JoinPOST.id.value = ""
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.value = ""
			document.JoinPOST.id.focus()
			return false;
		}

		if (document.JoinPOST.password.value == "") {
			alert("パスワードを入力してください。")
			document.JoinPOST.password.focus()
			return false;
		}

		if (document.JoinPOST.password.value.length < 8) {
			alert("パスワードの形式が正しくありません。")
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.value = ""
			document.JoinPOST.password.focus()
			return false;
		} else if (document.JoinPOST.password.value.length > 16) {
			alert("パスワードの形式が正しくありません。")
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.value = ""
			document.JoinPOST.password.focus()
			return false;
		}
		if (!document.JoinPOST.password.value
				.match(/^[a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-]|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])$/)) {
			alert("パスワードの形式が正しくありません。");
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.value = ""
			document.JoinPOST.password.focus()
			return false;
		}

		if (document.JoinPOST.password.value != document.JoinPOST.passwordCheck.value) {
			alert("パスワードが一致しません。")
			document.JoinPOST.password.value = ""
			document.JoinPOST.passwordCheck.focus()
			return false;
		}

		if (document.JoinPOST.mail.value == "") {
			alert("メールを入力してください。")
			document.JoinPOST.mail.focus()
			return false;
		}
		
		if (!document.JoinPOST.mail.value.match(/^[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\.[a-zA-Z\.]{2,6}$/)) {
			alert("メールの形式が正しくありません。")
			document.JoinPOST.mail.value = ""
			document.JoinPOST.mail.focus()
			return false;
		}

		if (document.JoinPOST.emp_name.value == "") {
			alert("名前を入力してください。")
			document.JoinPOST.emp_name.focus()
			return false;
		}

		if (document.JoinPOST.entry_date.value == "") {
			alert("入社日を入力してください。")
			document.JoinPOST.entry_date.focus()
			return false;
		}

		if (document.JoinPOST.address.value == "") {
			alert("住所を入力してください。")
			document.JoinPOST.address.focus()
			return false;
		}

		if (document.JoinPOST.com_code.value == "") {
			alert("会社を選択してください。")
			document.JoinPOST.com_code.focus()
			return false;
		}

		if (document.JoinPOST.dep_code.value == "") {
			alert("部署を選択してください。")
			document.JoinPOST.dep_code.focus()
			return false;
		}

		if (document.JoinPOST.pos_code.value == "") {
			alert("職位を選択してください。")
			document.JoinPOST.pos_code.focus()
			return false;
		}
		if (document.JoinPOST.gender.value == "") {
			alert("性別を選択してください。")
			document.JoinPOST.gender.focus()
			return false;
		}

		if (confirm("登録が完了しました。") == true) {
			document.form.submit();
		} else {
			return;
		}
	}

	$('#com_code').change(function() {
		$("#dep_code").remove();
		var select = $("#com_code option:selected").val();
		$.ajax({
			url : 'G02_1',
			type : 'POST',
			data : {
				"com_code" : select
			},
			success : function(data) {
				$("#dep_area").append(data);
			}
		})
	})

	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dayNamesMin : [ '日', '月', '火', '水', '木', '金', '土' ],
			dateFormat : "yymmdd",
			showOn : "button"
		});
	});

	$('#id').change(function() {
		/*  $("#id").remove();*/

		$("#p1").remove();
		$("#p2").remove();
		$("#pw1").remove();
		$("#pw2").remove();
		$("#password1").remove();
		$("#password2").remove();

		var id = $("#id").val();
		$.ajax({
			url : 'G02_2',
			type : 'POST',
			data : {
				"id" : id
			},
			success : function(data) {
				$("#tab3").append(data);

			}
		})
	})
</script>