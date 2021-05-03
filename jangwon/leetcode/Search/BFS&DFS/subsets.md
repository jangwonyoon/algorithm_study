```js
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let powerSet = [];
    
    const generatePowerSet = (path,idx) => {
        powerSet.push(path);
        for(let i=idx; i<nums.length; i++) {
            generatePowerSet([...path,nums[i]],i+1);
        }
    }
    generatePowerSet([],0);
    return powerSet;
};
```

```py
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        
        def dfs(idx, path):
            result.append(path)
            for i in range(idx, len(nums)):
                dfs(i + 1, path + [nums[i]])
                
        dfs(0, [])
        return result
```