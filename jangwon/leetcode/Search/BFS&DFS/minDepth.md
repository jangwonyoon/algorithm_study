# DFS,BFS 

## 111. Minimum Depth of Binary Tree

### https://leetcode.com/problems/minimum-depth-of-binary-tree/

* 문제 분석

1. root노드에서 left노드까지의 가장 짧은 거리를 구하는 문제 

* DFS 풀이 

```js

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
 
var minDepth = function(root) {
    let result = Number.MAX_VALUE;
    if(!root) return 0;
    
    const dfs = (node,depth=1) => {
        if(!node.left && !node.right) {
            result = Math.min(result,depth);
            return;
        }else{
            if(node.left) {
                dfs(node.left, depth+1);
            }
            if(node.right) {
                dfs(node.right,depth+1);
            }
        }
    }
    dfs(root);
    return result;
};
```

* BFS 풀이

```js
var minDepth = function(root) {
    if(!root) return 0;
    let result = Number.MAX_VALUE;
    let queue = [];
    let depth = 1;
    queue.push(root);
    
    while(queue.length) {
        let len = queue.length;
        for(let i=0; i<len; i++) {
            const cur = queue.shift();
            if(cur.left) queue.push(cur.left);
            if(cur.right) queue.push(cur.right);
            if(!cur.left && !cur.right) return depth;
        }
        depth++;
    }
};
```