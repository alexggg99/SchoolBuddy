/**
 * Created by alexggg99 on 25.01.16.
 */

app.factory('ClassroomService', function($resource){
    return $resource('/classroom/:id',{id:'@id'},{
        'update':{method:'PUT'}
    })
});
