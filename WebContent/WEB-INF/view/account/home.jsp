<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!doctype html>
<html ng-app="accountDashboard">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>
	<!-- <p>Static: <img alt="Spring" src="/WirelessSpring/static/js/scripts/spring.jpg"> -->
	<p>
		<!-- <img alt="SpringContext" src="${pageContext.request.contextPath}/static/js/scripts/spring.jpg"> -->

		<script>
			var urlRef = "${pageContext.request.contextPath}/json/";
			var accountNumber = "${accountNumber}";

			//alert("accountNumber = " + accountNumber);
		</script>
		
		<div ng-view></div>

		<script src="${pageContext.request.contextPath}/static/js/scripts/angular.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/scripts/angular-route.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/scripts/angular-resource.js"></script>

		<script src="${pageContext.request.contextPath}/static/js/angularJS/app.js"></script>
		
		<script src="${pageContext.request.contextPath}/static/js/angularJS/controllers/accountController.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/angularJS/services/accountFactory.js"></script>
		
	
	
</body>
</html>
