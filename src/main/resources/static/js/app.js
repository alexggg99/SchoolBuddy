///**
// * Created by alexggg99 on 03.07.15.
// */
////(function() {
//    //var app = angular.module('myApp', []);
//    var app=angular.module("myApp",[]);
//
//    app.config(["$routeProvider",function($routeProvider){
//        $routeProvide.when('/', {
//            templateUrl:"home.html",
//            controller:'HomeController'
//        })
//            .otherwise({redirectTo:'/'})
//    }])
////})
//
//function HomeController(){
//
//}
//
//app.controller('HomeController', HomeController);

var app = angular.module('myApp', ['ngRoute', 'ngResource']);

//Define Routing for app
app.config(['$routeProvider','$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'templates/index.html',
                controller: 'SchoolController'
            }).
            when('/login', {
                templateUrl: 'templates/login.html',
                controller: 'LoginController'
            }).
            when('/classrooms', {
                templateUrl: 'templates/classrooms.html',
                controller: 'ClassroomController'
            }).
            otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true).hashPrefix('!');
    }]);

angular.module('loginPage', ['ngRoute'])
    .config(['$locationProvider',
        function($locationProvider) {
            $locationProvider.html5Mode(true).hashPrefix('!');
        }])
    .controller('LoginController', function($route, $scope){

        $scope.error;

        if(location.search != ""){
            $scope.error = true;
        }

    })
