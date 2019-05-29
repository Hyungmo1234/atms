<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// URL設定
	// FULL URL : /G00-2/G10/G11
	String URL_personal_information = "/G00-2/G10/G11";
	String URL_attendance_information = "/G00-2/G10/G12";
%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#main {
	text-align: left;
	height: 70%;
}

.table_CountArea {
	
	background-color :#F6D8CE;
	border : 1px solid #444444;
}

.table_memberInfoList{
	width : 100%;
	border-collapse: collapse;
	border : 1px solid #444444;
	height: 200px;
}

.table_memberInfoList td {
	border : 1px solid #444444;
	
}
.table_EmpName,.table_WorkTime{
	font-weight: bold;
}

</style>

</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="main">
	<div
         style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
         <table class="table_memberInfoList"
            style="width: 95%; margin: 0 auto; margin-top:150px;">
            <tr>
               <td class="table_CountArea">番号</td>
               <td>会社</td>
               <td>職位</td>
               <td>名前</td>
               <td>部署</td>
               <td>性別</td>
               <td>メール</td>
               <td>稼働時間</td>
            </tr>

            <c:forEach items="${membersData}" var="membersData"
               varStatus="status">
               <tr>
                  <td class="table_CountArea">${status.count }</td>
                  <td>${membersData.comName_ryak}</td>
                  <td>${membersData.pos_name}</td>
                  <td class="table_EmpName"
                     onClick="document.getElementById('get_memeberInfoForm_${membersData.emp_name}').submit()">
                     ${membersData.emp_name}</td>
                  <td>${membersData.dep_name}</td>
                  <td><c:set var="gender" value="${membersData.gender}" /> <c:choose>
                        <c:when test="${gender eq 1 }">
                           	男性	
                        </c:when>
                        <c:otherwise>
                           	女性
                        </c:otherwise>
                     </c:choose></td>
                  <td>${membersData.mail}</td>
                  <td class="table_WorkTime"
                     onClick="document.getElementById('get_memeberAttdanceForm_${membersData.emp_name}').submit()">
               	      稼働時間</td>
               </tr>
               <!-- 社員情報アクセス -->
               <form id="get_memeberInfoForm_${membersData.emp_name}"
                  action=<%= URL_personal_information %> method="POST">
                  <input type="hidden" name="name" value=${membersData.emp_name}>
               </form>
					<!-- 勤怠情報アクセス -->
					<form id="get_memeberAttdanceForm_${membersData.emp_name}"
						action=<%= URL_attendance_information %> method="POST">
						<input type="hidden" name="id" value=${membersData.id}>
					</form>

				</c:forEach>
			</table>
		</div>
	</div>

	<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>