<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<script type="text/javascript">
	function getCityState() {
		var zipcode = $("#zipcode").val();
		alert(zipcode);
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/json/citystate/" + zipcode, 
			success : function(res) {
				$("#city").val($.trim(res.city));
				$("#state").val($.trim(res.state));
			}
			,
			error : function() {
				alert("error");
			}
		});
	}
</script>
	
	
		
	<div class="container">
		
		<!-- 
			the commandName "account" relates to the account variable set in activation-flow.xml
				<var name="account" class="com.wireless.domain.Account"/>  
		-->
		
		<form:form method="post" commandName="cart">
		
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="hidden" name="_eventId" value="toDeviceInfo"/>
		 
			<h3>CUSTOMER INFORMATION</h3>

			<div class="row">
				<div class="form-group col-sm-3 col-md-3 col-lg-3">
					<label for="firstname">First name</label> 
					<form:input class="form-control" id="firstname" path="account.customer.firstName" value="Otong" placeholder="Enter first name"/>
				</div>
				<div class="form-group col-sm-3 col-md-3 col-lg-3">
					<label for="lastName">Last name</label> 
					<form:input class="form-control" id="lastName" path="account.customer.lastName" value="Ompong" placeholder="Enter last name"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-xs-6 col-sm-2 col-md-2 col-lg-2">
					<label for="dob">DOB</label> 
					<form:input class="form-control" id="dob" path="account.customer.dob" placeholder="Enter date of birth"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group  col-sm-6 col-md-6 col-lg-6">
					<label for="address1">Address</label> 
					<form:input class="form-control" id="address1" path="account.customer.address.address1" value="2200 e elm st" placeholder="Enter address"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-xs-4 col-sm-2 col-md-2 col-lg-2">
					<label for="zipcode">Zip code</label> 
					<form:input class="form-control" id="zipcode" path="account.customer.address.zip" value="85719" onblur="return getCityState()"/>
				</div>
				<div class="form-group col-xs-6 col-sm-4 col-md-4 col-lg-4">
					<label for="city">City</label> 
					<form:input class="form-control" id="city" path="account.customer.address.city" value="Tucson"/>
				</div>
				<div class="form-group col-xs-3 col-sm-2 col-md-2 col-lg-2">
					<label for="state">State</label> 
					<form:input class="form-control" id="state" path="account.customer.address.state" value="AZ"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-sm-12 col-md-12 col-lg-12">
					<label for="language">Language</label>
					
					<div class="radio">	
						<label>
							<form:radiobutton path="account.language" value="E" />English
						</label>
						&nbsp;&nbsp;
						<label>	
							<form:radiobutton path="account.language" value="S" />Spanish
						</label>	
					</div>	
					  
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-xs-6 col-sm-3 col-md-3 col-lg-3">
					<label for="authId">Authentication Id</label> 
					<form:input class="form-control" id="authId" path="account.customer.authId" value="1122" placeholder="Enter PIN"/>
				</div>
			</div>
		
			<p><button type="submit" class="btn btn-primary">Next <span class=" glyphicon glyphicon-chevron-right"></span></button></p>
		
		</form:form>
	</div>
	
	<div class="container">
		<div><hr/></div>
		cart = ${cart.account.customer}
	</div>
	<!-- 
	<form action="${pageContext.request.contextPath}/losSetup" method="post">
		<h3>CUSTOMER INFORMATION COLLECTION</h3>
		Firstname: <input type="text" name="firstName" value="otong1"><br>
		Lastname: <input type="text" name="lastName" value="lenon"><br>
		DOB: <input type="text" name="dob" value="01/01/1999"><br>
		Address1: <input type="text" name="address1" value="2200 e elm st"><br>
		Zip: <input type="text" id="zipcode" name="zipcode" onblur="return getCityState()"><br>
		City: <input type="text" id="city" name="city"><br>
		State: <input type="text" id="state" name="state" value=""><br>
		Language: <input type="radio" name="language" value="E" checked>English  <input type="radio" name="language" value="S">Spanish<br>
		AuthId: <input type="text" name="authId" value="1111"><br> 
		<input type="hidden" name="activation_state" value="customerInfo">
		<input type="submit" value="Next">
	</form>
	 -->
	 
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>