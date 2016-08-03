app.factory('apps', ['$http', function($http) { 
  return $http.get('apps.json') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);