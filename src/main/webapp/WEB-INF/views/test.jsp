<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <c:forEach items="${attendanceList}" var="list">
   <table>
      <tr>
         <td>${list.id }</td>
         <td>${list.year_month }</td>
         <td>%{list.day}</td>
         <td>${list.s_time }</td>
         <td>${list.e_time }</td>
         <td>${list.br_time }</td>
         <td>${list.op_time }</td>
         <td>${list.notice }</td>
         <td>${list.wco_name }</td>
         <td>${list.remarks }</td>
         <td>${list.reg_id }</td>
         <td>${list.upd_id }</td>
         <td>${list.upd_date}</td>
         <td>${list.del_cd }</td>
      </tr>
     </table>
   </c:forEach>
         <div><a href="attendanceUpdate">update</a></div>
</body>


</html>