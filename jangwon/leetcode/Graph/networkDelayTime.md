# Graph (Bellman-form algorithm)

## 743. Network Delay Time

### https://leetcode.com/problems/network-delay-time/


**Reference** : https://leetcode.com/problems/network-delay-time/


**벨만 포드 알고리즘 해결**

```js
var networkDelayTime = function(times, n, k) {
    const time = Array(n+1).fill(Infinity);
    let result = [];
    time[k] = 0;
    for(let i=0; i<n; i++) {
        for(const [u,v,t] of times) {
            if(time[u] === Infinity) continue;
            if(time[v] > time[u] + t) {
                time[v] = time[u] + t;
            }
        }
    }
    
    for(let i=1; i<=n; i++) {
        result = Math.max(result,time[i])
    }
    return result === Infinity ? -1 : result;
};
```
