/**
 * Created by alexggg99 on 25.01.16.
 */

app2.factory('ActivityService', function($resource){
    return $resource('/activity/:id',{id:'@id'},{
        'update':{method:'PUT'}
    })
});
