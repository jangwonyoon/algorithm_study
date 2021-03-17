```js
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */


// hash
var intersect = function(nums1, nums2) {
    let hash = new Map();
    let result = [];
    
    for(const num of nums1) {
        if(!hash.has(num)) {
            hash.set(num,1);
        }else{
            hash.set(num,hash.get(num) + 1);
        }
    }
    
    for(const num of nums2) {
        if(hash.has(num) && hash.get(num) > 0) {
            result.push(num);
            hash.set(num,hash.get(num)-1);
        }
    }
    return result;
};
```