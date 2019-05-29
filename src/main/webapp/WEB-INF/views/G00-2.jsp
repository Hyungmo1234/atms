<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%
	// URL 管理社員情報照会
	// FULL URL /G00-2/G10
	String URL_MembersInfomation = "/G00-2/G10"; 
%>
   <!-- 
  	作成者：朴勇賢
   
    -->
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#main {
   text-align: left;
   height: 70%;
}

#admin_membersView {
   margin : 100px 0px 0px 0px;
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
         style="font-family: verdana; border: 1px solid red; font-size: 25px; text-align:center; height: 100%">
         
         <div id="admin_membersView">
            <a href=<%= URL_MembersInfomation %>>管理社員情報照会</a>
         </div>
      
      </div>
   </div>

   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</body>
</html>