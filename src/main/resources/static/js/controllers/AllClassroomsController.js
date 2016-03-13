/**
 * Created by Alex on 24.01.2016.
 */

app2.controller('AllClassroomsController', function($scope, $location, ClassroomService, ClassroomDetailsService,
                                                $state, $stateParams, classrooms){
    $scope.classrooms = classrooms;
    $scope.fields = ['name', 'school', 'teacher'];
    $scope.openClassroomDetail = function (classroomId){
        //$stateParams.id = classroomId;
        //$state.go('classroom');
        //$state.transitionTo('/classrooms/'+classroomId);
        $state.go('classroom_parent.classroom_detail', {id:classroomId});
    };

})