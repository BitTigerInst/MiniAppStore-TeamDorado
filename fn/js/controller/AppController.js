app.controller('AppController',['$scope','apps', '$routeParams', function($scope, apps, $routeParams){
	apps.success(function(data){
		$scope.app = data[$routeParams.trackId];
	});

	$scope.currentAppIndex = parseInt($routeParams.trackId);
}]);