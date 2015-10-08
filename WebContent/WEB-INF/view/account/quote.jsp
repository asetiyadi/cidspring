<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quote Submission</title>
</head>
<body>
	<h3>Amount Due Today</h3>
	<div>
		<div>Cricket Monthly</div>
		<div>Amount Due</div>
	</div>
	 MDN: ${cart.account.subscribers[0].device.deviceId}
	<c:forEach var="los" begin="0" items="${cart.account.subscribers}">
		<div>Line of Service</div>
		<div>ESN/MEID/IMEI: ${los.device.deviceId}  MDN: ${los.getDevice().getDeviceId()}</div>
		<c:set var="totalAmountDue" value="0"/>
		<c:forEach var="hotBill" items="${cart.billingQuote.hotBillCharges}">
			<div>Charges due (<fmt:formatDate value="${hotBill.effectiveDate}" type="date"/> - <fmt:formatDate value="${hotBill.expirationDate}" type="date"/>)</div>
			<div>${hotBill.chargeTotal}</div>
			<c:forEach var="subscriberCharges" items="${hotBill.subscriberQuoteCharges}">
				<c:forEach var="featureCharge" items="${subscriberCharges.subscriberCharges}">
					<div>${featureCharge.chargeItemName}</div>
					<div><fmt:formatNumber type="currency" value="${featureCharge.chargeAmount}"/> </div>
				</c:forEach>
				<div>Taxes</div>
				<div>${subscriberCharges.taxTotal}</div>
				<div>Subtotal</div>
				<div>${subscriberCharges.taxTotal + subscriberCharges.chargeTotal}</div>
			</c:forEach>
			<c:set var="totalAmountDue" value="${totalAmountDue + hotBill.chargeTotal + hotBill.taxTotal}"/>
		</c:forEach>
		<hr/>
		<div>Total Amount Due Today</div>
		<div><fmt:formatNumber type="currency" value="${totalAmountDue}" /></div>
	</c:forEach>
	
	<form:form method="post" action="${pageContext.request.contextPath}/payment" commandName="cart">
		<input type="hidden" name="billingQuote.amountDueToday" value="${totalAmountDue}"/>
		<input type="submit" value="Next"/>
	</form:form>
	
	<br>
	<!-- 
	Name: ${cart.account.customer.firstName} ${cart.account.customer.lastName}<br>
	Market: ${account.marketId }
	-->
	
</body>
</html>