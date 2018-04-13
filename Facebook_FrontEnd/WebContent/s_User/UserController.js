myApp.controller("UserController",['$scope','$rootScope','$location','$http',function($scope,$rootScope,$location,$http)
	{
	 console.log("User Controller loaded");
	 
	 $scope.user={userId:0,userName:'',password:'',email:'',role:'USER',enabled:'',isOnline:''}
	 
		 
	 $scope.createUser=function(){
		 console.log($scope.user);
		// console.log("User is going to be added",$scope.user);
		 console.log("Adding User information");
		 $http.post('http://localhost:8089/Facebook_MiddlewareT/create',$scope.user)
		 .then(function(response){
			 $location.path('/signUp');
		 })
	 }
	}
	]);