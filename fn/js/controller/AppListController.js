app.controller('AppListController', ['$scope', 'apps', function($scope, apps){
			apps.success(function(data){
				$scope.apps = data;
			});
}]);