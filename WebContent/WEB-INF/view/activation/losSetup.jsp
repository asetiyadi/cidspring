<%@ include file="/WEB-INF/view/layout/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOS Setup</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	
	<script type="text/javascript">
	function validateDevice()
	{
		var deviceId = $("#deviceId").val();
		//alert("deviceid = " + deviceId);
		//var contextPath = $("#contextPath").val();
		
		//alert("zipcode = " + zipcode);
		//alert("contextPath = ${pageContext.request.contextPath}");
		
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/json/device/${model.account.marketId}/" + deviceId, 
			success : function(res) {
				//alert("id = " + $.trim(res.deviceId));
				//alert("status = " + $.trim(res.deviceStatus));
				$("#testDevice").val($.trim(res.deviceId));
				$("#deviceIdValidated").html($.trim(res.deviceId));
				$("#deviceStatus").html($.trim(res.deviceStatus));
				$("#deviceModel").html($.trim(res.deviceCode));
			}
			,
			error : function() {
				alert("error");
			}
		});
		
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/json/products/${model.account.marketId}/" + deviceId, 
			success : function(res) {
				alert("id = " + $.trim(res.deviceId));
				alert("status = " + $.trim(res.deviceStatus));
				$("#testDevice").val($.trim(res.deviceId));
				$("#deviceIdValidated").html($.trim(res.deviceId));
				$("#deviceStatus").html($.trim(res.deviceStatus));
				$("#deviceModel").html($.trim(res.deviceCode));
			}
			,
			error : function() {
				alert("error");
			}
		});
	}
	
	function setAction()
	{
		var form_url = $("#formLos").attr("action");
	    //alert("Before - action=" + form_url);	
	    //changing the action to google.com
	    $("#formLos").attr("action","${pageContext.request.contextPath}/losSetup/validateDevice");
	    //alert("After - action = "+$("#formLos").attr("action"));
	    //submit the form
	    $("#formLos").submit();
	}
	</script>
</head>
<body>
	
	
	lastname =
	<c:out value="${account.getCustomer().getLastName()}"></c:out>
	<br> marketId =
	<c:out value="${account.getMarketId()}"></c:out>
	
	<form:form id="formLos" method="post" commandName="account" action="${pageContext.request.contextPath}/${formAction}">
		<div id="device">
			<h4>Device ID</h4>
			<div>
				<form:input id="deviceId" path="subscribers[0].device.deviceId" />
				<input type="button" value="Validate Device" onclick="setAction()">
			</div>
		</div>

		<div id="product" style="display: ;">
			<h4>Product</h4>
			<c:forEach var="product" items="${products}">
				<input type="radio" name="productCode" value="<c:out value='${product.productId}'/>"/><c:out value="${product.productName}" /><br/>
			</c:forEach>
		</div>

		<div id="rateCenter" style="display: ;">
			<h4>Rate Center</h4>
			<c:forEach var="rateCenter" items="${rateCenters}">
				<input type="radio" name="rateCenterOptions" value="<c:out value='${rateCenter.id}'/>"/>${rateCenter.id}: <c:out value="${rateCenter.description}" /><br/>
			</c:forEach>
		</div>
		
		<div id="deviceInfo" style="display: ">
			<h4>Device</h4>
			<div>Device ID: ${account.subscribers[0].device.deviceId}</div>
			<div>
				Device Model: 
				<c:if test="${fn:length(account.subscribers[0].device.deviceCode) != 0}">
					|${account.subscribers[0].device.deviceCode}|
				</c:if>
				<c:if test="${fn:length(account.subscribers[0].device.deviceCode) == 0}">
					<select name="phoneModel">
						<option value="APL 5">iPhone 5</option>
						<option value="HTC2000">HTC One SV</option>
					</select>
				</c:if>
			</div>
			<div>Billing Responsible Party: <form:checkbox path="subscribers[0].billingResponsibleParty"/></div>
			<div>Payment Confirmation Email: 
				<form:radiobutton path="subscribers[0].receiveNotification" value="1"/> Yes
				<form:radiobutton path="subscribers[0].receiveNotification" value="0"/> No
			</div>
		</div>
		
		<input type="submit" value="Next"/>
	</form:form>
</body>
</html>