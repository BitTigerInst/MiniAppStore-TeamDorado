app.controller('AppDetailController', ['$scope','apps', '$routeParams', function($scope,apps ,$routeParams) {
    // Your code here
    apps.success(function (data) {
        scope.detail = data.content[$routeParams.id];


    });
}]);
