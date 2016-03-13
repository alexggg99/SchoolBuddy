 /**
 * Created by Alex on 05.02.2016.
 */


app2.controller('WelcomeController', function($scope, $log, $state){

    var vm = this;
    vm.message = 'Welcome to School Buddy!';
    vm.reloadCount = 0;
    $scope.refresh = function(){
        $log.debug($state.current);
        $state.reload();
    }

})