<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		<input name="username" placeholder="USERNAME" />
		<input name="password" type="password" placeholder="PASSWORD"/>
		<input name="email" placeholder="E-MAIL"/>
		<input name="phone" placeholder="PHONE"/>
		<input name="address" placeholder="ADDRESS"/>
		<input name="realname" placeholder="REALNAME" />
		<input name="nickname" placeholder="NICKNAME"/>
		<button>회원가입</button>
	</form:form>

</body>
</html>