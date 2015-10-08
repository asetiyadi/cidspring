<%@ include file="/WEB-INF/view/layout/header.jsp" %>
	
	<form:form method="post" commandName="cart">
	
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" id="_eventId" name="_eventId" value="toConfirmation"/>
		
		<div class="container">
			<h3>PAYMENT CONFIRMATION</h3>
	
			<c:if test="${cart.payment.vestaResponseCode == 0}">
				<div class="row">
					<div class="col-sm-6 col-md-6 col-lg-6">
						Payment Successful - Confirmation ID: ${cart.payment.approvalTransactionId}
					</div>
				</div>
			</c:if>
			<br/>
			<p><button type="submit" class="btn btn-primary">Next <span class=" glyphicon glyphicon-chevron-right"></span></button></p>
			
		</div>
	</form:form>
	
	<div class="container">
		<div><hr/></div>
		<h4>Payment approvalId</h4>${cart.payment.approvalTransactionId }
		<h4>Credit Card</h4>${cart.payment.creditCard}
		<h4>Payment</h4>${cart.payment }
		<h4>Cart</h4>${cart}
	</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>