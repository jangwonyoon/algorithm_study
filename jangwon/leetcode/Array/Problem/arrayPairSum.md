# array

## leetcode 561. Array Partition I

### https://leetcode.com/problems/array-partition-i/

```py
class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        sum = 0
        pair = []
        nums.sort()
        
        for n in nums:
            pair.append(n)
            if len(pair) == 2:
                sum += min(pair)
                pair = []
                
        return sum
```

```js
var arrayPairSum = function(nums) {
    nums.sort((a,b)=>b-a);
    let arr = [];
    let sum = 0;
    
    for(let i=0; i<nums.length; i++) {
        arr.push(nums[i]);
        if(arr.length === 2) {
            sum += Math.min(...arr);
            arr = [];
        }
    }
    return sum;
};
```