```js
function solution(board){
  let result = 0;
  let dx=[-1, -1, 0, 1, 1, 1, 0, -1];
  let dy=[0, 1, 1, 1, 0, -1, -1, -1];
  let n = board.length;

  const dfs = (x,y) => {
    board[x][y] = 0; // 방문 처리 
    for(let k=0; k<8; k++) {
      let nx = x+dx[k]; // 다음 좌표 처리
      let ny = y+dy[k]; //  다음 좌표처리
      if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] ===1) {
        dfs(nx,ny);
      }
    }
  }

  for(let i=0; i<n; i++) {
    for(let j=0; j<n; j++) {
      if(board[i][j] === 1) {
        result++;
        console.log(i,j);
        dfs(i,j);
      }
    }
  }
  return result;
}
let arr=[[1, 1, 0, 0, 0, 1, 0], 
          [0, 1, 1, 0, 1, 1, 0],
          [0, 1, 0, 0, 0, 0, 0],
          [0, 0, 0, 1, 0, 1, 1],
          [1, 1, 0, 1, 1, 0, 0],
          [1, 0, 0, 0, 1, 0, 0],
          [1, 0, 1, 0, 1, 0, 0]];
console.log(solution(arr));


/*
  상하좌우, 대각선이 고립되어있으면 0으로 conut한다.

  대각선 확인하는 경우는 8방향을 확인한다.
*/
```