# Tree

## leetcode 783. Minimum Distance Between BST Nodes

### https://leetcode.com/problems/minimum-distance-between-bst-nodes/


**JS 풀이**

- node의 현재 값을 배열에 넣어준다.
- 배열을 정렬 한 후 반복문을 통해 모든 차 값을 배열에 넣어준다.
- 최소 값을 뽑아준다.

> 트리구조 답지 못하게 푼거 같다.

```js
var minDiffInBST = function(root) {
    if(!root) return 0;
    let result = [];
    let min = [];
    const dfs = (node) => {
        if(!node) return;
        result.push(node.val);
        dfs(node.left);
        dfs(node.right);
    }
    dfs(root);
    result.sort((a,b)=>b-a);
    
    let start = 0;
    while(start < result.length) {
        for(let i=start+1; i<result.length; i++) {
            min.push(result[start] - result[i]);
        }
        start++;
    }
    
    return Math.min(...min);
};
```

```js
var minDiffInBST = function(root) {
    let result = Infinity;
    let prev = -Infinity
    
    const dfs = (node) => {
        if(!node) return;
        
        if(node.left) {
            dfs(node.left);
        }
        result = Math.min(result, node.val - prev);
        prev = node.val;
        
        if(node.right) {
            dfs(node.right);
        }
    }
    
    dfs(root);
    return result;
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
    prev = -sys.maxsize
    result = sys.maxsize
    
    # 재귀 구조 중위 순회 비교 결과
    def minDiffInBST(self, root: TreeNode) -> int:
        if root.left:
            self.minDiffInBST(root.left)
        
        self.result = min(self.result, root.val - self.prev)
        self.prev = root.val
        
        if root.right:
            self.minDiffInBST(root.right)
        
        return self.result
```