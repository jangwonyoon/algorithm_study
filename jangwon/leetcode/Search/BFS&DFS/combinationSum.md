# DFS,BFS

## leetcode 39. Combination Sum

### https://leetcode.com/problems/combination-sum/

**파이썬 풀이**

```py
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        
        def dfs(csum, index, path):
            # 종료 조건
            if csum < 0:
                return
            if csum == 0:
                result.append(path)
                return
            
            # 자신 부터 하위 원소 까지의 나열 재귀 호출
            for i in range(index, len(candidates)):
                dfs(csum - candidates[i], i, path + [candidates[i]])
                
        dfs(target, 0, [])
        return result
```

**JS 풀이**

```js
var combinationSum = function(candidates, target) {
    let result = [];
    
    const dfs = (sum, index, path=[]) => {
        // sum이 target 이상인 경우 탐색 중지
        if(sum > target) return; 
        if(sum === target) {
            result.push(path);
        }
        
        // 순회
        for(let i=index; i<candidates.length; i++) {
            dfs(sum + candidates[i], i, [...path, candidates[i]]);
        }
    }
    
    dfs(0,0);
    return result;
};
```