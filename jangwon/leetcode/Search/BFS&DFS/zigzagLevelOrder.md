# BFS,DFS

## leetcode 103. Binary Tree Zigzag Level Order Traversal

### https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


* BFS 풀이

```js
var zigzagLevelOrder = function(root) {
    if(!root) return [];
    let result = [];
    let queue = [root];
    let depth = 0;
    
    while(queue.length) {
        let level = [];
        let len = queue.length;
        for(let i=0; i<len; i++) {
            let node = queue.shift();
            if(depth % 2 === 0) level.push(node.val);
            else level.unshift(node.val);
            
            if(node.left) queue.push(node.left);
            if(node.right) queue.push(node.right);
        }
        depth++;
        result.push(level);
    }
    return result;
};
```

* DFS 풀이

```js
function zigzagLevelOrder(root) {
    if(!root) return [];
    let result = [];
    
    const dfs = (node,depth,level) => {
        if(!node) return;
        if(!level[depth]) level.push([]);
        if(depth % 2 === 0 ) level[depth].push(node.val);
        else level[depth].unshift(node.val);
        
        dfs(node.left,depth+1,level);
        dfs(node.right,depth+1,level);
    }
    dfs(root,0,result);
    return result;
}
```