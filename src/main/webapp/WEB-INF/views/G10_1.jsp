<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="dep_code1" id="dep_code1">
		<c:forEach items="${JoinGET2}" var="JoinGET2">
			<option value="${JoinGET2.dep_code}">${JoinGET2.dep_name}</option>
		</c:forEach>
</select>