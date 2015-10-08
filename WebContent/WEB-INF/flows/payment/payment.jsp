<%@ include file="/WEB-INF/view/layout/header.jsp" %>

	<form:form method="post" commandName="cart">
		
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" name="_eventId" value="toPaymentConfirmation"/>
		
		<div class="container">
			<h3>PAYMENT INFORMATION</h3>
			
			<div class="row">
				<div class="col-sm-6 col-md-6 col-lg-6">
					Amount due today: <fmt:formatNumber value="${cart.billingQuote.amountDueToday}" type="currency"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-sm-6 col-md-6 col-lg-6">
					<label>Credit/Debit Card Type:</label> 
					<form:select class="form-control" path="payment.creditCard.cardType">
						<form:option value="VISA">VISA</form:option>
						<form:option value="MASTER">MASTER CARD</form:option>
					</form:select>
					<form:hidden id="paymentMethod" path="payment.paymentMethod" value="CREDIT"/>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group col-sm-3 col-md-3 col-lg-3">
					<label>CreditCard #:</label>
					<input type="text" id="creditCardNo" maxlength="16" class="form-control" value="4111111111111111"/>
					<form:hidden id="cardToken" path="payment.creditCard.cardToken" value="4111900000002963"/>
				</div>
				<div class="form-group col-sm-1 col-md-1 col-lg-1">
					<label>CVV:</label> 
					<form:input id="cvn" class="form-control" path="payment.creditCard.cvn" size="4" maxlength="4" value="1111"/>
				</div>
				<div class="row">
					<c:set var="optionMonth" value="'01','02','03'"/>
					<div class="form-group col-sm-1 col-md-1 col-lg-1">
					<label>Exp:</label> 
					
					<form:input id="expirationMonth" class="form-control" path="payment.creditCard.expirationMonth" size="2" maxlength="2" value="11"/>
					
					</div>
					<div class="form-group col-sm-1 col-md-1 col-lg-1">
					<label>&nbsp;</label> 
					</div>
					<div class="form-group col-sm-1 col-md-1 col-lg-1">
					<label>&nbsp;</label> 
					<form:input id="expirationYear" class="form-control" path="payment.creditCard.expirationYear" size="2" maxlength="2" value="15"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-sm-3 col-md-3 col-lg-3">
					<label>First Name:</label> 
					<form:input class="form-control" path="payment.creditCard.firstName" value="${cart.account.customer.firstName}"/>
				</div>
				<div class="form-group col-sm-3 col-md-3 col-lg-3">
					<label>Last Name:</label> 
					<form:input class="form-control" path="payment.creditCard.lastName" value="${cart.account.customer.lastName}"/>
				</div>
			</div>
		
			<div class="row">
				<div class="form-group col-sm-4 col-md-4 col-lg-4">
					<label>Address:</label> 
					<form:input class="form-control" path="payment.creditCard.address.address1" value="${cart.account.customer.address.address1}"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-sm-3 col-md-3 col-lg-3">
					<label>City:</label> 
					<form:input class="form-control" path="payment.creditCard.address.city" value="${cart.account.customer.address.city}"/>
				</div>
				<div class="form-group col-sm-1 col-md-1 col-lg-1"> 
					<label>State:</label> 
					<form:input class="form-control" path="payment.creditCard.address.state" value="${cart.account.customer.address.state}"/>
				</div>
				<div class="form-group col-sm-1 col-md-1 col-lg-1"> 
					<label>Zip:</label> 
					<form:input class="form-control" path="payment.creditCard.address.zip" value="${cart.account.customer.address.zip}"/>
				</div>
			</div>
			
			<p><button type="submit" class="btn btn-primary">Next <span class=" glyphicon glyphicon-chevron-right"></span></button></p>
			
		</div>
	</form:form>
	
	<div class="container">
		<div><hr/></div>
		cart = ${cart}
	</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>