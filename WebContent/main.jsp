<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> main.jsp </title>
</head>
<body>

	<%
		response.sendRedirect(request.getContextPath() + "/index.do");
		//response.sendRedirect("/myspring_day04/index.do");//절대경로 필수. 여기서만 유일하게 절대경로 사용
	%>

</body>
</html>