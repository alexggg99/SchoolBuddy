/**
 * Created by alexggg99 on 25.01.16.
 */

app2.filter('labelCase', function(){
    return function(name){
        return name[0].toUpperCase() + name.slice(1);
    }
})