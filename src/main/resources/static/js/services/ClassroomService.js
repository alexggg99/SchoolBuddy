/**
 * Created by alexggg99 on 25.01.16.
 */

app2.factory('ClassroomService', function($resource){
    return $resource('/classroom/:id',{id:'@id'},{
        'update':{method:'PUT'}
    })
});

app2.factory('ClassroomDetailsService', function($resource){
    return $resource('activity/:classroomId/detail/:month',{id:'@id'})
});
