/**
 * Created by Alex on 24.01.2016.
 */

app.controller('SchoolController', function($scope, SchoolService){
    $scope.schools = SchoolService.query();
    $scope.fields = ['id' ,'name', 'address', 'director'];
    $scope.school = {};
    $scope.show = function(school){
        console.log(school);
    }
})