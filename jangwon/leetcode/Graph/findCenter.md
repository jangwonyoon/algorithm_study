# Graph

## 1791. Find Center of Star Graph

### https://leetcode.com/problems/find-center-of-star-graph/


* solved 1

* 문제 분석 

```js
var findCenter = function(edges) {
    let counts = Array(edges.length+1).fill(0);
    
    for(let [i,j] of edges) {
        i--
        j--
        counts[i]++;
        counts[j]++;
    }
    
    for(let i=0; i<counts.length; i++) {
        if(counts[i] === edges.length) {
            return i+1;
        }
    }
    
};
```

* **[Most Vote]** Reference Code

```js
const findCenter = (edges) => {
  const [[a, b], [c, d]] = edges;
  return a === c || b === c ? c : d;
};
```