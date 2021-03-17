```js
function solution(answers) {
    let s1 = [1, 2, 3, 4, 5];
    let s2 = [2, 1, 2, 3, 2, 4, 2, 5];
    let s3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    let c1 = 0;
    let c2 = 0;
    let c3 = 0;
    
    for(let i=0; i<answers.length; i++) {
        if(s1[i % s1.length] === answers[i]) {
            c1++;
        }
        if(s2[i % s2.length] === answers[i]) {
            c2++;
        }
        if(s3[i % s3.length] === answers[i]) {
            c3++;
        }
    }
    let max = [c1,c2,c3];
    let result = [];
    max.map((el,idx)=>{
        if(Math.max(...max) === el) {
            result.push(idx+1);
        }
    })
    return result;
}
```