<%@ include file="/WEB-INF/view/layout/header.jsp" %>

	<script type="text/javascript">
	
	function setEventId(eventType)
	{
		//var form_url = $("#formLos").attr("action");
		//alert(eventType);
	    //alert("Before - action=" + $("#_eventId").val());	
	    //changing the action to google.com
	    $("#_eventId").val(eventType);
	    //alert("After - action = "+ $("#_eventId").val());
	    //submit the form
	    $("#formLos").submit();
	}
	</script>

 
	<form:form id="formLos" commandName="cart">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" id="_eventId" name="_eventId" value="loadLosInfoToCart"/>
		
		<div class="container">
			<h3>LINE OF SERVICE INFO</h3>
			<div class="row">
				<div class="form-group col-sm-12 col-md-12 col-lg-12">
					<label for="account.productCode">Product</label>	
					<div class="radio">	
						<c:forEach var="product" items="${products}">
							<label>
								<form:radiobutton path="account.productCode" value="${product.productId}" />${product.productName}
							</label>
							&nbsp;&nbsp;
						</c:forEach>
					</div>	
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-sm-12 col-md-12 col-lg-12">
					<label for="account.rateCenterId">Rate Center</label>	
					<div class="radio">	
						<c:forEach var="rateCenter" items="${rateCenters}">
							<label>
								<form:radiobutton path="account.rateCenterId" value="${rateCenter.id}" />${rateCenter.description}
							</label>
							<br/>
						</c:forEach>
					</div>	
				</div>
			</div>
			
			<div class="row">
				<div class="form-group  col-sm-6 col-md-6 col-lg-6">
					<label>Device Info</label> 
					<div>Device ID: <c:out value="${cart.account.subscribers[0].device.deviceId}"/></div>
					<div>Model: <c:out value="${cart.account.subscribers[0].device.model}"/></div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group  col-sm-6 col-md-6 col-lg-6">
					<div>Billing Responsible Party: <form:checkbox path="account.subscribers[0].billingResponsibleParty"/></div>
					<div>Payment Confirmation Email: 
						<form:radiobutton path="account.subscribers[0].receiveNotification" value="1"/> Yes
						<form:radiobutton path="account.subscribers[0].receiveNotification" value="0"/> No
					</div>
				</div>
			</div>
			
			<p><button type="submit" class="btn btn-primary">Next <span class=" glyphicon glyphicon-chevron-right"></span></button></p>
		</div>
	</form:form>
	
	
	<div class="container">
		<div><hr/></div>
		<p>cart: ${cart}</p>
		<p>Products: ${products}</p>
		<p>RateCenters: <c:out value="${rateCenters}"/></p>
		<p>Device: ${device}</p>
		<p>currentSubscriber: ${currentSubscriber}</p>
	</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>