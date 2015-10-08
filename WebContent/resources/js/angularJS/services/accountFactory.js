
(function(){
	
	var accountFactory = function($resource, $q, baseRestUrl)
	{
		var factory = {};
		console.log("baseRestUrl: " + baseRestUrl);
		
		var resource = $resource(baseRestUrl + "/account/:id", {id:"@id"});
		
		factory.getAccount = function(accountNumber)
		{
			var resource = $resource(baseRestUrl + "/account/:id", {}, {
				byAccount: {
					params:{id: accountNumber},
					isArray: false,
					method: 'GET'
				}
			});
			
			return resource.byAccount(accountNumber);
		};
		
		return factory;
	};
	
	accountFactory.$inject = ['$resource','$q','baseRestUrl'];
	
	angular.module('accountDashboard')
		.factory('accountFactory', accountFactory)
		.constant('baseRestUrl', 'http://localhost:8080/Wireless/json');
	
}());

/*
(function(){
	
	var accountFactory = function($resource)
	{
		var factory = {};
		
		factory.getAccount = function(accountNum)
		{
			//var url = "/Wireless/json/account/" + accountNumber;
			var url = "/Wireless/json/account/";
			
           
           return $resource(url, {}, {
        	   getAccount: {method: 'GET', params:{accountNumber: accountNum}, isArray:true}
           });
		}
		
		return factory;
	}
	
	accountFactory.$inject = ['$resource'];
	
	angular.module('accountDashboard',['ngResource']).factory('accountFactory', accountFactory);
	
}());
*/