# Backtraking(DFS)

## Leetcode 1219. Path with Maximum Gold

### https://leetcode.com/problems/path-with-maximum-gold/


* 문제 풀이

1. 방문한 좌표를 `tmp` 임시 변수에 할당해준다.
2. 방문한 좌표를 `0`으로 처리 해준다.
3. 상하좌우를 DFS로 백트래킹하여 가장 큰 값을 찾는다.
4. 방문한 좌표를 다시 이전 값으로 돌려준다. `tmp` 사용
5. 가장 큰 값을 반복해서 처리해주고 최종으로 가장 큰 값을 반환하여 준다.


```js
var getMaximumGold = function(grid) {
    let count = 0; 
    for(let i=0; i<grid.length; i++) {
        for(let j=0; j<grid[i].length; j++) {
            if(grid[i][j] !==0 ) {
                count = Math.max(count,getMaxGold(grid,i,j));
            }
        }
    }
    return count;
};

const getMaxGold = (grid,row=0,col=0,count=0) => {
    let rowLength = grid.length;
    let colLength = grid[0].length;
    
    if(row>=rowLength || col >=colLength || row<0 || col<0) {
        return count;
    }
    else if(grid[row][col] !==0) {
        count += grid[row][col];
        let tmp = grid[row][col];
        grid[row][col] = 0; // 방문처리
        let left = getMaxGold(grid, row-1, col, count);
        let right = getMaxGold(grid, row+1, col, count);
        let top = getMaxGold(grid, row, col-1, count);
        let bottom = getMaxGold(grid, row, col+1, count);
        grid[row][col] = tmp;
        return Math.max(left,right,top,bottom);
    }
    return count;
}
```

```js
var getMaximumGold = function(grid) {
    let r = grid.length; 
    let c = grid[0].length;
    let max = 0;
    
    if(!r) return max;
    
     for(let i=0; i<r; i++) {
        for(let j=0; j<c; j++) {
            if(grid[i][j]) {
                max = Math.max(max,dfs(i,j))
            }
        }
    }
    
    function dfs(x,y) {
        if(x<0 || y<0 || x>=r || y>=r || grid[x][y] === 0) return 0;
        let tmp = grid[x][y];
        grid[x][y] = 0; //check visited
        let count = tmp;
        count += Math.max(dfs(x-1,y),dfs(x+1,y),dfs(x,y-1),dfs(x,y+1));
        grid[x][y] = tmp;
        return count;
    }
    
    return max;
};
```