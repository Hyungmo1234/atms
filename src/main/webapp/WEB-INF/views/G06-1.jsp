<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%
	Date now = new Date();
   int year = now.getYear()+1900;//他の場所から呼んで使用
   int month = now.getMonth();//他の場所から呼んで使用
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#monthtable {
   border: 1px solid #999999;
   margin: 0 auto;
   text-align: center;
}

html, body {
   height: 90%;
}

#monthmain {
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
<body>

	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script language='javascript'>
      var input = new Date();
      var output = new Date();
      var op_time = new Array();
      var test_text;
      var target;
      var f_work = 0;

      for( var num = 0; num < 31; num++){
    	  work[num] = 0;
      }
      
      var name;

      function setinhour(name) {
         target = document.getElementById("inhour"+name);
         input.setHours(parseInt(target.options[target.selectedIndex].value));
      }
      function setinminute(name) {
         target = document.getElementById("inminute"+name);
         input.setMinutes(parseInt(target.options[target.selectedIndex].value));
      }
      function setouthour(name) {
         target = document.getElementById("outhour"+name);
         output.setHours(parseInt(target.options[target.selectedIndex].value));
      }
      function setoutminute(name) {
         target = document.getElementById("outminute"+name);
         output.setMinutes(parseInt(target.options[target.selectedIndex].value));
      }
      function setfreetime(name) {
          target = document.getElementById("freetime"+name);
          op_time[name] = (output.getTime() - input.getTime()) / 3600000;
          op_time[name] = op_time[name] - (parseInt(target.options[target.selectedIndex].value)/60);
          f_work = 0;
          for(var num = 0; num<op_time.length; num++){
         	f_work = f_work+op_time[num];
          }
          document.getElementById("time"+name).innerHTML = op_time[name];
          document.getElementById("list").innerHTML = f_work;
      }      
   </script>
   <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>

   <%
      Calendar cal = new GregorianCalendar(year, month, 1);
      int data = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
      ArrayList<String> inhour=new ArrayList<String>();
      ArrayList<String> inminute=new ArrayList<String>();
      ArrayList<String> outhour=new ArrayList<String>();
      ArrayList<String> outminute=new ArrayList<String>();
      for(int y = 1; y <data; y++){
    	  inhour.add("inhour"+y);
      }
      for(int y = 1; y <data; y++){
    	  inminute.add("inminute"+y);
      }
      for(int y = 1; y <data; y++){
    	  outhour.add("outhour"+y);
      }
      for(int y = 1; y <data; y++){
    	  outminute.add("outminute"+y);
      }
   %>

   <center>
      <!-- 前月と来月に月の変更 のメソッドを追加-->
      <p style="display: inline; border: 1px solid #444444; margin-bottom : 5px;">
         &nbsp;<%=year%>年
         <%=month+1%>月&nbsp;
      </p>
   </center>
   <div id = "monthmain">
   <form action = "G06-1" id = "dbfrm" method = "post">
      <table  id = "monthtable"  class="scrolltable">
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
         <%
            for (int k = 0; k < data; k++) {
            	System.out.println(cal);
         %>
         <tr>
               <td><%=k+1 %>日</td>
               <td><select id="inhour<%=k %>" name = "inhour<%=k %>" onchange="setinhour(<%=k %>)">
                     <c:forEach var="i" begin="0" end="23" step="1">
                           <option><c:out value="${i}" /></option>
                     </c:forEach>
               </select> <select id="inminute<%=k %>" name ="inminute<%=k %>" onchange="setinminute(<%=k %>)">
                     <c:forEach var="i" begin="0" end="59" step="15">
                              <option><c:out value="${i}" /></option>
                     </c:forEach>
               </select></td>
               <td><select id="outhour<%=k %>" name = "outhour<%=k %>" onchange="setouthour(<%=k %>)">
                     <c:forEach var="i" begin="0" end="23" step="1">
                              <option><c:out value="${i}" /></option>
                     </c:forEach>
               </select> <select id="outminute<%=k %>" name = "outminute<%=k %>" onchange="setoutminute(<%=k %>)">
                     <c:forEach var="i" begin="0" end="59" step="15">
                              <option><c:out value="${i}" /></option>
                     </c:forEach>
               </select></td>
         <td>
         <div id ="time<%=k%>">
         </div>
         </td>
         <td>
         <select class="select font">
                  <option>勤怠</option>
                  <option>正常出勤</option>
                  <option>休憩</option>
                  <option>遅刻</option>
                  <option>早退</option>
                  <option>半休</option>
                  <option>欠勤</option>
         </select>
         </td>
         <td>
         <select id="freetime<%=k %>" name = "freetime<%=k %>" onchange="setfreetime(<%=k %>)">
               <option>=休憩=</option>
               <c:forEach var="i" begin="0" end="60" step="15">
                        <option><c:out value="${i}" /></option>
               </c:forEach>
         </select>
         </td>
         <td>
                  <input id = "notice" name = "notice" type="text" maxlength="200" value="作業内容を入力要望" style="width: 300px;"/>
         </td>
         <td>
                  <input id = "remark" name = "remark" type="text" style="width: 400px;" maxlength="200" />
         </td>
         
         <%
            }
         %>
      </table>
      <button style="float:right">保存後EXCEL出力</button>
      <button style="float:right">保存</button>
      </form>
   </div>
   <!-- 追加 -->
   <div>
      <p style="folat: left;">
         <b>TOTAL</b> :&nbsp; <div id="list" style = "font-size : 15px;"></div>
      </p>
   </div>
   <button onclick="history.back();" style = "width : 100px"> キャンセル</button>
   <!-- 追加 -->


   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>

</body>
</html>
