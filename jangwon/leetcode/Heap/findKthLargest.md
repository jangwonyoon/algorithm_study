# Heap

## leetcode 215. Kth Largest Element in an Array

### https://leetcode.com/problems/kth-largest-element-in-an-array/

**heapq 모듈 이용**

```py
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = list()
        for n in nums:
            heapq.heappush(heap, -n)
        
        for _ in range(1, k):
            heapq.heappop(heap)
        
        return -heapq.heappop(heap)
```

**heapq 모듈의 heapify 이용**

```py
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        
        for _ in range(len(nums) - k):
            heapq.heappop(nums)
            
        return heapq.heappop(nums)
```

**heapq 모듈의 nlargest 이용**

```py
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]
```