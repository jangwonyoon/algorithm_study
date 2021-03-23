# 완전탐색

* 내 풀이

```js
function solution(n, k, card){
  let sumArr = [];
  let result = 0;
  for(let i=0; i<n; i++) {
    let sum1 = 0;
    for(let j=i+1; j<n; j++) {
      let sum2 = 0;
      for(let k=j+1; k<n; k++) {
        let sum3 = 0;
        sum3 = arr[i]+arr[j]+arr[k];
        sumArr.push(sum3);
      }
      sumArr.push(sum2);
    }
    sumArr.push(sum1);
  }

  sumArr = [...new Set(sumArr)].sort((a,b)=>b-a);
  result = sumArr[k-1];
  return result;
}
let arr=[13, 15, 34, 23, 45, 65, 33, 11, 26, 42];
console.log(solution(10, 3, arr));
```
```js
function solution(n, k, card){

}
let arr=[13, 15, 34, 23, 45, 65, 33, 11, 26, 42];
console.log(solution(10, 3, arr));
```

* 레퍼런스 풀이

```js
function solution(n, k, card){
  let result = 0;
  let tmp = new Set();
  for(let i=0; i<n; i++) {
    for(let j=i+1; j<n; j++) {
      for(let k=j+1; k<n; k++) {
        tmp.add(card[i] + card[j] + card[k]);
      }
    }
  }
  let a = Array.from(tmp).sort((a,b)=>b-a); // 유사배열객체 
  result  = a[k-1];
  return result;
}
let arr=[13, 15, 34, 23, 45, 65, 33, 11, 26, 42];
console.log(solution(10, 3, arr));
```