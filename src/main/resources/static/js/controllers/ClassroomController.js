/**
 * Created by Alex on 24.01.2016.
 */

app.controller('ClassroomController', function($scope, ClassroomService, $routeParam){
    var vm = this;
    $scope.schools = SchoolService.query();
    $scope.fields = ['id' ,'name', 'address', 'director'];
    $scope.school = {};
})