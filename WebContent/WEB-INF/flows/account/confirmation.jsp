<%@ include file="/WEB-INF/view/layout/header.jsp" %>

	<form:form method="post" commandName="cart">
	
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" id="_eventId" name="_eventId" value="toConfirmation"/>
		
		<div class="container">
			<h3>CONFIRMATION</h3>
			
			<div class="row">
				<div class="col-sm-4 col-md-4 col-lg-4">
					Account Number:
				</div>
				<div class="col-sm-4 col-md-4 col-lg-4">
					${cart.account.accountNumber}
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 col-md-4 col-lg-4">
					MDN:
				</div>
				<div class="col-sm-4 col-md-4 col-lg-4">
					${cart.account.subscribers[0].mdn}
				</div>
			</div>
		</div>
	</form:form>

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>