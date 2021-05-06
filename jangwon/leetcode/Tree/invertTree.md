# Tree

## leetcode 226. Invert Binary Tree

### https://leetcode.com/problems/invert-binary-tree/


**파이썬, 자바스크립트 Bottom-up DFS 방식**

```js
var invertTree = function(node) {
     if (node) {
        const tmp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(tmp);
    }
    return node;
};
```

```py 
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root:
            root.left, root.right = \
                self.invertTree(root.right), self.invertTree(root.left)
            return root
        return None
```

```js
var invertTree = function(root) {
    const queue = [root];
    while(queue.length) {
        let node = queue.shift();
        if(node) {
            // swap;
            let tmp = node.right;
            node.right = node.left;
            node.left = tmp;
            
            queue.push(node.right);
            queue.push(node.left);
        }
    }
    return root;
};
```

```py
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        queue = collections.deque([root])
        
        while queue:
            node = queue.popleft()
            
            if node:
                node.left, node.right = node.right, node.left
                
                queue.append(node.left)
                queue.append(node.right)
        
        return root
```