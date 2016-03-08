 /**
 * Created by Alex on 05.02.2016.
 */


app2.controller('WelcomeController', function($scope, $log){

    var vm = this;
    vm.message = 'Welcome to School Buddy!';
    vm.reloadCount = 0;
    //vm.refresh = function(){
    //    $log.debug($route.current);
    //    $log.debug($route.routes);
    //    $route.reload();
    //}

})