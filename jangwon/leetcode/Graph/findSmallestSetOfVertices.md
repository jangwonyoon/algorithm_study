# Graph 

## 1557. Minimum Number of Vertices to Reach All Nodes

### https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

```js
var findSmallestSetOfVertices = function(n, edges) {
    let degree = new Array(n).fill(0);
    let result = [];
    edges.map(([s,e]) => degree[e]++);
    let min = Math.min(...degree);
    degree.map((el,idx)=>{
        if(el === min) {
            result.push(idx);
        }
    })
    return result;
};
```