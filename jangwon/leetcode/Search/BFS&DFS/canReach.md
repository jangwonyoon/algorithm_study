# DFS,BFS

## leetcode 1306. Jump Game III

### https://leetcode.com/problems/jump-game-iii/

```js
var canReach = function(arr, start) {
    const dfs = (idx) => {
        if(arr[idx] === 0) return true;
        if(arr[idx] === '#' || idx < 0 || idx >= arr.length) return false;
        const move = arr[idx];
        arr[idx] = '#'; // 방문 처리
        return dfs(idx + move) || dfs(idx - move);
    }
    return dfs(start);
};
```