# DFS

## 네트워크 Lv.3

### https://programmers.co.kr/learn/courses/30/lessons/43162

```js
function solution(n, computers) {
    var result = 0;
    let check = Array.from({length:n},()=>0);
    let len = computers.length;
    
    const dfs = (idx)=> {
        check[idx] = 1; // 방문처리 
        for(let i=0; i<len; i++) {
            if(computers[idx][i] === 1 && check[i] === 0) {
                dfs(i);
            }
        }
    }
    
    for(let i=0; i<len; i++) {
        if(check[i] === 0) {
            dfs(i);
            result +=1;
        }
    } 
    return result;
}
```