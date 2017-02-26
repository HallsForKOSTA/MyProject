<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!private String number = ""; //선언문
	private String number2 = "";
	private String operator = "";
	private String result = "";

	public String nvl(Object str) {
		if (str == null || ((String) str).trim().length() == 0) {
			return "";
		}

		return ((String) str).trim();
	}%>

<%
// 			number = nvl(request.getAttribute("num1"));
// 			number2 = nvl(request.getAttribute("num2"));
// 			operator = nvl(request.getAttribute("operator")); 

	number = nvl(request.getParameter("num1"));
	number2 = nvl(request.getParameter("num2"));
	operator = nvl(request.getParameter("operator"));
	result = nvl(request.getAttribute("result"));
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계산기</title>
</head>
<body>

	<form action="calcProcess.jsp">
		<input type="text" name="num1" value="<%=number%>"> <input
			type="text" name="operator" value="<%=operator%>"> <input
			type="text" name="num2" value="<%=number2%>"> <input
			type="submit" value="계산"> <input type="text" name="result"
			value="<%=result%>">
	</form>

</body>
</html>