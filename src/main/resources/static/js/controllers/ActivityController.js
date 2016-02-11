/**
 * Created by Alex on 24.01.2016.
 */

app.controller('ActivityController', function($scope, $location, ActivityService, ClassroomService){
    $scope.activities = ActivityService.query();
    $scope.classrooms = ClassroomService.query();
    $scope.fields = ['name', 'classroom', 'date'];
    $scope.activity = {};
    $scope.search = function(){
        var classroom_detail_url = '/classrooms/' + $scope.selectedClassroom.id + '/detail/' + $scope.selectedMonth;
        $location.url(classroom_detail_url);
    };
})