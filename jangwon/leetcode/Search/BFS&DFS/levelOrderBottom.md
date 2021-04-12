# BFS

## leetcode 107. Binary Tree Level Order Traversal II

### https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

```js
var levelOrderBottom = function(root) {
    if(!root) return [];
    const queue = [];
    let result = [];
    queue.push(root);
    
    while(queue.length) {
        let len = queue.length;
        let level = [];
        for(let i=0; i<len; i++) {
            let node = queue.shift();
            level.push(node.val);
            if(node.left) {
                queue.push(node.left);
            }
            if(node.right) {
                queue.push(node.right);
            }
        }
        result.push(level);
    }
    result.reverse();
    return result;
};
```