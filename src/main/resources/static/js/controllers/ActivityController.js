/**
 * Created by Alex on 24.01.2016.
 */

app2.controller('ActivityController', function($scope, $state, activities, classrooms){
    $scope.activities = activities;
    $scope.classrooms = classrooms;
    $scope.fields = ['name', 'date'];
    $scope.activity = {};
    $scope.selectedMonth = angular.isUndefined($scope.selectedMonth) ? 1 : $scope.selectedMonth;   //default
    $scope.selectedClassroom = angular.isUndefined($scope.selectedClassroom) ? 1 : $scope.selectedClassroom; //default
    $scope.search = function(){
        var classroom_detail_url = '/classrooms/' + $scope.selectedClassroom + '/detail/' + $scope.selectedMonth;
        $state.go('classroom_parent.classroom_detail', {id:$scope.selectedClassroom, month:$scope.selectedMonth});
    };
})