var app = angular.module('appsApp', ['ngRoute']);
app.config(function ($routeProvider) {
  $routeProvider
  .when('/', {
   controller: 'AppController',
   templateUrl: 'views/app.html'
 })
 .when('/:id', {
   controller: 'AppDetailController',
   templateUrl: 'views/appDetail.html'

 })
 .otherwise({
   redirectTo: '/'
 });
});
