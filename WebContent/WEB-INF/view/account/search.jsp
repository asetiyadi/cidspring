<%@ include file="/WEB-INF/view/layout/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
	function setAction(action)
	{
		if(action == "activation")	
		{
			$("#home").attr("action", "${pageContext.request.contextPath}/customerInfo");	
		}
		else
		{
			$("#home").attr("action", "${pageContext.request.contextPath}/account/home");	
		}
		
		$("#home").submit();
		
	}
</script>
</head>
<body>

<form:form id="home" method="post" action="${pageContext.request.contextPath}/customerInfo">
	<input type="button" name="activation" value="Start Activation" onclick="setAction('activation')"/>

	<div>
		Account No: <input type="text" name="accountNumber">
		<input type="button" name="search" value="Search" onclick="setAction('search')"/>
	</div>

</form:form>
</body>
</html>