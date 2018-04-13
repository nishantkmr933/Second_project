var myApp = angular.module("myApp", ["ngRoute"]);

myApp.config(function($routeProvider) {
	$routeProvider

	.when("/login", {
		templateUrl : "s_User/login.html"
	}).when("/signUp", {
		templateUrl : "s_User/SignUp.html"
	}).when("/addBlog",{
		templateUrl:"s_Blog/AddBlog.html"
	})
})