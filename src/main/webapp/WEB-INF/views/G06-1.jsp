<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- 오늘 날짜와 이번 달의 최대날 측정 -->
<%
   Date now = new Date();
   int year = now.getYear() + 1900;//他の場所から呼んで使用
   int month = now.getMonth() +1;//他の場所から呼んで使用
   Calendar cal = new GregorianCalendar(year, month, 1);
   int data = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<!-- 테이블 부분 -->
#monthtable {
   border: 1px solid #999999;
   margin: 0 auto;
   text-align: center;
}
html, body {
   height: 90%;
}
<!-- 메인 div 부분 -->
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
   <!-- 화면에서 가동시간을 계산해서 동적으로 화면에 나타내기 위한 부분 -->
      var input = new Date();<!-- 출근시간 -->
      var output = new Date();<!-- 퇴근시간 -->
      var op_time = new Array();<!-- 가동시간 -->
      var target;<!-- 저장변수 -->
      var f_work = 0;<!-- 가동시간합 -->
      for( var num = 0; num < 31; num++){<!--초기값설정  -->
         op_time[num] = 0;
      }
      
      var name;
      function setinhour(name) {<!-- 출근시간 시각설정 -->
         target = document.getElementById("in_hour"+name);
         input.setHours(parseInt(target.options[target.selectedIndex].value));
      }
      function setinminute(name) {<!-- 출근시간 분설정 -->
         target = document.getElementById("in_minute"+name);
         input.setMinutes(parseInt(target.options[target.selectedIndex].value));
      }
      function setouthour(name) {<!-- 퇴근시간 시각설정 -->
         target = document.getElementById("out_hour"+name);
         output.setHours(parseInt(target.options[target.selectedIndex].value));
      }
      function setoutminute(name) {<!-- 퇴근시간 분설정 -->
         target = document.getElementById("out_minute"+name);
         output.setMinutes(parseInt(target.options[target.selectedIndex].value));
      }
      function setfreetime(name) {<!-- 가동시간 계산및 화면에 출력 -->
          target = document.getElementById("br_time"+name);
          op_time[name] = (output.getTime() - input.getTime()) / 3600000; <!-- 출근시간-퇴근시간/360000 으로 가동시간 계산 -->
          op_time[name] = op_time[name] - (parseInt(target.options[target.selectedIndex].value)/60);<!-- 가동시간에 휴식시간 제거 휴식시간은 분단위임으로 /60 -->
          f_work = 0;
          for(var num = 1; num<op_time.length; num++){
            f_work = f_work+parseFloat(op_time[num]);<!-- 모든 가동시간을 더해서 총 가동시간 계산 -->
          }
          document.getElementById("time"+name).innerHTML = op_time[name];<!-- time div에 가동시간 출력 -->
          document.getElementById("list").innerHTML = f_work;<!-- list div에 총 가동시간 출력 -->
      }      
      
      function btn_click(str){<!-- 엑셀출력버튼 -->
    	 	if(str=="saveWithExcel"){
    		  dbfrm.action="Excel" <!-- 엑셀출력 버튼눌렸을시 폰의 액션을 excel로 바꿈 -->
    	  } 
      }
   </script>
   <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>

   <center>
      <p style="display: inline; border: 1px solid #444444; margin-bottom: 5px;"><!-- 오늘의 년과 달 출력 -->
         &nbsp;<%=year%>年
         <%=month%>月&nbsp;
      </p>
   </center>
   <div id="monthmain">
      <form action="attendanceUpdate" id="dbfrm" method="post">
         <table id="monthtable" class="scrolltable">
            <tr><!-- 테이블 로우 설정및 출력 -->
               <td style="width: 5%; height: 25px; 0 auto;">日付</td>
               <td style="width: 10%;">開始時間</td>
               <td style="width: 10%;">終了時間</td>
               <td style="width: 5%;">稼働時間</td>
               <td style="width: 10%;">勤怠</td>
               <td style="width: 10%;">休憩時間</td>
               <td style="width: 25%;">作業内容</td>
               <td style="width: 25%;">備考</td>
            </tr>
            <c:set var="x" value="1" /><!-- 각 input값의 id 변경을 위한 값 -->
            <c:set var="f_time" value="0" /><!-- 총가동시간 일단 0 -->
            <c:set var="wco_name_list">勤怠,正常出勤,休憩,遲刻,早退,半休,欠勤</c:set><!-- wco_name 리스트 설정-->
            <c:forEach items="${attendanceList}" var="list"><!-- db에서 가져온 정보들로 가동시간와 총 가동시간을 계산해서 저장 -->
               <fmt:parseNumber value="${fn:substring(list.s_time,0,2) }"
                  type="number" var="s_hour" />
               <fmt:parseNumber value="${fn:substring(list.s_time,3,5) }"
                  type="number" var="s_minute" />
               <fmt:parseNumber value="${fn:substring(list.e_time,0,2) }"
                  type="number" var="e_hour" />
               <fmt:parseNumber value="${fn:substring(list.e_time,3,5) }"
                  type="number" var="e_minute" />
               <c:set var="w_time"
                  value="${((e_hour*60+e_minute) - (s_hour*60+s_minute)-list.br_time)/60}" />
               <script>
               op_time['<c:out  value="${x}"/>'] = '<c:out value="${w_time}"/>';<!-- 각 날짜별 가동시간 저장 -->
            </script>
               <c:set var="f_time" value="${w_time + f_time }" /><!--총 가동시간 저장 -->
               <tr>
                  <td><input  id = "day<c:out value="${x}" />"
                  name = "day"
                   type = "text"  style = "width : 30px; border: 0px; text-align : center"
                   value = "<c:out value="${x}" />" readOnly>
                   </td> <!-- 오늘날짜출력 -->
                  <td><select id="in_hour<c:out value = "${x}"/>"
                     name="in_hour"
                     onchange="setinhour(<c:out value = "${x}"/>)"><!-- 출근 시각 출력 -->
                        <c:forEach var="i" begin="0" end="23" step="1"><!-- 셀렉트박스 1~23시 -->
                           <c:choose>
                              <c:when test="${fn:substring(list.s_time,0,2) eq i }"><!-- db에 저장된값 과 일치하는 부분을 셀렉트 -->
                                 <option selected="selected"><c:out value="${i}" /></option>
                              </c:when>
                              <c:otherwise>
                                 <option><c:out value="${i}" /></option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                  </select> <select id="in_minute<c:out value = "${x}"/>"
                     name="in_minute"
                     onchange="setinminute(<c:out value = "${x}"/>)">
                        <c:forEach var="i" begin="0" end="59" step="15"><!-- 출근 분 출력 -->
                           <c:choose>
                              <c:when test="${fn:substring(list.s_time,3,5) eq i }"><!-- db에 저장된값 과 일치하는 부분을 셀렉트 -->
                                 <option selected="selected"><c:out value="${i}" /></option>
                              </c:when>
                              <c:otherwise>
                                 <option><c:out value="${i}" /></option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                  </select></td>
                  <td><select id="out_hour<c:out value = "${x}"/>"
                     name="out_hour"
                     onchange="setouthour(<c:out value = "${x}"/>)"><!-- 퇴근 시각 출력 -->
                        <c:forEach var="i" begin="0" end="23" step="1">
                           <c:choose>
                              <c:when test="${fn:substring(list.e_time,0,2) eq i }"><!-- db에 저장된값 과 일치하는 부분을 셀렉트 -->
                                 <option selected="selected"><c:out value="${i}" /></option>
                              </c:when>
                              <c:otherwise>
                                 <option><c:out value="${i}" /></option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                  </select> <select id="out_minute<c:out value = "${x}"/>"
                     name="out_minute"
                     onchange="setoutminute(<c:out value = "${x}"/>)"><!--퇴근 분 출력 -->
                        <c:forEach var="i" begin="0" end="59" step="15">
                           <c:choose>
                              <c:when test="${fn:substring(list.e_time,3,5) eq i }"><!-- db에 저장된값 과 일치하는 부분을 셀렉트 -->
                                 <option selected="selected"><c:out value="${i}" /></option>
                              </c:when>
                              <c:otherwise>
                                 <option><c:out value="${i}" /></option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                  </select></td>
                  <td>
                     <div id="time<c:out value = "${x}"/>"><!-- 가동시간 출력 -->
                        <input id = "op_time<c:out value = "${x}"/>" name = "op_time" type = "hidden" value = "${w_time }"/><!-- 동적으로 변한값  -->
                        <c:out value="${w_time}" /><!-- 기본 출력값  -->
                     </div>
                  </td>
                  <td><select id= "w_list<c:out value = "${x}"/>" name= "w_list" class="select font"><!-- wco_list 출력  -->
                        <option>=休憩=</option>
                        <c:forEach items="${wco_name_list}" var="w_list">
                           <c:choose>
                              <c:when test="${list.wco_name eq w_list }"><!-- db에 저장된값 과 일치하는 부분을 셀렉트 -->
                                 <option selected="selected"><c:out value="${w_list}" /></option>
                              </c:when>
                              <c:otherwise>
                                 <option><c:out value="${w_list}" /></option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                  </select></td>
                  <td><select id="br_time<c:out value = "${x}"/>"
                     name="br_time"
                     onchange="setfreetime(<c:out value = "${x}"/>)"><!-- 휴식시간 출력  -->
                        <c:forEach var="i" begin="0" end="60" step="15">
                           <c:choose>
                              <c:when test="${list.br_time eq i }"><!-- db에 저장된값 과 일치하는 부분을 셀렉트 -->
                                 <option selected="selected"><c:out value="${i}" /></option>
                              </c:when>
                              <c:otherwise>
                                 <option><c:out value="${i}" /></option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                  </select></td>
                  <td><input id="notice<c:out value = "${x}"/>"
                     name="notice" type="text" maxlength="200"
                     style="width: 300px;" value="${list.notice}" /></td><!-- 작업내역 출럭  -->
                  <td><input style="width: 400px;"
                     id="remark<c:out value = "${x}"/>"
                     name="remark" type="text" maxlength="200"
                     value="${list.remarks}" /></td><!-- 비고 출력  -->
               </tr>
               <c:set var="x" value="${x+1 }" />
            </c:forEach>
               <tr>
                  <td>
                        <input id = "op_time" name = "op_time" type = "hidden" value = "${w_time }"/> <!-- 가동시간의 히든값(버그대응용)  -->
                  </td>
               </tr>
         </table>
         <input type = "hidden" id = "month" name = "month" value = "<%=month%>"/> <!-- 다음페이지에 현제 달을 넘기기위한 히든값  -->
         <input type = "hidden" id = "year" name = "year" value = "<%=year %>"/><!-- 다음페이지에 현제 년을 넘기기위한 히든값  -->
         <input type = "submit" style="width: 70px; float: right" value = "保存"/><!-- 일반 보존버튼. attendanceUpdate로 넘어간다 -->
         <input type = "submit" style="width:150px; float: right" onclick="btn_click('saveWithExcel')" value="保存後EXCEL出力" ><!-- 보존 및 엑셀출력 버튼 엑셀쪽으로 넘어간다 -->

      </form>
   </div>
   <!-- 追加 -->
   <div>
      <p style="float: left;">
         <b>TOTAL</b> :&nbsp;
      <div id="list" style="font-size: 30px;">
         <c:out value="${f_time}" /><!-- 총가동시간 출력 -->
      </div>
      </p>
   </div>
   <button onclick="history.back();" style="width: 100px">キャンセル</button><!-- 전 페이지로 되돌아가기  -->
   <!-- 追加 -->


   <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>

</body>
</html>
