/**
 * Created by Alex on 24.01.2016.
 */

app2.controller('ClassroomController', function($scope, $location, ClassroomService, ClassroomDetailsService,
                                                $state, $stateParams, classroom){
    $scope.classroom = classroom;

    if(angular.isDefined($stateParams.month)){
        ClassroomDetailsService.query({classroomId:$stateParams.id, month:$stateParams.month}, function(classroomDetails){
            $scope.classroomDetails = classroomDetails;
        });
    }else{
        ClassroomDetailsService.query({classroomId:$stateParams.id}, function(classroomDetails){
            $scope.classroomDetails = classroomDetails;
        });
    }


})