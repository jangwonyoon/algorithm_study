```js
function solution(arr){
  let result = arr;
  let tmp=0;
  for(let i=0; i<arr.length-1; i++) {
    for(let j=0; j<arr.length-i-1; j++) {
      if(arr[j] > 0 && arr[j+1] < 0) {
        tmp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = tmp;
      }
    }
  }
  return result;
}
let arr=[1, 2, 3, -3, -2, 5, 6, -6];
console.log(solution(arr));
```