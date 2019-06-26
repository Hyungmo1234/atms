<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
	background-color: #F6D8CE;
	border: 1px solid #444444;
}

.table_memberInfoList {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #444444;
	height: 200px;
}

.table_memberInfoList td {
	border: 1px solid #444444;
}

.table_EmpName, .table_WorkTime {
	font-weight: bold;
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
	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
	<div id="main">
		<div
			style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: left; height: 100%">
			<div style="float: right; margin: 50px;">
		
	<form id="test"
		action="/test" method="POST">
		<table>
			<tr>
				<td>
					<p>会社: </p>
				</td>
			<td>
			   <select name="com_code1" id="com_code1">
					<option value="">全体</option>
					<option value="11">GCS</option>
					<option value="12">NCB</option>
					<option value="13">CSS</option>
					<option value="21">PSS</option>
					<option value="22">FOS</option>
					<option value="23">ISS</option>
				</select>
				
				 <td>部署</td>
                  <td id="dep_area1">: <select name="dep_code1" id="dep_code1">
                        <c:forEach items="${JoinGET2}" var="JoinGET2">
                           <option value="${JoinGET2.dep_code}">${JoinGET2.dep_name}</option>
                        </c:forEach>
                  </select>
                  </td>
                  
             
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
                  
				<td>
				 <input type=text name="search" value='' placeholder="名前を入力してください">
				<button type='submit'>검색</button>
				</td>
			
                 
               </tr>
			</table>
	</form>
		<%-- <table>
			<tr>
				<td>
					<p>会社: </p>
				</td>
			<td>
			   <select name="com_code1" id="com_code1">
					<option value="">全体</option>
					<option value="11">GCS</option>
					<option value="12">NCB</option>
					<option value="13">CSS</option>
					<option value="21">PSS</option>
					<option value="22">FOS</option>
					<option value="23">ISS</option>
				</select>
				
				 <td>部署</td>
                  <td id="dep_area1">: <select name="dep_code1" id="dep_code1">
                        <c:forEach items="${JoinGET2}" var="JoinGET2">
                           <option value="${JoinGET2.dep_code}">${JoinGET2.dep_name}</option>
                        </c:forEach>
                  </select>
                  </td>
                  
             
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
                  
				<td>
				 <input type=text name="" value='' placeholder="이름을 입력해주세요">
				<button type='submit'>검색</button>
				</td>
			
                 
               </tr>
			</table> --%>
			</div>
			
			
			<table class="table_memberInfoList"
				style="width: 95%; margin: 0 auto; margin-top: 0px;">
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
							${membersData.full_op_time}</td>
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

<script type="text/javascript">
$('#com_code1').change(function() {
    $("#dep_code1").remove();
    var select = $("#com_code1 option:selected").val();
    $.ajax({
       url : 'G10_1',
       type : 'POST',
       data : {
          "com_code1" : select
       },
       success : function(data) {
          $("#dep_area1").append(data);
       },
       error : function(request,status,error){
    	   alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
       }
    })
 })
</script>

</html>