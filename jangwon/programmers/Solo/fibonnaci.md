# DP

## 피보나치의 수 

### https://programmers.co.kr/learn/courses/30/lessons/12945


```js
function solution(n) {
    let memo = [0,1];
    for(let i=2; i<=n; i++) {
        memo[i] = (memo[i-1] + memo[i-2]) % 1234567;
    }
    return memo[n]
}
```