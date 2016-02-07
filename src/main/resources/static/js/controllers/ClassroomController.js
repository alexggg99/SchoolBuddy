/**
 * Created by Alex on 24.01.2016.
 */

app.controller('ClassroomController', function($scope, $location, $routeParams, ClassroomService){
    $scope.classrooms = ClassroomService.query();
    $scope.fields = ['name', 'school', 'teacher'];
    $scope.openClassroom = function (classroomId){
        $location.path('/classrooms/' + classroomId);
        //console.log(classroomId);
        //$scope.classroom = ClassroomService.get($routeParams.id | -1);
    };
})