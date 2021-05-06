# Graph

## leetcode 787. Cheapest Flights Within K Stops

### https://leetcode.com/problems/cheapest-flights-within-k-stops/

**파이썬 풀이 - 다익스트라 알고리즘(heapq -> 우선 순위 큐 사용)**

```py
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        graph = collections.defaultdict(list)
        # 그래프 인접 리스트 구성
        for u, v, w in flights:
            graph[u].append((v,w))
        # 큐 변수 : [(가격, 정점, 남은 가능 경유지 수)]
        Q = [(0,src,K)]
        
        while Q:
            price, node, k = heapq.heappop(Q)
            if node == dst:
                return price
            if k >= 0:
                for v, w in graph[node]:
                    alt = price + w
                    heapq.heappush(Q, (alt, v, k - 1))
        
        return -1
```