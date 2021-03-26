* 풀이 1

* 배열 내장 메소드를 사용한 풀이

```js
function solution(cacheSize, cities) {
    let result = 0;
    let cache = [];
    cities = cities.map((el,idx)=>el.toLowerCase());
    cities.forEach((x,idx)=>{
        let pos = -1;
        for(let i=0; i<cacheSize; i++) {
            if(cache[i] === x) pos = i;
        }
        // miss
        if(pos === -1) {
            result += 5;
            cache.unshift(x);
            if(cache.length > cacheSize) {
                cache.pop();
            }
        }
        // hit
        else{
            result += 1;
            cache.splice(pos,1);
            cache.unshift(x);
        }
    })
    return result;
}
```

* 풀이 2

* cache를 만들어 반복문 처리를 통한 풀이 
  
```js
function solution(cacheSize, cities) {
    let result = 0;
    let cache = Array(cacheSize).fill(0);
    cities.map((x,idx)=>{
        x = x.toLowerCase();
        let pos = -1;
        for(let i=0; i<cacheSize; i++) if(x === cache[i]) pos = i;
        // miss
        if(pos === -1) {
            for(let i=cacheSize-1; i>=1; i--) {
                cache[i] = cache[i-1];
            }
            result += 5;
        }
        // hit
        else {
             for(let i=pos; i>=1; i--) {
                cache[i] = cache[i-1];
            }
            result += 1;
        }
        cache[0] = x;
    })
    return result;
}
```