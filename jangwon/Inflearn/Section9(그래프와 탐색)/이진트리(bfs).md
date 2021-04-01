```js
function solution(){
  let result = "";
  let queue = [];
  queue.push(1);

  while(queue.length) {
    let v = queue.shift();
    result += v+" ";
    for(let nv of[v*2,v*2+1]) {
      if(nv > 7) continue; // 건너뛴다.
      queue.push(nv);
    }
  }
  return result;
}
solution();
```