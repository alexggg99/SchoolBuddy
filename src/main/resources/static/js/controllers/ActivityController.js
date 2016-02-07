/**
 * Created by Alex on 24.01.2016.
 */

app.controller('ActivityController', function($scope, ActivityService){
    $scope.activities = ActivityService.query();
    $scope.fields = ['name', 'classroom', 'date'];
    $scope.activity = {};
})