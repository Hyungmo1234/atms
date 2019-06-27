<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
  <%
  	String URL_user_info = "G06-2";
  
  %>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#main {
   height: 70%;
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
      <div style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: center; height: 100%">
      <div style="padding-top:70px;"><h4><a href="attendanceGET">勤怠情報入力</a></h4></div>
      <div><h4><a href="#" onClick="document.getElementById('getForm').submit()">勤怠情報照会</a></h4></div>
      <div style="padding-top:130px;"><h4><a href="G03">社員情報照会</a></h4></div>
      
      </div>
   </div>

   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
<!--  -->
<form id="getForm" action=<%= URL_user_info %> method="POST"></form>

</form>
</html>
