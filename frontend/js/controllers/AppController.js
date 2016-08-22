app.controller('AppController', ['$scope','apps', '$routeParams', function($scope,apps ,$routeParams) {
  // Your code here
  apps.success(function(data) {
   $scope.applist = data;


}]);
