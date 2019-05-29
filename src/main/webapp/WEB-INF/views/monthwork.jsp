<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
   border: 1px solid #999999;
   margin: 0 auto;
   text-align: center;
}

html, body {
   height: 90%;
}

div {
   height: 80%;
   margin: 0 auto;
   overflow: scroll;
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

   <%
      int total_time = 0;
      int year = 2019;//他の場所から呼んで使用
      int month = 5;//他の場所から呼んで使用
      int month_date;
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
         month_date = 31;
      } else if (month == 2) {
         month_date = 28;
      } else {
         month_date = 30;
      }
   %>
   <center>
      <!-- 前月と来月に月の変更 のメソッドを追加-->
      <input style="display: inline;" type="button" value="前月"
         onClick="window.location.reload()">
      <p style="display: inline; border: 1px solid #444444;">
         &nbsp;<%=year%>年
         <%=month%>月&nbsp;
      </p>
      <input style="display: inline;" type="button" value="カレンダー"
         onClick="window.location.reload()"> <input
         style="display: inline;" type="button" value="来月"
         onClick="window.location.reload()">
   </center>

   <div>
      <table class="scrolltable">
         <tr>
            <td style="width: 5%; height: 25px; 0 auto;">日付</td>
            <td style="width: 10%;">開始時間</td>
            <td style="width: 10%;">終了時間</td>
            <td style="width: 5%;">稼働時間</td>
            <td style="width: 10%;">勤怠</td>
            <td style="width: 8%;">休憩時間</td>
            <td style="width: 20%;">作業内容</td>
            <td style="width: 5%;">備考</td>
            <td style="width: 5%;">入力・修正</td>
         </tr>

         <%
            for (int k = 0; k <= month_date; k++) {
         %>
         <tr>
            <td><%=k%>日</td>
            <td><select>
                  <%
                     for (int i = 0; i < 24; i++) {
                  %>
                  <option><%=i + 1%></option>
                  <%
                     }
                  %>
            </select> <select>
                  <%
                     for (int i = 0; i <= 60; i = i + 15) {
                  %>
                  <option><%=i%></option>
                  <%
                     }
                  %>
            </select></td>
            <td><select>
                  <%
                     for (int i = 0; i < 24; i++) {
                  %>
                  <option><%=i + 1%></option>
                  <%
                     }
                  %>
            </select> <select>
                  <%
                     for (int i = 0; i <= 60; i = i + 15) {
                  %>
                  <option><%=i%></option>
                  <%
                     }
                  %>
            </select></td>
            <td><p></p></td>
            <td><select class="select font">
                  <option>勤怠</option>
                  <option>正常出勤</option>
                  <option>休憩</option>
                  <option>遅刻</option>
                  <option>早退</option>
                  <option>半休</option>
                  <option>欠勤</option>
            </select></td>
            <td><select class="select font">
                  <option>=休憩=</option>
                  <%
                     for (int i = 0; i < 24; i++) {
                  %>
                  <option><%=i + 1%></option>
                  <%
                     }
                  %>
            </select></td>
            <td><input type="text" value="作業内容を入力要望" style="width: 300px;" /></td>
            <td><input type="text" style="width: 30px;" /></td>
            <td><button>入力</button></td>
         </tr>
         <%
            }
         %>
      </table>
      <!-- 追加 -->
      <div id="list">
         <p style="folat: left;">
            TOTAL :&nbsp;<%=total_time%></p>
         <button style="float: right;">EXCEL</button>
         <button style="float: right;">登録</button>
      </div>
      <!-- 追加 -->
   </div>


   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>

</body>
</html>