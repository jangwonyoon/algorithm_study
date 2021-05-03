# DFS & BFS

## leetcode 200. Number of Islands

### https://leetcode.com/problems/number-of-islands/

**풀이 1**

```js
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let count =0;
    
    const dfs = (x,y) => {
        if( x < 0 || x >= grid.length || y < 0 || y >= grid[x].length ) return;
        if(grid[x][y] === '1') {
        // 방문 처리 
        grid[x][y] ='0';
        dfs(x+1 , y);
        dfs(x , y+1);
        dfs(x-1 , y);
        dfs(x , y-1);
        }
    }
    
    for(let i=0; i < grid.length; i++) {
        for(let j=0; j < grid[i].length; j++){
            if(grid[i][j] === '1') {
                count++;
                dfs(i,j);
            }
        }
    }
    return count;
};
```

**풀이 2**

``` js
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let result = 0;
    let dx = [-1,0,1,0];
    let dy = [0,-1,0,1];
    
    const dfs = (x,y) => {
        grid[x][y] = '0'; // 방문 처리
        if(x < 0 || y < 0 || x > grid.length || y > grid[0].length) {
            return;
        }else{
            for(let i=0; i<4; i++) {
                let nx = x + dx[i];
                let ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] === '1'){
                    grid[nx][ny] = 0; // 방문 처리
                    dfs(nx,ny);
                }
            }
        }
    }
    
    for(let i=0; i<grid.length; i++) {
        for(let j=0; j<grid[0].length; j++) {
            if(grid[i][j] === '1') {
                result += 1;
                dfs(i,j);
            }            
        }
    }
    
    return result;
};
```

**파이썬 풀이**

```py
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(i,j):
            # 더 이상 땅이 아닌 경우 종료
            if i < 0 or i >= len(grid) or \
                j < 0 or j >= len(grid[0]) or \
                grid[i][j] != '1':
                    return 
            
            grid[i][j] = 0
            
            # 동서남북 탐색
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)
        
        count = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    dfs(i,j)
                    # 모든 육지 탐색 후 카운트 1 증가
                    count += 1
        
        return count
```