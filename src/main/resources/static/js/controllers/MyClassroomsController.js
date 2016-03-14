/**
 * Created by Alex on 24.01.2016.
 */

app2.controller('MyClassroomsController', function($scope, $location, myClassroomsService, $state, $stateParams){

    $scope.user = {};
    $scope.myClassrooms = {};
    $scope.fields = ['name', 'date'];

    myClassroomsService.getCurrentUser()
        .then(function(user) {
            $scope.user = user;
        })
        .catch(showError);

    myClassroomsService.getMyClassrooms()
        .then(function(classrooms) {
            $scope.myClassrooms = classrooms;
        })
        .catch(showError);

    function showError(message) {
        console.log('Error : ' + message);
    }

})