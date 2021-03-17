# String

### https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

```js
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let str = (x + '').split('').reverse();
    let num = (x + '').split('');
    
    str.map((el,idx) => {
        if(el === '-') {
            str = str.filter((el) => el != '-');
        }
    })
    
    str.map((el,idx) => {
        if(el === '0' && idx === str.length -1) {
            str = str.filter((el) => el != '0');
        }
    })
    
    for(let el of num) {
        if(el === '-') {
            str.unshift('-');
        }
    }
    
    let result = +str.join('');
    
    if(-Math.pow(2,31) > result || Math.pow(2,31) -1 < result) {
        return 0;
    }
    
    return result;
};


/*

    1) 부호는 살리고 0은 없엔다 
    2) 부호가 있는 경우 
    
    231 - 1
    
    2의 31승 -1 


*/
```