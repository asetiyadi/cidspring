
(function()
{
    var app = angular.module('accountDashboard', ['ngRoute','ngResource']);
    
    app.config(function($routeProvider) {
       $routeProvider
            .when('/',  {
                //controller: 'AccountController',
                templateUrl: 'dashboard'
            })
            .otherwise( {
                redirectTo: '/'   
            });
    });
}());


/*
var app = angular.module('accountDashboard', ['ngRoute']);

app.config(function($routeProvider) {
   $routeProvider
        .when('/',  {
            controller: 'AccountController',
            templateUrl: 'dashboard'
        })
        .otherwise( {
            redirectTo: '/'   
        });
});
*/

