# Array

## leetcode 238. Product of Array Except Self

### https://leetcode.com/problems/product-of-array-except-self/


```js
var productExceptSelf = function(nums) {
    if(!nums.length) return [];
    let result = [];
    let p = 1;
    
    for(let i=0; i<nums.length; i++) {
        result.push(p);
        p = p * nums[i];
    }
    
    p = 1;
    for(let i=nums.length-1; i>=0; i--) {
        result[i]  = result[i] * p;
        p = p * nums[i];
    }
    
    return result;
};
```

```py
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        p = 1
        
        for i in range(len(nums)):
            result.append(p);
            p = p * nums[i]
            
        p = 1
        
        for i in range(len(nums)-1, -1, -1):
            result[i] = result[i] * p
            p = p * nums[i]
            
        return result
```