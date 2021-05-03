# DFS,BFS

## leetcode 332. Reconstruct Itinerary

### https://leetcode.com/problems/reconstruct-itinerary/

```py
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = collections.defaultdict(list)
        # 그래프 순서대로 구성
        for a, b in sorted(tickets):
            graph[a].append(b)
        
        route = []
        def dfs(a):
            # 첫 번째 값을 읽어 어휘 순 방문
            while graph[a]:
                dfs(graph[a].pop(0))
            route.append(a)
            
        dfs('JFK')
        # 다시 뒤집어 어휘 순 결과로
        return route[::-1]
```

```py
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = collections.defaultdict(list)
        # 그래프 순서대로 구성
        for a, b in sorted(tickets):
            graph[a].append(b)
        
        route, stack = [], ['JFK']
        
        while stack:
            # 반복으로 스택을 구성하되 막히는 부분에서 풀어내는 처리
            while graph[stack[-1]]:
                stack.append(graph[stack[-1]].pop(0))
            route.append(stack.pop())
            
        # 다시 뒤집어 어휘 순 결과로
        return route[::-1]            
```

```js
/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
var findItinerary = function(tickets) {
    let graph = {};
    let res = [];
    
    for(const [s,e] of tickets){
        if(!graph[s]){
            graph[s] = [e];
        }else{
            graph[s].push(e);
        }
    }
    
   for(let loc in graph) {
        graph[loc].sort();
    }  
    
    const dfs = (s) => {
        let city = graph[s];
        while(city && city.length){
            dfs(city.shift());
        }
        res.push(s);
        console.log(res)
    }
    dfs('JFK');
    return res.reverse();
    
};
```