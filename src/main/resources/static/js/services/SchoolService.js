/**
 * Created by alexggg99 on 25.01.16.
 */

app.factory('SchoolService', function($resource){
    return $resource('/school/:id',{id:'@id'},{
        'update':{method:'PUT'}
    })
});
