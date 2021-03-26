```js
function solution(size, arr){
  let cache =Array(size).fill(0);
  arr.forEach((x,i)=>{
    let pos = -1;
    for(let i=0; i<size; i++) {
      // cache hit
      if(x === cache[i]) pos = i;
    }
    // cache miss
    if(pos === -1) {
      for(let i=size-1; i>=1; i--) {
        cache[i] = cache[i-1];
      }
      cache[0] = x;
    }
    // cache hit
    else {
       for(let i=pos; i>=1; i--) {
        cache[i] = cache[i-1];
      }
    }
    // 맨 앞에 할당
    cache[0] = x;
  })
  return cache;
}
let arr=[1, 2, 3, 2, 6, 2, 3, 5, 7];
console.log(solution(5, arr));
```


```js
function solution(size, arr){
  let cache =[];
  arr.forEach((x,i)=>{
    let pos = -1;
    for(let i=0; i<size; i++) if(x === cache[i]) pos = i;

    // miss
    if(pos === -1) {
      cache.unshift(x);
      if(cache.length > size) {
        cache.pop();
      }

      // hit
    }else {
      cache.splice(pos,1);
      cache.unshift(x);
    }
  })
  return cache;
}
let arr=[1, 2, 3, 2, 6, 2, 3, 5, 7];
console.log(solution(5, arr));
```