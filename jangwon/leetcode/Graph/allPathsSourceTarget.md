```js
var allPathsSourceTarget = function(graph) {
    const adj = new Map();
    const N = graph.length - 1
    const res = [];
    
    for(let i=0; i<graph.length; i++) {
        adj.set(i,new Set(graph[i]));
    }
    
    
    function dfs(idx,path = []) {
        path.push(idx);
        if(N === idx) {
            res.push(path);
            return res;
        }
        adj.get(idx).forEach((v,i)=>{
            dfs(v,path.slice())
        })
        return res;
    }
    
    return dfs(0);
};

```