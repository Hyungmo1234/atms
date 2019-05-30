<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//
	String URL_member_info = "/G00-2/G10/G12";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#main {
	text-align: left;
	height: 70%;
}

#body {
	font-family: verdana; 
	border: 1px solid red; 
	font-size: 25px; 
	text-align: left; 
	height: 100%
}

#monthTable{
	border: 1px solid #999999;
	margin: 0 auto;
	text-align: center;
}

#monthTable td {
	width : 10%;
}

#monthTable td:last-child {
	min-width : 20%;
}

#monthMain {
	height: 80%;
	margin: 0 auto;
	overflow: scroll;
}

#month_Title {
	font-size: 20px; 
	text-align:center;
	font-weight : bold;
	padding : 0px 10px 20px 10px;
}

#month_Detail {
	font-size: 14px; 
	text-align:center;
}

</style>
</head>
<body>
<!-- jQuery Load -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<!-- js File Load -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/G12_javaScript.js"></script>


<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>

<div id="main">
	<div id="body">
				
	   <center>
	   
			<!-- 이벤트 분류 필요 -->
			<input id="month_mae" style="display: inline;" type="button" value="前月">
				<p style="display: inline; border: 1px solid #444444;">
					<!-- Link to open the modal -->
<!-- 					<a href="#ex1" rel="modal:open"> -->
					<a onclick="test()">
						<!-- 날짜 데이터 분류 필요 // 달력 모달 기능 추가 -->
						 ${year}年 ${month}月
					</a>
				</p>
			<input style="display: inline;" type="button" value="来月" onClick="window.location.reload()">
	      
	   </center>
	
	   <div id = "monthMain">
	      <table id = "monthTable">
	         <tr id = "month_Title">
	            <td>日付</td>
	            <td>開始時間</td>
	            <td>終了時間</td>
	            <td>稼働時間</td>
	            <td>勤怠</td>
	            <td>休憩時間</td>
	            <td>作業内容</td>
	            <td>備考</td>
	         </tr>
	         <!-- c:for문 처리 필요 -->
	         <c:forEach items="${attendanceData}" var="attendanceData">
				 <tr id = "month_Detail">
				 	<td><label id="day">${attendanceData.day}</label></td>
				 	<td><label id="start_Time">${attendanceData.s_time}</label></td>
				 	<td><label id="end_Time">${attendanceData.e_time}</label></td>
				 	<td><label id="op_time">${attendanceData.op_time}</label></td>
				 	<td><label id="wco_name">${attendanceData.wco_name}</label></td>
				 	<td><label id="br_time">${attendanceData.br_time}</label></td>
				 	<td><label id="remarks">${attendanceData.remarks}</label></td>
			 </tr>
			 </c:forEach>
			 <!-- c:if문 처리 필요 // -->
	      </table>
	   </div>
	</div>
</div>

   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
   <%-- 
<!-- Modal -->
<div id="ex1" class="modal">
	<jsp:include page="/WEB-INF/views/G07.jsp">
		<jsp:param name="id" value="aaa" />
	</jsp:include>
</div>
 --%>
<!-- form test -->
<form id="formTest" action=<%= URL_member_info %> method="POST">
	<input id="id" type="hidden" name="id" value="${id}">
	<input id="year" type="hidden" name="year" value="${year}">
	<input id="month" type="hidden" name="month" value="${month}">
</form>

</body>
</html>