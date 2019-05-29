<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<%
   Date now = new Date();
   int year = now.getYear() + 1900;//他の場所から呼んで使用
   int month = now.getMonth();//他の場所から呼んで使用
   Calendar cal = new GregorianCalendar(year, month, 1);
   int data = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
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
     var list = new Array();
      var test_text;
      var target;
      var f_work = 0;

      for( var num = 0; num < 31; num++){
         op_time[num] = 0;
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
      function insertlist(){
         for(var num = 0; num < <%=data%>; num ++){
             target = document.getElementById("inhour"+num);
            list[num] = parseInt(target.options[target.selectedIndex].value);
         }
        window.alert(list[0]);
      }
   </script>
   <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>

   <center>
      <!-- 前月と来月に月の変更 のメソッドを追加-->
      <p
         style="display: inline; border: 1px solid #444444; margin-bottom: 5px;">
         &nbsp;<%=year%>年
         <%=month + 1%>月&nbsp;
      </p>
   </center>
   <div id="monthmain">
      <form action="AttendanceGet" id="dbfrm" method="get">
         <table id="monthtable" class="scrolltable">
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
            <c:set var = "x" value = "1"/>
            <c:set var = "wco_name_list">勤怠,正常出勤,休憩,遲刻,早退,半休,欠勤</c:set>
         <c:forEach items="${attendanceList}" var="list">
            <tr>
               <td>
               <c:out value = "${x}"/>
               日</td>
               <td><select id="inhour<c:out value = "${x}"/>" name="inhour<c:out value = "${x}"/>"
                  onchange="setinhour(<c:out value = "${x}"/>)">
                     <c:forEach var="i" begin="0" end="23" step="1">
                        <c:choose>
                           <c:when test="${fn:substring(list.s_time,0,2) eq i }">
                              <option selected="selected"><c:out value="${i}" /></option>
                           </c:when>
                            <c:otherwise>
                              <option><c:out value="${i}" /></option>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
               </select> <select id="inminute<c:out value = "${x}"/>" name="inminute<c:out value = "${x}"/>"
                  onchange="setinminute(<c:out value = "${x}"/>)">
                     <c:forEach var="i" begin="0" end="59" step="15">
                        <c:choose>
                           <c:when test="${fn:substring(list.s_time,3,5) eq i }">
                              <option selected="selected"><c:out value="${i}" /></option>
                           </c:when>
                            <c:otherwise>
                              <option><c:out value="${i}" /></option>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
               </select></td>
               <td><select id="outhour<c:out value = "${x}"/>" name="outhour<c:out value = "${x}"/>"
                  onchange="setouthour(<c:out value = "${x}"/>)">
                     <c:forEach var="i" begin="0" end="23" step="1">
                        <c:choose>
                           <c:when test="${fn:substring(list.e_time,0,2) eq i }">
                              <option selected="selected"><c:out value="${i}" /></option>
                           </c:when>
                            <c:otherwise>
                              <option><c:out value="${i}" /></option>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
               </select> <select id="outminute<c:out value = "${x}"/>" name="outminute<c:out value = "${x}"/>"
                  onchange="setoutminute(<c:out value = "${x}"/>)">
                     <c:forEach var="i" begin="0" end="59" step="15">
                        <c:choose>
                           <c:when test="${fn:substring(list.e_time,3,5) eq i }">
                              <option selected="selected"><c:out value="${i}" /></option>
                           </c:when>
                            <c:otherwise>
                              <option><c:out value="${i}" /></option>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
               </select></td>
               <td>
                  <div id="time<c:out value = "${x}"/>"></div>
               </td>
               <td><select class="select font">
                     <option>=休憩=</option>
                     <c:forEach  items="${wco_name_list}" var="w_list">
                        <c:choose>
                           <c:when test="${list.wco_name eq w_list }">
                              <option selected="selected"><c:out value="${w_list}" /></option>
                           </c:when>
                            <c:otherwise>
                              <option><c:out value="${w_list}" /></option>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
               </select></td>
               <td><select id="freetime<c:out value = "${x}"/>" name="freetime<c:out value = "${x}"/>"
                  onchange="setfreetime(<c:out value = "${x}"/>)">
                     <c:forEach var="i" begin="0" end="59" step="15">
                        <c:choose>
                           <c:when test="${fn:substring(list.e_time,3,4) eq i }">
                              <option selected="selected"><c:out value="${i}" /></option>
                           </c:when>
                            <c:otherwise>
                              <option><c:out value="${i}" /></option>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
               </select></td>
               <td><input id="notice<c:out value = "${x}"/>" 
               name="notice<c:out value = "${x}"/>" 
               type="text"maxlength="200"  style="width: 300px;"
               value= "${list.notice}" /></td>
               <td><input  style="width: 400px;" id="remark<c:out value = "${x}"/>"
                name="remark<c:out value = "${x}"/>"
                type="text" maxlength="200" 
                value = "${list.remarks}"/></td>
            </tr>
               <c:set var = "x" value = "${x+1 }"/>
         </c:forEach>
         </table>
         <button style="width: 150px; float: right"
            onclick="location.href = '/Excel'">保存後EXCEL出力</button>
         <button style="float: right" onclick="insertlist()">保存</button>
      </form>
   </div>
   <!-- 追加 -->
   <div>
      <p style="folat: left;">
         <b>TOTAL</b> :&nbsp;
      <div id="list" style="font-size: 15px;"></div>
      </p>
   </div>
   <button onclick="history.back();" style="width: 100px">キャンセル</button>
   <!-- 追加 -->


   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>

</body>
</html>