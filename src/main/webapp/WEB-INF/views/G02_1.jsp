<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="dep_code" id="dep_code">
		<c:forEach items="${JoinGET}" var="JoinGET">
			<option value="${JoinGET.dep_code}">${JoinGET.dep_name}</option>
		</c:forEach>
</select>