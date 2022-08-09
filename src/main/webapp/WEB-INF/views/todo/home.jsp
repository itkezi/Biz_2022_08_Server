<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%> 
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
<style>
body {
text-align:center;
width: 100vw;
height:100vh;
}

table {
text-align: center;
width: 70%;
margin : 20px auto;
border: 1px solid black;
border-collapse: collapse;
}

table th, td {
border: 1px solid black;
padding : 10px;
}


</style>
</head>
<body>
<sec:authorize access="isAuthenticated()">
	<h1>
	<sec:authentication property="principal.username"/>
	(<sec:authentication property="principal.nickname"/>)
	 TODOLIST
	</h1>
	
</sec:authorize>

<table>
	<tr>
		<th>NO</th>
		<th>입력일자</th>
		<th>입력시간</th>
		<th>TODO</th>
		<th>완료일자</th>
		<th>완료시간</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
<c:forEach items="${TODO}" var="td" varStatus="INDEX">
	<tr>
		<td>${INDEX.count}</td>
		<td>${td.s_date}</td>
		<td>${td.s_time}</td>
		<td> ${td.content} </td>
		
		<c:choose>
		<c:when test="${td.comp}">
		<td>${td.e_date}</td>
		<td>${td.e_time}</td>
		<td>완료됨</td>
		</c:when>
		<c:otherwise>
		<td colspan="2"><a href="${rootPath}/todo/comp/${td.seq}">완료하기</a></td>
		<td><a href="${rootPath}/todo/update/${td.seq}">수정</a></td>
		</c:otherwise>
		</c:choose>
		<td><a href="${rootPath}/todo/delete/${td.seq}">삭제</a></td>

	</tr>
</c:forEach>
</table>
<a href="${rootPath}/todo/insert">추가하기</a>
<a href="${rootPath}/">메인화면으로</a>
</body>
</html>