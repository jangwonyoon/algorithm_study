# Tree

## leetcode 297. Serialize and Deserialize Binary Tree

### https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

**이진 트리의 직렬화, 역직렬화 문제**

**직렬화** - 이진트리의 데이터 구조를 파일이나 디스크에 저장하기 위해 물리적인 형태로 바꾸워 주는 과정

**역직렬화** - 직렬화 된 데이터를 다시 Tree 구조로 바꾸는 과정

```py
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root) ->str:
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        queue = collections.deque([root])
        result = ['#']
        
        # 트리 BFS 직렬화
        while queue:
            node = queue.popleft()
            if node:
                queue.append(node.left)
                queue.append(node.right)
                
                result.append(str(node.val))
            else:
                result.append('#')
        
        return ' '.join(result)

    def deserialize(self, data) -> TreeNode:
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        
        # 예외 처리
        if data == '# #':
            return None
        
        nodes = data.split()
        
        root = TreeNode(int(nodes[1]))
        queue = collections.deque([root])
        index = 2
        # 빠른 런너처럼 자식 노드 결과를 먼저 확인 후 큐 삽입
        while queue:
            node = queue.popleft()
            if nodes[index] is not '#':
                node.left = TreeNode(int(nodes[index]))
                queue.append(node.left)
            index += 1
            
            if nodes[index] is not '#':
                node.right = TreeNode(int(nodes[index]))
                queue.append(node.right)
            index += 1
        return root
    
    
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
```

```js
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    if(!root) return [];
    
    let result = ['#'];
    let queue = [root];
    
    while(queue.length){
        let node = queue.shift();
        if(node){
            queue.push(node.left);
            queue.push(node.right);
            
            result.push(node.val + '');
        }else{
            result.push('#');
        }
    }
    return result.join('');
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    if(!data.length) return null;
    
    let nodes = data.split('');
    
    let root = new TreeNode(+nodes[1]);
    let queue = [root];
    let idx = 2;
    
    while(queue.length){
        let node = queue.shift();
        
        if(nodes[idx] !== '#'){
            node.left = new TreeNode(+(nodes[idx]));
            queue.push(node.left);
        }
        idx++;
        
        if(nodes[idx] !== '#'){
            node.right = new TreeNode(+(nodes[idx]));
            queue.push(node.right);
        }
        idx++;
    }
    return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
```