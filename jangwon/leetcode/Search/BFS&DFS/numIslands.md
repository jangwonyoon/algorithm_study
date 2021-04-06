```js
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let count =0;
    
    const dfs = (x,y) => {
        if(grid[x][y] === '1') {
            // 방문 처리 
            grid[x][y] ='0';
        }else return;
        
        if(x < grid.length -1 ) {
            dfs(x+1 , y)
        }
        
        if(y < grid[x].length -1 ) {
            dfs(x , y+1)
        }
        
        if(x < grid.length -1 ) {
            dfs(x , y)
        }
        
        if(x > 0 && grid.length -1 ) {
            dfs(x-1 , y)
        }
        
        if(y > 0 && grid[x].length -1 ) {
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