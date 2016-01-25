/**
 * Created by Alex on 24.01.2016.
 */

app.controller('LogoutController', function($scope){
    $scope.logout = function(){
        location.href = '/logout';
    }
})