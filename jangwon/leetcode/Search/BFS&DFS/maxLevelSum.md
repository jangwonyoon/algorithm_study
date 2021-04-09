# BFS 

## 1161. Maximum Level Sum of a Binary Tree

### https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

* 문제 풀이

1. 각 level별 node의 합을 구하기 위해 큐를 사용 (BFS)
2. 큐의 삽입 한 값을 shift()를 통해 뽑고 sum 변수에 더해서 확인한다.
3. queue가 끝난 경우 sum 을 0으로 초기화 시켜 각 level별 sum 값을 확인 할 수 있도록 한다.
4. 각 레벨 별 sum값을 sumArr배열에 넣어준다.
5. sumArr에서 가장 큰 값을 찾아주고 인덱스를 찾아준다.
6. 문제에서 root는 1부터 시작하므로 인덱스 값에 1을 더해주어 반환 해준다.

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
 * @return {number}
 */
var maxLevelSum = function(root) {
    let sumArr = [];
    let queue = [];
    let result = 0;
    queue.push(root);
    
    while(queue.length) {
        let sum = 0;
        let len = queue.length;
        for(let i=0; i<len; i++) {
            let x = queue.shift();
            sum += x.val;
            if(x.left){
                queue.push(x.left);
            }
            if(x.right){        
                queue.push(x.right);
            }
        }
        sumArr.push(sum);
    }
    let max = Math.max(...sumArr);
    result = sumArr.indexOf(max) + 1;
    return result;
};
```

* 레퍼런스 DFS 풀이

```js
var maxLevelSum = function(root) {
    const sums = [-Infinity];
    callDFS(root, 1);
    return sums.indexOf(Math.max(...sums));
      
    function callDFS(node, level) {
        if(!node) return;
        if(sums[level] === undefined) sums.push(node.val);
        else sums[level] += node.val;
        
        callDFS(node.left, level+1);
        callDFS(node.right, level+1);
    }
};
```