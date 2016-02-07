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
                templateUrl: 'templates/welcome.html',
                controller: 'WelcomeController',
                controllerAs:'home'
            }).
            when('/schools', {
                templateUrl: 'templates/schools.html',
                controller: 'SchoolController'
            }).
            when('/classrooms', {
                templateUrl: 'templates/classrooms.html',
                controller: 'ClassroomController'
            }).
            when('/classrooms/:id', {
                templateUrl: 'templates/classroom.html',
                controller: 'ClassroomController'
            }).
            when('/activities', {
                templateUrl: 'templates/activities.html',
                controller: 'ActivityController'
            }).
            otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true).hashPrefix('!');
    }]);

//app.run(['$rootScope', '$log', function($rootScope, $log){
//    $rootScope.$on('$routeChangeSuccess', function(event, current, previos){
//        $log.debug('route changed');
//
//        $log.debug(event);
//        $log.debug(current);
//        $log.debug(previos);
//    })
//    $rootScope.$on('$routeChangeError', function(event, current, previos){
//        $log.debug('route changed');
//
//        $log.debug(event);
//        $log.debug(current);
//        $log.debug(previos);
//    })
//}]);

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
