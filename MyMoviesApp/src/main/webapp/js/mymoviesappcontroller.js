var MyMoviesApp = angular.module('MyMoviesApp', []);

MyMoviesApp.controller('UserSearchController', function($scope, $http) {
	$scope.users = [];

	$scope.search = function() {
		//remove current results
		$scope.users = [];
		$scope.messageText="";
		
		//search
		$http.get('/MyMoviesApp/rest/users',		
			{params: {
				firstName:$scope.searchFirstName, 
				lastName:$scope.searchLastName}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.users = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

MyMoviesApp.controller('MyMoviesAppAddUserController', function($scope, $http) {	
	
	$scope.create = function() {
		$scope.messageText="";
		
		$http.post('/MyMoviesApp/rest/users',
				{"user":{"firstName":$scope.createFirstName,"lastName":$scope.createLastName,"email":$scope.createEmail}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Created new user with ID "+data.user.id;				
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});
	};
});