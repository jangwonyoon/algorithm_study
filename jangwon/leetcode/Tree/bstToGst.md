# Tree

## leetcode. 1038. Binary Search Tree to Greater Sum Tree

### https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

```py
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    val: int = 0
        
    def bstToGst(self, root: TreeNode) -> TreeNode:
        # 중위 순회 노드 값 누적 R->N->L
        if root:
            self.bstToGst(root.right)
            self.val += root.val
            root.val = self.val
            self.bstToGst(root.left)
        
        return root
```        
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
var bstToGst = function(root) {
    let val = 0;
    const dfs = (node) => {
        if(!node) return;
        if(node){
            dfs(node.right);
            val += node.val;
            node.val = val;
            dfs(node.left);
        }
    }
    
    dfs(root);
    return root;
};
```