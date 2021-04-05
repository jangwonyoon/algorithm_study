# BFS, DFS Search

## 199. Binary Tree Right Side View

### https://leetcode.com/problems/binary-tree-right-side-view/

* BFS 풀이

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
 * @return {number[]}
 */
    

var rightSideView = function(root) {
    const result = [];
    const queue = [];
    
    if (root === null) return result;
    
    queue.push(root);
    while(queue.length !== 0) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let n = queue.shift();
            if (i === size - 1) result.push(n.val);
            if (n.left !== null) queue.push(n.left);
            if (n.right !== null) queue.push(n.right);
        }
    }
    
    return result;
};
```


* DFS 풀이 

```js
var rightSideView = function(root) {
    if (!root) return [];
    let res = [];
    
    const pre = (node, depth=0) => {
        if (!node) return;
        res[depth] = node.val;
        pre(node.left, depth+1);
        pre(node.right, depth+1);
    }
    
    pre(root);
    return res;
};

```