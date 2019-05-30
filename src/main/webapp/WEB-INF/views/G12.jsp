<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// 
	String URL_member_info = "/G00-2/G10/G12";
	String URL_MembersInfomation = "/G00-2/G10"; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>G12</title>
<style>
#main {
	width : 100%;
	height : 70%;
}

#table_area {
   border: 1px solid #999999;
   margin: 0 auto;
   text-align: center;
}

#table_div {
	height: 100%;
	margin: 0 auto;
	overflow-y: scroll;
}

#table_area tr:first-child{
	background-color : #1AAB8A;
}

#table_area tr:nth-child(2n){
	background-color : gray;
}

button {
   background: #1AAB8A;
   color: #fff;
   border: none;
   position: relative;
   height: 20px;
   width: 70px;
   cursor: pointer;
   transition: 800ms ease all;
   outline: none;
}
button:hover {
   background: #fff;
   color: #1AAB8A;
}
button:before, button:after {
   content: '';
   position: absolute;
   top: 0;
   right: 0;
   height: 2px;
   width: 0;
   background: #1AAB8A;
   transition: 400ms ease all;
}
button:after {
   right: inherit;
   top: inherit;
   left: 0;
   bottom: 0;
}
button:hover:before, button:hover:after {
   width: 100%;
   transition: 800ms ease all;
}
</style>
<!-- jQuery Load -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- js File Load -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/G12_javaScript.js?var=2"></script>

</head>
<body>

<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>

<div id="main">
	<!-- calendar Area -->
	<div id="monthmain">				
	   <center>
			<!-- 이벤트 분류 필요 -->
			<input id="month_before" style="display: inline;" type="button" value="前月">
				<p style="display: inline; border: 1px solid #444444;">
					<a id="calendar">
						<!-- 날짜 데이터 분류 필요 // 달력 모달 기능 추가 -->
						 ${year}年 ${month}月
					</a>
				</p>
			<input id="month_next" style="display: inline;" type="button" value="来月">
	   </center>
	</div>
	
	<!-- table Area -->
   <div id = "table_div">
      <table id = "table_area">
		<!-- table title Area -->
		<tr>
		     <td style="width: 5%; height: 25px; 0 auto;">日付</td>
			<td style="width: 10%;">開始時間</td>
			<td style="width: 10%;">終了時間</td>
			<td style="width: 5%;">稼働時間</td>
			<td style="width: 10%;">勤怠</td>
			<td style="width: 10%;">休憩時間</td>
			<td style="width: 25%;">作業内容</td>
			<td style="width: 25%;">備考</td>
		</tr>
		<!-- // table title Area -->
		<!-- table cotent Area -->
		<c:forEach items="${attendanceData}" var="attendanceData">
		<tr id = "month_Detail">
			<td><label id="day">${attendanceData.key_day}</label></td>
			<td><label id="start_Time">${attendanceData.s_time}</label></td>
			<td><label id="end_Time">${attendanceData.e_time}</label></td>
			<td><label id="op_time">${attendanceData.op_time}</label></td>
			<td><label id="wco_name">${attendanceData.wco_name}</label></td>
			<td><label id="br_time">${attendanceData.br_time}</label></td>
			<td><label id="notice">${attendanceData.notice}</label></td>
			<td><label id="remarks">${attendanceData.remarks}</label></td>
		</tr>
		</c:forEach>
		<!-- // table cotent Area -->
      </table>
   </div>
   
</div>
	
<!-- btn Area -->
<button onclick="location.href='<%= URL_MembersInfomation %>'" style="width: 100px">キャンセル</button>


<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
   
<!-- form test -->
<form id="formTest" action=<%= URL_member_info %> method="POST">
	<input id="id" type="hidden" name="id" value="${id}">
	<input id="year" type="hidden" name="year" value="${year}">
	<input id="month" type="hidden" name="month" value="${month}">
</form>

</body>
</html>