
var HashMap = function() {

    let obj={};
    
    return {
        put: function(k,v) {
            obj[k]=v; 
        },

        keys: function() {
            const arr = [];
            for(const getKey in obj){
                arr.push(getKey);
            }
            return arr;

            // Object.keys(obj);
        },

        contains: function(k) {
            for(const key in obj){
                if(key === k){
                    return true;
                } 
            }
            return false; 
        },

        get: function(k) {
            return obj[k];
        },

        clear: function() {
             obj={};
        }
    };
};