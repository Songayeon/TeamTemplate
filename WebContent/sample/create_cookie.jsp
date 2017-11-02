<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
//expireDate = new Date();  
//expireDate.setMonth(expireDate.getMonth()+6) ;

//document.cookie‎ = "cookieTwo=ccccc;expires=" + expireDate.toGMTString() ;

</script>
<%
	Cookie cookie = new Cookie("ulevel","5");
	cookie.setMaxAge(60*60); //60분동안 
	//cookie.setSecure(flag)
	
	//쿠키 만들경우 필수!!
	//서버페이지는  접근 가능 : 서버만 쿠키 정보를 알 수 있음. → 피싱이 되더라도, 쿠키를 볼 수 없음
	//브라우저는 접근 X : 브라우저에서 쿠키 정보를 알 수 없음. → 피싱이 되더라도, 쿠키를 볼 수 없음
	cookie.setHttpOnly(true);

	response.addCookie(cookie);
	out.print("쿠키 생성됨");
%>
<%
//pageContext.forward("boardViewCookie.jsp");
%>


</body>
</html>