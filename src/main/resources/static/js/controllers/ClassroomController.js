/**
 * Created by Alex on 24.01.2016.
 */

app2.controller('ClassroomController', function($scope, $location, ClassroomService, ClassroomDetailsService){
    $scope.classrooms = ClassroomService.query();
    $scope.fields = ['name', 'school', 'teacher'];
    $scope.openClassroom = function (classroomId){
        $location.path('/classrooms/' + classroomId);
    };

    //if(angular.isDefined($routeParams.id)){
    //    ClassroomService.get({id:$routeParams.id}, function(classroom){
    //        $scope.classroom = classroom;
    //    });
    //    if(angular.isDefined($routeParams.month)){
    //        $scope.selectedMonth = $routeParams.month;
    //        ClassroomDetailsService.query({classroomId:$routeParams.id, month:$routeParams.month}, function(classroomDetails){
    //            $scope.classroomDetails = classroomDetails;
    //        });
    //    }else{
    //        ClassroomDetailsService.query({classroomId:$routeParams.id}, function(classroomDetails){
    //            $scope.classroomDetails = classroomDetails;
    //        });
    //    }
    //}


})