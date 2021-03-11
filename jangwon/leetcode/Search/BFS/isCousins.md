```js
var isCousins = function(root, x, y) {
    const dfs = (node,target,depth=0,parent) => {
        if(!node) return null;
        if(node.val = target){
            return {depth , parent};
        }
        let left = dfs(node.left,target,depth+1,node);
        let right = dfs(node.right,target,depth+1,node);
        return left || right;
    }
    let {depth:xDepth, parent: xParent} = dfs(root,x);
    let {depth:yDepth, parent: yParent} = dfs(root,x);
    
    return xDepth === yDepth && xParent !== yParent;
    
};
```