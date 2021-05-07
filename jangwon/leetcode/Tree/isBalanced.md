# Tree

## leetcode 110. Balanced Binary Tree

### https://leetcode.com/problems/balanced-binary-tree/

```js
var isBalanced = function(root) {
    if(!root) return true;
    
    const dfs = (node) => {
        if(!node) return 0;
        let left = dfs(node.left);
        let right = dfs(node.right);
        let sub = Math.abs(left - right);
        
        if(sub > 1 || left === -1 || right === -1) return -1;
        
        return Math.max(left, right) + 1;
    }
    
    return dfs(root) === -1 ? false : true;
    
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
    def isBalanced(self, root: TreeNode) -> bool:
        def check(root):
            if not root:
                return 0
            
            left = check(root.left)
            right = check(root.right)
            
            # 높이 차이가 나는 경우 -1, 이외에는 높이에 따라 1 증가
            if left == -1 or \
                right == -1 or \
                abs(left - right) > 1:
                return -1
            return max(left, right) + 1
        
        return check(root) != -1
```