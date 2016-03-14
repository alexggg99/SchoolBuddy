/**
 * Created by Alex on 14.03.2016.
 */


(function(){
    app2.factory('myClassroomsService', function($http, $q, $log, $timeout){

        return {
            getCurrentUser: getCurrentUser,
            getMyClassrooms: getMyClassrooms
        }

        function getCurrentUser(){
            return $http.get('/user')
                .then(function(response) {
                    return response.data;
                })
                .catch(function(response) {
                    $log.error('Error retrieving user: ' + response.statusText);
                    return $q.reject('Error retrieving user.');
                })
        }

        function getMyClassrooms(){
            return $http.get('/user/getClassrooms')
                .then(function(response) {
                    return response.data;
                })
                .catch(function(response) {
                    $log.error('Error retrieving classrooms: ' + response.statusText);
                    return $q.reject('Error retrieving classrooms.');
                })
        }

    })
}())