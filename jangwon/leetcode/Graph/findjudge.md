# Graph

## 997. Find the Town Judge

### https://leetcode.com/problems/find-the-town-judge/


* solved 1

```js
var findJudge = function(N, trust) {
    const outdegrees = Array(N+1).fill(0); 
    const indegrees = Array(N+1).fill(0);
    
    for(let i = 0; i < trust.length; i++) {
        let [a, b] = trust[i];
        
        outdegrees[a]++;
        indegrees[b]++;
    }
    
    for(let i = 1; i <= N; i++) {
        if (outdegrees[i] == 0 && indegrees[i] == N - 1) {
            return i;
        }
    }
    
    return -1;
};
```

* solved 2

```js
let findJudge = (N,trust) => {
    if(trust.length < N -1) {
        return -1;
    }
    
    let counts = Array(N+1).fill(0);
    
    for(let [a,b] of trust) {
        counts[a]--;
        counts[b]++;
    }
    for(let i=1; i<=N; i++) {
        if(counts[i] === N -1) {
            return i;
        }
    }
    return -1;
}
```