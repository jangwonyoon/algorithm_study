# Backtracking

## 980. Unique Paths III

### https://leetcode.com/problems/unique-paths-iii/

```js

var uniquePathsIII = function(grid) {
    let emptyCount = 0;
    let sRow = null, sCol = null;
    // house keeping
    for (let i=0;i<grid.length;i++) {
        for (let j=0;j<grid[0].length;j++) {
            if (grid[i][j]==0) emptyCount++;
            else if (grid[i][j]==1) [sRow, sCol] = [i, j];
        }
    }
    
    let uniquePaths = 0;
    var backtracking = function(r, c, e) {
        let dRow = [-1,0,1,0];
        let dCol = [0,-1,0,1];
		
		// base case
         if (grid[r][c]=='2' && e == emptyCount+1) {
             uniquePaths++;
             return;
         }
        
        let backUp = grid[r][c];
        // temp mark
        grid[r][c] = '*';
        for(let i=0;i<dRow.length;i++) {
            let nRow = r + dRow[i];
            let nCol = c + dCol[i];

            if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length 
                && grid[nRow][nCol] != '*' && grid[nRow][nCol] != -1) {
                backtracking(nRow, nCol, e+1)
            }
        }
        // reset
        grid[r][c] = backUp;
    }
    backtracking(sRow, sCol, 0);
    return uniquePaths;
}
```