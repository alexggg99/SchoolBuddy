/**
 * Created by Alex on 24.01.2016.
 */

app.controller('MenuController', function($scope, $rootScope, $location){
    $scope.logout = function(){
        location.href = '/logout';
    }

    $rootScope.$on( "$routeChangeStart", function(event, next, current) {
        $scope.page = $location.$$path.slice(0,7);
    });

})