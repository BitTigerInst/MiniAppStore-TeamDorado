var app = angular.module('ReaderApp', ['ngRoute']);
app.config(function ($routeProvider) { 
  $routeProvider 
    .when('/apps', { 
      controller: 'AppListController', 
      templateUrl: 'views/appscle.html' 
    })
    .when('/apps/:trackId', { 
      controller: 'AppController', 
      templateUrl: 'views/appl.html' 
    })
    .otherwise({ 
      redirectTo: '/books' 
    }); 
});