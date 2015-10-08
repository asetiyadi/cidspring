<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>

</head>
<body onload='document.f.j_username.focus();'>
	<div id="springimg"><img alt="Spring" src="<c:url value='/static/images/spring.jpg'/>"></div>

	<h3>Enter Username and Password</h3>
	
	<c:if test="${param.error != null}">
		<span class="loginError">Invalid username or password</span>
	</c:if>
	
	<form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value='sapi'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='text' name='j_password' value='ompong' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>