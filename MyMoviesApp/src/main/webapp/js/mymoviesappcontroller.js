var MyMoviesApp = angular.module('MyMoviesApp', []);

MyMoviesApp.controller('MovieSearchController', function($scope, $http) {
	$scope.movies = [];

	$scope.search = function() {
		//remove current results
		$scope.movies = [];
		$scope.messageText="";
		
		//search
		$http.get('/MyMoviesApp/rest/movies',		
			{params: {
				movieName:$scope.searchMovieName, 
				releaseDate:$scope.searchReleaseDate,
				rating:$scope.searchMovieRating,
				genre:$scope.searchMovieGenre}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.movies = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

MyMoviesApp.controller('MyMoviesAppAddMovieController', function($scope, $http) {	
	$scope.create = function() {
		$scope.messageText="";
		
		$http.post('/MyMoviesApp/rest/movies',
				{"movie":{"movieName":$scope.createMovieName,"releaseDate":$scope.createReleaseDate,"rating":$scope.createRating,"genre":$scope.createGenre}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Created new movie with ID "+data.user.id;				
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});
	};
});

MyMoviesApp.controller('TheatreSearchController', function($scope, $http) {
	$scope.theatres = [];

	$scope.search = function() {
		//remove current results
		$scope.theatres = [];
		$scope.messageText="";
		
		//search
		$http.get('/MyMoviesApp/rest/theatres',		
			{params: {
				theatreName:$scope.searchTheatreName, 
				zipCode:$scope.searchZipCode,
				cityName:$scope.searchCityName,
				stateName:$scope.searchStateName}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.theatres = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

MyMoviesApp.controller('MyMoviesAppAddTheatreController', function($scope, $http) {	
	
	$scope.create = function() {
		$scope.messageText="";
		
		$http.post('/MyMoviesApp/rest/theatres',
				{"theatre":{"theatreName":$scope.createTheatreName,"zipcode":$scope.createZipCode,"cityname":$scope.createCityName,"statename":$scope.createStateName}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Created new theatre with ID "+data.user.id;				
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});
	};
});

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