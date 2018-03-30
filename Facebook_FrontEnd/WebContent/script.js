(function () {
    'use strict';
    console.log('Inside script.js');
    angular.module('main-app', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider'];
    function config($routeProvider, $locationProvider) {
        console.log('Inside config()....');
        $routeProvider
            .when('/home', {
                templateUrl: 's_home/home.view.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm',
            })
    }
}
)