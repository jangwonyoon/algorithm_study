# DFS,BFS

## 865. Smallest Subtree with all the Deepest Nodes

### https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

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
 * @return {TreeNode}
 */


var subtreeWithAllDeepest = function(root) {
    let maxDepth = getMaxDepth(root);
    
    const getSubtree = (root, depth = 0) => {
        if (!root) return null;
        if (depth == maxDepth) return root;
        let leftSub = getSubtree(root.left, depth + 1);
        let rightSub = getSubtree(root.right, depth + 1);
        if (leftSub && rightSub) return root; 
        if (leftSub) return leftSub;
        if (rightSub) return rightSub;
    }
    return getSubtree(root);
};

const getMaxDepth = (root,depth=0) => {
    if(!root) return 0;
    if(!root.left && !root.right) return depth;
    return Math.max(getMaxDepth(root.left,depth+1),getMaxDepth(root.right,depth+1));
};
```