<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
<body>
   <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
   <div id="main">
      <div style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align: center; height: 100%">
      <div style="padding-top:70px;"><h4><a href="attendanceGET">勤怠情報入力</a></h4></div>
      <div><h4><a href="G06-2">勤怠情報照会</a></h4></div>
      <div style="padding-top:130px;"><h4><a href="G03">社員情報照会</a></h4></div>
      
      </div>
   </div>

   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>

</html>
