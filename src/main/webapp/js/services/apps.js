app.factory('apps', ['$http', function($http) {
  return $http.get('/apps')
            .success(function(data) {
              return data;
            })
            .error(function(err) {
                conosle.log('cannot get data');
              return err;
            });
}]);
