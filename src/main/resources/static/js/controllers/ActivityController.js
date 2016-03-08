/**
 * Created by Alex on 24.01.2016.
 */

app2.controller('ActivityController', function($scope, $location, ActivityService, ClassroomService){
    $scope.activities = ActivityService.query();
    $scope.classrooms = ClassroomService.query();
    $scope.fields = ['name', 'classroom', 'date'];
    $scope.activity = {};
    $scope.selectedMonth = angular.isUndefined($scope.selectedMonth) ? 1 : $scope.selectedMonth;   //default
    $scope.selectedClassroom = angular.isUndefined($scope.selectedClassroom) ? 1 : $scope.selectedClassroom; //default
    $scope.search = function(){
        var classroom_detail_url = '/classrooms/' + $scope.selectedClassroom + '/detail/' + $scope.selectedMonth;
        $location.url(classroom_detail_url);
    };
})