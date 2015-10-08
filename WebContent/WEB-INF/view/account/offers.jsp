<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers</title>
</head>
<body>
	<form:form method="post" commandName="cart" action="${pageContext.request.contextPath}/quote">
		<table cellpadding="10">
			<tr>
				<c:forEach var="offer" items="${offers}">
					<c:set var="ratePlan" value="${offer.offerRatePlanBean}" />
						<td valign="top">
							<input type="radio" name="ratePlanOptions" value="${ratePlan.planId}" />${ratePlan.planName} 
							<c:set var="features" value="${offer.offerFeaturesBean}" /> 
							<c:forEach var="feature" items="${features}">
								<c:if test="${!feature.featurePrice.equalsIgnoreCase('X') && feature.isSelectable == true}">
									<input type="checkbox" name="feature_${ratePlan.planId}" value="${feature.id}">
								</c:if>
								<c:if test="${!feature.featurePrice.equalsIgnoreCase('X') && feature.isSelectable == false}">
									<input type="hidden" name="feature_${ratePlan.planId}" value="${feature.id}">
								</c:if>
								${feature.offerName} - ${feature.featurePrice}<br />
							</c:forEach>
						</td>
				</c:forEach>
			</tr>
		</table>
		
		<input type="submit" value="Next">
	</form:form>

	<h5>Device</h5>
	ID = ${account.subscribers[0].device.deviceId}
	<br> Code = ${account.subscribers[0].device.deviceCode}
	<br> Refurbished = ${account.subscribers[0].device.isRefurbished()}
	<br>

	<h5>Customer</h5>
	Name = ${account.customer.firstName} ${account.customer.lastName}
	<br>

	<h5>Subscriber</h5>
	Receive Notification = ${account.subscribers[0].receiveNotification}
	<br> BRP = ${account.subscribers[0].billingResponsibleParty}
	<br>

	<h5>Account</h5>
	Rate Center ID = ${account.rateCenterId}
	<br> Market ID = ${account.marketId}
	<br> Product Code = ${account.productCode}
	<br>
</body>
</html>