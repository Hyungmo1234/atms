<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body onload="list()">
	<br>
	<div
		style="font-family: verdana; padding: 5px; border: 1px solid red; font-size: 25px; text-align: left; height: 80%">
		<h1>社員情報修正画面</h1>
		<center>
			<form action="/modifyPost" method="post" id="modify">
				<table>
					<tr>
						<th>ID</th>
						<td>: ${emp.id}<input type="hidden" value="${emp.id}"
							name="id" /></td>

					</tr>
					<tr>
						<th>既存パスワード</th>
						<td>: <input type="password" id="password" name="password"
							value=""></td>
					</tr>
					<tr>
						<th>名前</th>
						<td>: ${emp.emp_name}</td>
					</tr>
					<tr>
						<td>会社</td>

						<td>: <select name="com_code" id="com_code">
								<c:set var="com_code" value="${emp.com_code}" />
								<option value="11"
									<c:if test="${com_code == '11'}">selected</c:if>>GCS</option>
								<option value="21"
									<c:if test="${com_code == '21'}">selected</c:if>>PSS</option>
								<option value="12"
									<c:if test="${com_code == '12'}">selected</c:if>>NCB</option>
								<option value="13"
									<c:if test="${com_code == '13'}">selected</c:if>>CSS</option>
								<option value="22"
									<c:if test="${com_code == '22'}">selected</c:if>>FOS</option>
								<option value="23"
									<c:if test="${com_code == '23'}">selected</c:if>>ISS</option>
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
								<option value="${emp.pos_code}">${emp.pos_name}</option>
								<option value="ONE"
									<c:if test="${emp.pos_code == 'ONE'}"> selected </c:if>>
									会長</option>
								<option value="PD"
									<c:if test="${emp.pos_code == 'PD'}"> selected </c:if>>社長</option>
								<option value="DIR"
									<c:if test="${emp.pos_code == 'DIR'}"> selected </c:if>>室長</option>
								<option value="EM"
									<c:if test="${emp.pos_code == 'EM'}"> selected </c:if>>本部長</option>
								<option value="AEM"
									<c:if test="${emp.pos_code == 'AEM'}"> selected </c:if>>本部長代理</option>
								<option value="GM"
									<c:if test="${emp.pos_code == 'GM'}"> selected </c:if>>部長</option>
								<option value="AGM"
									<c:if test="${emp.pos_code == 'AGM'}"> selected </c:if>>部長代理</option>
								<option value="MG"
									<c:if test="${emp.pos_code == 'MG'}"> selected </c:if>>マネージャー</option>
								<option value="AMG"
									<c:if test="${emp.pos_code == 'AMG'}"> selected </c:if>>マネージャー代理</option>
								<option value="SLD"
									<c:if test="${emp.pos_code == 'SLD'}"> selected </c:if>>総括リーダ</option>
								<option value="LD"
									<c:if test="${emp.pos_code == 'LD'}"> selected </c:if>>リーダ</option>
								<option value="MB"
									<c:if test="${emp.pos_code == 'MB'}"> selected </c:if>>メンバー</option>
						</select></td>
					</tr>

					<tr>
						<th>性別</th>
						<td>: <c:set var="gender" value="${emp.gender}" /> <c:choose>
								<c:when test="${gender == 1}">
               		 		男性<input type="radio" name="gender" value="1"
										checked />
                      	 	女性<input type="radio" name="gender" value="2" />
								</c:when>
								<c:otherwise>
               		 		  男性<input type="radio" name="gender" value="1" /> 
                     		  女性<input type="radio" name="gender" value="2"
										checked />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>
						<th>メール</th>
						<td>: <input type="text" name="mail" value="${emp.mail}"></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td>: <input type="text" name="cellphone"
							value="${emp.cellphone}"></td>
					</tr>
					<tr>
						<th>住所</th>
						<td>: <input type="text" name="address"
							value="${emp.address}"></td>
					</tr>
					<tr>
						<th>入社日</th>
						<td>: <input type="number" id="userdate" name="entry_date"
							value="${emp.entry_date}"></td>
					</tr>
				</table>
		</center>

		<br> <input type="button" id="modify" onclick="empsubmit();"
			value="修正完了" /> <input type="button" value="キャンセル"
			onclick="history.back();" />
		</form>
	</div>
</body>
<script type="text/javascript">
	function empsubmit() {
		var pw = document.getElementById("password").value;
		if (pw == "${Logininfo.password}") {
			alert("変更したした。");
			document.getElementById("modify").submit();
		} else {
			alert("password error");
		}
	}

	function list() {
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
</script>
<footer style="margin-top: 20px">
	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</footer>
</html>