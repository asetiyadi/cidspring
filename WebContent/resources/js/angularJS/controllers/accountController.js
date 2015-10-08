(function () {
    var AccountController = function ($scope, accountFactory) {

    	function init()
        {	
    		$scope.version = "0.1";
    		$scope.isError = false;
            //$scope.account = null;
            /*
            accountFactory.getAccount(accountNumber)
            	.success(function(account){
            		$scope.account = account;

            		//alert("account = " + $scope.account.accountNumber);
            	})
            	.error(function(data, status, headers, config){
            		alert("error");
            	});
            */

    		 var accountQuery = accountFactory.getAccount('90976433591');
    		 
             accountQuery.$promise.then(function(result)	{
             	$scope.account = result;
             }, 
             function(error)	{
             	$scope.account = null;
             	$scope.isError = true;
             	
             	var errorObj = {};
             	errorObj.data = error.data;
             	errorObj.status = error.status;
             	errorObj.statusText = error.statusText;
             	errorObj.restUrl = error.config.url;
             	
             	$scope.errorObj = errorObj;
             });
      }
        
        init();
        
        
    };
    
    AccountController.$inject = ['$scope', 'accountFactory'];
    
    angular.module('accountDashboard')
        .controller('AccountController', AccountController);
    
}());

/*
(function () {
    var AccountController = function (accountFactory) {

    	function init()
        {
            this.account = null;
            //this.isAccountExist = false;
            
            //var accountNumber = '90011393676';
            
            accountFactory.getAccount(accountNumber)
            	.success(function(account){
            		this.account = account;
            		//$scope.isAccountExist = true;
            		alert("account = " + this.account.accountNumber);
            	})
            	.error(function(data, status, headers, config){
            		alert("error");
            	});
        }
        
        init();
    };
    
    AccountController.$inject = ['accountFactory'];
    
    angular.module('accountDashboard')
        .controller('AccountController', AccountController);
    
}());
*/