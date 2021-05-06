# Tree

## leetcode. 617. Merge Two Binary Trees

### https://leetcode.com/problems/merge-two-binary-trees/

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
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
var mergeTrees = function(r1, r2) {
    if(r1 && r2) {
        const newTree = new TreeNode(r1.val + r2.val);
        newTree.left = mergeTrees(r1.left, r2.left);
        newTree.right = mergeTrees(r1.right, r2.right);
        
        return newTree;
    }
    return r1 || r2;
};
```

```py
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mergeTrees(self, r1: TreeNode, r2: TreeNode) -> TreeNode:
        if r1 and r2:
            node = TreeNode(r1.val + r2.val)
            node.left = self.mergeTrees(r1.left, r2.left)
            node.right = self.mergeTrees(r1.right, r2.right)
            
            return node
        
        return r1 or r2
```