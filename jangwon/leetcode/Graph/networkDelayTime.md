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

**파이썬 다익스트라 알고리즘**

```py
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(list)
        # 그래프 인접 리스트 구성
        for u, v, w in times:
            graph[u].append((v, w))
            
        print(graph)
        # 큐 변수: [(소요시간, 정점)]
        Q = [(0, k)]
        dist = collections.defaultdict(int)
        
        # 우선순위 큐 최솟값 기준으로 정점까지 최단 경로 삽입
        while Q:
            time, node = heapq.heappop(Q)
            if node not in dist:
                dist[node] = time
                for v, w in graph[node]:
                    alt = time + w
                    heapq.heappush(Q, (alt, v))
        # 모든 노드의 최단 경로 존재 여부 판별
        if len(dist) == n:
            return max(dist.values())
        return -1
```