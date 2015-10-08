<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<script type="text/javascript">
	function getCityState() {
		var zipcode = $("#zipcode").val();

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

	<form:form method="post" commandName="account" action="${pageContext.request.contextPath}/losSetup">
		<div class="container">
		<h3>CUSTOMER INFORMATION COLLECTION</h3>
		First name: <form:input path="customer.firstName" />
		<br>
		Last name: <form:input path="customer.lastName" />
		<br>
		DOB: <form:input path="customer.dob" />
		<br>
		Address1: <form:input path="customer.address.address1" />
		<br>
		Zip code: <form:input id="zipcode" path="customer.address.zip"
			onblur="return getCityState()" />
		<br>
		City: <form:input id="city" path="customer.address.city" />
		<br>
		State: <form:input id="state" path="customer.address.state" />
		<br>
		Language: <form:radiobutton path="language" value="E" />English  <form:radiobutton
			path="language" value="S" />Spanish<br>
		AuthId: <form:input path="customer.authId" />
		<br>

		<input type="submit" value="Next">
		</div>
	</form:form>

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
	 

	 <%
	 	//out.println("print user = " + session.getAttribute("user"));
	 %>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>