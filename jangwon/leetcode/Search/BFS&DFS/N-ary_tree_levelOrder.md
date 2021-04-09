# BFS,DFS  

## 429. N-ary Tree Level Order Traversal

### https://leetcode.com/problems/n-ary-tree-level-order-traversal/


* DFS

```js
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    const res = [];
    
    const dfs = (node,depth=0) => {
        if(!node) return;
        if(depth === res.length) {
            res.push([]);
        }
        res[depth].push(node.val);
        for(child of node.children) {
            dfs(child, depth+1);
        }
    }
    dfs(root);
    return res;
};
```

```js
var levelOrder = function(root) {
    let result = [];
    let queue = [];
    queue.push(root);
    
    while(queue.length) {
        let len = queue.length;
        let currlevel = [];
        for(let i=0; i<len; i++){
            let currNode = queue.shift();
            currlevel.push(currNode.val);
            queue.push(...currNode.children);
        }
        result.push(currlevel);
    }
    return result;
};
```