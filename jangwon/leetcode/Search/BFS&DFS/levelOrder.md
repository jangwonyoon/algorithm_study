# BFS

## 102. Binary Tree Level Order Traversal

### https://leetcode.com/problems/binary-tree-level-order-traversal/


> 이진트리의 level별 node를 저장하해서 반환하는 문제

- `BFS`를 사용하여 각 레벨 별로 값을 집어넣고 반환하는 방식으로 해결 
  
<pre>
  <code>
               3
           ╱       ╲
         ↙            ↘
       9                20
     ↙   ↘           ↙    ↘
   4       1        5       7
 ↙  ↘    ↙  ↘    ↙  ↘    ↙  ↘
                2
Level Order Traversal = [[3], [9,20], [4,1,5,7], [2]]
  </code>
</pre>


<table>
<thead>
<tr>
<th>Current</th>
<th>i &lt;</th>
<th>qLength</th>
<th>queue</th>
<th>currLevel</th>
<th>levels</th>
</tr>
</thead>
<tbody>
<tr>
<td>3</td>
<td>0</td>
<td>1</td>
<td>[9,20]</td>
<td>[3]</td>
<td>[[3]]</td>
</tr>
<tr>
<td>9</td>
<td>0</td>
<td>2</td>
<td>[20,4,1]</td>
<td>[9]</td>
<td>[3]</td>
</tr>
<tr>
<td>20</td>
<td>1</td>
<td>2</td>
<td>[4,1,5,7]</td>
<td>[9,20]</td>
<td>[[3],[9,20]]</td>
</tr>
<tr>
<td>4</td>
<td>0</td>
<td>4</td>
<td>[1,5,7]</td>
<td>[4]</td>
<td>[[3],[9,20]]</td>
</tr>
<tr>
<td>1</td>
<td>1</td>
<td>4</td>
<td>[5,7]</td>
<td>[4,1]</td>
<td>[[3],[9,20]]</td>
</tr>
<tr>
<td>5</td>
<td>2</td>
<td>4</td>
<td>[7,2]</td>
<td>[4,1,5]</td>
<td>[[3],[9,20]]</td>
</tr>
<tr>
<td>7</td>
<td>3</td>
<td>4</td>
<td>[2]</td>
<td>[4,1,5,7]</td>
<td>[[3],[9,20],[4,1,5,7]]</td>
</tr>
<tr>
<td>2</td>
<td>0</td>
<td>1</td>
<td>[]</td>
<td>[2]</td>
<td>[[3],[9,20],[4,1,5,7],[2]]</td>
</tr>
</tbody>
</table>

* 풀이

```js
var levelOrder = function(root) {
    if(!root) return [];
    let result = [];
    let queue = [];
    queue.push(root);
    
    while(queue.length) {
        let len = queue.length;
        let curLevel = [];
        for(let i=0; i<len; i++) {
            const curr = queue.shift();
            if(curr.left) queue.push(curr.left);
            if(curr.right) queue.push(curr.right);
            curLevel.push(curr.val);
        }
        result.push(curLevel);
    }
    return result;
};
```