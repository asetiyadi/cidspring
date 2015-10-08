<%@ include file="/WEB-INF/view/layout/header.jsp" %>

	<form:form id="formLos" commandName="cart">
	
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" id="_eventId" name="_eventId" value="validatedevice"/>
		
		<div class="container">
			<div class="col-md-6">
				<h3>DEVICE VALIDATION</h3>

				<div class="row">
					<div class="col-xs-12 col-sm-4 col-md-5 col-lg-5">
						<label for="deviceId">Device ID</label>	
						<form:input class="form-control" id="deviceId" path="account.subscribers[0].device.deviceId" value="429496729500057302" placeholder="Enter device ID"/>
					</div>

					<div class="col-xs-12 col-sm-4 col-md-5 col-lg-4">
						<label>&nbsp;</label>
						<button type="submit" class="btn btn-primary form-control">Validate Device ID</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	
	<div class="container">
		<div><hr/></div>
		cart = ${cart.account.customer}
	</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>