```js
function solution(citations) {
    let sort = citations.sort((a,b)=>b-a);
    let result = 0;
    for(let i=0; i<sort.length; i++) {
        if(sort[i] > i) result++;
    }
    return result;
}
```