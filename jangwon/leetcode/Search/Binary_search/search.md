# Binary Search

## leetcode 704. Binary Search

### https://leetcode.com/problems/binary-search/

**파이썬 재귀 풀이**

```py
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        def binary_search(left, right):
            if left <= right:
                mid = (left + right) // 2
                
                if nums[mid] < target:
                    return binary_search(mid + 1, right)
                elif nums[mid] > target:
                    return binary_search(left, mid - 1)
                else:
                    return mid
            else:
                return -1
            
            return binary_search(0, len(nums) - 1)
```

```py
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = (left + right) // 2
            
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid
        
        return -1
```