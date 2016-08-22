app.factory('apps', ['$http', function($http) {
  return $http.get('http://localhost:8080/apps')
            .success(function(data) {
              return data;
            })
            .error(function(err) {
              return err;
            });
}]);
