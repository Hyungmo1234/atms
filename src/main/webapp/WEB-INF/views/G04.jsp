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
<body>
   <br>
   <div
      style="font-family: verdana; padding: 5px; border: 1px solid red; font-size: 25px; text-align: left; height: 80%">
      <h1>社員情報修正画面</h1>
      <center>
      <form action="/modifyPost" method="post">
         <table>
            <tr>
               <th>ID</th>
             <td>: ${Logininfo.id}<input type="hidden" value="${Logininfo.id}" name="id"/></td>

            </tr>
            <tr>
               <th>既存パスワード</th>
               <td>: <input type="password" name= "password" value="${Logininfo.password}"></td>
            </tr>
            <tr>
               <th>名前</th>
               <td>: ${Logininfo.emp_name}</td>
            </tr>
            <tr>
               <th>会社</th>
               <td>: <select name=company>
                     <option value="${Logininfo.comName_ryak}">${Logininfo.comName_ryak}</option>
                     <option value="FOS">FOS</option>
                     <option value="PSS">PSS</option>
                     <option value="GCS">GCS</option>
                     <option value="CSS">CSS</option>
                     <option value="NCB">NCB</option>
                     <option value="ISS">ISS</option>
     
               </select></td>
            </tr>
            <tr>
               <th>部署</th>
               <td>: <select name=department>
                     <option value="">部署を選択してください。</option>
                     <option value="">戦略企画室</option>
                     <option value="">人事総括本部 対内人事部</option>
                     <option value="">人事総括本部 対外人事部</option>
                     <option value="">開発事業本部 開発1部</option>
                     <option value="">開発事業本部 開発2部</option>
                     <option value="">開発事業本部 開発3部</option>
                     <option value="">開発事業本部 開発4部</option>
                     <option value="">開発事業本部 開発5部</option>
                     <option value="">個人契約</option>
                     <option value="">営業部</option>
                     <option value="">管理部</option>
               </select></td>
            </tr>
            <tr>
               <th>職位</th>
               <td>: <select name=position>
                     <option value="">職位を選択してください。</option>
                     <option value="">会長</option>
                     <option value="">社長</option>
                     <option value="">室長</option>
                     <option value="">本部長</option>
                     <option value="">本部長代理</option>
                     <option value="">部長</option>
                     <option value="">部長代理</option>
                     <option value="">マネージャー</option>
                     <option value="">マネージャー代理</option>
                     <option value="">総括リーダ</option>
                     <option value="">リーダ</option>
                     <option value="">メンバー</option>
               </select></td>
            </tr>
         
            <tr>
               <th>性別</th>
               <td>: <c:if test="${Logininfo.gender eq 1}">
                     男性<input type="radio" name="gender" value="1" checked />
                        女性<input type="radio" name="gender" value="2" />
                  </c:if> <c:if test="${Logininfo.gender eq 2}">
                     男性<input type="radio" name="gender" value="1" /> 
                        女性<input type="radio" name="gender" value="2" checked />
                  </c:if>
               </td>
            </tr>
            
            <tr>
               <th>メール</th>
               <td>: <input type="text" name="mail" value="${Logininfo.mail}"></td>
            </tr>
            <tr>
               <th>電話番号</th>
               <td>: <input type="text" name="cellphone" value="${Logininfo.cellphone}"></td>
            </tr>
            <tr>
               <th>住所</th>
               <td>: <input type="text" name="address" value="${Logininfo.address}"></td>
            </tr>
            <tr>
               <th>入社日</th>
               <td>: <input type="number" id="userdate" name="entry_date"
                  value="${Logininfo.entry_date}"></td>
            </tr>
         </table>
      </center>
      
      <br> <input type="submit" id="modify" value="修正完了" /> 
      <input type="button" value="キャンセル" onclick="history.back();" />
      </form>
   </div>
</body>
<footer style="margin-top: 20px">
   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</footer>
</html>