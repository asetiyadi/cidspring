<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<p>Amount due today: ${cart.billingQuote.amountDueToday}</p>

<form:form method="post" commandName="cart" action="${pageContext.request.contextPath}/paymentConfirmation">
	<div>
		Credit/Debit Card Type: 
		<form:select path="payment.creditCard.cardType">
			<form:option value="VISA">VISA</form:option>
			<form:option value="MASTER">MASTER CARD</form:option>
		</form:select>
		<form:hidden path="payment.paymentMethod" value="CREDIT"/>
	</div>
	<div>
		CreditCard #: <input type="text" size="16" maxlength="16"/>
		<form:hidden path="payment.creditCard.cardToken" value="4111900000001692"/>
		CVV: <form:input path="payment.creditCard.cvn" size="4" maxlength="4"/>
		Exp. Date: <form:input path="payment.creditCard.expirationMonth" size="2" maxlength="2"/>/<form:input path="payment.creditCard.expirationYear" size="2" maxlength="2"/>
	</div>
	<div>
		First Name: <form:input path="payment.creditCard.firstName" value="${account.customer.firstName}"/>
		Last Name: <form:input path="payment.creditCard.lastName" value="${account.customer.lastName}"/>
	</div>
	<div>
		Address: <form:input path="payment.creditCard.address.address1" value="${account.customer.address.address1}"/>
	</div>
	<div>
		City: <form:input path="payment.creditCard.address.city" value="${account.customer.address.city}"/> 
		State: <form:input path="payment.creditCard.address.state" value="${account.customer.address.state}"/> 
		Zip: <form:input path="payment.creditCard.address.zip" value="${account.customer.address.zip}"/>
	</div>
	<input type="submit" value="Next"/>
</form:form>
</body>
</html>