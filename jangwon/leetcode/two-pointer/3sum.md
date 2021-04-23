# two-pointer

## leetcode 15. 3Sum

### https://leetcode.com/problems/3sum/

```js
var threeSum = function(nums) {
    
    // 예외 처리
    if(!nums.length) return [];
    let result = [];
    let len = nums.length;
    nums.sort((a,b)=>b-a);
    
    for(let i=0; i<len; i++) {
        
        // 중복 된 값 건너뛰기
        if(i>0 && nums[i] === nums[i-1]) continue;
        
        for(let j=i+1; j<len; j++) {
            // 중복 된 값 건너뛰기
            if(j>i+1 && nums[j] === nums[j-1]) continue;
            
            for(let k=j+1; k<len; k++) {
                // 중복 된 값 건너뛰기
                if(k>j+1 && nums[k] === nums[k-1]) continue;
                
                let tmp = [];
                if(nums[i] + nums[j] + nums[k] === 0) {
                    tmp.push(nums[i],nums[j],nums[k]);
                }
                if(tmp.length > 0) result.push(tmp);
            }
        }
    }
    
    return result;
};
```
**파이썬 투 포인터 풀이**

```py
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        results = []
        nums.sort()

        for i in range(len(nums) - 2):
            # 중복된 값 건너뛰기
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # 간격을 좁혀가며 합 `sum` 계산
            left, right = i + 1, len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    # `sum = 0`인 경우이므로 정답 및 스킵 처리
                    results.append([nums[i], nums[left], nums[right]])

                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1

        return results
```