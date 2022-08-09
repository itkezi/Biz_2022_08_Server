<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
</head>
<body>
		<form:form>
			<input name="username" readonly="readonly" value="${TODO.username}">
			<input name="s_date" value="${TODO.s_date}" readonly>
			<input name="s_time" value="${TODO.s_time}" readonly>
			<input name="content" placeholder="TODO" value="${TODO.content}">
			<button>저장</button>			
		</form:form>

</body>
</html>