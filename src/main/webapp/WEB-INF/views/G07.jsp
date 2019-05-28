<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style type="text/css">

.calendar {
	border-collapse:collapse;
	margin: auto;
	padding: 0px;
}

.calendar th, .calendar td {
	border: 1px solid black;
}

.calendar input {
	font-size:30px;
	text-align: center;
	width: 130px;
	height: 40px;
}

.btnMonth {
	background: white;
	border: none;
	font-size: 25px;

	padding: 20px 50px;
	cursor: pointer;
	
	display: table;
	margin-left: auto;
	margin-right: auto;
}

.btnMonth:hover {
   background: #e6e6e6;
}

.btnMonth:focus{
	outline: none;
}

</style>
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<script type="text/javascript">

	//今年の年度をもらう
	$(document).ready(function() {
		
		var today = new Date();
		var year = today.getFullYear();
		
	    $('#txtYear').val(year);
	});
	
	//年度入力チェック
	function yearCheck() {
		var txtYear = document.month.txtYear;
		var btnMonth = document.month.btnMonth;
		
		if (txtYear.value.length <= 0) {
			alert("年度を入力してください。");
			document.month.txtYear.focus();
			return false;
		}
		
		// alert(document.month.txtYear+" "+document.month.btnMonth);
		
		/* $(opener.document).find("#txtYear").val(document.month.txtYear);
		$(opener.document).find("#btnMonth").val(document.month.btnMonth); */
		
		// window.opener.onPopupClose(myValue);//myValue is the value you want to return to main javascript
		window.close();
	}
</script>

	
	<form action="/G00-2/G10/G12" name="month" method="post">
	

		<!-- テーブル -->
		<table class="calendar">
		
			<!-- 年度入力 -->
			<tr>
			
				<td colspan="3" style="text-align:center; padding: 15px; margin: auto;">
					<input type="number" id="txtYear" name="年度" maxlength="4">
						<font size="6">年</font>
				</td>
			</tr>
	
			<!-- 月ボタン -->
			<c:forEach var="line" begin="1" end="4">
				<tr>
	
					<c:forEach var="row" begin="1" end="3">
						<td>
						
							<c:set var="month" value="${month+1}" />
							<button id="btnMonth" name="月" class="btnMonth"
								value="${month}" onclick="return yearCheck();" >${month }</button>
						
						</td>
					</c:forEach>
	
				</tr>
			</c:forEach>
		</table>

	</form>

</body>
</html>



