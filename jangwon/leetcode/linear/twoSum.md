* 풀이 1

```py
# 브루투 포스
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i,j]
```

* 풀이 2

```py
# in을 통한 탐색
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i, n in enumerate(nums):
            complement = target - n
            if complement in nums[i+1:]:
                return [nums.index(n),nums[i+1:].index(complement) + (i+1)]
```
* 풀이 3

```py
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        # 키와 값을 바꿔 딕셔너리로 저장
        for i, num in enumerate(nums):
            nums_map[num] = i
        
        for i, num in enumerate(nums):
            if target - num in nums_map and i != nums_map[target-num]:
                return [i, nums_map[target - num]]
```

* 풀이 4

```py
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        # 하나의 for문으로 통합
        for i, num in enumerate(nums):
            if target - num in nums_map:
                return [nums_map[target - num], i]
            nums_map[num] = i
```

* 풀이 5: 투 포인터 풀이 

```py
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # nums가 정렬이 되어서 나온다는 가정하에 풀이
        # nums가 정렬이 되어서 나오지 않는다면 Index가 뒤 섞여 좋은 풀이가 아니다.
        left, right = 0, len(nums) - 1
        while not left == right:
            # 합이 타겟보다 작은 경우 값을 증가 시키기 위해 left를 늘린다.
            if nums[left] + nums[right] < target:
                left += 1
            # 합이 타겟보다 큰 경우 값을 증가 시키기 위해 right를 줄인다.
            elif nums[left] + nums[right] > target:
                right -= 1
            else:
                return [left, right]
```

