<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		var contextPath = "${contextPath}";
		$.get(contextPath + "/api/members", function(json) {
			var dataLength = json.length;
			if (dataLength >= 1) {
				var sCont = "";
				for (i = 0; i < dataLength; i++) {
					sCont += "<tr>";
					sCont += "<td>" + json[i].id + "</td>";
					sCont += "<td><a href='read?id=" + json[i].id + "'>"
							+ json[i].name + "</a></td>";
					sCont += "<td>" + json[i].email + "</td>";
					sCont += "<td>" + json[i].registerDateTime + "</td>";
					sCont += "</tr>";
				}
				$("#load:last-child").append(sCont);
			}
		});
	});
</script>
</head>
<body>
	<div>
		<button id="new">추가</button>
	</div>
	<table border="1">
		<thead>
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>가입일</th>
		</thead>
		<tbody id="load">
		</tbody>
	</table>
</body>
</html>