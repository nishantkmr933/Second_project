myApp.controller("BlogController",['$scope','$rootScope','$location','$http',function($scope,$rootScope,$location,$http)
	{
	 console.log("blog Controller loaded");
	 
	 $scope.blog={blogId:0,title:'',contents:'',dateCreated:'',lastModified:'',status:'',incrementLikes:''}
	 
		 
	 $scope.addBlog=function(){
		 console.log("blog is going to be added",self.blog);
		 console.log("Adding blog information");
		 $http.post('http://localhost:8089/Facebook_MiddlewareT/addBlog',self.blog)
		 .then(function(response){
			 $location.path('/blog');
		 })
	 }
	}
	]);