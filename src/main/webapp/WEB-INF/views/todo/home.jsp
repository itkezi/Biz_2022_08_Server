<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
</head>
<body>
<h1>TODO LIST</h1>

<table>
	<tr>
		<th>SEQ</th>
		<th>입력일자</th>
		<th>입력시간</th>
		<th>TODO</th>
		<th>완료일자</th>
		<th>완료시간</th>
		<th>완료여부</th>
		<th></th>
	</tr>
<c:forEach items="${TODO}" var="td">
	<tr>
		<td>${td.seq}</td>
		<td>${td.s_date}</td>
		<td>${td.s_time}</td>
		<td> ${td} </td>
		<td>${td.e_date}</td>
		<td>${td.e_time}</td>
		<td><a>ㅁ</a></td>
		<td><a href="${rootPath}/update">수정하기</a></td>
	</tr>
</c:forEach>
</table>
<a href="${rootPath}/todo/insert">추가하기</a>
</body>
</html>