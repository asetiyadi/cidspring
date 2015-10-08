<%@ include file="/WEB-INF/view/layout/header.jsp" %>

	<form:form id="formLos">
	
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" id="_eventId" name="_eventId" value="toPayment"/>
		
		<div class="container">
			<h3>REVIEW YOUR ORDER</h3>
			
			<div class="row">
				<div class="form-group col-sm-12 col-md-12 col-lg-12">
					<c:forEach var="los" begin="0" items="${cart.account.subscribers}">
												
						<c:set var="totalAmountDue" value="0"/>
						<c:forEach var="hotBill" items="${cart.billingQuote.hotBillCharges}">
							<c:forEach var="subscriberCharges" items="${hotBill.subscriberQuoteCharges}">
								<div class="row">
									<div class="col-sm-3 col-md-3 col-lg3">
										<label>Device ID:</label> 
									</div>
									<div class="col-sm-3 col-md-3 col-lg3">
										<label>${los.device.deviceId}</label>	
									</div>
								</div>
								<div class="row">
									<div class="col-sm-3 col-md-3 col-lg3">
										<label>MDN</label>
									</div>
									<div class="col-sm-3 col-md-3 col-lg3">
										<label>${subscriberCharges.mdn}</label>
									</div>
								</div>
								<br/>
								<div class="row">
									<div class="col-sm-4 col-md-4 col-lg4">
										&nbsp;&nbsp;&nbsp;Charges due (<fmt:formatDate value="${hotBill.effectiveDate}" type="date"/> - <fmt:formatDate value="${hotBill.expirationDate}" type="date"/>)
									</div>
									<div class="col-sm-4 col-md-4 col-lg4">
										<fmt:formatNumber value="${hotBill.chargeTotal}" type="currency"/>
									</div>
								</div>
								<br/>
								<c:forEach var="featureCharge" items="${subscriberCharges.subscriberCharges}">
									<div class="row">
										<div class="col-sm-4 col-md-4 col-lg4">
											&nbsp;&nbsp;&nbsp;${featureCharge.chargeItemName}
										</div>
										<div class="col-sm-4 col-md-4 col-lg4">
											<fmt:formatNumber type="currency" value="${featureCharge.chargeAmount}"/>
										</div>
									</div>
								</c:forEach>
								
								<div class="row">
									<div class="col-sm-4 col-md-4 col-lg4">
										&nbsp;&nbsp;&nbsp;Taxes
									</div>
									<div class="col-sm-4 col-md-4 col-lg4">
										<fmt:formatNumber value="${subscriberCharges.taxTotal}" type="currency"/>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-4 col-md-4 col-lg4">
										&nbsp;&nbsp;&nbsp;Subtotal
									</div>
									<div class="col-sm-4 col-md-4 col-lg4">
										<fmt:formatNumber value="${subscriberCharges.taxTotal + subscriberCharges.chargeTotal}" type="currency"/>
									</div>	
								</div>
							</c:forEach>
							<c:set var="totalAmountDue" value="${totalAmountDue + hotBill.chargeTotal + hotBill.taxTotal}"/>
							<input type="hidden" name="billingQuote.amountDueToday" value="${totalAmountDue}"/>
						</c:forEach>
						
						<hr/>
						
						<div class="row">
							<div class="col-sm-3 col-md-3 col-lg3">
								<label>Total Amount Due Today</label>
							</div>
							<div class="col-sm-3 col-md-3 col-lg3">
								<label><fmt:formatNumber type="currency" value="${totalAmountDue}" /></label>
							</div>
						</div>
					</c:forEach>	
				</div>
			</div>

			<p><button type="submit" class="btn btn-primary">Next <span class=" glyphicon glyphicon-chevron-right"></span></button></p>
			
		</div>
	</form:form>
	
	<div class="container">
		<div><hr/></div>
		<h4>RP/Features</h4>
			<c:forEach var="offer" items="${cart.account.subscribers[0].offeringCodes}">
				<c:out value="${offer}"/>
			</c:forEach>
		
		<h4>accountQuoteChargesBean</h4>${cart.billingQuote.hotBillCharges[0].accountQuoteChargesBean[0]}
		<h4>subscriberQuoteCharges</h4>${cart.billingQuote.hotBillCharges[0].subscriberQuoteCharges[0] }
		<h4>HotBillCharges</h4>${cart.billingQuote.hotBillCharges[0]}
		<h4>BillingQuote</h4>${cart.billingQuote}
	</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>