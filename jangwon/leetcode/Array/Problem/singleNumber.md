```js
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let hash = new Map();
    
    if(nums.length  < 2) return nums;
    
    for(let num of nums) {
        if(!hash.has(num)) {
            hash.set(num,1);
        }else{
            hash.set(num,hash.get(num) + 1);
        }
    }
    for(let el of hash) {
        if(el[1] === 1) {
            return el[0]
        }
    }
};

return nums.reduce((prev, curr) => prev ^ curr);
```