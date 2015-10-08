<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Confirmation</title>
</head>
<body>
	<h4>Payment Result</h4>
	<c:if test="${cart.payment.vestaResponseCode == 0}">
		<div>Payment Successful - Confirmation ID: ${cart.payment.approvalTransactionId}</div>
	</c:if>
	<form:form method="post" commandName="cart" action="${pageContext.request.contextPath}/confirmation">
		<input type="submit" value="Next"/>
	</form:form>
</body>
</html>