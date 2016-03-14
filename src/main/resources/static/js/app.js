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

//var app = angular.module('myApp', ['ngRoute', 'ngResource']);
//
////Define Routing for app
//app.config(['$routeProvider','$locationProvider',
//    function($routeProvider, $locationProvider) {
//        $routeProvider.
//            when('/', {
//                templateUrl: 'templates/welcome.html',
//                controller: 'WelcomeController',
//                controllerAs:'home'
//            }).
//            when('/schools', {
//                templateUrl: 'templates/schools.html',
//                controller: 'SchoolController'
//            }).
//            when('/classrooms', {
//                templateUrl: 'templates/classrooms.html',
//                controller: 'ClassroomController'
//            }).
//            when('/classrooms/:id', {
//                templateUrl: 'templates/classroom_parent.html',
//                controller: 'ClassroomController'
//            }).
//            when('/activities', {
//                templateUrl: 'templates/activities.html',
//                controller: 'ActivityController',
//                resolve: {
//                    activities: function(ActivityService){
//                        return ActivityService.query();
//                    }
//                }
//            })
//            .when('/classrooms/:id/detail/:month?', {
//                templateUrl: 'templates/classroomDetail.html',
//                controller: 'ClassroomController'
//            }).
//            otherwise({
//                redirectTo: '/'
//            });
//        $locationProvider.html5Mode(true).hashPrefix('!');
//    }]);

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
        function ($locationProvider) {
            $locationProvider.html5Mode(true).hashPrefix('!');
        }])
    .controller('LoginController', function ($route, $scope) {

        $scope.error;

        if (location.search != "") {
            $scope.error = true;
        }

    });

var app2 = angular.module('stateApp', ['ui.router', 'ngResource']);
app2.config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
    $locationProvider.html5Mode(true).hashPrefix('!');
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('home', {
            url: '/',
            controller: 'WelcomeController',
            controllerAs: 'home',
            templateUrl: 'templates/welcome.html'
        })
        .state('schools', {
            url: '/schools',
            templateUrl: 'templates/schools.html',
            controller: 'SchoolController'
        }).
        state('classrooms', {
            url: '/classrooms',
            templateUrl: 'templates/classrooms.html',
            controller: 'AllClassroomsController',
            resolve: {
                classrooms: function (ClassroomService) {
                    return ClassroomService.query();
                }
            }
        }).
        state('classroom_parent', {
            abstract: true,
            url: '/classrooms/:id/detail/:month',
            templateUrl: 'templates/classroom_parent.html',
            controller: 'ClassroomController',
            params: {
                classroomMessage: {value: 'Learning is fun!'}
            },
            resolve: {
                classroom: function(ClassroomService, $stateParams){
                    return ClassroomService.get({id:$stateParams.id}, function(classroom){
                        return classroom;
                    });
                }
            }
        }).
        state('classroom_parent.classroom_summary', {
            url: '/summary',
            views:{
                'classTeacherInfo':{
                    templateUrl:'templates/teacherInfo.html',
                    controller:'ClassroomTeacherController'
                },
                'classMessage':{
                    templateUrl:'templates/classroom_message.html',
                    controller:'ClassroomMessageController'
                }
            }
        }).
        state('classroom_parent.classroom_detail', {
            url: '/detail/:month',
            views:{
                'classTeacherInfo':{
                    templateUrl:'templates/classroomDetail.html'
                }
            }
        }).
        state('activities', {
            url: '/activities',
            templateUrl: 'templates/activities.html',
            controller: 'ActivityController',
            resolve: {
                classrooms: function(ClassroomService){
                    return ClassroomService.query();
                },
                activities: function(ActivityService){
                    return ActivityService.query();
                }
            }
        }).
        state('myClassrooms', {
            url: '/myClassrooms',
            templateUrl: 'templates/myClassrooms.html',
            controller: 'MyClassroomsController',
            resolve: {
                classrooms: function (ClassroomService) {
                    return ClassroomService.query();
                }
            }
        })
});

app2.run(['$rootScope', '$log', function ($rootScope, $log) {

    //$rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    //    $log.debug('state changed');
    //    $log.debug('event', event);
    //    $log.debug('toState', toState);
    //    $log.debug('toParams', toParams);
    //    $log.debug('fromState', fromState);
    //    $log.debug('fromParams', fromParams);
    //});
    $rootScope.$on('$stateNotFound', function (event, unfoundState, fromState, fromParams) {

        $log.error('The requested state was not found: ', unfoundState);

    });

    $rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {

        $log.error('An error occurred while changing states: ', error);

        $log.debug('event', event);
        $log.debug('toState', toState);
        $log.debug('toParams', toParams);
        $log.debug('fromState', fromState);
        $log.debug('fromParams', fromParams);
    });
}]);