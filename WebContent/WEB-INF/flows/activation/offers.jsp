<%@ include file="/WEB-INF/view/layout/header.jsp" %>

	<form:form method="post">
	
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" name="_eventId" value="toQuote"/>
		
		<div class="container">
			<h3>RATE PLAN AND OFFERS</h3>
			
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
			
			<p><button type="submit" class="btn btn-primary">Next <span class=" glyphicon glyphicon-chevron-right"></span></button></p>
		</div>
	</form:form>
	
	<div class="container">
		<p><hr/></p>
		<p><c:out value="${offers[0].offerRatePlanBean.planName}"/></p>
		 
		<h4>Device</h4>
		ID = ${cart.account.subscribers[0].device.deviceId}
		<br> Code = ${cart.account.subscribers[0].device.deviceCode}
		<br> Refurbished = ${cart.account.subscribers[0].device.isRefurbished()}
		<br>

		<h4>Customer</h4>
		${cart.account.customer}
		<br>
	
		<h4>Subscriber</h4>
		${cart.account.subscribers[0]}
		<br>
	
		<h4>Account</h4>
		Rate Center ID = ${cart.account.rateCenterId}
		<br> Market ID = ${cart.account.marketId}
		<br> Product Code = ${cart.account.productCode}
		<br>
		<h4>Contract</h4>
		${cart.account.subscribers[0].contract }
		<h4>Cart</h4>
		${cart }
	</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>