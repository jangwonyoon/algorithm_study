# Array , Two Poniter , Hash Table

## 349. Intersection of Two Arrays

### https://leetcode.com/problems/intersection-of-two-arrays/

```js
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    let arr1 = new Set(nums1);
    let arr2 = new Set(nums2);
    let hash = new Map();
    let result = [];
    
    for(const num of arr1) {
        if(!hash.has(num)) {
            hash.set(num,1);
        }else{
            hash.set(num,hash.get(num)+1);
        }
    }
    
    for(const num of arr2) {
        if(!hash.has(num)) {
            hash.set(num,1);
        }else{
            hash.set(num,hash.get(num)+1);
        }
    }
    for(const el of hash) {
        if(el[1] >= 2) {
            result.push(el[0])
        }
    }
    
    return result;
};
```

```js
var intersection = function(nums1, nums2) {
    let p1 = 0;
    let p2 = 0;
    let num1 = nums1.sort((a,b)=>a-b);
    let num2 = nums2.sort((a,b)=>a-b);
    let result = [];
    while(p1 < num1.length && p2 < num2.length) {
        if(nums1[p1] === nums2[p2]) {
            result.push(nums1[p1]);
            p1++;
            p2++;
        }else {
            if(num1[p1] < num2[p2]) {
                p1++;
            }else {
                p2++;
            }
        }
    }
    
    return [...new Set(result)];
};
```