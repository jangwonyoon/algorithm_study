# BFS

## leetcode 513. Find Bottom Left Tree Value

### https://leetcode.com/problems/find-bottom-left-tree-value/

* BFS 풀이

* 내 풀이 

1. level별 노드를 담은 result 배열을 만든다. 
2. 가장 마지막 인덱스의 요소가 maxDepth이므로 요소에서 왼쪽 노드의 값을 리턴한다.


```js
var findBottomLeftValue = function(root) {
    const queue = [];
    let result = [];    
    let answer = 0;
    queue.push(root);
    
    while(queue.length) {
        let len = queue.length;
        let tmp = [];
        for(let i=0; i<len; i++) {
            let node = queue.shift();
            tmp.push(node.val);
            if(node.left) {
                queue.push(node.left);
            }
            if(node.right) {
                queue.push(node.right);
            }
        }
        result.push(tmp);
    }
    
    let targetIdx = result.length -1;
    answer = result[targetIdx][0];
    return answer;
};
```